package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Victor Rodriguez
 */
public class Cronometro extends Thread {
    //******************************************************************************
    //ATRIBUTOS DEL CRONOMETRO
    JLabel tiempo;
    int minutos;
    int segundos;

    //******************************************************************************
    //CONTRUCTOR
    public Cronometro(JLabel tiempo) {
        this.tiempo = tiempo;
        this.minutos = 0;
        this.segundos = 0;

    }
    //******************************************************************************
    //METODO RUN PARA QUE CORRA EL CRONOMETRO 
    @Override
    public void run() {
        while (this.minutos != 60) {
            this.segundos = 0;
            while (this.segundos < 60) {
                System.out.println(this.minutos + ":" + this.segundos);
                this.tiempo.setText(this.minutos + ":" + this.segundos);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.segundos++;
            }
            this.minutos++;
        }
    }

}
