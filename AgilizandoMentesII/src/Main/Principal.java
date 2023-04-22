/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import BBDD.ConexionBBDD;
import BBDD.MetodosCalculo;
import BBDD.MetodosUsuario;
import Calculadora.Calculadora;
import Login.Login;
import Usuario.Usuario;
import java.sql.*;
import java.time.LocalDate;

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
        //String usuario = "Despinosa";
        //String usuario = "Rgutierrez";
        //String usuario = "Adiez";
        
        /*
        String contrasena = "12345";
        String DNI = "12345678T";
        String email = "123@asd.es";
        String alias = "AliasDaniel";
        String nombreUsuario ="Amartinez";
        System.out.println("Login Usuario " + MetodosUsuario.loginUsuario(con, usuario));
        System.out.println("Login Contraseña " + MetodosUsuario.loginContrasena(con, usuario, contrasena));
        System.out.println("DNI " + MetodosUsuario.comprobarDNI(con, DNI));
        System.out.println("Email " + MetodosUsuario.compobrarEmail(con, email));
        System.out.println("Alias " + MetodosUsuario.compobrarAlias(con, alias));
        System.out.println("Nombre Usuario " + MetodosUsuario.comprobarNombreUsuario(con, nombreUsuario));
        System.out.println("Es Profesor " + MetodosUsuario.comprobarEsProfesor(con, nombreUsuario));    
        */
        
        
        Usuario.setUsuario(usuario);
        MetodosUsuario.generarUsuario(con);
        //System.out.println(Usuario.getAlias() + Usuario.getApellido1() + Usuario.getApellido2() + Usuario.getNombre());
        
        //Calculadora calcu = new Calculadora();
        //calcu.setVisible(true);
        
        //devuelve la fecha actual
        //System.out.println(Date.valueOf(LocalDate.now()));
        
        System.out.println("Insertar Datos Partida Calculo25");
        //MetodosCalculo.insertResultado(con,28, 14);
        System.out.println("fin insertar datos");
        System.out.println("Mejores 5 partidas del jugador " + Usuario.getUsuario());
        MetodosCalculo.selectJugadorMejoresPartidas(con);
        System.out.println("Fin de Mejores 5 patidas del Jugador ");
        System.out.println("Mostrando las mejores 5 partidas de todos los jugadores de ese nivel");
        MetodosCalculo.selectClasificacion(con);
        System.out.println("fin de mostrar las mejores partidas de los jugadores de ese nivel");
        System.out.println("Mostrando las ultimas 5 Partidas del Jugador");
        MetodosCalculo.selectJugadorUltimasPartidas(con);
        System.out.println("fin mostrando ultimas partidas");
        
        
        conBD.desconectar();
    }
    
}
