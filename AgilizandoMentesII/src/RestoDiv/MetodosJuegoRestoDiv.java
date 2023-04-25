/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestoDiv;

import Tiempo.Tiempo;
import Usuario.*;

/**
 *
 * @author CafeConPalito
 */
public class MetodosJuegoRestoDiv {

    //private int nivel = (int) (Math.random() * 4 + 1);
    // private int intentos;
    private int dividendo;
    private int divisor;
    private int respuesta;
    private int tiempoPartida;
    private int aciertos = 0;
    private int intentos = 5;
    private int nivelA;
    private int nivelB;
    private Tiempo tiempo = new Tiempo();

    private void implementarNivel() {
        switch (Usuario.getCurso()) {
            case "1":
                nivelA = 10;
                nivelB = 10;
                break;
            case "2":
                nivelA = 100;
                nivelB = 10;
                break;
            case "3":
                nivelA = 100;
                nivelB = 100;
                break;
            case "4":
                nivelA = 1000;
                nivelB = 100;
                break;
            default:
                throw new AssertionError();
        }

    }

    public void crearPregunta() {
        implementarNivel();
        dividendo = (int) (Math.random() * nivelA + 1);
        divisor = (int) (Math.random() * nivelB + 1);
        while (divisor > dividendo) {
            divisor = (int) (Math.random() * nivelB + 1);
        }
        respuesta = dividendo % divisor;
    }

    /**
     * Metodo que comprueba si la respuesta es correcta, y añade 1 a los
     * aciertos
     *
     * @param respuesta
     * @return boolean si la respuesta es correcta
     */
    public boolean comprobarRespuesta(String respuesta) {
        try {
            int aux = Integer.parseInt(respuesta);
            if (this.respuesta == aux) {
                aciertos++;
                return true;
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        }
        return false;
    }

    public boolean comprobarQuedanIntentos() {
        intentos--;
        return intentos != 0;
    }

    public void iniciarJuego() {
        tiempo.iniciarContador();
    }

    public void terminarJuego() {
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

    public int getAciertos() {
        return aciertos;
    }

    public int getIntentos() {
        return intentos;
    }

}
