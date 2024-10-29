package larasamuelproject1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
    
    public String user;
    private String password;
    private int cantPuntos;
    private int acumuladorPuntos;
    private String fecha;
    private boolean estado;
    private ArrayList<Partida> historialPartidas;

    
    public Usuario () {}
    
    public Usuario (String user, String password) {
        this.user=user;
        this.password=password;
        this.acumuladorPuntos=0;
        LocalDate fechaActual = LocalDate.now();
        this.fecha=fechaActual.toString();
        this.estado=true;
        this.historialPartidas = new ArrayList<>();
    }
    public void agregarPartida(String oponente, boolean gano) {
        Partida partida = new Partida(oponente, gano);
        historialPartidas.add(partida);
    }

    public ArrayList<Partida> getHistorialPartidas() {
        return historialPartidas;
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
    
    public int getPuntos(){
        return this.acumuladorPuntos;
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
    
    public void toggleEstado(){
        this.estado = !this.estado;
    }
    
    public void cambiarPuntos(int puntos){
        this.acumuladorPuntos += puntos;
    }
    
    public void sumarPuntos(int puntos) {
        if (puntos > 0) {
            this.acumuladorPuntos+=puntos;
        }
    }
    
    public void restarPuntos(int puntos) {
        if (puntos > 0 && this.acumuladorPuntos >= puntos) {
            this.acumuladorPuntos -= puntos;
        }
    }
}
