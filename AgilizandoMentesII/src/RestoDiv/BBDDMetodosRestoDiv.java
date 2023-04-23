/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RestoDiv;

import BBDD.MetodosCalculo;
import Usuario.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CafeConPalito
 */
public class BBDDMetodosRestoDiv {

    /**
     * Inserta en la BBDD la puntuacion del jugador para el juego Resto Division
     *
     * @param con
     * @param puntos
     * @param tiempo_partida al pasarle un entero como tiempo los considera como
     * segundos y los almacena bien mientras no dure mas de 1 min
     * @param tipo
     */
    public static void insertResultado(Connection con, int puntos, int tiempo_partida, String tipo) {
    }

    /**
     * Busca en la BBDD las mejores 5 partidas del jugador y las ordena de mejor
     * a peor 1º por puntos luego por tiempo.
     *
     * @param con
     */
    public static void selectJugadorMejoresPartidas(Connection con) {
    }

    /**
     * Busca en la BBDD las ultimas 5 partidas de el jugador
     *
     * @param con
     */
    public static void selectJugadorUltimasPartidas(Connection con) {
    }

    /**
     * Busca en la BBDD las 5 mejores puntuaciones de todos los jugadores en el
     * nivel del Usuario
     *
     * @param con
     */
    public static void selectClasificacion(Connection con) {

        PreparedStatement ps = null;
        PreparedStatement psBusqueda = null;
        ResultSet rs = null;
        ResultSet rsBusqueda = null;
        ArrayList <objetosBBDDRestoDiv> lista = new ArrayList();

        //Variable nombre del juego
        String nombreJuego = "RestoDiv";

        //SQL
        String selectReto = "select id_reto from reto where nombre_reto = ? and nivel = ?";
        String select = "select alias, time_to_sec(tiempo_partida), fecha_hora from resto_div inner join usuario on id_usuario = jugador where reto = ? order by tiempo_partida asc limit 5";

        try {

            psBusqueda = con.prepareStatement(selectReto);
            psBusqueda.setString(1, nombreJuego);
            psBusqueda.setInt(2, Integer.parseInt(Usuario.getCurso()));
            rsBusqueda = psBusqueda.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            if (rsBusqueda.next()) {
                ps = con.prepareStatement(select);
                ps.setString(1, rsBusqueda.getString(1));

                rs = ps.executeQuery();

                while (rs.next()) {
                    objetosBBDDRestoDiv jugador = new objetosBBDDRestoDiv(rs.getString(1), rs.getInt(2), rs.getString(3));
                    lista.add(jugador);
                }
                
                for (objetosBBDDRestoDiv i : lista) {
                    System.out.println("alias: " + i.getAlias() + " tiempo partida: " + i.getTiempoPartida() + " Jugado el: " + i.getFecha_hora());
                }
                
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
