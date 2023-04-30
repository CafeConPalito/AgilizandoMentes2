/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculo;

import Euclides.*;
import Tiempo.Tiempo;
import Usuario.Usuario;

/**
 *
 * @author CafeConPalito
 */
public class MetodosJuegoCalculo {

    private int numero1;
    private int numero2;
    private int respuesta;
    private int auxoperacion;
    private String operacion;
    private Tiempo tiempo = new Tiempo();
    private int nivelA = 10;
    private int nivelB = 10;
    private int tiempoPartida;
    private int aciertos = 0;
    private int fallos = 0;
    private int intentos = 25;

    /**
     * inicializa los dos valores numéricos y el signo para crear una
     * operación(pregunta)
     * @param nivel
     */
    public void crearPregunta(int nivel) {
        implementarNivel(nivel);
        numero1 = (int) (Math.random() * nivelA + 1);
        numero2 = (int) (Math.random() * nivelB + 1);
        auxoperacion = (int) (Math.random() * 4 + 1);

        calculo(numero1, numero2, auxoperacion, nivel);
    }

    /**
     * Genera una operación.
     *
     * @param x
     * @param y
     * @param aux
     */
    private void calculo(int num1, int num2, int auxsigno, int nivel) {

        switch (auxsigno) {
            case 1:
                operacion = "+";
                respuesta = num1 + num2;
                break;
            case 2:
                operacion = "-";
                respuesta = num1 - num2;
                break;
            case 3:
                operacion = "X";
                respuesta = num1 * num2;
                break;
            case 4:
                while (num1 % num2 != 0) {
                    numero1 = (int) (Math.random() * nivelA + 1);
                    numero2 = (int) (Math.random() * nivelB + 1);
                }
                operacion = "/";
                respuesta = num1 / num2;
                break;
        }
    }

    public boolean comprobarRespuesta(String respuesta) {
        try {
            int aux = Integer.parseInt(respuesta);
            if (this.respuesta == aux) {
                aciertos++;
                return true;
            } else{
                fallos++;
                return false;
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
    public String textoPregunta(){
        return "El resultado de " +numero1 + "  " + operacion + "  " +numero2+ " es:";
    }
    
    public String textoAlmacenRespuesta(){
        return "El resultado de " +numero1 + "  " + operacion + "  " +numero2+ " es:" + respuesta;  
    }

    public int getNumero1() {
        return numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public String getOperacion() {
        return operacion;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public int getTiempoPartida() {
        return tiempoPartida;
    }

    public int getAciertos() {
        return aciertos;
    }

}
