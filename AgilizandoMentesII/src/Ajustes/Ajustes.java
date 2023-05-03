package Ajustes;

import BBDD.MetodosAjustesBBDD;
import Main.Main;
import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Ajustes extends javax.swing.JPanel {
    
    /**
     * Inicializa los componentes de panel Ajustes
     */
    public Ajustes() {
        initComponents();
        if (!Main.isIslogin()) {
            valortexto.setText(Byte.toString(Configuracion.getTamano()));
            texto.setValue(Configuracion.getTamano());
            selectidioma.removeAllItems();
            if (Configuracion.getIdioma().equals("Español")) {
                selectidioma.addItem("Español");
                selectidioma.addItem("Ingles");
            } else {
                selectidioma.addItem("Ingles");
                selectidioma.addItem("Español");
            }
            Si.setSelected(Configuracion.isSonido());
        } else {
            MetodosAjustesBBDD.cargarAjustes(Main.getCon());
            valortexto.setText(Byte.toString(Configuracion.getTamano()));
            texto.setValue(Configuracion.getTamano());
            selectidioma.removeAllItems();
            if (Configuracion.getIdioma().equals("Español")) {
                selectidioma.addItem("Español");
                selectidioma.addItem("Ingles");
            } else {
                selectidioma.addItem("Ingles");
                selectidioma.addItem("Español");
            }
            Si.setSelected(Configuracion.isSonido());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        sonido = new javax.swing.JLabel();
        aplicar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        web = new javax.swing.JLabel();
        idioma = new javax.swing.JLabel();
        selectidioma = new javax.swing.JComboBox<>();
        texto = new javax.swing.JSlider();
        valortexto = new javax.swing.JLabel();
        Si = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        bienvenido1 = new javax.swing.JLabel();
        tamano1 = new javax.swing.JLabel();
        version1 = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JPanel();
        Fondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1070, 720));
        setMinimumSize(new java.awt.Dimension(1070, 720));
        setPreferredSize(new java.awt.Dimension(1070, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(false);
        background.setPreferredSize(new java.awt.Dimension(1070, 720));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sonido.setFont(Estilos.getFuenteCuerpo());
        sonido.setText("Sonido");
        sonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sonidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sonidoMouseExited(evt);
            }
        });
        background.add(sonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        aplicar.setBackground(Estilos.getColorPanel());
        aplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aplicarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aplicarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aplicarMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APLICAR");

        javax.swing.GroupLayout aplicarLayout = new javax.swing.GroupLayout(aplicar);
        aplicar.setLayout(aplicarLayout);
        aplicarLayout.setHorizontalGroup(
            aplicarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aplicarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );
        aplicarLayout.setVerticalGroup(
            aplicarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        background.add(aplicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 130, -1));

        web.setFont(Estilos.getFuenteCuerpo());
        web.setForeground(Estilos.getColorFuenteRegistroLogin());
        web.setText("cafeconpalito.com");
        web.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        web.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webMouseClicked(evt);
            }
        });
        background.add(web, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, -1, -1));

        idioma.setFont(Estilos.getFuenteCuerpo());
        idioma.setText("Idioma");
        idioma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idiomaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                idiomaMouseExited(evt);
            }
        });
        background.add(idioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        selectidioma.setFont(Estilos.getFuenteCuerpo());
        selectidioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Ingles" }));
        selectidioma.setBorder(null);
        selectidioma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        background.add(selectidioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        texto.setFont(Estilos.getFuenteCuerpo());
        texto.setMaximum(3);
        texto.setMinimum(1);
        texto.setValue(2);
        texto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                textoStateChanged(evt);
            }
        });
        background.add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 170, -1));

        valortexto.setFont(Estilos.getFuenteCuerpo());
        valortexto.setText("2");
        background.add(valortexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        Si.setFont(Estilos.getFuenteCuerpo());
        Si.setText("Si");
        Si.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Si.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SiMouseExited(evt);
            }
        });
        Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiActionPerformed(evt);
            }
        });
        background.add(Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        jPanel2.setBackground(Estilos.getColorPanel());

        bienvenido1.setFont(Estilos.getFuenteCuerpo());
        bienvenido1.setForeground(Estilos.getColorFuentePanel());
        bienvenido1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bienvenido1.setText("Ajustes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bienvenido1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bienvenido1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 460, 40));

        tamano1.setFont(Estilos.getFuenteCuerpo());
        tamano1.setText("Tamaño del texto");
        tamano1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tamano1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tamano1MouseExited(evt);
            }
        });
        background.add(tamano1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        version1.setFont(Estilos.getFuenteCuerpo());
        version1.setText("Version: 1.0.5");
        background.add(version1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, -1, -1));

        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelFondo.setBackground(Estilos.getColorPanelBlanco());
        jPanelFondo.setPreferredSize(new java.awt.Dimension(1070, 720));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo.png"))); // NOI18N

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void aplicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarMouseEntered
        aplicar.setBackground(Estilos.getColorSobreBoton());

        //CONFIGURACION PARA ACTIVAR SONIDO
        if (Configuracion.isSonido()) {
            Configuracion.sonar("aplicar");
        }

    }//GEN-LAST:event_aplicarMouseEntered

    private void aplicarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarMouseExited
        aplicar.setBackground(Estilos.getColorPanel());
        Configuracion.parar();

    }//GEN-LAST:event_aplicarMouseExited

    private void aplicarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarMouseClicked
        Configuracion.setTamano((byte) texto.getValue());
        MetodosAjustesBBDD.actualizarletra();

        Configuracion.setIdioma(selectidioma.getSelectedItem().toString());
        if (Si.isSelected()) {
            Configuracion.setSonido(true);

        } else {
            Configuracion.setSonido(false);
        }
        
        MetodosAjustesBBDD.guardarAjustes(Main.getCon());

        Ajustes a1 = new Ajustes();
        a1.setSize(1070, 720);
        a1.setLocation(0, 0);
        Main.getCuerpo().removeAll();
        Main.getCuerpo().add(a1);
        Main.getCuerpo().revalidate();
        Main.getCuerpo().repaint();

    }//GEN-LAST:event_aplicarMouseClicked

    private void textoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_textoStateChanged
        valortexto.setText(Integer.toString(texto.getValue()));
    }//GEN-LAST:event_textoStateChanged

    private void idiomaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idiomaMouseEntered

        //CONFIGURACION PARA ACTIVAR SONIDO
        if (Configuracion.isSonido()) {
            Configuracion.sonar("idioma");
        }
    }//GEN-LAST:event_idiomaMouseEntered

    private void sonidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sonidoMouseEntered

        //CONFIGURACION PARA ACTIVAR SONIDO
        if (Configuracion.isSonido()) {
            Configuracion.sonar("sonido");
        }
    }//GEN-LAST:event_sonidoMouseEntered

    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SiActionPerformed

    private void SiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiMouseEntered

        //CONFIGURACION PARA ACTIVAR SONIDO
        if (Configuracion.isSonido()) {
            Configuracion.sonar("si");
        }
    }//GEN-LAST:event_SiMouseEntered

    private void idiomaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idiomaMouseExited
        Configuracion.parar();
    }//GEN-LAST:event_idiomaMouseExited

    private void sonidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sonidoMouseExited
        Configuracion.parar();
    }//GEN-LAST:event_sonidoMouseExited

    private void SiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiMouseExited
        Configuracion.parar();
    }//GEN-LAST:event_SiMouseExited

    private void tamano1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tamano1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tamano1MouseEntered

    private void tamano1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tamano1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tamano1MouseExited

    private void webMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webMouseClicked
        // TODO add your handling code here:
         try {
            Desktop.getDesktop().browse(new URI("http://192.168.24.16:8082/"));
        } catch (IOException ex) {
            //System.err.println("Ha ocurrido una IOException");
        } catch (URISyntaxException ex) {
            //System.err.println("No ha encontrado la URL");
        }
    }//GEN-LAST:event_webMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JCheckBox Si;
    private javax.swing.JPanel aplicar;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bienvenido1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel idioma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JComboBox<String> selectidioma;
    private javax.swing.JLabel sonido;
    private javax.swing.JLabel tamano1;
    private javax.swing.JSlider texto;
    private javax.swing.JLabel valortexto;
    private javax.swing.JLabel version1;
    private javax.swing.JLabel web;
    // End of variables declaration//GEN-END:variables
}
