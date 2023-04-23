/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestoDiv;

import Tiempo.Tiempo;

/**
 *
 * @author CafeConPalito
 */
public class MetodosRestoDiv {

    //private int nivel = (int) (Math.random() * 4 + 1);
    // private int intentos;
    private int dividendo;
    private int divisor;
    private int respuesta;
    private int tiempoPartida;
    private Tiempo tiempo = new Tiempo();

    public MetodosRestoDiv() {
        dividendo = (int) (Math.random() * 100 + 1);
        divisor = (int) (Math.random() * 100 + 1);
        while (divisor > dividendo) {
            divisor = (int) (Math.random() * 10 + 1);
        }
        respuesta = dividendo % divisor;
    }

    public void iniciarJuego() {
        tiempo.iniciarContador();
    }

    public void terminarJuego(){
        tiempo.pararContador();
        tiempoPartida = tiempo.getSecTranscurridos();
    }

    public int getDividendo() {
        return dividendo;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public int getTiempoPartida() {
        return tiempoPartida;
    }
    
    
}
