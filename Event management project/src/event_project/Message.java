/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_project;
import java.sql.SQLException;
public class Message {
    public static void InputMessage (int sid, int rid, String message, String messageTitle ){
     
             
            String SQL="INSERT INTO messaging(sender, receiver, messageTitle, messageText) VALUES('"+sid+"', '"+rid+"', '"+messageTitle+"', '"+message+"')";
            DB.Add_DB_M(SQL);
        
    }
    
    public static void retrieve (int id){
        if (!"".equals(DB.Result_id_DB_M(id, "messageText"))){
         System.out.println("---------------------------- \n");
           System.out.println("Message Title: " + DB.Result_id_DB_M(id, "messageTitle")+"\n" 
       +"Message Text: " + DB.Result_id_DB_M(id, "messageText")+"\n");
           System.out.println("---------------------------- \n");
            delete(id);}}
   
        

    
    
    private static void delete(int id){
        
            
            String SQL="DELETE FROM messaging WHERE receiver = '"+id+"' ";
            DB.Add_DB_M(SQL);
        
    }
}
