/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tiempo;

/**
 *
 * @author produccion
 */
public class Tiempo {

    /* no los declaro estaticos para tener que inicializar un objeto con cada partida
    asi se pueden evitar posibles errores si no se termina bien la partida y queda mal almacenado un valor
     */
    private long inicioContador;
    private long finContador;
    private int secTranscurridos;
    private boolean controlInicializacion = false; // Creo que lo puedo quitar

    /**
     * Inicia el contador de tiempo
     */
    public void iniciarContador() {
        inicioContador = System.currentTimeMillis();
        controlInicializacion = true;
    }

    /**
     * Detiene el contador del tiempo
     * solo para el contador y almacena el valor si el contador se inicio
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
     * @return 
     */
    public int getSecTranscurridos() {
        return secTranscurridos;
    }
    
    
    
    
}
