/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import com.sun.jdi.connect.spi.Connection;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author damt108
 */
public class MetodosUsuario {

    public static boolean loginUsuario(Connection con, String usuario) {

    //DEJO COMENTADO PARA QUE NO PETE
    /*
        try {

            String selectLogUsuario = "select nombre_usuario from usuario where nombre_usuario = " + usuario;

            // PENDIENTE DE REVISAR
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(selectLogUsuario);

            if (usuario.equals(rs.toString())) {
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.err.println("ERROR AL LEER");
            return false;
        }
    */
    
    //QUITAR AL ARREGLAR
    return false;
    }

    public static boolean loginContrasena(Connection con, String usuario, String contrasena) {

    //DEJO COMENTADO PARA QUE NO PETE
        /*
        try {
            
            //esto busca la contraseña en la BBDD del usuario cifrada en md5
            //Deprecated
            //String selectContUsuario = "select contraseña from usuario where nombre_usuario = '" + usuario + "'";
            
            //esto devuelve la contraseña pasada como parametro y la devuelve desde la BBDD 
            //Deprecated
            //String selectCifrarContrasena = "select md5('" + contrasena + "')";
             
            //Select todo en uno
            String selectComprobarContraseña = "select if(md5('" + contrasena + "') = (select contrasena from usuario where nombre_usuario = '" + usuario + "'),true,false)";

            // PENDIENTE DE REVISAR
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(selectComprobarContraseña);

            if ("true".equalsIgnoreCase(rs.toString())) {
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.err.println("ERROR AL LEER");
            return false;
        }
        */
        
        //QUITAR AL ARREGLAR
        return false;
    }

    public static void registrar(Connection con) {

        String nombre = null;
        String apellido1 = null;
        String apellido2 = null;
        String dni = null;
        int curso = 0; // solo acepta valores de 1 a 4, solo puede ser 0 si esProfe true
        String fechaNacimiento = null;
        boolean esProfesor = false;
        String email = null;
        String alias = null;
        String nombreUsuario = null;
        String contraseña = null;

        /*
        try {
            
            
            coche c1 = new coche();
            c1.setMatricula("ABC123");
            c1.setMarca("Seat");
            c1.setModelo("Ibiza");
            c1.setColor("Rojo");
            
            String insertarPersona = "insert into persona(matricula,modelo,marca,color) values(?,?,?,?)";
            String insertarUsuario = "insert into usuario("
            PreparedStatement ps = conexion.prepareStatement(insertarCoche);
            
            ps.setString(1, c1.getMatricula());
            ps.setString(2, c1.getModelo());
            ps.setString(3, c1.getMarca());
            ps.setString(4, c1.getColor());
            
            ps.executeUpdate();
            
            System.out.println("datos insertados ;)");
        
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
         */
    }

    //definir condiciones
    public static boolean comprobarNombre() {

        return false;
    }

    //definir condiciones
    public static boolean comprobarApellido1() {

        return false;
    }

    //definir condiciones
    public static boolean comprobarApellido2() {

        return false;
    }

    //definir condiciones
    public static boolean comprobarDNI() {

        return false;
    }
    
    //definir condiciones
    public static boolean comprobarEsProfesor() {

        return false;
    }
    
    //definir condiciones
    public static boolean compobrarEmail() {

        return false;
    }
    
    //definir condiciones
    public static boolean compobrarAlias() {

        return false;
    }
    
    //definir condiciones
    public static boolean compobrarNombreUsuario() {

        return false;
    }
    
    //definir condiciones
    public static boolean compobrarContrasena() {

        return false;
    }
    
}
