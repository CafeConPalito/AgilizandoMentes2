/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tiempo;

/**
 * Clase que controla todo lo que tiene que ver con los tiempos de las partidas.
 *
 * @author CafeConPalito
 */
public class Tiempo {

    private long inicioContador;
    private long finContador;
    private int secTranscurridos;
    private boolean controlInicializacion = false; // Controla que el temporizador no este inicializado, para evitar inicializarlo varias veces por error.

    /**
     * Inicia el contador de tiempo, no permite inicializarlo si ya esta
     * inicializado
     */
    public void iniciarContador() {
        if (controlInicializacion == false) {
            inicioContador = System.currentTimeMillis();
            controlInicializacion = true;
        }

    }

    /**
     * Detiene el contador del tiempo, solo detiene el contador y almacena el
     * valor si el contador se inicializo
     */
    public void pararContador() {
        if (controlInicializacion) {
            finContador = System.currentTimeMillis();
            secTranscurridos = (int) (finContador - inicioContador) / 1000;
            controlInicializacion = false;
        }
    }

    /**
     * Devuelve el tiempo transcurrido
     *
     * @return int
     */
    public int getSecTranscurridos() {
        return secTranscurridos;
    }

}
