/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajustes;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author terciodemarte
 */
public class HeaderColor extends DefaultTableCellRenderer {

    public HeaderColor() {
        setOpaque(true);
    }

    /**
     * Este metodo Override permite modificar el estilo de las tablas, en este
     * caso modifica el color del Header a Verde y el Texto a Blanco
     *
     * @param table
     * @param value
     * @param selected
     * @param focused
     * @param row
     * @param column
     * @return devuelve el estilo de un jTable modificado.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        setBackground(Estilos.getColorPanel());
        setForeground(Estilos.getColorPanelBlanco());
        //you can change the color that u want 
        return this;
    }
}
