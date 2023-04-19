/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.sql.*;

/**
 *
 * @author damt108
 */
public class MetodosUsuario {

    public static boolean loginUsuario(Connection con, String usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        // se prepara la sentencia para la BBDD como un String
        String selectLogUsuario = "select nombre_usuario from usuario where nombre_usuario = ?";
        
        try {
            
            //se crear el Statement Con la conexion a la BBDD y el String
            ps = con.prepareStatement(selectLogUsuario);
            //se añade al select el nombre del usuario
            ps.setString(1, usuario);
            //se ejecuta la sentencia y devuelve un resultado
            rs = ps.executeQuery();
            
            //Es necesario usar el Next Para pasar a la primera Linea de la busqueda
            //una vez en la primera linea podemos obtener la informacion;
            if (rs.next() && usuario.equals(rs.getString(1))) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println("ERROR AL LEER Usuario");
            return false;
        }

    }

    /**
     * Comprobar la contraseña con el cifrado correcto
     *
     * @param con
     * @param usuario
     * @param contrasena
     * @return
     */
    public static boolean loginContrasena(Connection con, String usuario, String contrasena) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //debuelve 1 para true 0 para false
        String selectComprobarContraseña = "select if(md5(?) = (select contrasena from usuario where nombre_usuario = ?),true,false)";
        
        try {
            
            ps = con.prepareStatement(selectComprobarContraseña);
            ps.setString(1, contrasena);
            ps.setString(2, usuario);
            
            rs = ps.executeQuery();

            //el valor que retorna es 1 (true) o 0(false)
            if (rs.next() && "1".equalsIgnoreCase(rs.getString(1))) {
                return true;
            }

            return false;

        } catch (SQLException e) {
            System.err.println("ERROR AL LEER Loging");
            return false;
        }

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

    /**
     * Comprueba si el nombre no esta vacio, pasado desde el registro
     * @param nombre
     * @return boolean
     */
    public static boolean comprobarNombre(String nombre) {
        if (!"".equalsIgnoreCase(nombre)) {
            return true;
        }
        return false;
    }

    /**
     * CComprueba si el apellido1 no esta vacio, pasado desde el registro
     * @param apellido1
     * @return boolean
     */
    public static boolean comprobarApellido1(String apellido1) {
        if (!"".equalsIgnoreCase(apellido1)) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba si el apellido2 no esta vacio, pasado desde el registro
     * @param apellido2
     * @return boolean
     */
    public static boolean comprobarApellido2(String apellido2) {
        if (!"".equalsIgnoreCase(apellido2)) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba si el DNI contiene 8 numeros y Una letra mayuscula, pasado desde el registro
     * y que no existe en la BBDD
     * @param con
     * @param DNI
     * @return boolean
     */
    public static boolean comprobarDNI(Connection con,String DNI) {
        if (DNI.matches("[0-9]{8}[A-Z]")) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba si el Email tiene los parametros correctos (caracteres + "@" +
     * dominio + ".", pasado desde el registro
     * y que no existe en la BBDD
     * @param con
     * @param email
     * @return boolean
     */
    public static boolean compobrarEmail(Connection con,String email) {

        if (email.matches("[0-9a-zA-Z]+[@][a-z]+[.][a-z]{2,3}")) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba si el alias no esta vacio, pasado desde el registro
     * y que no existe en la BBDD
     * @param alias
     * @param con
     * @return boolean
     */
    public static boolean compobrarAlias(Connection con, String alias) {
        if (!"".equalsIgnoreCase(alias)) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba que el nombre de usuario no esta vacio, pasado desde el registro
     * y que no existe en la BBDD
     * @param con
     * @param nombreUsuario
     * @return boolean
     */
    public static boolean compobrarNombreUsuario(Connection con, String nombreUsuario) {
        if (!"".equalsIgnoreCase(nombreUsuario)) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba que el nombre de usuario no esta vacio, pasado desde el registro
     * @param contrasena
     * @return boolean
     */
    public static boolean compobrarContrasena(String contrasena) {
        if (!"".equalsIgnoreCase(contrasena) && contrasena.length()>4) {
            return true;
        }
        return false;
    }
    
    
    //este metodo sobra!
    public static boolean comprobarEsProfesor() {

        return false;
    }

}
