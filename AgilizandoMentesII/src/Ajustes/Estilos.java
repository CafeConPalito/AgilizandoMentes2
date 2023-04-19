/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajustes;

import java.awt.Font;

/**
 *
 * @author damt111
 */
public class Estilos {
    private static Font fuenteCuerpo = new Font("Roboto Medium", 0, 18);
    private static Font fuentePanel = new Font("Roboto Medium", 0, 24);

    public static Font getFuenteCuerpo() {
        return fuenteCuerpo;
    }

    public static Font getFuentePanel() {
        return fuentePanel;
    }

    public static void setFuentePanel(Font fuentePanel) {
        Estilos.fuentePanel = fuentePanel;
    }

    public static void setFuenteCuerpo(Font fuenteCuerpo) {
        Estilos.fuenteCuerpo = fuenteCuerpo;
    }
    




}
