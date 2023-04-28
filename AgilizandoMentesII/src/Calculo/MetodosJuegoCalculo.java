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
    private int resultado;
    private int auxsigno;
    private String signo;
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
     */
    public void crearPregunta() {
        //implementarNivel();
        numero1 = (int) (Math.random() * nivelA + 1);
        numero2 = (int) (Math.random() * nivelB + 1);
        auxsigno = (int) (Math.random() * 4 + 1);

        calculo(numero1, numero2, auxsigno);
    }

    /**
     * Genera una operación.
     *
     * @param x
     * @param y
     * @param aux
     */
    private void calculo(int num1, int num2, int auxsigno) {

        switch (auxsigno) {
            case 1:
                signo = "+";
                resultado = num1 + num2;
                break;
            case 2:
                signo = "-";
                resultado = num1 - num2;
                break;
            case 3:
                signo = "X";
                resultado = num1 * num2;
                break;
            case 4:
                while (num1 % num2 != 0) {
                    numero1 = (int) (Math.random() * nivelA + 1);
                    numero2 = (int) (Math.random() * nivelB + 1);
                }
                signo = "/";
                resultado = num1 / num2;
                break;
        }
    }

}

public boolean comprobarRespuesta(String respuesta) {
        try {
            int aux = Integer.parseInt(respuesta);
            if (this.resultado == aux) {
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

    public void implementarNivel() {
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

    public int getNumero1() {
        return numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public int getResultado() {
        return resultado;
    }

    public String getSigno() {
        return signo;
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
