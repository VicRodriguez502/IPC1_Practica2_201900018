package Hilos;

import Interfaz.VentanaP;
import static Interfaz.VentanaP.crearImagen;
import static Interfaz.VentanaP.tiempo1;
import static Organizador.Reporte.reportehtml;
import static practica2.GraphUsac.acabar;
import static practica2.GraphUsac.iniciar;
import static practica2.GraphUsac.iniciar1;

/**
 *
 * @author Victor Rodriguez
 */
public class QuiksortD extends Thread {
    //*****************************************************************************
    //ATRIBUTOS PARA ORDENAMIENTO
    Cronometro c = new Cronometro(tiempo1);
    private  VentanaP clase;
    private int[] datos;
    private  int contador;
    private  int pasos = 0;

    //******************************************************************************
    //CONSTRUCTOR DE ORDENAMIENTO
    public QuiksortD(VentanaP clase, int[] datos, int contador) {
        this.clase = clase;
        this.datos = datos;
        this.contador = contador;
    }

    //******************************************************************************
    //MÉTODO RUN PARA QUE CORRA EL ORDENAMIENTO
    @Override
    public void run() {
        
        c.start();
        quicksort(datos, 0, datos.length - 1);
        iniciar = false;
        acabar = true;
        clase.cuadro.removeAll();
        clase.cuadro.repaint();
        clase.grafica();
        c.stop();
        crearImagen(VentanaP.barChart);
        reportehtml();
    }

    //******************************************************************************
    //METODO DE ORDENAMIENTO QUICKSORT DESCENDENTE 
    public  void quicksort(int[] datos1, int primero, int ultimo) { //algoritmo de ordenamiento quickSort como funcion recursiva
        int i, j;
        double pivote;
        int aux;
        i = primero;
        j = ultimo;
        pivote = datos1[(primero + ultimo) / 2]; //obtengo mi pivote

        do {
            while (datos1[i] > pivote) { //este ciclo me sirve para incrementar mi contador
                i++;
            }
            while (datos1[j] < pivote) { //este ciclo me sirve para decrementar mi contador
                j--;
            }
            if (i <= j) { //aca es donde hago el intercambio de valores que se ajustan a mi condicion y ajusto mis contadores
                aux = datos1[i];
                datos1[i] = datos1[j];
                datos1[j] = aux;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
                clase.cuadro.removeAll();
                clase.cuadro.repaint();
                clase.grafica();
                pasos++;
                clase.pasitos.setText(String.valueOf(pasos));

                i++;
                j--;
            }
        } while (i <= j && iniciar1);
        //como mi funcion es recursiva tengo que estar mandando los valores obtenidos segun mi condicion y asi encontrar los pivotes
        if (iniciar) {
            if (primero < j) {
                quicksort(datos1, primero, j);
            }
            if (i < ultimo) {
                quicksort(datos1, i, ultimo);
            }
        }
    }
}
