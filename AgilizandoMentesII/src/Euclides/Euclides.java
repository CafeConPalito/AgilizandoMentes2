/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Euclides;

import RestoDiv.*;
import BBDD.ObjetoJuegoBBDD;
import BBDD.MetodosJuegoBBDD;
import Usuario.Usuario;
import Ajustes.*;
import Main.Main;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author damt111
 */
public class Euclides extends javax.swing.JPanel {

    MetodosJuegoEuclides juego = null;
    boolean controlPartida = false; // partida no iniciada , en true iniciada
    private String almacenOperaciones = "";
    private final String NOMBREDEJUEGO = "euclides"; //nombre que tiene la tabla en la BBDD
    private int nivel;// implementado para pasar un nivel 

    /**
     * Creates new form NewJPanel
     */
    public Euclides() {
        initComponents();
        try {
            nivel = Integer.parseInt(Usuario.getCurso());
        } catch (NumberFormatException e) {
        }
        jLnivelActual.setText("Nivel " + nivel);
        actualizarTablas();

    }

    public void actualizarTablas() {
        actualizarClasificacion();
        actualizarMejorePartidas();
        actualizarUltimasPartidas();
        actualizarNumeroPartidas();
        actualizarMediaAciertos();
    }

    public void actualizarAlmacenOperaciones(boolean control) {
        if (controlPartida) {
            if (control) {
                almacenOperaciones = almacenOperaciones + "\n★ " + juego.textoAlmacenRespuesta();
                jTextPaneAlmacenOperaciones.setText(almacenOperaciones);
            } else {
                almacenOperaciones = almacenOperaciones + "\n☓ " + juego.textoAlmacenRespuesta() + ", tu respuesta " + TFrespuesta.getText();
                jTextPaneAlmacenOperaciones.setText(almacenOperaciones);
            }
        } else {
            jTextPaneAlmacenOperaciones.setText("");
        }

    }
    /**
     * Segun el valor pasado modifica el nivel, entre 1 y 4, controla que la partida no este inicializada con el booleano de controlPartida.
     * 
     * @param opcion valor '1' para subir un nivel, valor '2' para bajar nivel
     */
    public void modificarNivel(int opcion) {
        if (controlPartida == false) {
            switch (opcion) {
                case 1:
                    if (nivel <4) {
                        nivel ++;
                    }
                    jLnivelActual.setText("Nivel " + nivel);
                    break;
                case 2:
                    if (nivel >1) {
                        nivel --;
                    }
                    jLnivelActual.setText("Nivel " + nivel);
                    break;
                default:
                    throw new AssertionError();
            }
            actualizarTablas(); // al modificar el nivel se cambia la tabla de clasificacion por la actual ;)
        }
    }

