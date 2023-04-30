package Ajustes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author terciodemarte
 */
public class Configuracion {
    private static byte tamano=2;
    private static String idioma="Español";
    private static boolean sonido=false;
    private static Clip clip;
    private static AudioInputStream audioInputStream;

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
    
    /**
     * Metodo para hacer sonar un archivo .wav
     * @param nombre Nombre del archivo
     */
    public static void sonar(String nombre){
        try {
                audioInputStream = AudioSystem.getAudioInputStream(new File("src/Audios/"+nombre+".wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
              
            }catch(FileNotFoundException ex){
                 Logger.getLogger(Ajustes.class.getName()).log(Level.SEVERE, null, ex);
            }catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Ajustes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ajustes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Ajustes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /**
     * Metodo para parar el audio que este sonando
     */
    public static void parar(){
        if (clip!=null) {
            clip.stop();
        }
    }
    
}
