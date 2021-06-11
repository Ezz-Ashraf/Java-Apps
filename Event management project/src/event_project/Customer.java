/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_project;

import java.util.*;

/**
 *
 * @author hussein
 */
public class Customer extends Person{
    Scanner input =new Scanner(System.in);
    public Customer (){
        
    }
    public Customer(String fname,String lname,String Email,String password,int id){
          super(fname,lname,Email,password,id);
    }
    public Customer (Person P){
        this.fname= P.getfname();
        this.lname=P.getlname();
        this.Email=P.getemail();
        this.password= P.getpassword();
        this.id= P.getid();
    }
    public void makeRequest(){
        try{
     System.out.println("Enter the following info to make a request");
     System.out.println("Enter Event Type");
      String etype = input.nextLine();
     System.out.println("Enter Hall name");
     String hname = input.nextLine();
     System.out.println("Enter Hall capacity");
     int cap = input.nextInt();
     input.nextLine();
     System.out.println("Enter booking date in YYYY-MM-DD format");
     String date = input.nextLine();
     Request r = new Request(etype, hname, date, cap, id);
     InsertRequest(r);
     
    }
        catch (InputMismatchException e){
          System.out.println("Wrong input, try again");
        }
    }
    public void InsertRequest (Request r){
String query=" insert into requests (eventType, HallName, HallCapacity, requestDate, cid) "
              + "values('"+r.get_eventType()+"', '"+r.get_hallName()+"', '"+r.get_hallCapacity()+"', '"+r.get_requestDate()+"', '"+r.get_customerID()+"')";
      int c = DB.settodatabase(query);
      if (c!=-1)
      System.out.println("Event booked successfully");
}
    
    public void recieveMessage()
   {
   Message.retrieve(id);
   }
   public void SendMessage()
   {
       DB.showProjectManagers();
                int Sid= id;
                System.out.println("Enter the id of the Project Manager you want to contact\n");
                int PM_id=input.nextInt();
                   System.out.println("Enter the message title");
                    input.nextLine();
            String  messageTitle=input.nextLine();
            System.out.println("Enter the message text");
            String  message=input.nextLine();
        Message.InputMessage(Sid,PM_id,message,messageTitle);
   }
   
  public void ManageBooking(){
      System.out.println("These are your bookings");
      DB.showRequests(id);
      System.out.println("Enter Reservation number for the request you want to delete, or 0 to exit");
      int tempRes = input.nextInt();
      if (tempRes!=0){
      Request.deleteRequest(tempRes);
      System.out.println("Request deleted successfully");
      }
      
  }
    public void createAccount(){
     System.out.println("Enter your first name");
     String name1 = input.nextLine();
     System.out.println("Enter your last name");
     String name2 = input.nextLine();
     System.out.println("Enter your Email");
     String uEmail = input.nextLine();
     System.out.println("Enter your Password");
     String uPassword = input.nextLine();
     System.out.println("Enter your security Answer");
     String Answer = input.nextLine();
     
    String query="insert into users (fname, lname, email, uPassword,Answer,role)  values('"+name1+"','"+name2+"','"+uEmail+"','"+uPassword+"','"+Answer+"', 1)";
            DB.settodatabase(query);
            int uID = DB.Result_email_DB(uEmail, "id");
            String msg = "Account created succssefully, your ID is " + uID +
                     " and your password is " + uPassword;
            Message.InputMessage(0, uID, msg, "Your ID and Password");
            System.out.println(msg);
    }
     
    }
    



