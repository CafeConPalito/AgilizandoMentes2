/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Login;

import Main.Main;
import java.awt.Color;
import Ajustes.*;
import Alumno.*;
import BBDD.MetodosAjustesBBDD;
import BBDD.MetodosUsuarioBBDD;
import Profesor.ProfesorBienvenida;
import Profesor.PanelProfesor;
import Usuario.AjustesUsuario;
import Usuario.Usuario;
import java.awt.Container;
import java.awt.event.KeyEvent;

/**
 *
 * @author TerciodeMarte
 */
public class Login extends javax.swing.JPanel {

    public Login() {
        initComponents();
        errorC.setVisible(false);
        errorU.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        iniciar = new javax.swing.JLabel();
        tienes = new javax.swing.JLabel();
        registra = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JLContra = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        PWF = new javax.swing.JPasswordField();
        errorC = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JLUsuario = new javax.swing.JLabel();
        TFUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        errorU = new javax.swing.JLabel();
        Boton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1070, 720));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciar.setFont(Estilos.getFuenteCuerpo());
        iniciar.setText("INICIAR SESIÓN");
        background.add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        tienes.setFont(Estilos.getFuenteCuerpo());
        tienes.setText("¿NO TIENES CUENTA?");
        background.add(tienes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, -1, -1));

        registra.setFont(Estilos.getFuenteCuerpo());
        registra.setForeground(new java.awt.Color(0, 153, 255));
        registra.setText("Regístrate aquí.");
        registra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registraMouseEntered(evt);
            }
        });
        background.add(registra, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        JLContra.setFont(Estilos.getFuenteCuerpo());
        JLContra.setText("Contraseña");

        PWF.setForeground(new java.awt.Color(204, 204, 204));
        PWF.setText("********");
        PWF.setBorder(null);
        PWF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PWFFocusGained(evt);
            }
        });
        PWF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PWFMousePressed(evt);
            }
        });
        PWF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PWFKeyPressed(evt);
            }
        });

        errorC.setFont(Estilos.getFuenteCuerpo());
        errorC.setForeground(Estilos.getColorFuenteError());
        errorC.setText("Contraseña no valida");
        errorC.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JLContra)
                        .addGap(0, 282, Short.MAX_VALUE))
                    .addComponent(errorC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PWF))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JLContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PWF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 370, 160));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        JLUsuario.setFont(Estilos.getFuenteCuerpo());
        JLUsuario.setText("Usuario");

        TFUsuario.setFont(Estilos.getFuenteCuerpo());
        TFUsuario.setForeground(new java.awt.Color(204, 204, 204));
        TFUsuario.setText("Inserte su nombre de usuario");
        TFUsuario.setBorder(null);
        TFUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TFUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFUsuarioFocusGained(evt);
            }
        });
        TFUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TFUsuarioMousePressed(evt);
            }
        });
        TFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFUsuarioActionPerformed(evt);
            }
        });

        errorU.setFont(Estilos.getFuenteCuerpo());
        errorU.setForeground(Estilos.getColorFuenteError());
        errorU.setText("Usuario no encontrado");
        errorU.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(errorU)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(JLUsuario)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(errorU))
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 380, 120));

        Boton.setBackground(Estilos.getColorPanel());
        Boton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonMouseExited(evt);
            }
        });

        jLabel1.setFont(Estilos.getFuenteCuerpo());
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTRAR");

        javax.swing.GroupLayout BotonLayout = new javax.swing.GroupLayout(Boton);
        Boton.setLayout(BotonLayout);
        BotonLayout.setHorizontalGroup(
            BotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        BotonLayout.setVerticalGroup(
            BotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        background.add(Boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFUsuarioActionPerformed

    private void BotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonMouseEntered
        Boton.setBackground(Estilos.getColorSobreBoton());
    }//GEN-LAST:event_BotonMouseEntered

    private void BotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonMouseExited
        Boton.setBackground(Estilos.getColorPanel());
    }//GEN-LAST:event_BotonMouseExited

    private void TFUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFUsuarioMousePressed
        if (TFUsuario.getText().equals("Inserte su nombre de usuario")) {
            TFUsuario.setText("");
            TFUsuario.setForeground(Color.black);
        }
        if (String.valueOf(PWF.getPassword()).isEmpty()) {
            PWF.setText("********");
            PWF.setForeground(Color.gray);
        }

    }//GEN-LAST:event_TFUsuarioMousePressed

    private void PWFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PWFMousePressed
        if (String.valueOf(PWF.getPassword()).equals("********")) {
            PWF.setText("");
            PWF.setForeground(Color.black);
        }
        if (TFUsuario.getText().isEmpty()) {
            TFUsuario.setText("Inserte su nombre de usuario");
            TFUsuario.setForeground(Color.gray);
        }


    }//GEN-LAST:event_PWFMousePressed

    private void BotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonMouseClicked
        errorU.setVisible(false);
        errorC.setVisible(false);

        //Compruebo que existe el usuario
        if (MetodosUsuarioBBDD.loginUsuario(Main.getCon(), TFUsuario.getText())) {
            //Compruebo que introduce bien la contraseña
            if (MetodosUsuarioBBDD.loginContrasena(Main.getCon(), TFUsuario.getText(), String.copyValueOf(PWF.getPassword()))) {
                //Compruebo si es alumno
                if (!MetodosUsuarioBBDD.comprobarEsProfesor(Main.getCon(), TFUsuario.getText())) {

                    //Confirmo que se ha logueado para que no vuelva atras
                    Usuario.setUsuario(TFUsuario.getText());
                    MetodosUsuarioBBDD.generarUsuario(Main.getCon());
                    MetodosAjustesBBDD.cargarAjustes(Main.getCon());
                    MetodosAjustesBBDD.actualizarletra();

                    //Muestro los paneles del alumno
                    AlumnoPanel pa1 = new AlumnoPanel();
                    pa1.setSize(210, 400);
                    pa1.setLocation(0, 0);
                    Main.getPanelVacio().removeAll();
                    Main.getPanelVacio().add(pa1);
                    Main.getPanelVacio().revalidate();
                    Main.getPanelVacio().repaint();

                    AlumnoBienvenida bienvenidaA = new AlumnoBienvenida();
                    bienvenidaA.setSize(1070, 720);
                    bienvenidaA.setLocation(0, 0);
                    Main.getCuerpo().removeAll();
                    Main.getCuerpo().add(bienvenidaA);
                    Main.getCuerpo().revalidate();
                    Main.getCuerpo().repaint();

                    Main.setIslogin(true);

                    AjustesUsuario au1 = new AjustesUsuario();
                    au1.setSize(210, 50);
                    au1.setLocation(0, 0);
                    Main.getAjustes().removeAll();
                    Main.getAjustes().add(au1);
                    Main.getAjustes().revalidate();
                    Main.getAjustes().repaint();

                } else {

                    //Confirmo que se ha logueado para que no vuelva atras
                    Usuario.setUsuario(TFUsuario.getText());
                    MetodosUsuarioBBDD.generarUsuario(Main.getCon());
                    MetodosAjustesBBDD.cargarAjustes(Main.getCon());
                    MetodosAjustesBBDD.actualizarletra();

                    //Muestro los paneles del profesor
                    PanelProfesor pp1 = new PanelProfesor();
                    pp1.setSize(210, 330);
                    pp1.setLocation(0, 0);
                    Main.getPanelVacio().removeAll();
                    Main.getPanelVacio().add(pp1);
                    Main.getPanelVacio().revalidate();
                    Main.getPanelVacio().repaint();

                    ProfesorBienvenida bienvenidaP = new ProfesorBienvenida();
                    bienvenidaP.setSize(1070, 720);
                    bienvenidaP.setLocation(0, 0);
                    Main.getCuerpo().removeAll();
                    Main.getCuerpo().add(bienvenidaP);
                    Main.getCuerpo().revalidate();
                    Main.getCuerpo().repaint();

                    Main.setIslogin(true);

                    AjustesUsuario au2 = new AjustesUsuario();
                    au2.setSize(210, 50);
                    au2.setLocation(0, 0);
                    Main.getAjustes().removeAll();
                    Main.getAjustes().add(au2);
                    Main.getAjustes().revalidate();
                    Main.getAjustes().repaint();

                }
            } else {
                //Muestro el error que se ha equivocado con la contraseña
                errorC.setVisible(true);
            }
        } else {
            //Muestro que se ha equivocado con el usaurio
            errorU.setVisible(true);
        }


    }//GEN-LAST:event_BotonMouseClicked

    private void registraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registraMouseEntered
        registra.setFont(Estilos.getFuenteCuerpo());
    }//GEN-LAST:event_registraMouseEntered

    private void registraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registraMouseClicked
        Container Cuerpo2 = this.getParent();
        Register r1 = new Register();
        r1.setSize(1070, 720);
        r1.setLocation(0, 0);
        Cuerpo2.removeAll();
        Cuerpo2.add(r1);
        Cuerpo2.revalidate();
        Cuerpo2.repaint();

    }//GEN-LAST:event_registraMouseClicked

    private void PWFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PWFFocusGained
        if (String.valueOf(PWF.getPassword()).equals("********")) {
            PWF.setText("");
            PWF.setForeground(Color.black);
        }
        if (TFUsuario.getText().isEmpty()) {
            TFUsuario.setText("Inserte su nombre de usuario");
            TFUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_PWFFocusGained

    private void TFUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFUsuarioFocusGained
        if (TFUsuario.getText().equals("Inserte su nombre de usuario")) {
            TFUsuario.setText("");
            TFUsuario.setForeground(Color.black);
        }
        if (String.valueOf(PWF.getPassword()).isEmpty()) {
            TFUsuario.setText("********");
            TFUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_TFUsuarioFocusGained

    private void PWFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PWFKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER && !String.valueOf(PWF.getPassword()).equals("********")) {
            //Compruebo que existe el usuario
            if (MetodosUsuarioBBDD.loginUsuario(Main.getCon(), TFUsuario.getText())) {
                //Compruebo que introduce bien la contraseña
                if (MetodosUsuarioBBDD.loginContrasena(Main.getCon(), TFUsuario.getText(), String.copyValueOf(PWF.getPassword()))) {
                    //Compruebo si es alumno
                    if (!MetodosUsuarioBBDD.comprobarEsProfesor(Main.getCon(), TFUsuario.getText())) {

                        //Confirmo que se ha logueado para que no vuelva atras
                        Usuario.setUsuario(TFUsuario.getText());
                        MetodosUsuarioBBDD.generarUsuario(Main.getCon());
                        MetodosAjustesBBDD.cargarAjustes(Main.getCon());
                        MetodosAjustesBBDD.actualizarletra();

                        //Muestro los paneles del alumno
                        AlumnoPanel pa1 = new AlumnoPanel();
                        pa1.setSize(210, 400);
                        pa1.setLocation(0, 0);
                        Main.getPanelVacio().removeAll();
                        Main.getPanelVacio().add(pa1);
                        Main.getPanelVacio().revalidate();
                        Main.getPanelVacio().repaint();

                        AlumnoBienvenida bienvenidaA = new AlumnoBienvenida();
                        bienvenidaA.setSize(1070, 720);
                        bienvenidaA.setLocation(0, 0);
                        Main.getCuerpo().removeAll();
                        Main.getCuerpo().add(bienvenidaA);
                        Main.getCuerpo().revalidate();
                        Main.getCuerpo().repaint();

                        Main.setIslogin(true);

                        AjustesUsuario au1 = new AjustesUsuario();
                        au1.setSize(210, 50);
                        au1.setLocation(0, 0);
                        Main.getAjustes().removeAll();
                        Main.getAjustes().add(au1);
                        Main.getAjustes().revalidate();
                        Main.getAjustes().repaint();

                    } else {

                        //Confirmo que se ha logueado para que no vuelva atras
                        Usuario.setUsuario(TFUsuario.getText());
                        MetodosUsuarioBBDD.generarUsuario(Main.getCon());
                        MetodosAjustesBBDD.cargarAjustes(Main.getCon());
                        MetodosAjustesBBDD.actualizarletra();

                        //Muestro los paneles del profesor
                        PanelProfesor pp1 = new PanelProfesor();
                        pp1.setSize(210, 330);
                        pp1.setLocation(0, 0);
                        Main.getPanelVacio().removeAll();
                        Main.getPanelVacio().add(pp1);
                        Main.getPanelVacio().revalidate();
                        Main.getPanelVacio().repaint();

                        ProfesorBienvenida bienvenidaP = new ProfesorBienvenida();
                        bienvenidaP.setSize(1070, 720);
                        bienvenidaP.setLocation(0, 0);
                        Main.getCuerpo().removeAll();
                        Main.getCuerpo().add(bienvenidaP);
                        Main.getCuerpo().revalidate();
                        Main.getCuerpo().repaint();

                        Main.setIslogin(true);

                        AjustesUsuario au2 = new AjustesUsuario();
                        au2.setSize(210, 50);
                        au2.setLocation(0, 0);
                        Main.getAjustes().removeAll();
                        Main.getAjustes().add(au2);
                        Main.getAjustes().revalidate();
                        Main.getAjustes().repaint();

                    }
                } else {
                    //Muestro el error que se ha equivocado con la contraseña
                    errorC.setVisible(true);
                }
            } else {
                //Muestro que se ha equivocado con el usaurio
                errorU.setVisible(true);
            }
        }
    }//GEN-LAST:event_PWFKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Boton;
    private javax.swing.JLabel JLContra;
    private javax.swing.JLabel JLUsuario;
    private javax.swing.JPasswordField PWF;
    private javax.swing.JTextField TFUsuario;
    private javax.swing.JPanel background;
    private javax.swing.JLabel errorC;
    private javax.swing.JLabel errorU;
    private javax.swing.JLabel iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel registra;
    private javax.swing.JLabel tienes;
    // End of variables declaration//GEN-END:variables
}
