/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestoDiv;

import Tiempo.Tiempo;

/**
 * Clase que permite generar la partida y controlar el Juego Resto de una división 
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
    private int nivelA; // Nivel de complejidad del juego
    private int nivelB; // Nivel de complejidad del juego
    private Tiempo tiempo = new Tiempo();

    /**
     * Recibe como parámetro el nivel de dificultad de la partida. Utiliza el
     * método implementarNivel para decidir el nivel de dificultad del Juego. A
     * partir de esto crea los valores dividendo, divisor y la respuesta, en
     * este caso el Resto de una división entera.
     *
     * @param nivel Nivel de dificultad seleccionado
     */
    public void crearPregunta(int nivel) {
        implementarNivel(nivel);
        dividendo = (int) (Math.random() * nivelA + 1);
        divisor = (int) (Math.random() * nivelB + 1);
        while (divisor > dividendo) {
            divisor = (int) (Math.random() * nivelB + 1);
        }
        respuesta = dividendo % divisor;
    }

    /**
     * Recibe como parámetro el nivel de dificultad de la partida, en funcion de
     * este nivel se decide la dificultad del juego.
     *
     * @param nivel valor entero entre 1 y 4 ambos incluidos
     */
    private void implementarNivel(int nivel) {
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
     * Método que comprueba si la respuesta es correcta, y añade 1 a los
     * aciertos
     *
     * @param respuesta 
     * @return boolean true si la respuesta es correcta
     */
    public boolean comprobarRespuesta(String respuesta) {
        try {
            int aux = Integer.parseInt(respuesta);
            if (this.respuesta == aux) {
                aciertos++;
                return true;
            }

        } catch (NumberFormatException e) {

        }
        return false;
    }

    /**
     * Método que resta 1 a contador de intentos  y devuelve true o false si quedan intentos
     * @return boolean 
     */
    public boolean comprobarQuedanIntentos() {
        intentos--;
        return intentos != 0;
    }

    /**
     * Método que devuelve un String con la pregunta que se va a realizar al usuario
     * @return String
     */
    public String textoPregunta() {
        return "El resto de la division de " + dividendo + " entre " + divisor + " es:";
    }

     /**
     * Método que devuelve un String con la respuesta correcta
     * @return String
     */
    public String textoAlmacenRespuesta() {
        return "Resto: " + dividendo + " / " + divisor + " es: " + respuesta;
    }

    /**
     * Método para iniciar el contador de tiempo
     */
    public void iniciarJuego() {
        tiempo.iniciarContador();
    }

    /**
     * Método para detener el contador de tiempo
     * y almacenar el tiempo transcurrido en segundos
     */
    public void terminarJuego() {
        tiempo.pararContador();
        tiempoPartida = tiempo.getSecTranscurridos();
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
