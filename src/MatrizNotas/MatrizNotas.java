package MatrizNotas;

import java.util.Random;

public class MatrizNotas {
    static void mostrarMatriz(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("_______________________");
        System.out.println("");
    }

    public static void main(String[] args) {
        double matrizNotas[][] = new double[6][4];

        Random rnd = new Random();
        for (int i = 0; i < matrizNotas.length; i++) {
            for (int j = 0; j < matrizNotas[i].length; j++) {
                matrizNotas[i][j] = rnd.nextInt(11);
            }
        }

        mostrarMatriz(matrizNotas);

        double matrizPonderaciones[] = {0.2,0.4,0.2,0.2};
        double notasFinales[][] = new double[6][1];

        for (int i = 0; i < notasFinales.length; i++) {
            for (int j = 0; j < notasFinales[i].length; j++) {
                for (int k = 0; k < matrizNotas[0].length; k++) {
                    notasFinales[i][j] += matrizNotas[i][k] * matrizPonderaciones[k];
                }
            }
        }
        mostrarMatriz(notasFinales);
    }
}

