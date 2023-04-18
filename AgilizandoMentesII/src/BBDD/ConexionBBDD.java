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
public class ConexionBBDD {
    
    static Connection con;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // esto por lo que entiendo utiliza el driver que bajamos (el jar)
    static final String USER = "root"; 
    static final String PASS = "1234";
    static final String BD = "nba"; // nombre de la base de datos
    //la direccion para conectar a la bbdd se le pasa como parametro "BD"
    static final String DB_URL = "jdbc:mysql://localhost:3306/"+BD+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
       
    
    public Connection conectar (){
        
        // ESTO NO ESTA BIEN LO DEJO COMO REFERENCIA.
        try {
            //Esta linea el de pildoras informaticas no la usa y le funciona la conexion y el video es de hace 7 años
            //Curso Java. Acceso a BBDD. JDBC II. Vídeo 202
            //https://www.youtube.com/watch?v=TipyOAYGsdc
            Class.forName(JDBC_DRIVER).newInstance(); 
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            if (con != null) {
                System.out.println("coneccion realizada");
            }
            
            

        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            System.err.println("problemas de coneccion\n" + ex.toString());
        } catch (ClassNotFoundException e) {
            System.err.println(e.toString());
        }
        
        return con;
        
    }

    //falta desconectar
    
    public void desconectar(){
        
        try {
            

        } catch (Exception e) {
        }
        
    }
    
}
