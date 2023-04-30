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
    private int nivelA = 10;
    private int nivelB = 10;
    private int tiempoPartida;
    private int aciertos = 0;
    private int intentos = 5;

    /**
     * Inicializa los dos valores para encontrar el máximo común divisor e
     * inicia el algoritmo de MetodosJuegoEuclides que nos dará el máximo común
     * divisor de los dos números
     *
     * @param nivel Nivel de dificultad seleccionado entero del 1 al 4
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
     * Calcula el Máximo común divisor de dos números, intenta evitar que sea 1
     * como norma general implementando un contador.
     *
     * @param x valor numero entero
     * @param y valor numero entero
     * @param nivel Nivel de dificultad seleccionado entero del 1 al 4
     */
    private void euclides(int x, int y, int nivel) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        respuesta = x;

        // Para evitar que el MaximoComunDivisor sea 1, pasa casi siempre,
        // se coloca un contador y condición para volver a intentarlo y volver a lanzar el juego
        if (respuesta == 1 && contador > 0) {
            contador--;
            crearPregunta(nivel);
        }

    }

    /**
     * Método que comprueba si la respuesta es correcta, y añade 1 a los
     * aciertos si es correcta
     *
     * @param respuesta Recibe como String la respuesta introducida por el
     * usuario
     * @return boolean true si la respuesta es correcta
     */
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

    /**
     * Método que resta 1 a contador de intentos y devuelve true o false si
     * quedan intentos
     *
     * @return boolean
     */
    public boolean comprobarQuedanIntentos() {
        intentos--;
        return intentos != 0;
    }

    /**
     * Método para iniciar el contador de tiempo
     */
    public void iniciarJuego() {
        tiempo.iniciarContador();
    }

    /**
     * Método para detener el contador de tiempo y almacenar el tiempo
     * transcurrido en segundos
     */
    public void terminarJuego() {
        tiempo.pararContador();
        tiempoPartida = tiempo.getSecTranscurridos();
    }

    /**
     * Recibe como parámetro el nivel de dificultad de la partida, en funcion de
     * este nivel se decide la dificultad del juego.
     *
     * @param nivel valor entero entre 1 y 4 ambos incluidos
     */
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

    /**
     * Método que devuelve un String con la pregunta que se va a realizar al
     * usuario
     *
     * @return String
     */
    public String textoPregunta() {
        return "El MCD de " + numeroMayor + " y " + numeroMenor + " es:";
    }

    /**
     * Método que devuelve un String con la respuesta correcta
     *
     * @return String
     */
    public String textoAlmacenRespuesta() {
        return "MCD: " + numeroMayor + " / " + numeroMenor + " es: " + respuesta;
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
