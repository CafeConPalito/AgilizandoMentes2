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
public class MetodosAlumnoBBDD {

    /**
     * Metodo para buscar alumnos en la vista view_info_alumnos
     * @param con Conexion a la base de datos
     * @param usuario usuario
     * @param alias alias de usuario
     * @param nombre nombre del usuario
     * @param apellido1 1º Apellido de usuario
     * @param apellido2 2º Apellido de usuario
     * @param dni DNI del usuario
     * @param email email del usuario
     * @param curso Curso del usuario
     * @return Array de objetos ObjetoAlumnoBBDD
     */
    public static ArrayList selectAlumnos(Connection con, String usuario, String alias, String nombre, String apellido1, String apellido2, String dni, String email, String curso) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ObjetoAlumnoBBDD> lista = new ArrayList();

        String select = "select nombre_usuario,alias,nombre,apellido1,apellido2,dni,email,curso,fecha_naci from view_info_alumnos where nombre_usuario like ? and alias like ? and nombre like ? and apellido1 like ? and apellido2 like ? and dni like ? and email like ? and curso like ?";

        try {
            
            ps = con.prepareStatement(select);

            
            ps.setString(1, usuario);
            ps.setString(2, alias);
            ps.setString(3, nombre);
            ps.setString(4, apellido1);
            ps.setString(5, apellido2);
            ps.setString(6, dni);
            ps.setString(7, email);
            ps.setString(8, curso);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
           

            while (rs.next()) {
                ObjetoAlumnoBBDD oa = new ObjetoAlumnoBBDD(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(9), rs.getString(8));
                lista.add(oa);
            }

        } catch (NumberFormatException e) {
            //System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            //System.err.println("Error en el select");
        }

        return lista;
    }
}
