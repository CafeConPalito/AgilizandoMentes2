/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Calculo;

import Calculo.*;
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
public class Calculo extends javax.swing.JPanel {

    MetodosJuegoCalculo juego = null;
    boolean controlPartida = false; // partida no iniciada , en true iniciada
    private String almacenOperaciones = "";
    private final String NOMBREDEJUEGO = "calculo"; //nombre que tiene la tabla en la BBDD
    private int nivel;// implementado para pasar un nivel 

    /**
     * Creates new form NewJPanel Inicializa el panel Obtiene el nivel / curso
     * del jugador para mostrarlo en el jLnivelActual Actualiza la información
     * del usuario
     *
     */
    public Calculo() {
        initComponents();
        //Esta linea aplica el color al header desde la clase HeaderColor del paquete Ajustes
        jTclasificacion.getTableHeader().setDefaultRenderer(new HeaderColor());
        jTmejoresPartidas.getTableHeader().setDefaultRenderer(new HeaderColor());
        jTultimasPartidas.getTableHeader().setDefaultRenderer(new HeaderColor());

        try {
            nivel = Integer.parseInt(Usuario.getCurso());
        } catch (NumberFormatException e) {
        }
        jLnivelActual.setText("Nivel " + nivel);
        tFrespuesta.setEnabled(controlPartida);
        actualizarTablas();
    }

    /**
     * Aglutina todas las actualizaciones de información que se muestra por
     * pantalla
     */
    public void actualizarTablas() {
        actualizarClasificacion();
        actualizarMejorePartidas();
        actualizarUltimasPartidas();
        actualizarNumeroPartidas();
        actualizarMediaAciertos();
        actualizarPenalizacion();
    }

    /**
     * Si la partida esta inicializada va añadiendo el resultado de las
     * operaciones a jTextPaneAlmacenOperaciones, en función de control se
     * decide que texto colocar, respuesta correcta o incorrecta Si la partida
     * no esta inicializada borra el contenido de jTextPaneAlmacenOperaciones
     *
     * @param control Recibe un booleano que indica si la respuesta es correcta
     * o incorrecta
     */
    public void actualizarAlmacenOperaciones(boolean control) {
        if (controlPartida) {
            if (control) {
                almacenOperaciones = almacenOperaciones + "\n★ " + juego.textoAlmacenRespuesta();
                jTextPaneAlmacenOperaciones.setText(almacenOperaciones);
            } else {
                almacenOperaciones = almacenOperaciones + "\n☓ " + juego.textoAlmacenRespuesta() + ", tu respuesta " + tFrespuesta.getText();
                jTextPaneAlmacenOperaciones.setText(almacenOperaciones);
            }
        } else {
            jTextPaneAlmacenOperaciones.setText("");
        }

    }

    public void actualizarPenalizacion() {
        jLTitulo.setText(" Los fallos penalizan " + (nivel+1) + " segundos");
    }

    /**
     * Según el valor pasado modifica el nivel, entre 1 y 4, controla que la
     * partida no este inicializada con el booleano de controlPartida.
     *
     * @param opcion valor '1' para subir un nivel, valor '2' para bajar nivel
     */
    public void modificarNivel(int opcion) {
        if (controlPartida == false) {
            switch (opcion) {
                case 1:
                    if (nivel < 4) {
                        nivel++;
                    }
                    jLnivelActual.setText("Nivel " + nivel);
                    break;
                case 2:
                    if (nivel > 1) {
                        nivel--;
                    }
                    jLnivelActual.setText("Nivel " + nivel);
                    break;
                default:
                    throw new AssertionError();
            }
            actualizarTablas(); // al modificar el nivel se cambia la tabla de clasificacion por la actual ;)
        }
    }

    /**
     * Actualiza la tabla jTclasificacion con información del jugador en función
     * de su nivel, actualizando la información desde la BBDD
     */
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

    /**
     * Actualiza la tabla jTmejoresPartidas con información del jugador en
     * función de su nivel, actualizando la información desde la BBDD
     */
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

    /**
     * Actualiza la tabla jTultimasPartidas con información del jugador en
     * función de su nivel, actualizando la información desde la BBDD
     */
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

    /**
     * Alcaliza el jLpartidasJugadas con las estadísticas del jugador en función
     * de su nivel, actualizando la información desde la BBDD
     */
    private void actualizarNumeroPartidas() {
        jLpatidasJugadas.setText("Partidas jugadas: " + MetodosJuegoBBDD.totalPartidas(Main.getCon(), NOMBREDEJUEGO, nivel));
    }

