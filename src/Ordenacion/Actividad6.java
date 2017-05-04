package Ordenacion;

import java.util.Random;

public class Actividad6 {
    public static void mostrarMatriz(int v[]) {
        for(int i = 0; i < v.length; i++)
            System.out.println(v[i]);
    }

    public static int[] vectorPromedio(int tam) {
        int v[] = new int[tam];
        Random r = new Random();

        for(int i = 0; i < tam; i++)
            v[i] = r.nextInt(100);
        return v;
    }

    public static int[] vectorOrdenado(int tam) {
        int v[] = new int[tam];

        for(int i = 0; i < tam; i++)
            v[i] = i;
        return v;
    }

    public static int[] vectorDesordenado(int tam) {
        int v[] = new int[tam];

        for(int i = tam; i > 0; i--) {
            for (int j = 0; j < tam; j++)
                v[j] = i;
        }
        return v;
    }

    public static void main(String[] args) {
        int v[] = vectorDesordenado(500000);

        double ini = System.currentTimeMillis();
        QuickSort.quickSort(v,0,499999);
        double fin = System.currentTimeMillis();

        System.out.println(fin - ini);
    }
}
