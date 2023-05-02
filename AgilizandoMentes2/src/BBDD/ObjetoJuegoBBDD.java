/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

/**
 *
 * @author produccion
 */
public class ObjetoJuegoBBDD {

    private String alias;
    private int tiempoPartida;
    private int aciertos;
    private String fecha_hora;

    /**
     * Constructor con parametros para crear objetos con la informacion referente a la Base de datos
     * @param alias alias del Usuario
     * @param tiempoPartida tiempo total transcurrido en la partida
     * @param aciertos numero de aciertos
     * @param fecha_hora fecha y hora de la partida jugada
     */
    public ObjetoJuegoBBDD(String alias, int tiempoPartida, int aciertos, String fecha_hora) {
        this.alias = alias;
        this.tiempoPartida = tiempoPartida;
        this.aciertos = aciertos;
        this.fecha_hora = fecha_hora;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getTiempoPartida() {
        return tiempoPartida;
    }

    public void setTiempoPartida(int tiempoPartida) {
        this.tiempoPartida = tiempoPartida;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

}
