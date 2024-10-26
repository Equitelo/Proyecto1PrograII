package larasamuelproject1;

import javax.swing.JOptionPane;

public class Admin {
    
    private Usuario []usr;
    public Usuario usuarioActual;
    
    
    public Admin(){
        this.usr=new Usuario[20];
    }
    
    public Usuario[] getUser(){
        return this.usr;
    }
    
    public boolean buscarUsuario(String user){
        for (Usuario pos: usr) {
            if(pos!=null && pos.getUser().equals(user)){
                this.usuarioActual=pos;
                this.usuarioActual.activarEstado();
                return true;
            }
        }
        return false;
    }
    
    public boolean agregarUsuario(String user, String password){
        if(!buscarUsuario(user)){
            for (int pos = 0; pos < 10; pos++) {
                if(usr[pos] == null){
                    Usuario newUser = new Usuario(user, password);
                    usr[pos] = newUser;
                    this.usuarioActual = newUser;
                    return true;
                }
            }
        }
        return false;
    }
    
    public void logOut(){
        this.usuarioActual=null;
    }
    
    public String getUsuarioActual(){
        return this.usuarioActual.getUser();
    }
    
    public String[] mostrarOponente(){
        
        int totalUsuarios = 0;
        for (Usuario pos: usr) {
            if (pos != null) {
                totalUsuarios++;
            }
        }
        
        if (totalUsuarios < 2) {
            return new String[] {"No hay suficientes usuarios registrados"};
        }
        
        int cantidad = 0;
        
        String []nombres = new String[totalUsuarios - 1];
        cantidad=0;
        for (int i = 0; i < usr.length; i++) {
            if(usr[i]!=null && !usr[i].getUser().equals(this.usuarioActual.getUser())){
                nombres[cantidad] = usr[i].user;
                cantidad++;
            }
        }
        return nombres;
    }
    
}
