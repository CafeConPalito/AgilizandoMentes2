/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Usuario.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CafeConPalito
 */
public class MetodosCalculo {

    /**
     * Inserta en la BBDD la puntuacion del jugador para el juego Calcula25
     *
     * @param con
     * @param puntos
     * @param tiempo_partida pasado como segundos
     */
    public static void insertResultado(Connection con, int puntos, int tiempo_partida) {
        PreparedStatement ps = null;
        PreparedStatement psBusqueda = null;
        ResultSet rs = null;

        //Variable nombre del juego
        String nombreJuego = "Calcula25";

        //SQL
        String select = "select id_reto from reto where nombre_reto = ? and nivel = ?";
        String insert = "insert into calculo(jugador,reto,puntos,tiempo_partida) values (?,?,?,sec_to_time(?))";

        try {

            //ejecuta esta sentencia para buscar ID del reto corresponde con el jugador. Pensado por si añadimos mas cosas al mismo reto 
            psBusqueda = con.prepareStatement(select);
            psBusqueda.setString(1, nombreJuego);
            psBusqueda.setInt(2, Integer.parseInt(Usuario.getCurso()));
            rs = psBusqueda.executeQuery();

            // si existe reto para ese jugador lo inserta.
            if (rs.next()) {

                ps = con.prepareStatement(insert);
                ps.setInt(1, Usuario.getIdUsuario());
                ps.setString(2, rs.getString(1));
                ps.setInt(3, puntos);
                ps.setInt(4, tiempo_partida);

                //CUANDO REALIZAMOS UNA INSERT SE UTILIZA EXECUTE UPDATE
                ps.executeUpdate();

            } else {
                System.err.println("FALLO EN LA BUSQUEDA, ERROR AL INSERTAR DATOS");
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Busca en la BBDD las mejores 5 partidas del jugador y las ordena de mejor
     * a peor 1º por puntos luego por tiempo.
     *
     * @param con
     */
    public static void selectJugadorMejoresPartidas(Connection con) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        //Variable nombre del juego
        //String nombreJuego = "Calcula25";
        //SQL
        String select = "select alias, puntos, tiempo_partida, fecha_hora from calculo inner join usuario on id_usuario = jugador where id_usuario = ? order by puntos desc, tiempo_partida desc limit 5";

        try {

            ps = con.prepareStatement(select);
            ps.setInt(1, Usuario.getIdUsuario());

            rs = ps.executeQuery();

            // para mostrar por pantalla los resultados. tocaria almacenarlos de alguna manera, por definir
            while (rs.next()) {
                System.out.println("Alias " + rs.getString(1) + " Puntos " + rs.getString(2) + " Tiempo Partida " + rs.getString(3) + " Fecha Partida " + rs.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Busca en la BBDD las ultimas 5 partidas de el jugador
     *
     * @param con
     */
    public static void selectJugadorUltimasPartidas(Connection con) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        //Variable nombre del juego
        //String nombreJuego = "Calcula25";
        //SQL
        String select = "select alias, puntos, tiempo_partida, fecha_hora from calculo inner join usuario on id_usuario = jugador where id_usuario = ? order by fecha_hora desc limit 5";

        try {

            ps = con.prepareStatement(select);
            ps.setInt(1, Usuario.getIdUsuario());

            rs = ps.executeQuery();

            // para mostrar por pantalla los resultados. tocaria almacenarlos de alguna manera, por definir
            while (rs.next()) {
                System.out.println("Alias " + rs.getString(1) + " Puntos " + rs.getString(2) + " Tiempo Partida " + rs.getString(3) + " Fecha Partida " + rs.getString(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        //Variable nombre del juego
        String nombreJuego = "Calcula25";

        //SQL
        String selectReto = "select id_reto from reto where nombre_reto = ? and nivel = ?";
        String select = "select alias, puntos, tiempo_partida, fecha_hora from calculo inner join usuario on id_usuario = jugador where reto = ? order by puntos desc, tiempo_partida desc limit 5";

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
                    System.out.println("Alias " + rs.getString(1) + " Puntos " + rs.getString(2) + " Tiempo Partida " + rs.getString(3) + " Fecha Partida " + rs.getString(4));
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
