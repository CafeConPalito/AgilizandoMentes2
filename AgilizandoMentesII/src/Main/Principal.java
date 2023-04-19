/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import BBDD.ConexionBBDD;
import BBDD.MetodosUsuario;
import Login.Login;
import Usuario.Usuario;
import java.sql.*;

/**
 *
 * @author Grupo1 Cafe Con Palito
 * @author Carmen, Ramiro, Albano, Daniel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Main a1 = new Main();
        
        //a1.setVisible(true);
        
        ConexionBBDD conBD = new ConexionBBDD();
        Connection con = conBD.conectar();
        
        //Usuario user = new Usuario();
        
        String usuario = "Cbarrios";
        
        System.out.println(MetodosUsuario.loginUsuario(con, usuario));
        
    }
    
}
