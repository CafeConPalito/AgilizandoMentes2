/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Euclides;

import Tiempo.Tiempo;
import Usuario.Usuario;

/**
 *
 * @author CafeConPalito
 */
public class MetodosJuegoEuclides {

    private int numeroMayor;
    private int numeroMenor;
    private int respuesta;
    private int contador = 5;
    private Tiempo tiempo = new Tiempo();
    private int nivelA=10;
    private int nivelB=10;
    private int tiempoPartida;
    private int aciertos = 0;
    private int intentos = 5;

    /**
     * inicializa los dos valores para encontrar el maximo comun divisor e
     * inicia el algoritmo de MetodosJuegoEuclides que nos dara el maximo comun
     * divisor de los dos numeros
     */
    public void crearPregunta(int nivel) {
        implementarNivel(nivel);
        numeroMayor = (int) (Math.random() * nivelA + 1);
        numeroMenor = (int) (Math.random() * nivelB + 1);

        while (numeroMenor > numeroMayor) {
            numeroMenor = (int) (Math.random() * nivelB + 1);
        }

        euclides(numeroMayor, numeroMenor, nivel);
    }

    /**
     * Calcula el Maximo comun divisor de dos numeros.
     *
     * @param x
     * @param y
     */
    private void euclides(int x, int y,int nivel) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        respuesta = x;

        // Para evitar que el MaximoComunDivisor sea 1, pasa casi siempre,
        // se coloca un contador y condicion para volver a intentarlo y volver a lanzar el juego
        if (respuesta == 1 && contador > 0) {
            contador--;
            crearPregunta(nivel);
        }

    }

    public boolean comprobarRespuesta(String respuesta) {
        try {
            int aux = Integer.parseInt(respuesta);
            if (this.respuesta == aux) {
                aciertos++;
                return true;
            }
        } catch (NumberFormatException nfe) {
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

    public void implementarNivel(int nivel) {
        switch (nivel) {
            case 1:
                nivelA = 10;
                nivelB = 10;
                break;
            case 2:
                nivelA = 100;
                nivelB = 10;
                break;
            case 3:
                nivelA = 100;
                nivelB = 100;
                break;
            case 4:
                nivelA = 1000;
                nivelB = 100;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public String textoPregunta(){
        return "El MCD de " +numeroMayor + " y " + numeroMenor+ " es:";
    }
    
    public String textoAlmacenRespuesta(){
        return "MCD: " + numeroMayor + " / " + numeroMenor + " es: " + respuesta;  
    }

    public int getNumeroMayor() {
        return numeroMayor;
    }

    public int getNumeroMenor() {
        return numeroMenor;
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

}
