/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajustes;

import java.awt.Color;
import java.awt.Font;
import org.w3c.dom.css.RGBColor;

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
    private static Color colorPanel = new Color(0,155,155);
    private static Color colorFuenteRegistroLogin = new Color(0,153,255);
    private static Color colorFuentePanel = new Color(255,255,255);
    private static Color colorFuenteCuerpo = new Color(0,0,0);
 
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

    public static void setSizeCuerpo(int sizeCuerpo) {
        Estilos.sizeCuerpo = sizeCuerpo;
        fuenteCuerpo = new Font("Roboto Medium", 0, Estilos.sizeCuerpo);
    }

}
