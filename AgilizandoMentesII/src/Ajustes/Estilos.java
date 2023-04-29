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
    private static int  sizeCuerpo =22;
            
    //FUENTES
    private static Font fuenteCuerpo = new Font("Roboto Medium", 0, sizeCuerpo);
    private static Font fuentePanel = new Font("Roboto Medium", 0, 24);
    
    //COLORES
    private static Color colorSobreBoton = new Color(69,195,195); //VERDE CONTRASTE
    private static Color colorPanel = new Color(0,155,155); //VERDE
    private static Color colorPanelBlanco = new Color(255,255,255); //blanco
    private static Color colorFuenteRegistroLogin = new Color(0,153,255); //AZUL
    private static Color colorFuenteError = new Color(255,50,0) ;// ROJO
    private static Color colorFuentePanel = new Color(255,255,255); //BLANCO
    private static Color colorFuenteCuerpo = new Color(0,0,0); //NEGRO
    private static Color colorRespuestaCorrecta = new Color(51, 204, 51); // Verde
    private static Color colorRespuestaIncorrecta = new Color(255,0,0); // Rojo      
    

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
