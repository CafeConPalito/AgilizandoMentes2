/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

/**
 *
 * @author terciodemarte
 */
public class ObjetoClasificacionBBDD {
    private String nivel,partidas,totalaciertos,mediaAciertos,nombre,apellido1,apellido2,juego;

    public ObjetoClasificacionBBDD(String nivel, String partidas, String totalaciertos, String mediaAciertos, String nombre, String apellido1, String apellido2,String juego) {
        this.nivel = nivel;
        this.partidas = partidas;
        this.totalaciertos = totalaciertos;
        this.mediaAciertos = mediaAciertos;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.juego =juego;
    }

    public ObjetoClasificacionBBDD(String nivel, String partidas, String totalaciertos, String mediaAciertos, String nombre, String apellido1, String apellido2) {
        this.nivel = nivel;
        this.partidas = partidas;
        this.totalaciertos = totalaciertos;
        this.mediaAciertos = mediaAciertos;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    

    public ObjetoClasificacionBBDD() {
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPartidas() {
        return partidas;
    }

    public void setPartidas(String partidas) {
        this.partidas = partidas;
    }

    public String getTotalaciertos() {
        return totalaciertos;
    }

    public void setTotalaciertos(String totalaciertos) {
        this.totalaciertos = totalaciertos;
    }

    public String getMediaAciertos() {
        return mediaAciertos;
    }

    public void setMediaAciertos(String mediaAciertos) {
        this.mediaAciertos = mediaAciertos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }
    
    
}
