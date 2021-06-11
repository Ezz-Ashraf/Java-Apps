/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_project;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Ezzeldin
 */
public class Pro_manager extends Person {
    Scanner input =new Scanner(System.in);
    Pro_manager()
    {
    this.role=2;
    }
/*public void Recieve_CustReq()
{
    System.out.print("Reservation number : ");
  String reserve_Num =DB.Result_id_DB_Role("PM", "reservationNum");
    System.out.println(reserve_Num);
    System.out.println("");
    System.out.print("Customer id : ");
    System.out.print(DB.Result_id_DB_Request(reserve_Num, "cid"));
    System.out.println("");
    System.out.print("Hall number : ");
    System.out.print(DB.Result_id_DB_Request(reserve_Num, "HallName"));
    System.out.println("");
System.out.print("Hall Capacity : ");
    System.out.print(DB.Result_id_DB_Request(reserve_Num, "HallCapacity"));
    System.out.println("");
System.out.print("Request Status : ");
    System.out.print(DB.Result_id_DB_Request(reserve_Num, "reqStatus"));
    System.out.println("");
            System.out.print(" request Date: ");
    System.out.print(DB.Result_id_DB_Request(reserve_Num, " requestDate"));
    System.out.println("");
System.out.print(" price: ");
    System.out.print(DB.Result_id_DB_Request(reserve_Num, "finalPrice"));
    System.out.println("");          
}*/
   public void ChangeStatus()
   {
       System.out.println("Enter Reservation number");
       int reserve_num=input.nextInt();
       System.out.println("Enter the request status 1 to approve 2 to decline");
       int status=input.nextInt();
       if (status==1){
       String command ="update requests set reqStatus='Approved' where reservationNum="+reserve_num;
       DB.settodatabase(command);
       }
       else
           
   {
       String command ="update requests set reqStatus='Declined' where reservationNum="+reserve_num;
       DB.settodatabase(command);
       }
   }
   
   public void recieveMessage()
   {
   Message.retrieve(id);
   }
   public void SendMessage()
   {
       int Sid=id;
       System.out.println("Enter the id of the Customer you want to get in contact with");
                int    Cust_id=input.nextInt();
                    System.out.println("Enter the message title");
                    input.nextLine();
            String  messageTitle=input.nextLine();
            System.out.println("Enter the message text");
            String  message=input.nextLine();
        Message.InputMessage(Sid,Cust_id,message,messageTitle);
   }
   public void SP_change()
   {
     System.out.println("Enter Reservation number");
      int reserve_num=input.nextInt();
      Request.sendRequest(reserve_num, role);
 
   }

  public void displayRequests(){
//        ArrayList<String>reserveNum=DB.gettableinfo("requests","reservationNum");
//        ArrayList<String>HallName=DB.gettableinfo("requests","HallName");
//        ArrayList<String>HallCapacity=DB.gettableinfo("requests","HallCapacity");
//        ArrayList<String>requestDate=DB.gettableinfo("requests","requestDate");
//        ArrayList<String>finalPrice=DB.gettableinfo("requests","finalPrice");
//        ArrayList<String>reqStatus=DB.gettableinfo("requests","reqStatus");
//        ArrayList<String>PM=DB.gettableinfo("requests","PM");
//        ArrayList<String>SP=DB.gettableinfo("requests","SP");
//        ArrayList<String>Eadmin=DB.gettableinfo("requests","Eadmin");
//           ArrayList<String>cid=DB.gettableinfo("requests","cid");
//      //  System.out.format("Reserve Num\t\tHall Name\t\tHall Capacity\t\trequest Date\t\tfinal Price\t\trequest Status\t\tPM\t\tSP\t\tAdmin\t\tCustomer id\n");
//      System.out.format("%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\t\t%-20s\n","reserveNum","Hall Name","Hall capacity","request Date","final Price","request status","PM","Sp","Admin","Customer id");
//        for (int i = 0; i < reserveNum.size(); i++) {
//            System.out.format("%-20s\t\t",reserveNum.get(i));
//           System.out.format("%-20s\t\t",HallName.get(i));
//           System.out.format("%-20s\t\t",HallCapacity.get(i));
//             System.out.format("%-20s\t\t",requestDate.get(i));
//          System.out.format("%-20s\t\t",finalPrice.get(i));
//          System.out.format("%-20s\t\t",reqStatus.get(i));
//             System.out.format("%-20s\t\t",PM.get(i));
//          System.out.format("%-20s\t\t",SP.get(i));
//           System.out.format("%-20s\t\t",Eadmin.get(i));
//            System.out.format("%-20s\t\t",cid.get(i));
//            System.out.println("\n");
//        }
//Request r=new Request();
Request.displayRequests(role);
  }
  public void DeleteRequest(int ReserveNum)
  {
  Request.deleteRequest(ReserveNum);
  }
}
