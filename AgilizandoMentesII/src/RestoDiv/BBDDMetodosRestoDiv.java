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
     * @param aciertos se pasan los aciertos del jugador
     * @param tiempo_partida se pasan los segundos como entero
     */
    public static void insertResultado(Connection con, int aciertos, int tiempo_partida) {
        PreparedStatement ps = null;
        PreparedStatement psBusqueda = null;
        ResultSet rs = null;

        //Variable nombre del juego
        String nombreJuego = "RestoDiv";

        //SQL
        String select = "select id_reto from reto where nombre_reto = ? and nivel = ?";
        String insert = "insert into resto_div(jugador,reto,aciertos,tiempo_partida) values (?,?,?,sec_to_time(?))";

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
                ps.setInt(3, aciertos);
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
     * @return ArrayList con las 5 mejores partidas del jugador
     */
    public static ArrayList selectJugadorMejoresPartidas(Connection con) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<objetosBBDDRestoDiv> lista = new ArrayList();

        //Variable nombre del juego
        //String nombreJuego = "RestoDiv";
        //SQL
        String select = "select alias, time_to_sec(tiempo_partida), aciertos, fecha_hora from resto_div inner join usuario on id_usuario = jugador where id_usuario = ? order by aciertos desc, tiempo_partida asc limit 5";

        try {

            ps = con.prepareStatement(select);
            ps.setInt(1, Usuario.getIdUsuario());

            rs = ps.executeQuery();

            while (rs.next()) {
                objetosBBDDRestoDiv jugador = new objetosBBDDRestoDiv(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                lista.add(jugador);
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    /**
     * Busca en la BBDD las ultimas 5 partidas de el jugador
     *
     * @param con
     * @return ArrayList con las 5 ultimas partidas del jugador
     */
    public static ArrayList selectJugadorUltimasPartidas(Connection con) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<objetosBBDDRestoDiv> lista = new ArrayList();

        //Variable nombre del juego
        //String nombreJuego = "RestoDiv";
        //SQL
        String select = "select alias, time_to_sec(tiempo_partida), aciertos, fecha_hora from resto_div inner join usuario on id_usuario = jugador where id_usuario = ? order by fecha_hora desc limit 5";

        try {

            ps = con.prepareStatement(select);
            ps.setInt(1, Usuario.getIdUsuario());

            rs = ps.executeQuery();

            while (rs.next()) {
                objetosBBDDRestoDiv jugador = new objetosBBDDRestoDiv(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                lista.add(jugador);
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     * Busca en la BBDD las 5 mejores puntuaciones de todos los jugadores en el
     * nivel del Usuario
     *
     * @param con
     * @return ArrayList con los 5 mejores calificados
     */
    public static ArrayList selectClasificacion(Connection con) {

        PreparedStatement ps = null;
        PreparedStatement psBusqueda = null;
        ResultSet rs = null;
        ResultSet rsBusqueda = null;
        ArrayList<objetosBBDDRestoDiv> lista = new ArrayList();

        //Variable nombre del juego
        String nombreJuego = "RestoDiv";

        //SQL
        String selectReto = "select id_reto from reto where nombre_reto = ? and nivel = ?";
        String select = "select alias, time_to_sec(tiempo_partida), aciertos, fecha_hora from resto_div inner join usuario on id_usuario = jugador where reto = ? order by aciertos desc, tiempo_partida asc limit 5";

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
                    objetosBBDDRestoDiv jugador = new objetosBBDDRestoDiv(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
                    lista.add(jugador);
                }

            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public static String totalPartidas(Connection con){
        String totalPartidas = "0";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //SQL
        String select = "SELECT partidas FROM estadisticas_resto_div where jugador = ? and nivel = ?";

        try {

            ps = con.prepareStatement(select);
            ps.setInt(1, Usuario.getIdUsuario());
            ps.setString(2,Usuario.getCurso());

            rs = ps.executeQuery();

            while (rs.next()) {
                totalPartidas = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalPartidas;
    }
    
    public static String mediaAciertos(Connection con){
        String mediaAciertos = "0";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //SQL
        String select = "SELECT mediaAciertos FROM estadisticas_resto_div where jugador = ? and nivel = ?";

        try {

            ps = con.prepareStatement(select);
            ps.setInt(1, Usuario.getIdUsuario());
            ps.setString(2,Usuario.getCurso());

            rs = ps.executeQuery();

            while (rs.next()) {
                mediaAciertos = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MetodosCalculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mediaAciertos;
    }

}