    private void actualizarClasificacion() {
        DefaultTableModel modelC = (DefaultTableModel) jTclasificacion.getModel();
        modelC.setRowCount(0);
        Object[] row = new Object[4];
        ArrayList<ObjetoJuegoBBDD> lista = MetodosJuegoBBDD.selectClasificacion(Main.getCon(), NOMBREDEJUEGO, nivel);
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getAlias();
            row[1] = lista.get(i).getTiempoPartida();
            row[2] = lista.get(i).getAciertos();
            row[3] = lista.get(i).getFecha_hora();
            modelC.addRow(row);
        }
    }

    private void actualizarMejorePartidas() {

        DefaultTableModel modelB = (DefaultTableModel) jTmejoresPartidas.getModel();
        modelB.setRowCount(0);
        Object[] row = new Object[4];
        ArrayList<ObjetoJuegoBBDD> lista = MetodosJuegoBBDD.selectJugadorMejoresPartidas(Main.getCon(), NOMBREDEJUEGO, nivel);
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getAlias();
            row[1] = lista.get(i).getTiempoPartida();
            row[2] = lista.get(i).getAciertos();
            row[3] = lista.get(i).getFecha_hora();
            modelB.addRow(row);
        }

    }

    private void actualizarUltimasPartidas() {

        DefaultTableModel modelL = (DefaultTableModel) jTultimasPartidas.getModel();
        modelL.setRowCount(0);
        Object[] row = new Object[4];
        ArrayList<ObjetoJuegoBBDD> lista = MetodosJuegoBBDD.selectJugadorUltimasPartidas(Main.getCon(), NOMBREDEJUEGO, nivel);
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getAlias();
            row[1] = lista.get(i).getTiempoPartida();
            row[2] = lista.get(i).getAciertos();
            row[3] = lista.get(i).getFecha_hora();
            modelL.addRow(row);
        }

    }

    private void actualizarNumeroPartidas() {
        jLpatidasJugadas.setText("Partidas Jugadas: " + MetodosJuegoBBDD.totalPartidas(Main.getCon(), NOMBREDEJUEGO, nivel));
    }

    private void actualizarMediaAciertos() {
        jLMediaAciertos.setText("Media de aciertos: " + MetodosJuegoBBDD.mediaAciertos(Main.getCon(), NOMBREDEJUEGO, nivel) + " %");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Informacion = new javax.swing.JPanel();
        Estadisticas = new javax.swing.JPanel();
        jLTituloEstadisticas = new javax.swing.JLabel();
        jLpatidasJugadas = new javax.swing.JLabel();
        jLMediaAciertos = new javax.swing.JLabel();
        jSPranking = new javax.swing.JScrollPane();
        jTclasificacion = new javax.swing.JTable();
        jSPbestPlays = new javax.swing.JScrollPane();
        jTmejoresPartidas = new javax.swing.JTable();
        jSPlastPlays = new javax.swing.JScrollPane();
        jTultimasPartidas = new javax.swing.JTable();
        jLlastPlays = new javax.swing.JLabel();
        javax.swing.JLabel jLbestPlays = new javax.swing.JLabel();
        jLranking = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneAlmacenOperaciones = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        TFrespuesta = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        buttonNewPlay = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLResultado = new javax.swing.JLabel();
        jLOperacion = new javax.swing.JLabel();
        botonSubirNivel = new javax.swing.JPanel();
        jLsubirNivel = new javax.swing.JLabel();
        botonBajarNivel = new javax.swing.JPanel();
        jLbajarNivel = new javax.swing.JLabel();
        jLnivelActual = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1070, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Informacion.setBackground(new java.awt.Color(255, 255, 255));

        Estadisticas.setBackground(new java.awt.Color(255, 255, 255));

        jLTituloEstadisticas.setFont(Estilos.getFuenteCuerpo());
        jLTituloEstadisticas.setForeground(Estilos.getColorFuenteCuerpo());
        jLTituloEstadisticas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLTituloEstadisticas.setText("Estadisticas");

        jLpatidasJugadas.setFont(Estilos.getFuenteCuerpo());
        jLpatidasJugadas.setForeground(Estilos.getColorFuenteCuerpo());
        jLpatidasJugadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLpatidasJugadas.setText("Partidas Jugadas");

        jLMediaAciertos.setFont(Estilos.getFuenteCuerpo());
        jLMediaAciertos.setForeground(Estilos.getColorFuenteCuerpo());
        jLMediaAciertos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLMediaAciertos.setText("Media de Aciertos");

        javax.swing.GroupLayout EstadisticasLayout = new javax.swing.GroupLayout(Estadisticas);
        Estadisticas.setLayout(EstadisticasLayout);
        EstadisticasLayout.setHorizontalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLpatidasJugadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLTituloEstadisticas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLMediaAciertos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );
        EstadisticasLayout.setVerticalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLTituloEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLpatidasJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLMediaAciertos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jSPranking.setBorder(null);

        jTclasificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Tiempo (sec)", "Aciertos", "Fecha y Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTclasificacion.setEnabled(false);
        jTclasificacion.setRowSelectionAllowed(false);
        jTclasificacion.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTclasificacion.getTableHeader().setReorderingAllowed(false);
        jSPranking.setViewportView(jTclasificacion);
        if (jTclasificacion.getColumnModel().getColumnCount() > 0) {
            jTclasificacion.getColumnModel().getColumn(0).setResizable(false);
            jTclasificacion.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTclasificacion.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTclasificacion.getColumnModel().getColumn(3).setResizable(false);
        }

        jSPbestPlays.setBorder(null);

        jTmejoresPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Tiempo (sec)", "Aciertos", "Fecha y Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTmejoresPartidas.setEnabled(false);
        jTmejoresPartidas.setRowSelectionAllowed(false);
        jTmejoresPartidas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTmejoresPartidas.getTableHeader().setReorderingAllowed(false);
        jSPbestPlays.setViewportView(jTmejoresPartidas);
        if (jTmejoresPartidas.getColumnModel().getColumnCount() > 0) {
            jTmejoresPartidas.getColumnModel().getColumn(0).setResizable(false);
            jTmejoresPartidas.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTmejoresPartidas.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTmejoresPartidas.getColumnModel().getColumn(3).setResizable(false);
        }

        jSPlastPlays.setBorder(null);

        jTultimasPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Tiempo (sec)", "Aciertos", "Fecha y Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTultimasPartidas.setEnabled(false);
        jTultimasPartidas.setRowSelectionAllowed(false);
        jTultimasPartidas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTultimasPartidas.getTableHeader().setReorderingAllowed(false);
        jSPlastPlays.setViewportView(jTultimasPartidas);
        if (jTultimasPartidas.getColumnModel().getColumnCount() > 0) {
            jTultimasPartidas.getColumnModel().getColumn(0).setResizable(false);
            jTultimasPartidas.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTultimasPartidas.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTultimasPartidas.getColumnModel().getColumn(3).setResizable(false);
        }

        jLlastPlays.setFont(Estilos.getFuenteCuerpo());
        jLlastPlays.setForeground(Estilos.getColorFuenteCuerpo());
        jLlastPlays.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLlastPlays.setText("Tus ultimas 5 partidas");
        jLlastPlays.setToolTipText("");

        jLbestPlays.setFont(Estilos.getFuenteCuerpo());
        jLbestPlays.setForeground(Estilos.getColorFuenteCuerpo());
        jLbestPlays.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbestPlays.setText("Tus mejores partidas");
        jLbestPlays.setToolTipText("");

        jLranking.setFont(Estilos.getFuenteCuerpo());
        jLranking.setForeground(Estilos.getColorFuenteCuerpo());
        jLranking.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLranking.setText("Clasificacion");
        jLranking.setToolTipText("");

        javax.swing.GroupLayout InformacionLayout = new javax.swing.GroupLayout(Informacion);
        Informacion.setLayout(InformacionLayout);
        InformacionLayout.setHorizontalGroup(
            InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLranking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPlastPlays, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addComponent(jLlastPlays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLbestPlays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPranking)
                    .addComponent(jSPbestPlays)
                    .addComponent(Estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        InformacionLayout.setVerticalGroup(
            InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Estadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLranking, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSPranking, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbestPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSPbestPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLlastPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSPlastPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel1.add(Informacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 490, 720));

        jLTitulo.setFont(Estilos.getFuenteCuerpo());
        jLTitulo.setForeground(Estilos.getColorFuenteCuerpo());
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLTitulo.setText("Calcula el resto de una división entera");
        jPanel1.add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 490, 40));

        jScrollPane1.setBorder(null);

        jTextPaneAlmacenOperaciones.setBorder(null);
        jTextPaneAlmacenOperaciones.setFont(Estilos.getFuenteCuerpo());
        jTextPaneAlmacenOperaciones.setForeground(Estilos.getColorFuenteCuerpo());
        jTextPaneAlmacenOperaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextPaneAlmacenOperaciones.setFocusable(false);
        jScrollPane1.setViewportView(jTextPaneAlmacenOperaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 500, 260));

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        TFrespuesta.setFont(Estilos.getFuenteCuerpo());
        TFrespuesta.setForeground(new java.awt.Color(204, 204, 204));
        TFrespuesta.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TFrespuesta.setText(" Inserta una respuesta");
        TFrespuesta.setBorder(null);
        TFrespuesta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFrespuestaFocusGained(evt);
            }
        });
        TFrespuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TFrespuestaMousePressed(evt);
            }
        });
        TFrespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFrespuestaKeyPressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        buttonNewPlay.setBackground(Estilos.getColorPanel());
        buttonNewPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonNewPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNewPlayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNewPlayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonNewPlayMouseExited(evt);
            }
        });

        jLabel1.setFont(Estilos.getFuenteCuerpo());
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jugar");

        javax.swing.GroupLayout buttonNewPlayLayout = new javax.swing.GroupLayout(buttonNewPlay);
        buttonNewPlay.setLayout(buttonNewPlayLayout);
        buttonNewPlayLayout.setHorizontalGroup(
            buttonNewPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        buttonNewPlayLayout.setVerticalGroup(
            buttonNewPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonNewPlayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLResultado.setFont(Estilos.getFuenteCuerpo());
        jLResultado.setForeground(Estilos.getColorFuenteCuerpo());
        jLResultado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLOperacion.setFont(Estilos.getFuenteCuerpo());
        jLOperacion.setForeground(Estilos.getColorFuenteCuerpo());
        jLOperacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLOperacion.setText("Operacion");

        botonSubirNivel.setBackground(Estilos.getColorPanel());
        botonSubirNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSubirNivel.setPreferredSize(new java.awt.Dimension(22, 22));
        botonSubirNivel.setRequestFocusEnabled(false);
        botonSubirNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSubirNivelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonSubirNivelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonSubirNivelMouseExited(evt);
            }
        });

        jLsubirNivel.setFont(Estilos.getFuenteCuerpo());
        jLsubirNivel.setForeground(new java.awt.Color(255, 255, 255));
        jLsubirNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLsubirNivel.setText("+");
        jLsubirNivel.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout botonSubirNivelLayout = new javax.swing.GroupLayout(botonSubirNivel);
        botonSubirNivel.setLayout(botonSubirNivelLayout);
        botonSubirNivelLayout.setHorizontalGroup(
            botonSubirNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLsubirNivel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );
        botonSubirNivelLayout.setVerticalGroup(
            botonSubirNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonSubirNivelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLsubirNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonBajarNivel.setBackground(Estilos.getColorPanel());
        botonBajarNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBajarNivel.setPreferredSize(new java.awt.Dimension(22, 22));
        botonBajarNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBajarNivelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonBajarNivelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonBajarNivelMouseExited(evt);
            }
        });

        jLbajarNivel.setFont(Estilos.getFuenteCuerpo());
        jLbajarNivel.setForeground(new java.awt.Color(255, 255, 255));
        jLbajarNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbajarNivel.setText("-");
        jLbajarNivel.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout botonBajarNivelLayout = new javax.swing.GroupLayout(botonBajarNivel);
        botonBajarNivel.setLayout(botonBajarNivelLayout);
        botonBajarNivelLayout.setHorizontalGroup(
            botonBajarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLbajarNivel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );
        botonBajarNivelLayout.setVerticalGroup(
            botonBajarNivelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonBajarNivelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbajarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLnivelActual.setBackground(new java.awt.Color(255, 255, 255));
        jLnivelActual.setFont(Estilos.getFuenteCuerpo());
        jLnivelActual.setForeground(Estilos.getColorFuenteCuerpo());
        jLnivelActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLnivelActual.setText("Nivel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(TFrespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonNewPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLnivelActual, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLOperacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSubirNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBajarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonNewPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFrespuesta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLnivelActual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(botonSubirNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonBajarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 560, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNewPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNewPlayMouseClicked
        //inserta codigo para iniciar la partida
        //Esto evita que una ves precionado el boton de inicio se pueda volver a iniciar una partida
        if (controlPartida == false) {
            actualizarAlmacenOperaciones(controlPartida);
            controlPartida = true;
            // inicia el juego
            juego = new MetodosJuegoEuclides();
            juego.crearPregunta(nivel);
            juego.iniciarJuego();
            //se coloca la pregunta en el panel
            jLOperacion.setText(juego.textoPregunta());
            jLResultado.setText("");
            TFrespuesta.setText("");
            //
            almacenOperaciones = "";
            //lleva el teclado al campo de la respuesta
            TFrespuesta.requestFocus();
        }

    }//GEN-LAST:event_buttonNewPlayMouseClicked

    private void buttonNewPlayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNewPlayMouseEntered
        buttonNewPlay.setBackground(Estilos.getColorSobreBoton());
    }//GEN-LAST:event_buttonNewPlayMouseEntered

    private void buttonNewPlayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNewPlayMouseExited
        buttonNewPlay.setBackground(Estilos.getColorPanel());
    }//GEN-LAST:event_buttonNewPlayMouseExited

    private void TFrespuestaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFrespuestaMousePressed
        if (TFrespuesta.getText().equals("Inserta una respuesta")) {
            TFrespuesta.setText("");
            TFrespuesta.setForeground(Color.black);
        }
    }//GEN-LAST:event_TFrespuestaMousePressed

    private void TFrespuestaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFrespuestaKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER && controlPartida == true) {
            if (juego.comprobarRespuesta(TFrespuesta.getText())) {
                jLResultado.setForeground(Estilos.getColorRespuestaCorrecta());
                jLResultado.setText("¡Correcto!");
                actualizarAlmacenOperaciones(true);
            } else {
                jLResultado.setForeground(Estilos.getColorRespuestaIncorrecta());
                jLResultado.setText("Incorrecto, la respuesta es: " + juego.getRespuesta());
                actualizarAlmacenOperaciones(false);
            }

            TFrespuesta.setText("");
            TFrespuesta.requestFocus();

            if (juego.comprobarQuedanIntentos()) {
                juego.crearPregunta(nivel);
                jLOperacion.setText(juego.textoPregunta());
            } else {
                juego.terminarJuego();
                controlPartida = false;
                TFrespuesta.setText(" Inserta una respueta");
                TFrespuesta.setForeground(new Color(204, 204, 204));
                jLOperacion.setText("Aciertos: " + juego.getAciertos() + ", Tiempo: " + juego.getTiempoPartida() + " sec");
                MetodosJuegoBBDD.insertResultado(Main.getCon(), juego.getAciertos(), juego.getTiempoPartida(), NOMBREDEJUEGO, nivel);
                // actualiza la informacion de las tablas
                actualizarTablas();
            }
        }
    }//GEN-LAST:event_TFrespuestaKeyPressed

    private void TFrespuestaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFrespuestaFocusGained
        // TODO add your handling code here:
        TFrespuesta.setText("");
        TFrespuesta.setForeground(Color.black);
    }//GEN-LAST:event_TFrespuestaFocusGained

    private void botonSubirNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSubirNivelMouseClicked
        // TODO add your handling code here:
        modificarNivel(1);
    }//GEN-LAST:event_botonSubirNivelMouseClicked

    private void botonSubirNivelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSubirNivelMouseEntered
        // TODO add your handling code here:
        botonSubirNivel.setBackground(Estilos.getColorSobreBoton());
    }//GEN-LAST:event_botonSubirNivelMouseEntered

    private void botonSubirNivelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSubirNivelMouseExited
        // TODO add your handling code here:
        botonSubirNivel.setBackground(Estilos.getColorPanel());
    }//GEN-LAST:event_botonSubirNivelMouseExited

    private void botonBajarNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBajarNivelMouseClicked
        // TODO add your handling code here:
        modificarNivel(2);
    }//GEN-LAST:event_botonBajarNivelMouseClicked

    private void botonBajarNivelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBajarNivelMouseEntered
        // TODO add your handling code here:
        botonBajarNivel.setBackground(Estilos.getColorSobreBoton());
    }//GEN-LAST:event_botonBajarNivelMouseEntered

    private void botonBajarNivelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBajarNivelMouseExited
        // TODO add your handling code here:
        botonBajarNivel.setBackground(Estilos.getColorPanel());
    }//GEN-LAST:event_botonBajarNivelMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Estadisticas;
    private javax.swing.JPanel Informacion;
    private javax.swing.JTextField TFrespuesta;
    private javax.swing.JPanel botonBajarNivel;
    private javax.swing.JPanel botonSubirNivel;
    private javax.swing.JPanel buttonNewPlay;
    private javax.swing.JLabel jLMediaAciertos;
    private javax.swing.JLabel jLOperacion;
    private javax.swing.JLabel jLResultado;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLTituloEstadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbajarNivel;
    private javax.swing.JLabel jLlastPlays;
    private javax.swing.JLabel jLnivelActual;
    private javax.swing.JLabel jLpatidasJugadas;
    private javax.swing.JLabel jLranking;
    private javax.swing.JLabel jLsubirNivel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jSPbestPlays;
    private javax.swing.JScrollPane jSPlastPlays;
    private javax.swing.JScrollPane jSPranking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTclasificacion;
    private javax.swing.JTextPane jTextPaneAlmacenOperaciones;
    private javax.swing.JTable jTmejoresPartidas;
    private javax.swing.JTable jTultimasPartidas;
    // End of variables declaration//GEN-END:variables
}
