package lab1p2_halmarordonez;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab1P2_HalmarOrdonez {

    static Scanner read = new Scanner(System.in);
    static Random rng = new Random();
    static ArrayList lista = new ArrayList();

    public static void main(String[] args) {
        int tamano = 0;
        while (tamano <= 4 || tamano % 2 == 0) {
            System.out.println("Ingrese el tamano de matriz deseado(Impar y mayor a 4): ");
            tamano = read.nextInt();
            System.out.println();
        }
        int matriz[][] = fillRandom(tamano, tamano);
        genMatriz(matriz);
        sort(matriz);
        System.out.println();
        System.out.println("Matriz Ordenada");
        genMatriz(sort(matriz));
        System.out.println();
        System.out.println("Arreglo de Medianas");
        int arreglo[] = calcMediana(matriz);
        genMatriz2(arreglo);
        System.out.println();
        System.out.println();
        System.out.println("Arreglo de medianas ordenado");
        genMatriz2(sortList(arreglo));
        System.out.println();
        System.out.println();
        System.out.print("Mediana de las medianas: ");
        System.out.println(calcMedianaLista(arreglo));

    }

    //GENERACION DE MATRIZ
    public static void genMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }

    }//FIN IMPRIMIR MATRIZ 
    
    //GENERACION DE MATRIZ2
    public static void genMatriz2(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {

            System.out.print("[" + matriz[i] + "]");
        }

    }//FIN IMPRIMIR MATRIZ2

    //LLENAR LA MATRIZ DE NUMEROS ALEATORIOS    
    public static int[][] fillRandom(int fila, int columna) {
        int[][] temp = new int[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temp[i][j] = rng.nextInt(10 - 0);
            }
        }
        return temp;
    }//FIN LLENAR MATRIZ RANDOM

    //ALGORITMO BUBBLESORT
    public static int[][] sort(int[][] matriz) {
        int[][] temp = matriz;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length - 1; j++) {
                if (temp[i][j] > temp[i][j + 1]) {
                    int ph = temp[i][j];
                    temp[i][j] = temp[i][j + 1];
                    temp[i][j + 1] = ph;
                    sort(temp);
                }
            }
        }
        return temp;
    }//FIN DE BUUBLESORT

    //CALCULACION DE MEDIANA
    public static int[] calcMediana(int[][] matriz) {
        int[] temp = new int[matriz.length];
        int mediana = 0;
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {
                mediana = mediana + matriz[i][j];
            }
            mediana = mediana / matriz.length;

            lista.add(mediana);
            temp[i] = mediana;
        }
        return temp;
    }//FIN DE LA CALCULACION DE MEDIANA

    public static int calcMedianaLista(int[] arreglo) {
        int mediana = 0;
        for (int i = 0; i < arreglo.length; i++) {
            mediana = mediana + arreglo[i];
        }
        mediana = mediana / arreglo.length;
        return mediana;
    }

    public static int[] sortList(int[] arreglo) {
        int[] temp = arreglo;
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (temp[i] > temp[i + 1]) {
                int ph = temp[i];
                temp[i] = temp[i + 1];
                temp[i + 1] = ph;
                sortList(temp);
            }
        }
        return temp;
    }
    
    //NO DESCUBRI COMO HACER LA MEDIANA ASI QUE HICE EL PROMEDIO 
}
