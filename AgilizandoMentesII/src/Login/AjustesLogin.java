/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Login;

import Ajustes.Ajustes;
import Ajustes.Estilos;
import Main.Main;
import java.awt.BorderLayout;

/**
 *
 * @author terciodemarte
 */
public class AjustesLogin extends javax.swing.JPanel {

    /**
     * Creates new form AjustesLogin
     */
    public AjustesLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ajustes = new javax.swing.JPanel();
        LoginTXT2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(210, 50));

        Ajustes.setBackground(Estilos.getColorPanel());
        Ajustes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ajustes.setPreferredSize(new java.awt.Dimension(210, 50));
        Ajustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AjustesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjustesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjustesMouseExited(evt);
            }
        });

        LoginTXT2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        LoginTXT2.setForeground(new java.awt.Color(255, 255, 255));
        LoginTXT2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginTXT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ajustesblanco.png"))); // NOI18N
        LoginTXT2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginTXT2.setPreferredSize(new java.awt.Dimension(210, 50));

        javax.swing.GroupLayout AjustesLayout = new javax.swing.GroupLayout(Ajustes);
        Ajustes.setLayout(AjustesLayout);
        AjustesLayout.setHorizontalGroup(
            AjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginTXT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AjustesLayout.setVerticalGroup(
            AjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AjustesLayout.createSequentialGroup()
                .addComponent(LoginTXT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Ajustes, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjustesMouseClicked
        Ajustes A1 = new Ajustes();
        A1.setSize(1070, 720);
        A1.setLocation(0, 0);
        
        Main.getCuerpo().removeAll();
        Main.getCuerpo().add(A1, BorderLayout.CENTER);
        Main.getCuerpo().revalidate();
        Main.getCuerpo().repaint();
    }//GEN-LAST:event_AjustesMouseClicked

    private void AjustesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjustesMouseEntered
        Ajustes.setBackground(Estilos.getColorSobreBoton());
    }//GEN-LAST:event_AjustesMouseEntered

    private void AjustesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjustesMouseExited
        Ajustes.setBackground(Estilos.getColorPanel());
    }//GEN-LAST:event_AjustesMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Ajustes;
    private javax.swing.JLabel LoginTXT2;
    // End of variables declaration//GEN-END:variables
}