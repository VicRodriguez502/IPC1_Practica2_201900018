package Organizador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Victor Rodriguez
 */
public class Reporte {

    //ATRIBUROS PARA LA CARGA DE ARCHIVOS JSON
    static String contenido = "";
    static File json;
    static FileReader lectura;
    static BufferedReader buff;

    public static File enlace() { //funcion
        JFileChooser fc = new JFileChooser();
        int op = fc.showOpenDialog(fc);
        if (op == JFileChooser.APPROVE_OPTION) {
            System.out.println(fc.getSelectedFile());
            return fc.getSelectedFile();

        } return null;
    } 
    
}

