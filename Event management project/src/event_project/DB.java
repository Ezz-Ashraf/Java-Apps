/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
    static String name = "EMS_Project";
    static String url =  "jdbc:sqlserver://LAPTOP-60NVTSQ7\\SQLEXPRESS:1433;databaseName=EMS_Project;integratedSecurity=true;";
       static Connection c;
   static Statement ss;
   static String query;
   static  ResultSet r;
 public static void Add_DB(String command)
{
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();
query=command ;  
   ss.execute(query);
System.out.println("Done");
   }
catch(SQLException ee)
{
    System.out.println("Error");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}


   }
 
}
public static String Result_id_DB(int id,String requested)
{
    String result="";
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();


r=ss.executeQuery("select * from users where id = "+id);
r.next();
    result= r.getString(requested);
   }
catch(SQLException ee)
{
    System.out.println("Error in connection");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}
}
   return result;
}


// messages table
 public static void Add_DB_M(String command)
{
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();
query=command ;  
       boolean execute = ss.execute(query);
System.out.println("Done");
   }
catch(SQLException ee)
{
    System.out.println("Error");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}


   }
 
}
public static String Result_id_DB_M(int id,String requested)
{
    String result="";
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();


r=ss.executeQuery("select * from messaging where receiver = "+id);
r.next();
    result= r.getString(requested);
   }
catch(SQLException ee)
{
    System.out.println("No messages available");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}
}
   return result;
}
// request table retrieve
public static String Result_id_DB_Role(String role,String requested)
{
    String result="";
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();


r=ss.executeQuery("select * from requests where "+role+"=1");
r.next();
    result= r.getString(requested);
   }
catch(SQLException ee)
{
    System.out.println("Error in connection");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}
}
   return result;
}
public static String Result_id_DB_Request(String reserve_Num,String requested)
{
    String result="";
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();


r=ss.executeQuery("select * from requests where reservationNum ="+reserve_Num);
r.next();
    result= r.getString(requested);
   }
catch(SQLException ee)
{
    System.out.println("Error in connection");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}
}
   return result;
}
public static ArrayList<String> gettableinfo(String table,String info){
    ArrayList <String> arr=new ArrayList();
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();


r=ss.executeQuery("select * from "+table);
while(r.next())
    arr.add(r.getString(info));
   }
catch(SQLException ee)
{
    System.out.println("Error in connection");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}
}
  return arr;
}
public static int settodatabase(String command)
{
   try{
        c      = DriverManager.getConnection(url);
         ss=c.createStatement();


       ss.execute(command);
       

   }
catch(SQLException ee)
{
    System.out.println("Error in connection");
    return -1;
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
    return -1;
}
}
   return 1;
}

    public static void showEvents(){
           try (Connection conn = DriverManager.getConnection(url)){
        String sql = "SELECT * FROM eventList";
 
Statement statement = conn.createStatement();
ResultSet result = statement.executeQuery(sql);

System.out.format("%-20s%-20s%-20s%-20s%-20s%s\n", "eventType", "hallname", "hallCapacity",
        "Available from", "Available to", "price range");

while (result.next()){
    String eventType = result.getString("eventType");
    String hallname = result.getString("HallName");
    int hallcapacity = result.getInt("HallCapacity");
    String fromDate = result.getString("fromDate");
    String toDate = result.getString("toDate");
    int estimatedPrice = result.getInt("estimatedPrice");
    
 
    String output = "%-20s%-20s%-20d%-20s%-20s%d";
    System.out.println(String.format(output, eventType, hallname, hallcapacity, fromDate,
            toDate, estimatedPrice));
    
}  
           }
        catch (SQLException ex){
        System.out.println("Erorr connecting to Database");
    }
  }
    
  public static void showRequests(int cid){
           try (Connection conn = DriverManager.getConnection(url)){
        String sql = "SELECT * FROM requests WHERE cid = ?";
 
PreparedStatement statement = conn.prepareStatement(sql);
statement.setInt(1, cid);
ResultSet result = statement.executeQuery();

System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%s\n","Event Type", "Reservation number",
         "Hall name", "Hall Capacity","Ready date", "Final price", "Request status");

while (result.next()){
    String eventType = result.getString("eventType");
    String hallname = result.getString("HallName");
    int hallcapacity = result.getInt("HallCapacity");
    String readydate = result.getString("requestDate");
    int finalprice = result.getInt("finalPrice");
    int resvnum = result.getInt("reservationNum");
    String reqstatus = result.getString("reqStatus");
    
 
    String output = "%-20s%-20d%-20s%-20d%-20s%-20d%s";
    System.out.println(String.format(output, eventType, resvnum, hallname, 
            hallcapacity, readydate, finalprice, reqstatus));
    
}  
           }
        catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
  }  
    
    
  public static void showProjectManagers(){
try (Connection conn = DriverManager.getConnection(url)){
String sql = "SELECT id, fname, lname FROM users WHERE role = 2";
 
Statement statement = conn.createStatement();
ResultSet result = statement.executeQuery(sql);
System.out.format("%-10s%s\n", "ID", "Project Manager");
System.out.println("------------------------------");
while (result.next()){
    int idTemp = result.getInt(1);
    String fName = result.getString(2);
    //String lName = result.getString(3);
    System.out.format("%-10d%s\n", idTemp, fName);
}
   }
    catch (SQLException ex){
        System.out.println("Erorr connecting to Database");
    }
  }
  
 public static int Result_email_DB(String email,String requested)
{
    int result=0;
   try{
          c      = DriverManager.getConnection(url);
         ss=c.createStatement();


r=ss.executeQuery("select * from users where email = '"+ email +"'");
r.next();
    result= r.getInt(requested);
   }
catch(SQLException ee)
{
    System.out.println("Error in connection");
}
   finally{
  try {
   c.close();
   ss.close();
   }
  catch(SQLException ee)
{
    System.out.println("Error");
}
}
   return result;
}
}
