package BBDD;

import java.sql.*;
import Usuario.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author terciodemarte
 */
public class MetodosUpdate {

    
    /**
     * Metodo para actualizar la contraseña del usuario
     * @param con
     * @param password 
     */
    public static void updatePassword(Connection con, String password) {
      
        PreparedStatement ps1 = null;
        String insert1 = "update usuario set contrasena=md5(?) where id_usuario=" + Usuario.getIdUsuario();
        try {
            ps1 = con.prepareStatement(insert1);
            ps1.setString(1, password);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetodosUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para actualizar el alias
     *
     * @param con
     * @param alias
     */
    public static void updateAlias(Connection con, String alias) {
        Usuario.setAlias(alias);
        PreparedStatement ps1 = null;
        String insert1 = "update usuario set alias=? where id_usuario=" + Usuario.getIdUsuario();
        try {
            ps1 = con.prepareStatement(insert1);
            ps1.setString(1, alias);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetodosUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para actualizar el nombre del usuario
     *
     * @param con
     * @param nombre
     */
    public static void updateNombre(Connection con, String nombre) {
        Usuario.setNombre(nombre);
        PreparedStatement ps1 = null;
        String insert1 = "update persona set nombre=? where id_usuario=" + Usuario.getIdUsuario();
        try {
            ps1 = con.prepareStatement(insert1);
            ps1.setString(1, nombre);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetodosUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para actualizar el primer apellido del usuario
     *
     * @param con
     * @param apellido1
     */
    public static void updateApellido1(Connection con, String apellido1) {
        Usuario.setApellido1(apellido1);
        PreparedStatement ps1 = null;
        String insert1 = "update persona set apellido1=? where id_usuario=" + Usuario.getIdUsuario();
        try {
            ps1 = con.prepareStatement(insert1);
            ps1.setString(1, apellido1);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetodosUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para actualizar el segundo apellido del usuario
     *
     * @param con
     * @param apellido2
     */
    public static void updateApellido2(Connection con, String apellido2) {
        Usuario.setApellido1(apellido2);
        PreparedStatement ps1 = null;
        String insert1 = "update persona set apellido2=? where id_usuario=" + Usuario.getIdUsuario();
        try {
            ps1 = con.prepareStatement(insert1);
            ps1.setString(1, apellido2);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetodosUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Metodo para actualizar el email del usuario
     *
     * @param con
     * @param email
     */
    public static void updateEmail(Connection con, String email) {

        PreparedStatement ps1 = null;
        String insert1 = "update persona set email=? where id_usuario=" + Usuario.getIdUsuario();
        try {
            ps1 = con.prepareStatement(insert1);
            ps1.setString(1, email);
            ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MetodosUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
