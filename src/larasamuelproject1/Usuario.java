package larasamuelproject1;

import java.util.Calendar;

public class Usuario {
    
    private String user;
    private String password;
    private int puntos;
    private Calendar fecha;
    private boolean estado;
    
    public Usuario (String user, String password) {
        this.user=user;
        this.password=password;
        this.puntos=0;
        this.fecha = Calendar.getInstance();
        this.estado=false;
    }
    
    public String getUser(){
        return this.user;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public Calendar getFecha() {
        return this.fecha;
    }
}
