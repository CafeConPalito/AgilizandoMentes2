/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Tiempo.Tiempo;
import java.util.Scanner;

/**
 *
 * @author CafeConPalito
 */
public class RestoDivisionEntera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // genero un nivel o curso aleatorio de momento pero esto vendria dado por el Usuario
        int nivel = (int) (Math.random() * 4 + 1);
        int intentos;
        int dividendo;
        int divisor;
        int respuesta;
        int escaner = -1;
        
        // contador de tiempo
        long contadorInicio;
        long contadorFinal;
        
        Scanner scNum = new Scanner(System.in);

        System.out.println("nivel: " + nivel);

        //segun el nivel se ejecuta uno de los niveles con intentos distintos y complejidad distinta
        switch (nivel) {
            case 1:
                intentos = 2;
                System.out.println("intentos 2");
                dividendo = (int) (Math.random() * 10 + 1);
                divisor = (int) (Math.random() * 10 + 1);
                
                // evita que el dividendo sea mayor que el divisor
                while (divisor > dividendo) {
                    divisor = (int) (Math.random() * 10 + 1);
                }
                
                //almacena la respuesta
                respuesta = dividendo % divisor;

                break;
            case 2:
                intentos = 1;
                System.out.println("intentos 1");
                dividendo = (int) (Math.random() * 10 + 1);
                divisor = (int) (Math.random() * 10 + 1);
                while (divisor > dividendo) {
                    divisor = (int) (Math.random() * 10 + 1);
                }
                respuesta = dividendo % divisor;

                break;
            case 3:
                intentos = 2;
                System.out.println("intentos 2");
                dividendo = (int) (Math.random() * 100 + 1);
                divisor = (int) (Math.random() * 10 + 1);
                while (divisor > dividendo) {
                    divisor = (int) (Math.random() * 10 + 1);
                }
                respuesta = dividendo % divisor;

                break;
            case 4:
                intentos = 1;
                System.out.println("intentos 1");
                dividendo = (int) (Math.random() * 100 + 1);
                divisor = (int) (Math.random() * 10 + 1);
                while (divisor > dividendo) {
                    divisor = (int) (Math.random() * 10 + 1);
                }
                respuesta = dividendo % divisor;

                break;

            default:
                throw new AssertionError();
        }
        
        // apagado, te da el resultado de la respuesta para poder probarlo y no volvernos locos
        // System.out.println("respuesta " + respuesta);
        
        Tiempo tiempo = new Tiempo();
        tiempo.iniciarContador();
        
        do {
            try {
                System.out.println("tienes " + intentos + " intento");
                System.out.println(dividendo + " / " + divisor + " resto = ");
                
                // como lo que traemos de un cuadro de texto es un String lo meto en un while y en un try para Realizar el Integer.ParseInt y que no de fallos.
                escaner = Integer.parseInt(scNum.nextLine());
                
                intentos--;

                // para volver a pedir la respuesta si es erronea
                if (respuesta != escaner && intentos > 0) {
                    System.out.println("Vuelve a intentarlo");
                }

                // este catch si da erros es importante para que le diga al usuario introduce un numero correctamente
            } catch (NumberFormatException e) {
                System.err.println("introduce un numero");
            }
        } while (intentos > 0 && respuesta != escaner);
        
        tiempo.pararContador();
        System.out.println("segundos transcurrodos: " + tiempo.getSecTranscurridos());
        
        // mesaje final, tocaria incluir los metodos para almacenar la info en la BBDD
        if (respuesta == escaner) {
            System.out.println("CORRECTO!");
        } else {
            System.out.println("FALLASTE respuesta correcta");
            System.out.println(dividendo + " / " + divisor + " resto " + dividendo % divisor);
        }

    }

}
