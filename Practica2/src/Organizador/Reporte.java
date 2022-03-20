package Organizador;

import static Interfaz.VentanaP.pasitos;
import static Interfaz.VentanaP.tiempo1;
import static Interfaz.VentanaP.datos;
import static Interfaz.VentanaP.contenido;
import static Interfaz.VentanaP.desordenados;
import static Interfaz.VentanaP.ordenados;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;

/**
 *
 * @author Victor Rodriguez
 */
public class Reporte {

    //******************************************************************************
    //CREANDO REPORTE HTML PARA EL SISTEMA 
    public static void reportehtml() {
        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
            String nombrereporte = (dtf.format(LocalDateTime.now()));
            reporte = new File(nombrereporte + ".HTML");
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);

            cadenaHTML = "<html>"
                    + "    <head>"
                    + "<h1>Victor Eduardo José Rodriguez Alonzo</h1><h2>201900018</h2></div>"
                    + "<h1> Ordenamiento Quicksort</h1></div>"
                    + "<p><b>Tiempo:</b>" + tiempo1.getText() + "</p>"
                    + "<p><b>Pasos:</b> " + pasitos.getText() + "</p>"
                    + "<p><b>Datos desordenados:</b> </p>"
                    + "    <body>";
            for (int i = 0; i < desordenados().length; i++) {
                cadenaHTML += "            <b>"
                        + "  <b>" + String.valueOf(desordenados()[i]) + "</b>" //llamamos lo que contiene la tabla
                        + "            </b>";
            }
            cadenaHTML += " <p><b>Datos Ordenados:</b> </p>";
            for (int i = 0; i < ordenados().length; i++) {
                cadenaHTML += "            <b>"
                        + "  <b>" + String.valueOf(ordenados()[i]) + "</b>" //llamamos lo que contiene la tabla
                        + "            </b>";
            }
            cadenaHTML += " <p><b>Grafica Generada:</b> </p>"
                    +"<img src=\"C:\\Users\\Victor Rodriguez\\OneDrive\\Documentos\\IPC1_Practica2_201900018\\Practica2\\imagen.jpeg\"/>";

            cadenaHTML += "</head"
                    + "    </body>"
                    + "</html>";

            br.write(cadenaHTML);

            br.close();
            fw.close();
            
            pdfgraf(cadenaHTML);

        } catch (IOException ex) {
            System.out.println("error escribiendo el reporte. Detalles " + ex.getMessage());
        }
    }
    //**************************************************************************
    //METODO PARA CREAR PDF DE USUARIOS
    public static void pdfgraf(String html){
        try{ //E métodos para generar 3 reportes de arriba y abajo
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
            String nombre = (dtf.format(LocalDateTime.now()));
            
                Document document = new Document(PageSize.LETTER);
                PdfWriter.getInstance(document, new FileOutputStream(nombre+".pdf"));

                document.open();
                document.addAuthor("Victor Rodriguez");
                document.addCreator("Victor Rodriguez");
                document.addSubject("reporteUsuarios");
                document.addCreationDate();
                document.addTitle("ReporteUsuario");

                HTMLWorker htmlWorker = new HTMLWorker(document);
                htmlWorker.parse(new StringReader(html));
                Image imagen = Image.getInstance("C:\\Users\\Victor Rodriguez\\OneDrive\\Documentos\\IPC1_Practica2_201900018\\Practica2\\imagen.jpeg");
                imagen.scaleToFit(500, 300);
                document.add(imagen);
                
                document.close();
            
        }catch(Exception e){
        }
    }
  

    //******************************************************************************
    //METODO PARA LEER LA RUTA DEL ENLACE EN EL JLABEL
    public static File enlace() { //funcion
        JFileChooser fc = new JFileChooser();
        int op = fc.showOpenDialog(fc);
        if (op == JFileChooser.APPROVE_OPTION) {
            System.out.println(fc.getSelectedFile());
            return fc.getSelectedFile();

        }
        return null;
    }

}
