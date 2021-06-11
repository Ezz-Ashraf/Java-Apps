
package event_project;
import java.util.*;



public class Event_project {
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Choose the operation from the following");
        System.out.println("1 - login\n2 - Sign up\n3 - Forgot my password\n4 - Exit");
        int choice=input.nextInt();
        Person p=new Person();
        switch(choice){
            case 1:{
                int id; String password;
                System.out.println("Enter your id");
                id=input.nextInt();
                input.nextLine();
                System.out.println("Enter your password");
                password=input.nextLine();
                p.setid(id);
                p.setpassword(password);
                if(p.login())
                    System.out.println("You have logged in");
                else
                    System.out.println("Wrong information");
                break;
            }
            case 2:{
                Customer n = new Customer();
                n.createAccount();
                System.exit(0);
                break;
            }
            case 3:{
                System.out.println("Enter your id");
                int id=input.nextInt();
                input.nextLine();
                System.out.println("Enter Your Answer");
                String answer=input.nextLine();
                System.out.println(p.ForgotMyPassword(id, answer));
                System.exit(0);
                break;   
            }
            case 4:
                    {
                    System.exit(0);
                    break;
                    }
            default:
                System.out.println("Wrong choice");
        }
        switch(p.getrole()){
            case 1:{
                Customer c = new Customer(p);
                int cusChoice;
                do{
                System.out.println("Choose the operation from the following");
                System.out.println("1 - Book an Event\n2 - Manage Bookings\n3 - Contact Project Manager\n4 - Read Inbox\n5 - Exit");
                cusChoice = input.nextInt();
                switch (cusChoice){
                    case 1:
                        DB.showEvents();
                        c.makeRequest();
                        break;
                    case 2:
                        c.ManageBooking();
                        break;
                    case 3:
                        c.SendMessage();
                        break;
                    case 4:
                       c.recieveMessage();
                       break;
                    case 5:
                        System.out.println("Program closed");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }} while (cusChoice!=5);
                break;
            }
            case 2:{
                int n;
                do {
                Pro_manager pm = new Pro_manager();
                pm.setid(p.getid());
                System.out.println("Hello PM");
                System.out.println("Enter 1 to display requests 2 to recieve messages 3 to send messages 4 to send requests to sp 5 to change request status 6 to delete request (To exit enter -1) ");
                n=input.nextInt();
                switch(n){
                    case -1:{
                        System.exit(0);
                        break;}
                    case 1:{
                        pm.displayRequests();
                        break;}
                    case 2:{
                        pm.recieveMessage();
                        break;}
                    case 3:{
                        pm.SendMessage();
                        break;
                    }
                    case 4:{
                        pm.SP_change();
                    break;
                    }
                        case 5:
                        {   pm.ChangeStatus();
                        break;}
                        
                    case 6:{
                        System.out.println("Enter reservetaion number of the request to delete");
                        int res=input.nextInt();
                        pm.DeleteRequest(res);
                        break;}
                    default:
                        System.out.println("Wrong input");
                }
                
                } while(n!=-1);
                break;
            }
            case 3:{
                ServiceProvider sp = new ServiceProvider();

            System.out.print("Welcome SP,");   
            
             int n;
             int c;
             
             do{
                 System.out.println(" Please choose one of the following operations \n1- Show available requests."
                    + " \n2- Calculate total prices. \n3- Set ready dates for requests \n4- Sent requests to PM \n -1 to exit"); 
                 
                 n=input.nextInt();
                 
                switch(n){
                    case -1:{
                        System.exit(0);
                        break;}
                    case 1:{
                        sp.showRequests();
                        break;}
                    case 2:{
                        sp.calculateTotalPrice();
                        break;}
                    case 3:{ 
                        sp.setReadyDate();
                        break;
                    }
                    case 4:{
                        sp.sendRequests();
                    break;
                    }
                    default:
                        System.out.println("Wrong input, Please try entering a valid input");
                  
                }
                
                 System.out.println("\nWould you like perform do another operation? ' 1 ' for yes, ' -1 ' to exit.");
                 c = input.nextInt();
                 
                 if(c!=-1)
                     continue;
                 else
                     System.exit(0);
          
                } while(n!=-1);
                break;
            }
            case 4:{
                String repeat="No";
                do{
                Admin admin=new Admin(p);
                System.out.println("Welcome Admin\n1-Add new employee\n2-Remove user\n3-Update the role of existing employee\n4-show customers requests\n5-Set customes requests");
                int x=input.nextInt();
                input.nextLine();
                if(x==1){
                    System.out.println("Enter the first name of the employee");
                    String fname=input.nextLine();
                    System.out.println("Enter the last name of the employee");
                    String lname=input.nextLine();
                    System.out.println("Enter the Email of the employee");
                    String Email=input.nextLine();
                    System.out.println("Enter the password of the employee");
                    String Password=input.nextLine();
                    System.out.println("Enter the role of the new employee");
                    int role=input.nextInt();
                            input.nextLine();
                            System.out.println("Enter the Answer");
                            String Answer=input.nextLine();
                            
                    Person emp=new Person();
                    emp.setemail(Email);
                    emp.setfname(fname);
                    emp.setlname(lname);
                    emp.setpassword(Password);
                    admin.addemployee(emp, role, Answer);
                    
                    
                }
               else if(x==2){
                    System.out.println("List of users");
                    admin.displayusers();
                    System.out.println("Enter the id of the user do you want to remove");
                    int n=input.nextInt();
                    input.nextLine();
                     admin.removeemployee(n);
                }
                else if(x==3){
                    System.out.println("Enter the id of the user do you want to update");
                    int id=input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the new role ");
                    int role=input.nextInt();
                    input.nextLine();
                    admin.updateemployee(id,role);
                }
                else if(x==4){
                    Request.displayRequests(admin.getrole());
                }
                 else if(x==5){
                    System.out.println("1-Send the request to PM\n2-Remove the request");
                        int c=input.nextInt();
                                input.nextLine();
                         if(c==1){
                             System.out.println("Enter reservation id");
                             int resid=input.nextInt();
                             input.nextLine();
                             admin.Setrequest(resid);
                         }
                         else if(c==2){
                             System.out.println("Enter reservation id");
                             int resid=input.nextInt();
                             input.nextLine();
                             admin.deletereq(resid);
                         }
                         else{
                             System.out.println("Wrong choice");
                         }
                        }
                 else{
                     System.out.println("Wrong choice");
                 }
                    System.out.println("Write Yes to repeat the menu or No to logout");
                    repeat=input.nextLine();
                }while(repeat.equalsIgnoreCase("Yes"));
                break;
               
            }
            default :{
                System.out.println("Login failed");
            }
               
        }
    }
}
