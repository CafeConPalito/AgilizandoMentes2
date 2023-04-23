/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Euclides;

/**
 *
 * @author CafeConPalito
 */
public class Euclides {

    private int numeroMayor;
    private int numeroMenor;
    private int maximoComunDivisor;
    private int contador = 5; 

    /**
     * inicializa los dos valores para encontrar el maximo comun divisor e inicia el algoritmo de Euclides
     * que nos dara el maximo comun divisor de los dos numeros
     */
    public void iniciarJuego() {
        System.out.println(" Inicia Juego");
        numeroMayor = (int) (Math.random() * 100 + 1);
        numeroMenor = (int) (Math.random() * 100 + 1);

        while (numeroMenor > numeroMayor) {
            numeroMenor = (int) (Math.random() * 100 + 1);
        }

        euclides(numeroMayor, numeroMenor);
    }

    /**
     * Calcula el Maximo comun divisor de dos numeros.
     *
     * @param x
     * @param y
     */
    public void euclides(int x, int y) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
            System.out.println("x " + x + " y " + y );
        }
        maximoComunDivisor = x;

        // Para evitar que el MaximoComunDivisor sea 1, pasa casi siempre,
        // se coloca un contador y condicion para volver a intentarlo y volver a lanzar el juego
        if (maximoComunDivisor == 1 && contador > 0) {
            contador --;
            iniciarJuego();
        }

    }

    public int getNumeroMayor() {
        return numeroMayor;
    }

    public int getNumeroMenor() {
        return numeroMenor;
    }

    public int getMaximoComunDivisor() {
        return maximoComunDivisor;
    }

}