    /**
     * Alcaliza el jLMediaAciertos con las estadísticas del jugador en función
     * de su nivel, actualizando la información desde la BBDD
     */
    private void actualizarMediaAciertos() {
        jLMediaAciertos.setText("Media de aciertos: " + MetodosJuegoBBDD.mediaAciertos(Main.getCon(), NOMBREDEJUEGO, nivel) + " / 25");
    }

    /**
     * Controla dentro del panel el desarrollo de la partida y las acciones que
     * realizan los usuarios en los botones y al insertar respuesta Da inicio a
     * la partida si el botón Jugar es pulsado y no esta una partida ya
     * inicializada Si la partida esta inicializada comprueba que la respuesta
     * introducida en el tFrespuesta es correcta y actualiza los mensajes en
     * pantalla dependiendo de la respuesta y finaliza la partida si al jugador
     * no le quedan intentos. volviendo al estado inicial el panel.
     *
     * @param control recibe un boolean
     */
    private void partida(boolean control) {

        //al presionar el Boton si la partida no esta iniciada!
        //Esto evita que una ves presionado el boton de inicio se pueda volver a iniciar una partida
        if (control == false && controlPartida == false) {
            actualizarAlmacenOperaciones(controlPartida);
            controlPartida = true;
            // inicia el juego
            juego = new MetodosJuegoCalculo();
            juego.crearPregunta(nivel);
            juego.iniciarJuego();
            //se coloca la pregunta en el panel
            jLOperacion.setText(juego.textoPregunta());
            jLResultado.setText("");
            tFrespuesta.setText("");
            //
            almacenOperaciones = "";

            //lleva el teclado al campo de la respuesta
            tFrespuesta.setEnabled(controlPartida);
            tFrespuesta.requestFocus();

        } else if (control && controlPartida) {
            if (juego.comprobarRespuesta(tFrespuesta.getText())) {
                jLResultado.setForeground(Estilos.getColorRespuestaCorrecta());
                jLResultado.setText("¡Correcto!");
                actualizarAlmacenOperaciones(true);
            } else {
                jLResultado.setForeground(Estilos.getColorRespuestaIncorrecta());
                jLResultado.setText("Incorrecto, la respuesta es: " + juego.getRespuesta());
                actualizarAlmacenOperaciones(false);
            }

            tFrespuesta.setText("");
            tFrespuesta.requestFocus();

            if (juego.comprobarQuedanIntentos()) {
                juego.crearPregunta(nivel);
                jLOperacion.setText(juego.textoPregunta());
            } else {
                juego.terminarJuego();
                controlPartida = false;
                tFrespuesta.setText(" Inserta una respueta");
                tFrespuesta.setForeground(Estilos.getColorGrisEsperandoRespuesta());
                tFrespuesta.setEnabled(controlPartida);
                jLOperacion.setText("Aciertos: " + juego.getAciertos() + ", Tiempo: " + juego.getTiempoPartida() + " sec");
                MetodosJuegoBBDD.insertResultado(Main.getCon(), juego.getAciertos(), juego.getTiempoPartida(), NOMBREDEJUEGO, nivel);
                // actualiza la informacion de las tablas

                actualizarTablas();
            }
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
        jLInstrucciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneAlmacenOperaciones = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        tFrespuesta = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        botonJugar = new javax.swing.JPanel();
        jLjugar = new javax.swing.JLabel();
        jLResultado = new javax.swing.JLabel();
        jLOperacion = new javax.swing.JLabel();
        botonSubirNivel = new javax.swing.JPanel();
        jLsubirNivel = new javax.swing.JLabel();
        botonBajarNivel = new javax.swing.JPanel();
        jLbajarNivel = new javax.swing.JLabel();
        jLnivelActual = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JPanel();
        Fondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1070, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Informacion.setBackground(new java.awt.Color(255, 255, 255));
        Informacion.setOpaque(false);

        Estadisticas.setBackground(new java.awt.Color(255, 255, 255));
        Estadisticas.setOpaque(false);

        jLTituloEstadisticas.setFont(Estilos.getFuenteCuerpo());
        jLTituloEstadisticas.setForeground(Estilos.getColorFuentePanel());
        jLTituloEstadisticas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLTituloEstadisticas.setText("Estadísticas");

        jLpatidasJugadas.setFont(Estilos.getFuenteCuerpo());
        jLpatidasJugadas.setForeground(Estilos.getColorFuentePanel());
        jLpatidasJugadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLpatidasJugadas.setText("Partidas jugadas");

        jLMediaAciertos.setFont(Estilos.getFuenteCuerpo());
        jLMediaAciertos.setForeground(Estilos.getColorFuentePanel());
        jLMediaAciertos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLMediaAciertos.setText("Media de aciertos");

        javax.swing.GroupLayout EstadisticasLayout = new javax.swing.GroupLayout(Estadisticas);
        Estadisticas.setLayout(EstadisticasLayout);
        EstadisticasLayout.setHorizontalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLpatidasJugadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLTituloEstadisticas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLMediaAciertos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );
        EstadisticasLayout.setVerticalGroup(
            EstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadisticasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jTclasificacion.getTableHeader().setOpaque(false);
        jTclasificacion.getTableHeader().setBackground(new java.awt.Color(255, 25, 25));
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

        jLbestPlays.setFont(Estilos.getFuenteCuerpo());
        jLbestPlays.setForeground(Estilos.getColorFuenteCuerpo());
        jLbestPlays.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLbestPlays.setText("Tus mejores partidas");

        jLranking.setFont(Estilos.getFuenteCuerpo());
        jLranking.setForeground(Estilos.getColorFuenteCuerpo());
        jLranking.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLranking.setText("Clasificación");

        javax.swing.GroupLayout InformacionLayout = new javax.swing.GroupLayout(Informacion);
        Informacion.setLayout(InformacionLayout);
        InformacionLayout.setHorizontalGroup(
            InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InformacionLayout.createSequentialGroup()
                        .addGroup(InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSPlastPlays, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addComponent(jLlastPlays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLbestPlays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSPranking)
                            .addComponent(jSPbestPlays))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jLranking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        InformacionLayout.setVerticalGroup(
            InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(Estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLranking, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSPranking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbestPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSPbestPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLlastPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSPlastPlays, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(Informacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 490, 720));

        jLTitulo.setBackground(Estilos.getColorPanel());
        jLTitulo.setFont(Estilos.getFuenteCuerpo());
        jLTitulo.setForeground(Estilos.getColorFuentePanel());
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLTitulo.setText(" Los fallos penalizan 5 s");
        jLTitulo.setOpaque(true);
        jPanel1.add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 500, 40));

        jLInstrucciones.setBackground(Estilos.getColorPanel());
        jLInstrucciones.setFont(Estilos.getFuenteCuerpo());
        jLInstrucciones.setForeground(Estilos.getColorFuentePanel());
        jLInstrucciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLInstrucciones.setText(" Calcula las siguientes operaciones:");
        jLInstrucciones.setOpaque(true);
        jPanel1.add(jLInstrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 500, 40));

        jScrollPane1.setBorder(null);

        jTextPaneAlmacenOperaciones.setBorder(null);
        jTextPaneAlmacenOperaciones.setFont(Estilos.getFuenteCuerpo());
        jTextPaneAlmacenOperaciones.setForeground(Estilos.getColorFuenteCuerpo());
        jTextPaneAlmacenOperaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextPaneAlmacenOperaciones.setFocusable(false);
        jScrollPane1.setViewportView(jTextPaneAlmacenOperaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 500, 260));

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        tFrespuesta.setFont(Estilos.getFuenteCuerpo());
        tFrespuesta.setForeground(Estilos.getColorGrisEsperandoRespuesta());
        tFrespuesta.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tFrespuesta.setText(" Inserta una respuesta");
        tFrespuesta.setBorder(null);
        tFrespuesta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tFrespuestaFocusGained(evt);
            }
        });
        tFrespuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tFrespuestaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tFrespuestaMousePressed(evt);
            }
        });
        tFrespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tFrespuestaKeyPressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        botonJugar.setBackground(Estilos.getColorPanel());
        botonJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonJugarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonJugarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonJugarMouseExited(evt);
            }
        });

        jLjugar.setFont(Estilos.getFuenteCuerpo());
        jLjugar.setForeground(new java.awt.Color(255, 255, 255));
        jLjugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLjugar.setText("Jugar");

        javax.swing.GroupLayout botonJugarLayout = new javax.swing.GroupLayout(botonJugar);
        botonJugar.setLayout(botonJugarLayout);
        botonJugarLayout.setHorizontalGroup(
            botonJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLjugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        botonJugarLayout.setVerticalGroup(
            botonJugarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonJugarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLjugar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLResultado.setFont(Estilos.getFuenteCuerpo());
        jLResultado.setForeground(Estilos.getColorFuenteCuerpo());
        jLResultado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLOperacion.setFont(Estilos.getFuenteCuerpo());
        jLOperacion.setForeground(Estilos.getColorFuenteCuerpo());
        jLOperacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        botonSubirNivel.setBackground(Estilos.getColorPanel());
        botonSubirNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        botonBajarNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                            .addComponent(tFrespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(botonJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tFrespuesta))
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

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelFondo.setBackground(Estilos.getColorPanelBlanco());
        jPanelFondo.setPreferredSize(new java.awt.Dimension(1070, 720));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FondoClaro.png"))); // NOI18N

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

    /**
     * Al presionar el botón de Jugar envía el estado de la partida solo si es
     * falso para iniciar el juego Evita que se pueda presionar el botón de
     * juego con una partida iniciada
     *
     * @param evt MouseEvent Clicked
     */
    private void botonJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonJugarMouseClicked
        if (!controlPartida) {
            partida(controlPartida);
        }
    }//GEN-LAST:event_botonJugarMouseClicked

    private void botonJugarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonJugarMouseEntered
        botonJugar.setBackground(Estilos.getColorSobreBoton());
    }//GEN-LAST:event_botonJugarMouseEntered

    private void botonJugarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonJugarMouseExited
        botonJugar.setBackground(Estilos.getColorPanel());
    }//GEN-LAST:event_botonJugarMouseExited

    private void tFrespuestaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tFrespuestaMousePressed
        if (tFrespuesta.getText().equals("Inserta una respuesta") && controlPartida) {
            tFrespuesta.setText("");
            tFrespuesta.setForeground(Color.black);
        }
    }//GEN-LAST:event_tFrespuestaMousePressed

    /**
     * Al escribir en el tFrespuesta comprueba que se presiona Enter si se va al
     * método partida, el cual controla el desarrollo de la misma
     *
     * @param evt MouseEvent Clicked
     */
    private void tFrespuestaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFrespuestaKeyPressed
        // TODO add your handling code here:

        //envia true si se preciona enter
        partida(evt.getKeyCode() == KeyEvent.VK_ENTER);
    }//GEN-LAST:event_tFrespuestaKeyPressed

    private void tFrespuestaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tFrespuestaFocusGained
        // TODO add your handling code here:
        if (controlPartida) {
            tFrespuesta.setText("");
            tFrespuesta.setForeground(Color.black);
        }
    }//GEN-LAST:event_tFrespuestaFocusGained

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

    private void tFrespuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tFrespuestaMouseClicked
        // TODO add your handling code here:
        if (controlPartida) {
            tFrespuesta.setText("");
            tFrespuesta.setForeground(Color.black);
        }
    }//GEN-LAST:event_tFrespuestaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Estadisticas;
    private javax.swing.JLabel Fondo;
    private javax.swing.JPanel Informacion;
    private javax.swing.JPanel botonBajarNivel;
    private javax.swing.JPanel botonJugar;
    private javax.swing.JPanel botonSubirNivel;
    private javax.swing.JLabel jLInstrucciones;
    private javax.swing.JLabel jLMediaAciertos;
    private javax.swing.JLabel jLOperacion;
    private javax.swing.JLabel jLResultado;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLTituloEstadisticas;
    private javax.swing.JLabel jLbajarNivel;
    private javax.swing.JLabel jLjugar;
    private javax.swing.JLabel jLlastPlays;
    private javax.swing.JLabel jLnivelActual;
    private javax.swing.JLabel jLpatidasJugadas;
    private javax.swing.JLabel jLranking;
    private javax.swing.JLabel jLsubirNivel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jSPbestPlays;
    private javax.swing.JScrollPane jSPlastPlays;
    private javax.swing.JScrollPane jSPranking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTclasificacion;
    private javax.swing.JTextPane jTextPaneAlmacenOperaciones;
    private javax.swing.JTable jTmejoresPartidas;
    private javax.swing.JTable jTultimasPartidas;
    private javax.swing.JTextField tFrespuesta;
    // End of variables declaration//GEN-END:variables
}
