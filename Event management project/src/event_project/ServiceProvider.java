package event_project;

import java.sql.*;
import java.util.*;

public class ServiceProvider extends Person{
    
    
     // sql classes
     static Statement s;    //writing to request  
     
     static Statement s2; 
     static Statement s3; 
     
     
     static ResultSet r;   //reading from  
     static ResultSet r2;  //reading from 
     

    //constructor
    ServiceProvider()
    {
     this.role=3;
    }
 
    
    //showRequests Function
    //views the Reservations no, eventtype, hall name, hall capacity and the requested date.
    void showRequests()
   {
  
            try (Connection conn = DriverManager.getConnection(DB.url)){ 
      
            s = conn.createStatement();
            r=s.executeQuery("select reservationNum, Hallname, HallCapacity, requestDate, eventType, SP from requests");    
               
            System.out.println("The available Requests are:\n\nReservation_Number\tEvent_Type\tHall_Name\tHall_Capacity\tRequested_Date\n----------------------------------------------------------------------------------");
            while(r.next())
            {
                Byte SP = r.getByte("SP");
                
                if(SP==1)
                {
                     int ReservNo= r.getInt("reservationNum");
                     String EventType = r.getString("EventType"); 
                     String HallName = r.getString("HallName"); 
                     int HallCapacity = r.getInt("HallCapacity");
                     String requestedDate = r.getString("requestDate");

                     System.out.format("%d %30s %13s %15d %15s\n",ReservNo,EventType,HallName,HallCapacity,requestedDate);
                }
                
            }

             s.close();
             r.close();
             conn.close();
      
    }catch(SQLException ex){
        System.out.println(ex.getMessage());  
    } 
  
   }
  

   //calculateTotalPrice function 
   //Calculates the final price for each request. (Prices are increased by 100 if no. of guests are more than 100, and are raised by 200 if no. of guests are more than 200)
    void calculateTotalPrice ()
    {
            try (Connection conn = DriverManager.getConnection(DB.url)){ 
      
            s = conn.createStatement(); // for writing in requests
            
            s2 = conn.createStatement();  //for r  of requests 
            s3 = conn.createStatement();  //for r2 of eventList
            
            
            //1- select all the requests in resultset r
            r=s2.executeQuery("select SP ,reservationNum, EventType, hallCapacity from requests"); 
            

            //2- move over all the requests
            while(r.next())
            {
               //3- select all the events in resultset r2
               r2 =s3.executeQuery("select eventType, estimatedPrice from eventList");
               
               
               Byte SP = r.getByte("SP");
           
                if(SP==1)
                {
                    int RNO = r.getInt("reservationNum");
                          
                    String Req_EventType = r.getString("Eventtype");
                    
                    int EstPrice = 0;
                    
                   //4- move over all eventlist 
                    while(r2.next())
                    {
                       String Event_EventType = r2.getString("Eventtype");
                       
                       if(Req_EventType.equalsIgnoreCase(Event_EventType))
                       {
                           EstPrice = r2.getInt("estimatedPrice");
                           break;
                       }
                    }
                      
                    int finalPrice = 0;
                    int Hallguests = r.getInt("HallCapacity");
         
                    if(Hallguests<=100 )
                           finalPrice=EstPrice;
                        else if (Hallguests>100 && Hallguests<=200)      
                             finalPrice = EstPrice + 100;
                               else
                                   finalPrice = EstPrice +200;
 
                    s.execute("update requests set finalPrice = "+finalPrice+" where reseRvationNum="+RNO );
                    
                }
            }

             System.out.println("Prices are calculated successfully");

             s.close();
             s2.close();
             
             r.close();
             r2.close();
             conn.close();

    }catch(SQLException ex){
        System.out.println(ex.getMessage());  
    } 
    }
    
 
    
   //set ready date 
   //set readydate for requests by selecting the requests with same eventtype and reqDate, setting them all to 'date already booked', then select the requests made first to be 'approved'.
 void setReadyDate()
{
try (Connection conn = DriverManager.getConnection(DB.url))
{ 
    
   //1- Set all dates to be 'approved'
    s = conn.createStatement();
    s.execute("update requests set requestDateCondition='approved' where SP=1");
    
    
 //2- query that selects all res_no with same readydate and eventypes and SP=1 
    s = conn.createStatement();
    r = s.executeQuery("SELECT A.reservationNum, A.requestDate, A.eventType\n" +
"FROM requests as A \n" +
" JOIN (SELECT Eventtype, requestDate\n" +
"            FROM requests\n" +
"			where SP=1\n" +
"            GROUP BY Eventtype, requestDate\n" +
"            HAVING COUNT(*) > 1\n" +
"			)  as B\n" +
"ON A.Eventtype = B.Eventtype AND A.requestDate = B.requestDate\n" +
"where SP=1");

//3- query that sets all there reqStatus to 'Date already Booked'   
       s2 = conn.createStatement();
    while(r.next())
    {
        int reservation_NO =r.getInt("reservationNUM");
        s2.execute("update requests set  requestDateCondition='Date already booked' where reservationNum= "+reservation_NO);

    }

 //4- query that select the first request made (min res no) of every distinct eventtype
    r2 = s.executeQuery("select min(reservationNum) as minResNO,eventType,requestDate from requests \n" +
"where reservationNum IN \n" +
" (\n" +
"SELECT  A.reservationNum\n" +
"FROM requests as A\n" +
" JOIN (SELECT Eventtype, requestDate\n" +
"            FROM requests\n" +
"			where SP=1\n" +
"            GROUP BY Eventtype, requestDate\n" +
"            HAVING COUNT(*) > 1) as B\n" +
"ON A.Eventtype = B.Eventtype AND A.requestDate = B.requestDate\n" +
"where SP=1\n" +
")\n" +
"group by eventtype,requestDate\n" +
"order by eventType");
 
 //5- query that sets the  reqStatus of the first requests made (min res no) to be 'approved'   
    while(r2.next())
    {
        int reservation_NO =r2.getInt("minResNO");
        s2.execute("update requests set  requestDateCondition='approved' where reservationNum="+reservation_NO);
    }
  
    System.out.println("Date was set successfully");
    
    s.close();
    s2.close();
   
    r.close();
    r2.close();
     conn.close();
    
}catch(SQLException ex)
{
 System.out.println(ex.getMessage()); 
}

}
  

  //sentRequests function
 //send requests to PM
 void sendRequests()
   {
            try (Connection conn = DriverManager.getConnection(DB.url)){ 
            s = conn.createStatement();
            s2 = conn.createStatement();

            r=s2.executeQuery("select SP,reservationNum from requests");    
       
            while(r.next())
            {
               Byte SP = r.getByte("SP");
               int RNO = r.getInt("reservationNum");
                
                if(SP==1)
                {
                    s.execute("update requests set PM=1 , SP=0 where reservationNum="+RNO); 
                }
            }
                 System.out.println("Ready dates and Prices are sent to PM successfully");
               
             s.close();
             r.close();
             conn.close();
           
       
    }catch(SQLException ex){
        System.out.println(ex.getMessage());  
    } 

   }
   
 
         @Override
     public String ToString(){
       return "Name is "+this.fname+" "+this.lname+"  Email is : "+this.Email;
   }

}