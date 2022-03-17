package Hilos;

import java.awt.*;
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
    
    public Cronometro(){
        this.tiempo = tiempo;
        this.minutos = 0;
        this.segundos = 0;
        
        
    }
   @Override 
   public void run(){
       while (this.minutos != 60){
           this.segundos = 0;
           while(this.segundos < 60){
               System.out.println(this.minutos + ":" +this.segundos);
               try {
                   sleep(1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
               }
               this.segundos++;
           } 
           this.minutos++;
       }
   }
}
