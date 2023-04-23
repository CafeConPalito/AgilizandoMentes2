/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestoDiv;

/**
 *
 * @author produccion
 */
public class objetosBBDDRestoDiv {
    
    private String alias;
    private int tiempoPartida;
    private String fecha_hora;

    public objetosBBDDRestoDiv(String alias, int tiempoPartida, String fecha_hora) {
        this.alias = alias;
        this.tiempoPartida = tiempoPartida;
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

}
