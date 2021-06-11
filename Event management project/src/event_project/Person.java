
package event_project;

import java.util.ArrayList;

/**
 *
 * @author omark
 */
public class Person {
    protected String fname;
    protected String lname;
    protected String Email;
    protected String password;
    protected int role;
    protected int id;
       Person(){
        
    }
    Person(String fname,String lname,String Email,String password,int id){
        this.fname=fname;
        this.lname=lname;
        this.Email=Email;
        this.password=password;
        this.id=id;
        
    }
    Person (String fname,String lname,String Email,String password){
      this.fname=fname;
        this.lname=lname;
        this.Email=Email;
        this.password=password; 
    }
    public boolean login (){
        if(this.idexist(this.id)&&this.password!=null&&this.password.equals(DB.Result_id_DB(this.id,"uPassword"))){
            this.setrole(this.id);
            return true;
        }
        return false;
    }
    private void setrole(int id){
        this.role=Integer.parseInt(DB.Result_id_DB(this.id,"role"));
    }
    public int getrole(){
        return this.role;
    }
    public String ForgotMyPassword(int id,String Answer){
        if(this.idexist(id)&&Answer.equals(DB.Result_id_DB(id,"Answer")))
        {
            this.id=id;
            this.password=DB.Result_id_DB(this.id,"uPassword");
            return "Your id is '"+id+"' and your password is :'"+this.password+"' ";
        }
        else{
            return "Wrong Id or Answer";
        }
    }
    public void setid(int id){
        this.id=id;
    }
   public void setfname(String fname){
       this.fname=fname;
   }
   public void setlname(String lname){
       this.lname=lname;
   }
   public void setemail(String Email){
       this.Email=Email;
   }
   public void setpassword(String password){
       this.password=password;
   }
   public int getid(){
       return this.id;
    }
   public String getfname(){
       return this.fname;
   }
   public String getlname(){
       return this.lname;
   }
   public String getemail(){
       return this.Email;
   }
   public String getpassword(){
       return this.password;
   }
   protected  ArrayList<String> display_fromuser_table(String column){
        ArrayList<String> c=new ArrayList();
        c=DB.gettableinfo("users",column);
        return c;
    }
   protected boolean Emailexist(String Email){
        ArrayList<String>s=display_fromuser_table("email");
        for (int i = 0; i < s.size(); i++) {
            if(s.get(i).equals(Email)){
                return true;}
        }
        
        return false;
    }
    protected boolean idexist(int id){
        ArrayList<String> ids=display_fromuser_table("id");
        for (int i = 0; i < ids.size(); i++) {
            if(Integer.parseInt(ids.get(i))==id)
                return true;
        }
        return false;
    }
   public String ToString(){
       return "Name is "+this.fname+" "+this.lname+"  Email is : "+this.Email;
   }
}
