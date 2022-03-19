package Hilos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Victor Rodriguez
 */
public class Cronometro extends Thread {

    JLabel tiempo;
    int minutos;
    int segundos;

    public Cronometro(JLabel tiempo) {
        this.tiempo = tiempo;
        this.minutos = 0;
        this.segundos = 0;

    }
    static boolean b = true;


    @Override
    public void run() {
        if (b) {
            while (this.minutos != 60) {
                this.segundos = 0;
                while (this.segundos < 60) {
                    System.out.println(this.minutos + ":" + this.segundos);
                    this.tiempo.setText(this.minutos + ":" + this.segundos);
                    try {
                        sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.segundos++;
                }
                this.minutos++;
            }
        }

    }
    public static void parar() {
        b = false;
    }

}
