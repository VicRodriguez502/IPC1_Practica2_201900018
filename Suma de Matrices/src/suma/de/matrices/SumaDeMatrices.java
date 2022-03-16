package suma.de.matrices;

import java.util.Scanner;

/**
 *
 * @author Victor Rodriguez
 */
public class SumaDeMatrices {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int matriz[][];
        int matriz1[][];
        int matriz2[][];
        matriz = new int[4][4];
        matriz1 = new int[4][4];
        matriz2 = new int[4][4];
        int limite, i, j;

        System.out.println("Ingrese el tamaño de la Matriz a Sumar");
        limite = entrada.nextInt();

        System.out.println("Ingrese elemnetos de la Primera matriz ");
        for (i = 0; i < limite; i++) {
            for (j = 0; j < limite; j++) {
                System.out.print("Columna " + (i + 1) + " fila " + (j + 1) + "= ");
                matriz[i][j] = entrada.nextInt();

            }

        }
        System.out.println("Ingrese elemnetos de la Segunda matriz ");
        for (i = 0; i < limite; i++) {
            for (j = 0; j < limite; j++) {
                System.out.print("Coluna " + (i + 1) + " fila " + (j + 1) + "= ");
                matriz1[i][j] = entrada.nextInt();
            }

        }
        System.out.println("La suma de las dos matrices es ");
        for (i = 0; i < limite; i++) {
            for (j = 0; j < limite; j++) {
                matriz2[i][j] = matriz[i][j] + matriz1[i][j];
            }
        }    
                for (i = 0; i < limite; i++) {
                    for (j = 0; j < limite; j++) {
                        System.out.println("Columna " + (i + 1) + " Fila " + (j + 1) + "= " + matriz2[i][j]);

                    }
                }
    }
}
