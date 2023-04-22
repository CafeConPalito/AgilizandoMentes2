/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Usuario.Usuario;
import java.sql.*;

/**
 *
 * @author produccion
 */
public class MetodosEuclides {

    /**
     * Inserta en la BBDD la puntuacion del jugador para el juego Euclides
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
     * @param con
     */
    public static void selectClasificacion(Connection con) {

    }

}
