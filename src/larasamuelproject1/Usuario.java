package larasamuelproject1;

import java.util.Calendar;

public class Usuario {
    
    public String user;
    private String password;
    private int puntos;
    private String fecha;
    private boolean estado;
    
    public Usuario () {}
    
    public Usuario (String user, String password) {
        this.user=user;
        this.password=password;
        this.puntos=0;
        Calendar calendar = Calendar.getInstance();
        this.fecha=calendar.toString();
        this.estado=true;
    }
    
    public String getUser(){
        return this.user;
    }
    
    public void setNewPassword(String password){
        this.password=password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPuntos(int p){
        this.puntos=p;
    }
    
    public String getFecha() {
        return this.fecha;
    }
    
    public boolean getEstado(){
        return this.estado;
    }
    
    public void activarEstado(){
        this.estado=true;
    }
    
    public void desactivarEstado(){
        this.estado=false;
    }
}
