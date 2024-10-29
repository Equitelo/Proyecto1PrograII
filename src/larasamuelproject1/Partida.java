/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larasamuelproject1;

import java.time.LocalDate;

public class Partida {
    private String oponente;
    private boolean gano; // true si ganó, false si perdió
    private LocalDate fecha;

    public Partida(String oponente, boolean gano) {
        this.oponente = oponente;
        this.gano = gano;
        this.fecha = LocalDate.now();
    }

    public String getOponente() {
        return oponente;
    }

    public boolean isGano() {
        return gano;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Oponente: " + oponente + " | Resultado: " + (gano ? "Ganó" : "Perdió") + " | Fecha: " + fecha;
    }
}