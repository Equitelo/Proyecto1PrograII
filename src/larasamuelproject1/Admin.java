package larasamuelproject1;

public class Admin {
    
    private Usuario []usr;
    public Usuario usuarioActual;
    
    
    public Admin(){
        this.usr=new Usuario[20];
    }
    
    public Usuario[] getUser(){
        return this.usr;
    }
    
    public Usuario buscarUsuario(String user, boolean cambiarUsuarioActual) {
    for (Usuario pos: usr) {
        if (pos != null && pos.getUser().equals(user)) {
            if (cambiarUsuarioActual) {
                this.usuarioActual = pos;
                this.usuarioActual.activarEstado();
            }
            return pos;
        }
    }
    return null;
}

public Usuario buscarUsuario(String user) {
    // Por defecto, permite cambiar el usuario actual
    return buscarUsuario(user, true);
}
    
    public boolean agregarUsuario(String user, String password) {
    if (buscarUsuario(user) == null) {
        for (int pos = 0; pos < usr.length; pos++) {
            if (usr[pos] == null) {
                Usuario newUser = new Usuario(user, password);
                usr[pos] = newUser;
                this.usuarioActual = newUser;

                
                
                return true;
            }
        }
    }
    return false;
}
    
    public boolean logOut(String password) {
        for (int i = 0; i < usr.length; i++) {
            if (usr[i] != null && usr[i].getPassword().equals(password)) {
                if (usuarioActual != null && usuarioActual.getPassword().equals(password)) {
                    usuarioActual = null; // Cierra la sesión del usuario actual si coincide
                }
                return true;
            }
        }
        return false;
    }
    
    public String getUsuarioActual(){
        return this.usuarioActual.getUser();
    }
    
    public void ganarPartida(String oponenteNombre) {
    Usuario oponente = buscarUsuario(oponenteNombre, false);
    
    if (oponente != null) {
        // Sumar puntos al usuario actual ya que ganó
        usuarioActual.sumarPuntos(3);
        
        // Registrar la partida en ambos usuarios
        usuarioActual.agregarPartida(oponente.getUser(), true); // Usuario actual ganó
        oponente.agregarPartida(usuarioActual.getUser(), false); // Oponente perdió
    } else {
        System.err.println("Error: No se encontró al oponente con nombre: " + oponenteNombre);
    }
}

public void perderPartida(String oponenteNombre) {
    Usuario oponente = buscarUsuario(oponenteNombre, false);
    
    if (oponente != null) {
        // Sumar puntos al oponente ya que el usuario actual perdió
        oponente.sumarPuntos(3);
        
        // Registrar la partida en ambos usuarios
        usuarioActual.agregarPartida(oponente.getUser(), false); // Usuario actual perdió
        oponente.agregarPartida(usuarioActual.getUser(), true); // Oponente ganó
    } else {
        System.err.println("Error: No se encontró al oponente con nombre: " + oponenteNombre);
    }
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
    
    public String buscarOponente(String oponenteNombre){
        for (Usuario pos : usr) {
            if (pos != null && pos.getUser().equals(oponenteNombre) && !pos.getUser().equals(usuarioActual.getUser())) {
                return oponenteNombre;
            }
        }
        return null;
    }
    
    public String[] ranking() {
        // Clonar el arreglo de usuarios para no modificar el original
        Usuario[] usuariosOrdenados = new Usuario[usr.length];
        int index = 0;

        for (Usuario usuario : usr) {
            if (usuario != null) {
                usuariosOrdenados[index++] = usuario;
            }
        }

        // Ordenar el arreglo por puntos usando el método de burbuja
        bubbleSort(usuariosOrdenados, index);

        // Crear un arreglo de nombres para devolver el ranking
        String[] rankingNombres = new String[index];
        for (int i = 0; i < index; i++) {
            rankingNombres[i] = usuariosOrdenados[i].getUser() + ": " + usuariosOrdenados[i].getPuntos() + " puntos";
        }

        return rankingNombres;
    }

    // Método de ordenamiento burbuja para usuarios basado en puntos
    private void bubbleSort(Usuario[] usuarios, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (usuarios[j].getPuntos() < usuarios[j + 1].getPuntos()) { // Ordenar de mayor a menor
                    Usuario temp = usuarios[j];
                    usuarios[j] = usuarios[j + 1];
                    usuarios[j + 1] = temp;
                }
            }
        }
    }
}
