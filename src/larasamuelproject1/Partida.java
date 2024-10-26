/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

/**
 *
 * @author user
 */
public abstract class Partida {
    
    protected int puntos;
    
    public Partida(){
        
    }
    
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
}
