package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static Organizador.Reporte.enlace;
import com.google.gson.*;
import java.io.*;
import javax.swing.event.AncestorListener;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Victor Rodriguez
 */
public class VentanaP extends JFrame implements ActionListener {

    //******************************************************************************
    //VARIABLES GLOBLAES PARA LOS DATOS LEIDOS DEL JSON
    int[] datos;
    int contador = 0;

    //******************************************************************************
    //VARIABLES PARA CREACIÓN DE VENTANA
    JButton examinar, generar, cargar;
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
        ascendente.setBounds(10, 130, 150, 25);
        this.add(ascendente);

        descendente = new JRadioButton("Descendente", false);
        descendente.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        descendente.setBackground(grisito);
        descendente.setForeground(Color.white);
        descendente.setBounds(10, 150, 150, 25);
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

        //TITULO DE TITULO DE LA GRAFICA
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
        generar.setBounds(10, 90, 150, 25);
        generar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        generar.setBackground(grisito);
        generar.setForeground(Color.white);
        generar.setVisible(true);
        generar.addActionListener(this);
        this.add(generar);
        
         //BOTON CARGAR, FUNCIONALIDAD PARA CARGAR DATOS Y GENERAR TABLA CON DATOS DESORDENADOS
        cargar = new JButton("CARGAR");
        cargar.setBounds(10, 50, 150, 25);
        cargar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        cargar.setBackground(grisito);
        cargar.setForeground(Color.white);
        cargar.setVisible(true);
        cargar.addActionListener(this);
        this.add(cargar);

        //*************************************************************************
        //CREACIÓN DEL PANEL PARA LA GRÁFICA 
        cuadro = new JPanel();
        cuadro.setBounds(10, 180, 1300, 500);
        cuadro.setBackground(blanco);
        cuadro.setVisible(true);
        this.add(cuadro);
        
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
                System.out.println("Numero: " + datos[i]);
            }
            grafica();
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

    boolean a = true;

    public void grafica() {
        String color = "";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < datos.length; i++) {
            dataset.addValue(datos[i], String.valueOf(datos[i]), color);
        }

        JFreeChart barChart = ChartFactory.createBarChart3D("", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(barChart);
        panel.setBounds(10, 50, 600, 400);
        cuadro.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == examinar) {
            RUTA = enlace();
            ruta1.setText(String.valueOf(RUTA));
        } else if (e.getSource() == cargar) {
            leerarchivo(RUTA);

        }

    }

}
