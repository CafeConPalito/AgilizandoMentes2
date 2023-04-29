/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import Ajustes.Configuracion;
import Ajustes.Estilos;
import Usuario.Usuario;
import java.sql.*;

/**
 *
 * @author CafeConPalito
 */
public class MetodosAjustes {

    /**
     * Metodo para guardar los ajustes del usuario logueado en la BBDD
     *
     * @param con Conexion a la base de datos
     */
    public static void guardarAjustes(Connection con) {
        PreparedStatement ps = null;
        String update = "update ajuste set tamaño =? ,idioma=?,sonido=? where usuario=?";
        try {
            ps = con.prepareStatement(update);
            ps.setString(1, Byte.toString(Configuracion.getTamano()));

            if (Configuracion.getIdioma().equals("Español")) {
                ps.setString(2, "Espanol");
            } else {
                ps.setString(2, "Ingles");
            }

            ps.setBoolean(3, Configuracion.isSonido());

            ps.setInt(4, Usuario.getIdUsuario());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("No se han podido guardar los datos de los ajustes");
        }
    }

    /**
     * Metodo para cargar los ajustes del usaurio logueado
     * @param con Conexion a la base de datos
     */
    public static void cargarAjustes(Connection con) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "select tamaño,idioma,sonido from ajuste where usuario = ?";

        try {

            ps = con.prepareStatement(select);
            ps.setInt(1, Usuario.getIdUsuario());
            rs = ps.executeQuery();

            //Es necesario usar el Next Para pasar a la primera Linea de la busqueda
            //una vez en la primera linea podemos obtener la informacion;
            if (rs.next()) {
                Configuracion.setTamano((byte) rs.getInt(1));
                if (rs.getString(2).equals("Espanol")) {
                    Configuracion.setIdioma("Español");
                } else {
                    Configuracion.setIdioma("Ingles");
                }
                Configuracion.setSonido(rs.getBoolean(3));
            }

        } catch (SQLException e) {
            System.err.println("No se han podido cargar los ajustes");

        }

    }
    
    /**
     * Metodo para actualizar la letra
     */
    public static void actualizarletra(){
         switch (Configuracion.getTamano()) {
            case 1:
                Estilos.setSizeCuerpo(14);

                break;
            case 2:
                Estilos.setSizeCuerpo(18);

                break;
            case 3:
                Estilos.setSizeCuerpo(22);

                break;
        }
    }

}
