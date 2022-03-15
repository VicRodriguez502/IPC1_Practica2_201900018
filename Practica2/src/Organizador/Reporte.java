
package Organizador;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Victor Rodriguez
 */


public class Reporte {
    static File link;
    static  boolean iniciado;
    JLabel ruta;
    
    
    public static void enlace(){
        JFileChooser ch = new JFileChooser();
        ch.setCurrentDirectory(new java.io.File("."));
        ch.setDialogTitle("Cargando Archivo");
        FileNameExtensionFilter fl = new FileNameExtensionFilter(".json","json");
        ch.addChoosableFileFilter(fl);
        
        if(ch.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            System.out.println("Se abrio el archivo");
            link = ch.getSelectedFile();
            iniciado = true;
            
        } else  {
            System.out.println("No abrio nada");
            iniciado = false;
        }
        
    }
    public String getPath()
    {
        return link.toString();
    } 
}
