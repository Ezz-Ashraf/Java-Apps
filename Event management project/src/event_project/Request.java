/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_project;

import java.util.ArrayList;

public class Request {
    
  private String reqStatus;
  private String hallName;
  private String requestDate;
  private String eventType;
  private int hallCapacity;
  private int finalPrice;
  private int customerID;
  private int reservationNum;
  private int PM;
  private int Eadmin;
  private int SP;
  
  Request(){
      
  }
  Request(String eventType, String hallname, String requestdate, int hallcapacity, int customerID){
      this.eventType = eventType;
      this.hallName = hallname;
      this.requestDate = requestdate;
      this.hallCapacity = hallcapacity;
      this.customerID = customerID;
  }
void set_reqStatus(String r){
    this.reqStatus = r;
}
void set_hallName(String r){
    this.hallName = r;
}
void set_requestDate(String r){
    this.requestDate = r;
}
void set_eventType(String r){
    this.eventType = r;
}
void set_hallCapacity(int r){
    this.hallCapacity = r;
}
void set_finalPrice(int r){
    this.finalPrice = r;
}
void set_customerID(int r){
    this.customerID = r;
}
void set_reservationNum(int r){
    this.reservationNum = r;
}
void set_PM(int r){
    this.PM = r;
}
void set_SP(int r){
    this.SP = r;
}
void set_Eadmin(int r){
    this.Eadmin = r;
}


String get_reqStatus(){
    return reqStatus;
}
String get_eventType(){
    return eventType;
}
String get_hallName(){
    return hallName;
}
String get_requestDate(){
    return requestDate;
}
int get_hallCapacity(){
    return hallCapacity;
}
int get_finalPrice(){
    return finalPrice;
}
int get_customerID(){
    return customerID;
}
int get_reservationNum(){
    return reservationNum;
}
int get_PM(){
    return PM;
}
int get_SP(){
    return SP;
}
int get_Eadmin(){
    return Eadmin;
}
public static void sendRequest(int reservationNum, int role){
    String command="";
    switch (role){
        case 2:
            command = "update requests set PM = 0, SP = 1 where reservationNum =" + reservationNum;
            break;
        case 3:
            command = "update requests set PM = 1, SP = 0 where reservationNum =" + reservationNum;
            break;
        case 4:
            command = "update requests set PM = 1, Eadmin = 0 where reservationNum =" + reservationNum;
            break;
            }
    DB.settodatabase(command);
}

public static void deleteRequest (int reservationNum){
    String command = "delete from requests where reservationNum =" + reservationNum;
      DB.settodatabase(command);
}
public static void displayRequests(int role){
        ArrayList<String>reserveNum=DB.gettableinfo("requests","reservationNum");
        ArrayList<String>eventType=DB.gettableinfo("requests","eventType");
        ArrayList<String>HallName=DB.gettableinfo("requests","HallName");
        ArrayList<String>HallCapacity=DB.gettableinfo("requests","HallCapacity");
        ArrayList<String>requestDate=DB.gettableinfo("requests","requestDate");
        ArrayList<String>finalPrice=DB.gettableinfo("requests","finalPrice");
        ArrayList<String>reqStatus=DB.gettableinfo("requests","reqStatus");
        ArrayList<String>reqDateCon=DB.gettableinfo("requests","requestDateCondition");
        ArrayList<String>PM=DB.gettableinfo("requests","PM");
        ArrayList<String>SP=DB.gettableinfo("requests","SP");
        ArrayList<String>Eadmin=DB.gettableinfo("requests","Eadmin");
           ArrayList<String>cid=DB.gettableinfo("requests","cid");
    switch(role){
        case 2:{
         
 System.out.format("%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\n","reserveNum","eventType","Hall Name","Hall capacity","request Date","final Price","request status","request Date condition","PM","Sp","Admin","Customer id");
        for (int i = 0; i < reserveNum.size(); i++) {
            if(PM.get(i).equals("1")){
              System.out.format("%-20s\t\t",reserveNum.get(i));
            System.out.format("%-20s\t\t",eventType.get(i));  
           System.out.format("%-20s\t\t",HallName.get(i));
           System.out.format("%-20s\t\t",HallCapacity.get(i));
             System.out.format("%-20s\t\t",requestDate.get(i));
          System.out.format("%-20s\t\t",finalPrice.get(i));
          System.out.format("%-20s\t\t",reqStatus.get(i));
            System.out.format("%-20s\t\t",reqDateCon.get(i));
             System.out.format("%-20s\t\t",PM.get(i));
          System.out.format("%-20s\t\t",SP.get(i));
           System.out.format("%-20s\t\t",Eadmin.get(i));
            System.out.format("%-20s\t\t",cid.get(i));
            System.out.println("\n");
        }
        }
        break;
}
         
       
        case 3:{
   System.out.format("%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\n","reserveNum","eventType","Hall Name","Hall capacity","request Date","final Price","request status","request Date condition","PM","Sp","Admin","Customer id");
          for (int i = 0; i < reserveNum.size(); i++) {
            if(SP.get(i).equals("1")){
              System.out.format("%-20s\t\t",reserveNum.get(i));
            System.out.format("%-20s\t\t",eventType.get(i));  
           System.out.format("%-20s\t\t",HallName.get(i));
           System.out.format("%-20s\t\t",HallCapacity.get(i));
             System.out.format("%-20s\t\t",requestDate.get(i));
          System.out.format("%-20s\t\t",finalPrice.get(i));
          System.out.format("%-20s\t\t",reqStatus.get(i));
            System.out.format("%-20s\t\t",reqDateCon.get(i));
             System.out.format("%-20s\t\t",PM.get(i));
          System.out.format("%-20s\t\t",SP.get(i));
           System.out.format("%-20s\t\t",Eadmin.get(i));
            System.out.format("%-20s\t\t",cid.get(i));
            System.out.println("\n");
        }
        }
        
          break;
  }

          
           case 4:{
               System.out.format("%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\n","reserveNum","eventType","Hall Name","Hall capacity","request Date","final Price","request status","request Date condition","PM","Sp","Admin","Customer id");
        for (int i = 0; i < reserveNum.size(); i++) {
            if(Eadmin.get(i).equals("1")){
            System.out.format("%-20s\t\t",reserveNum.get(i));
            System.out.format("%-20s\t\t",eventType.get(i));  
           System.out.format("%-20s\t\t",HallName.get(i));
           System.out.format("%-20s\t\t",HallCapacity.get(i));
             System.out.format("%-20s\t\t",requestDate.get(i));
          System.out.format("%-20s\t\t",finalPrice.get(i));
          System.out.format("%-20s\t\t",reqStatus.get(i));
            System.out.format("%-20s\t\t",reqDateCon.get(i));
             System.out.format("%-20s\t\t",PM.get(i));
          System.out.format("%-20s\t\t",SP.get(i));
           System.out.format("%-20s\t\t",Eadmin.get(i));
            System.out.format("%-20s\t\t",cid.get(i));
            System.out.println("\n");
        }
        }
            break;
        }
            
           
        default:{
            System.out.println("Your role doesn't exist");
        }
    }
 }
}

