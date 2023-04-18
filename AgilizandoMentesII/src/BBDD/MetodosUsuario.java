/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author damt108
 */
public class MetodosUsuario {

    public static void login(Connection con) {

        String user;

    }

    public static void registrar(Connection con) {

        String nombre = null;
        String apellido1 = null;
        String apellido2 = null;
        String dni = null;
        int curso = 0; // solo acepta valores de 1 a 4
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

}
