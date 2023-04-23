/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import BBDD.ConexionBBDD;
import BBDD.MetodosCalculo;
import BBDD.MetodosUsuario;
import Calculadora.Calculadora;
import Euclides.Euclides;
import Login.Login;
import Tiempo.Tiempo;
import Usuario.Usuario;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

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
        
        /*
        // TODO ESTO FUNCIONA!
        System.out.println("Insertar Datos Partida Calculo25");
        MetodosCalculo.insertResultado(con,28, 200);
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
        */
        
        // prueba para añadir segundos y convertirlos en tiempo
        // FUNCIONA!
        /*
        System.out.println("Probando Añadir tiempo a la BBDD");
        Scanner sc = new Scanner(System.in);
        System.out.println("inicia el contador esperando intro");
        Tiempo tiempo = new Tiempo();
        tiempo.iniciarContador();
        sc.next();
        tiempo.pararContador();
        System.out.println("fin del contador");
        
        System.out.println("segundos transcurridos: " + tiempo.getSecTranscurridos());
        
        //inserta datos en la tabla resto_div.
        PreparedStatement ps = null;
        String insert = "insert into resto_div(jugador,reto,intentos,puntos,tiempo_partida) values(1,1,1,1,sec_to_time(?));";
        try {
            ps = con.prepareStatement(insert);
            ps.setInt(1, tiempo.getSecTranscurridos());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        */
        
        /*
        //EUCLIDES
        //Funciona, se crea un objeto de esa clase y se inicializa la partida. esto genera solo los dos numeros iniciales y almacena el Maximo comun divisor.
        Euclides partida = new Euclides();
        partida.iniciarJuego();
        System.out.println("numero A: " + partida.getNumeroMayor() + ", Numero B: " + partida.getNumeroMenor() + ", Maximo comun divisor: " + partida.getMaximoComunDivisor());
        */
        
        conBD.desconectar();
    }
    
}
