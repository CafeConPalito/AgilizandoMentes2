/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package RestoDiv;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author terciodemarte
 */
public class MetodosJuegoRestoDivTest {

    /**
     * Prueba unitaria clase de equivalencia rango por abajo
     */
    @Test
    public void testCrearPreguntaAbajo() {
        int nivel = 0;
        MetodosJuegoRestoDiv instance = new MetodosJuegoRestoDiv();
        instance.crearPregunta(nivel);
    }

    /**
     * Prueba unitaria clase de equivalencia rango por arriba
     */
    @Test
    public void testCrearPreguntaArriba() {
        int nivel = 5;
        MetodosJuegoRestoDiv instance = new MetodosJuegoRestoDiv();
        instance.crearPregunta(nivel);
    }

    /**
     * Prueba unitaria clase de equivalencia dentro de rango
     */
    @Test
    public void testCrearPreguntaDentro() {
        int nivel = 2;
        MetodosJuegoRestoDiv instance = new MetodosJuegoRestoDiv();
        instance.crearPregunta(nivel);
    }

    /**
     * Prueba unitaria boolean
     */
    @Test
    public void testComprobarRespuesta() {
        MetodosJuegoRestoDiv instance = new MetodosJuegoRestoDiv();
        assertFalse(instance.comprobarRespuesta(""));
    }

    /**
     * Prueba unitaria ComprobarQuedan Intentos
     */
    @Test
    public void testComprobarQuedanIntentos() {
        MetodosJuegoRestoDiv instance = new MetodosJuegoRestoDiv();
        boolean result = instance.comprobarQuedanIntentos();
        assertTrue(result);
    }

    /**
     * Prueba Unitaria comprobar un string que no este vacio
     */
    @Test
    public void testTextoPregunta() {
        MetodosJuegoRestoDiv instance = new MetodosJuegoRestoDiv();
        assertNotEquals("", instance.textoPregunta());

    }

}
