/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import BBDD.ConexionBBDD;
import BBDD.MetodosRegistroBBDD;
import BBDD.MetodosUsuarioBBDD;
import Calculadora.Calculadora;
import Euclides.MetodosJuegoEuclides;
import Login.Login;
import BBDD.MetodosJuegoBBDD;
import RestoDiv.MetodosJuegoRestoDiv;
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

        /*
        Me queda por poner sonido a:
            -Register
            -MAIN
            -PanelProfesor
            -ProfesorBienvenida
            -ProfesorInfoAlumnos
            -ProfesorInfoClasificacionAlumnos
            -Calculo
            -RestoDiv
            -Cambio
        
        */
        /*
        CLASES CON JAVA DOC y Ortografía
        
        Leyenda 
        " * " Paquete
        " - " Clase
        
        Pendientes de Revisar: SI DA TIEMPO QUE OTRO LO COMPRUEBE
            
            *Tiempo
                - Tiempo: Daniel JavaDoc y Ortografía. segundo chequeo:
        
            *RestoDiv
                - RestoDiv: Daniel JavaDoc y Ortografía. segundo chequeo:
                - MetodosJuegoRestoDiv: Daniel JavaDoc y Ortografía. segundo chequeo:
        
            Euclides
                - MetodosJuegoEuclides: Daniel JavaDoc y Ortografía. segundo chequeo:
                - Euclides (no revisar ya que va a ser un copia y pega de RestoDiv)
        
            *Alumno
                - AlumnoBienvenida: Daniel JavaDoc y Ortografía. segundo chequeo:
                - AlumnoPanel: Daniel JavaDoc y Ortografía. segundo chequeo:
        
            * Calculadora
                - Calculadora: Daniel JavaDoc y Ortografía. segundo chequeo:
            
            *Main
                - Main
        
            * Usuario
                - Usuario
                - Cambio
                - AjusteUsuario
        
            * Login
                - Login
                - Register
                - AjustesLogin

            * Ajustes
                - Ajustes
                - Configuracion: Daniel JavaDoc y Ortografía. segundo chequeo: 
                - Estilos: Daniel JavaDoc y Ortografía. segundo chequeo:
        
            *Profesor
                - ProfesorBienvenida: Daniel JavaDoc y Ortografía. segundo chequeo:
                - PanelProfesor autor: Daniel JavaDoc y Ortografía. segundo chequeo:
                - ProfesorInfoAlumnos: Daniel JavaDoc y Ortografía. segundo chequeo:
                - ProfesorInfoAlumnosClasificacion
            
             Calculo
                - MetodosJuegoCalculo
                - Calculo (no revisar ya que va a ser un copia y pega de RestoDiv)
        
            *BBDD
                - ConexionBBDD: Daniel JavaDoc y Ortografía. segundo chequeo:
                - MetodosAjusteBBDD
                - MetodosAlumnoBBDD
                - MetodosClasificacionBBDD
                - MetodosJuegoBBDD
                - MetodosRegistroBBDD
                - MetodosUpdateBBDD
                - MetodosUsuarioBBDD
                - ObjetoAlumnoBBDD
                - ObejetoClasificacionBBDD
                - ObjetoJuegoBBDD: Daniel JavaDoc y Ortografía. segundo chequeo:
        
        Terminados:

         */
        
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
        System.out.println("Login Usuario " + MetodosUsuarioBBDD.loginUsuario(con, usuario));
        System.out.println("Login Contraseña " + MetodosUsuarioBBDD.loginContrasena(con, usuario, contrasena));
        System.out.println("DNI " + MetodosUsuarioBBDD.comprobarDNI(con, DNI));
        System.out.println("Email " + MetodosUsuarioBBDD.compobrarEmail(con, email));
        System.out.println("Alias " + MetodosUsuarioBBDD.compobrarAlias(con, alias));
        System.out.println("Nombre Usuario " + MetodosUsuarioBBDD.comprobarNombreUsuario(con, nombreUsuario));
        System.out.println("Es Profesor " + MetodosUsuarioBBDD.comprobarEsProfesor(con, nombreUsuario));    
         */
        //usuario.setUsuario(usuario);
        //MetodosUsuario.generarUsuario(con);
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
        //EUCLIDES
        //Funciona, se crea un objeto de esa clase y se inicializa la partida. esto genera solo los dos numeros iniciales y almacena el Maximo comun divisor.
        /* MetodosJuegoEuclides partida = new MetodosJuegoEuclides();
        partida.crearPregunta();
        System.out.println("numero A: " + partida.getNumeroMayor() + ", Numero B: " + partida.getNumeroMenor() + ", Maximo comun divisor: " + partida.getMaximoComunDivisor());
         */
        //RestoDiv
        /*
        MetodosJuegoRestoDiv juego = new MetodosJuegoRestoDiv();
        System.out.println("dame el resto de la division de estos dos numeros");
        System.out.println("Dividendo: " + juego.getDividendo() + ", divisor " + juego.getDivisor());
        Scanner sc = new Scanner(System.in);
        juego.crearPregunta();
        int respuesta = sc.nextInt();
        juego.terminarJuego();
        if (respuesta == juego.getRespuesta()) {
            System.out.println("Correcto!");
            System.out.println("Tiempo transcurrido (sec): " + juego.getTiempoPartida());
        } else {
            System.out.println("FALLASTE! la respuesta correcta es: " + juego.getRespuesta());
            System.out.println("Tiempo transcurrido (sec): " + juego.getTiempoPartida());
        }
         */
        //RestoDiv
        //BBDDMetodosRestoDiv.selectClasificacion(con);
        //Euclides Ramiro
        /*
        MetodosJuegoEuclides juego = new MetodosJuegoEuclides();
        Scanner lectura = new Scanner(System.in);
        do {
            juego.iniciarJuego();
            juego.crearPregunta();
            System.out.println("Inserta el máximo común divisor de " + juego.getNumeroMayor() + " y " + juego.getNumeroMenor());
            if (juego.comprobarRespuesta(lectura.nextLine())) {
                System.out.println("acertaste");
            } else {
                System.out.println("fallaste, la respuesta correcta es: " + juego.getMaximoComunDivisor());
            }
        } while (juego.comprobarQuedanIntentos());
            juego.terminarJuego();
            System.out.println("numero de aciertos: " + juego.getAciertos() + " tiempo transcurrido " + juego.getTiempoPartida());
         */
        conBD.desconectar();
    }
}
