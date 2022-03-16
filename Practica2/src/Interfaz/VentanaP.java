package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Organizador.Reporte;
import static Organizador.Reporte.enlace;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Victor Rodriguez
 */
public class VentanaP extends JFrame implements ActionListener {
    
    //GLOBAL
    int[] datos;

    //******************************************************************************
    //VARIABLES PARA CREACIÓN DE VENTANA
    JButton examinar, generar;
    static JLabel ruta, ruta1, titulo, titulo1;
    JRadioButton ascendente, descendente;
    JPanel cuadro;
    File RUTA;

    String contenido = "";
    File json;
    FileReader lectura;
    BufferedReader buff;

    //******************************************************************************
    //COLORES
    Color moradito = new Color(187, 143, 206);
    Color grisito = new Color(153, 163, 164);
    Color blanco = new Color(251, 252, 252);

    public VentanaP() {
        //**************************************************************************
        //CREACIÓN PARA ESCOGER LAS OPCIONES DE ORDENAMIENTO
        ascendente = new JRadioButton("Ascendente", true);
        ascendente.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        ascendente.setBackground(grisito);
        ascendente.setForeground(Color.white);
        ascendente.setBounds(10, 80, 150, 25);
        this.add(ascendente);

        descendente = new JRadioButton("Descendente", false);
        descendente.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        descendente.setBackground(grisito);
        descendente.setForeground(Color.white);
        descendente.setBounds(10, 100, 150, 25);
        this.add(descendente);

        ButtonGroup bg = new ButtonGroup();
        bg.add(ascendente);
        bg.add(descendente);

        //**************************************************************************
        //CREACIÓN DE TITULOS
        //TITULO DE LINK
        ruta = new JLabel("LINK:");
        ruta.setBounds(210, 10, 100, 25);
        ruta.setForeground(Color.white);
        ruta.setFont(new Font("Verdana", Font.BOLD, 12));
        ruta.setVisible(true);
        this.add(ruta);

        ruta1 = new JLabel();
        ruta1.setBounds(320, 10, 1000, 25);
        ruta1.setForeground(Color.white);
        ruta1.setFont(new Font("Verdana", Font.BOLD, 12));
        ruta1.setVisible(true);
        this.add(ruta1);

        //TITUTLO DE TITULO DE LA GRAFICA
        titulo = new JLabel("TITULO GRÁFICA:");
        titulo.setBounds(210, 50, 300, 25);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Verdana", Font.BOLD, 12));
        titulo.setVisible(true);
        this.add(titulo);
        
        //TITUTLO DE TITULO DE LA GRAFICA
        titulo1 = new JLabel();
        titulo1.setBounds(340, 50, 1000, 25);
        titulo1.setForeground(Color.white);
        titulo1.setFont(new Font("Verdana", Font.BOLD, 12));
        titulo1.setVisible(true);
        this.add(titulo1);

        //**************************************************************************
        //CREACIÓN DE LOS BOTONES
        //BOTON EXAMINAR PARA EL PATH
        examinar = new JButton("EXAMINAR");
        examinar.setBounds(10, 10, 150, 25);
        examinar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        examinar.setBackground(grisito);
        examinar.setForeground(Color.white);
        examinar.setVisible(true);
        examinar.addActionListener(this);
        this.add(examinar);

        //BOTON GENERAR, PARA GENERAR LA GRÁFICA
        generar = new JButton("GENERAR");
        generar.setBounds(10, 50, 150, 25);
        generar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        generar.setBackground(grisito);
        generar.setForeground(Color.white);
        generar.setVisible(true);
        generar.addActionListener(this);
        this.add(generar);

        //**************************************************************************
        //CREACIÓN DE LA VENTANA
        this.setTitle("GRAFICADORA USAC 2022");
        this.setBounds(20, 20, 1340, 730);
        this.getContentPane().setBackground(moradito);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void leerarchivo(File ruta) {
        try {
            lectura = new FileReader(ruta); //Obtendremos el texto 
            buff = new BufferedReader(lectura); //leera el texto
            String casilla;
            //Lo siguiente se leera linea a linea
            while ((casilla = buff.readLine()) != null) {
                contenido += casilla;
            }
            JsonParser parser = new JsonParser();
            Object contenido1 = parser.parse(contenido);
            JsonObject objetito = (JsonObject) contenido1;
            String title = objetito.get("title").getAsString();
            System.out.println(title);
            titulo1.setText(title);
            Object jsonarrayobyeto = objetito.get("dataset");
            JsonArray arreglo = (JsonArray) jsonarrayobyeto;
            System.out.println("Cantidad Objetos: " + arreglo.size());
            datos = new int[arreglo.size()];
            for (int i = 0; i < arreglo.size(); i++) {
               // System.out.println(arreglo.get(i).getAsInt());
                datos[i] = arreglo.get(i).getAsInt();
                System.out.println("Numero: "+ datos[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != lectura) {
                    lectura.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == examinar) {
            RUTA = enlace();
            ruta1.setText(String.valueOf(RUTA));
        } else if (e.getSource() == generar) {
            leerarchivo(RUTA);
            
        }

    }
}
