package larasamuelproject1;

public class Logica {
    String userName;
    String password;
    String date;
    boolean active;
    
    Logica (String userName, String password, String date) {
        this.userName=userName;
        this.password=password;
        this.date=date;
        this.active=false;
    }
    
    public String getUser(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getDate(){
        return this.date;
    }
    
    
}
