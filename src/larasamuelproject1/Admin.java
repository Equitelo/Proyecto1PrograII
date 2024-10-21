package larasamuelproject1;

public class Admin {
    
    private Usuario []usr;
    
    public Admin(){
        this.usr=new Usuario[20];
    }
    
    public Usuario[] getUser(){
        return this.usr;
    }
    
    public Usuario buscarUsuario(String user){
        for (Usuario pos: usr) {
            if(pos!=null && pos.getUser().equals(user)){
                return pos;
            }
        }
        return null;
    }
    
    public boolean agregarUsuario(String user, String password){
        if(buscarUsuario(user)==null){
            for (int pos = 0; pos < 10; pos++) {
                if(usr[pos] == null){
                    usr[pos] = new Usuario(user, password);
                    return true;
                }
            }
        }
        return false;
    }
    
}
