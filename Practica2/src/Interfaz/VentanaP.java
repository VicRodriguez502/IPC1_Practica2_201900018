package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Organizador.Reporte;
import static Organizador.Reporte.enlace;

/**
 *
 * @author Victor Rodriguez
 */
public class VentanaP extends JFrame implements ActionListener {

    //******************************************************************************
    //VARIABLES PARA CREACIÓN DE VENTANA
    JButton examinar, generar;
    static JLabel ruta, titulo;
    JRadioButton ascendente, descendente;
    JPanel cuadro;

    //******************************************************************************
    //COLORES
    Color moradito = new Color(187, 143, 206);
    Color grisito = new Color(153, 163, 164);

    public VentanaP() {
        //**************************************************************************
        //CREACIÓN PARA ESCOGER LAS OPCIONES DE ORDENAMIENTO
        ascendente = new JRadioButton("Ascendente",true);
        ascendente.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        ascendente.setBackground(grisito);
        ascendente.setForeground(Color.white);
        ascendente.setBounds(10, 80 , 150, 25);
        this.add(ascendente);
        
        descendente = new JRadioButton("Descendente",false);
        descendente.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        descendente.setBackground(grisito);
        descendente.setForeground(Color.white);
        descendente.setBounds(10, 100, 150, 25);
        this.add(descendente);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(ascendente);
        bg.add(descendente);
        

        //**************************************************************************
        //CREACIÓN CUADROS DE TEXTO
        //CUANDRO DE TEXTO PARA COLOCAR EL PATH
        ruta = new JLabel();
        ruta.setBounds(210, 10, 500, 25);
        ruta.setFont(new Font("Verdana", Font.BOLD, 12));
        ruta.setVisible(true);
        this.add(ruta);
        
        //CUADRO DE TEXTO PARA TITULO DE LA GRÁFICA
        titulo = new JLabel();
        titulo.setBounds(210, 50, 500, 25);
        titulo.setFont(new Font("Verdana", Font.BOLD, 12));
        titulo.setVisible(true);
        this.add(titulo);
        
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
        this.setBounds(20,20,1340,730);
        this.getContentPane().setBackground(moradito);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == examinar){
            enlace();
        }
       
    }
}
