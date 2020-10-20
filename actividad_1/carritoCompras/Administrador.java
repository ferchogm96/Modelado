import java.io.Serializable;

public class Administrador implements Serializable{

     public String user = "admin";
     public String pass = "pass";

     public String getUser(){
          return this.user;
     }

     public String getPass(){
          return this.pass;
     }

     public void setPass(String pass){
          this.pass = pass;
     }

     public void setUser(String user){
          this.user = user;
     }

}
