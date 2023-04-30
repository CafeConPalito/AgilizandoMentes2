/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajustes;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author damt111
 */
public class Estilos {
    private static int  sizeCuerpo =18;
            
    //FUENTES
    private static Font fuenteCuerpo = new Font("Roboto Medium", 0, sizeCuerpo);
    private static Font fuentePanel = new Font("Roboto Medium", 0, 24);
    
    //COLORES
    /**
     * Verde Claro pasar sobre Boton
     */
    private static Color colorSobreBoton = new Color(69,195,195);
    /**
     * Panel Fondo Verde
     */
    private static Color colorPanel = new Color(0,155,155);
    /**
     * Panel Fondo Blanco 
     */
    private static Color colorPanelBlanco = new Color(255,255,255); //blanco
    /**
     * Texto Azul Registro
     */
    private static Color colorFuenteRegistroLogin = new Color(0,153,255); //AZUL
    /**
     * Texto Rojo Error Registro
     */
    private static Color colorFuenteError = new Color(255,50,0) ;// ROJO
    /**
     * Texto Blanco Panel
     */
    private static Color colorFuentePanel = new Color(255,255,255); //BLANCO
    
    /**
     * Texto Negro Cuerpo
     */
    private static Color colorFuenteCuerpo = new Color(0,0,0); //NEGRO
    /**
     * Texto Verde Respuesta Correcta Juegos
     */
    private static Color colorRespuestaCorrecta = new Color(51, 204, 51); // Verde
    /**
     * Texto Rojo Respuesta Incorrecta Juegos
     */
    private static Color colorRespuestaIncorrecta = new Color(255,0,0); // Rojo
    /**
     * Texto Rojo Respuesta Incorrecta Juegos
     */
    private static Color colorGrisEsperandoRespuesta = new Color(204, 204, 204); // Gris Claro 

    
    
    
    
    public static Color getColorGrisEsperandoRespuesta() {
        return colorGrisEsperandoRespuesta;
    }
  
    public static Color getColorSobreBoton() {
        return colorSobreBoton;
    }
    
    public static Font getFuenteCuerpo() {
        return fuenteCuerpo;
    }

    public static Font getFuentePanel() {
        return fuentePanel;
    }

    public static Color getColorPanel() {
        return colorPanel;
    }

    public static Color getColorFuentePanel() {
        return colorFuentePanel;
    }

    public static Color getColorFuenteCuerpo() {
        return colorFuenteCuerpo;
    }

    public static Color getColorFuenteRegistroLogin() {
        return colorFuenteRegistroLogin;
    }

    public static Color getColorFuenteError() {
        return colorFuenteError;
    }

    public static Color getColorPanelBlanco() {
        return colorPanelBlanco;
    }

    public static void setColorPanelBlanco(Color colorPanelBlanco) {
        Estilos.colorPanelBlanco = colorPanelBlanco;
    }
    
    public static void setSizeCuerpo(int sizeCuerpo) {
        Estilos.sizeCuerpo = sizeCuerpo;
        fuenteCuerpo = new Font("Roboto Medium", 0, Estilos.sizeCuerpo);
    }

    public static Color getColorRespuestaCorrecta() {
        return colorRespuestaCorrecta;
    }

    public static Color getColorRespuestaIncorrecta() {
        return colorRespuestaIncorrecta;
    }

}
