
package event_project;

import java.util.ArrayList;
public class Admin extends Person {
    public Admin(){
        this.role=4;
    }
    public Admin(String fname,String lname,String Email,String password,int id){
        super(fname,lname,Email,password,id);
        this.role=4;
    }
    public Admin(Person p){
        this.id=p.getid();
        this.password=p.getpassword();
        this.role=4;
    }
    public void addemployee(Person p,int role,String Answer){
        if(!this.Emailexist(p.getemail())&&role>0&&role<=4&&p.getemail().matches("(.*)@(.*).com")){
            String query="insert into users (fname, lname, email, uPassword,role,Answer)  values('"+p.getfname()+"','"+p.getlname()+"','"+p.getemail()+"','"+p.getpassword()+"','"+role+"','"+Answer+"')";
            DB.settodatabase(query);
            System.out.println("User has been added succssefully");
        }
        else 
            System.out.println("Failed to add user");
    }
    public void removeemployee(int id){
        if(this.idexist(id)){
            String query="delete from users where id='"+id+"'";
            DB.settodatabase(query);
            System.out.println("Person with id ='"+id+"' has been removed successfully");
        }
        else 
            System.out.println("Wrong id");
    }
    public void updateemployee(int id,int role){
        if(role>0&&role<=4&&this.idexist(id)){
            String query="update users set role='"+role+"'where id='"+id+"'";
            DB.settodatabase(query);
            System.out.println("Role number "+role+" has been assigned to employee with id : "+id);
        }
        else{
            System.out.println("Failed to update the role of the employee");
        }
    }
    public void Setrequest(int resid){
        Request.sendRequest(resid, this.role);
        System.out.println("Request has been sent to be reviewed by Project manager");
    }
    public void deletereq(int resid){
        Request.deleteRequest(resid);
        System.out.println("Request has been deleted");
    }
    public void displayusers(){
        ArrayList<String>id=DB.gettableinfo("users","id");
        ArrayList<String>fname=DB.gettableinfo("users","fname");
        ArrayList<String>role=DB.gettableinfo("users","role");
        System.out.print("Id\t\tName\t\tRole\n");
        for (int i = 0; i < id.size(); i++) {
            System.out.print(id.get(i)+"\t\t");
            System.out.print(fname.get(i)+"\t\t");
            System.out.print(role.get(i)+"\t\t");
            System.out.println("");
        }
    }
    @Override
    public String ToString(){
       return super.ToString()+" role =Admin";
   }
}
