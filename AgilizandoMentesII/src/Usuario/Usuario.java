/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * @author damt108
 */
public class Usuario {
    
    private static int idUsuario;
    private static String usuario;
    private static String alias;
    private static boolean esProfe = false;
    private static String nombre;
    private static String apellido1;
    private static String apellido2;
    

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        Usuario.idUsuario = idUsuario;
    }

    public static String getAlias() {
        return alias;
    }

    public static void setAlias(String alias) {
        Usuario.alias = alias;
    }

    public static boolean isEsProfe() {
        return esProfe;
    }

    public static void setEsProfe(boolean esProfe) {
        Usuario.esProfe = esProfe;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Usuario.nombre = nombre;
    }

    public static String getApellido1() {
        return apellido1;
    }

    public static void setApellido1(String apellido1) {
        Usuario.apellido1 = apellido1;
    }

    public static String getApellido2() {
        return apellido2;
    }

    public static void setApellido2(String apellido2) {
        Usuario.apellido2 = apellido2;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Usuario.usuario = usuario;
    }
    
    
}
