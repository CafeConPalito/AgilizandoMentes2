package Ajustes;

/**
 *
 * @author terciodemarte
 */
public class Configuracion {
    private static byte tamano=2;
    private static String idioma="Espanol";
    private static boolean sonido=false;

    public static byte getTamano() {
        return tamano;
    }

    public static void setTamano(byte tamano) {
        Configuracion.tamano = tamano;
    }

    public static String getIdioma() {
        return idioma;
    }

    public static void setIdioma(String idioma) {
        Configuracion.idioma = idioma;
    }

    public static boolean isSonido() {
        return sonido;
    }

    public static void setSonido(boolean sonido) {
        Configuracion.sonido = sonido;
    }
    
    
}
