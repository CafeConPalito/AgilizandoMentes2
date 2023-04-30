/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author terciodemarte
 */
public class MetodosClasificacionBBDD {


    /**
     * Metodo para sacar los datos de las clasificaciones en los juegos
     * @param con Conexion a la base de datos
     * @param nombre nombre del usuario
     * @param apellido1 1º Apellido de usuario
     * @param apellido2 2º Apellido de usuario
     * @param nivel nivel del juego
     * @param juego nombre del juego
     * @return ArrayList de objetos ObjetoClasificacionBBDD
     */
    public static ArrayList selectClasificacion(Connection con,String nombre, String apellido1, String apellido2, String nivel, String juego ) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ObjetoClasificacionBBDD> lista = new ArrayList();

        String select = "select nivel,partidas,totalaciertos,mediaAciertos,nombre,apellido1,apellido2 from estadisticas_"+juego+" where nombre like ? and apellido1 like ? and apellido2 like ? and nivel like ?";

        try {
            
            ps = con.prepareStatement(select);

         
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, nivel);

          
            rs = ps.executeQuery();

           
            //si encuentra resultado del reto de ese jugador busca la info
           

            while (rs.next()) {
                ObjetoClasificacionBBDD oa = new ObjetoClasificacionBBDD(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7));
                lista.add(oa);
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

        return lista;
    }
}
