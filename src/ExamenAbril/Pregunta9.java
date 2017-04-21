package ExamenAbril;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pregunta9 {
    public static int[][][] leerMatriz() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduzca número de filas: ");
        int filas = Integer.parseInt(br.readLine());
        System.out.println("Introduzca número de columnas: ");
        int columnas = Integer.parseInt(br.readLine());
        System.out.println("Introduzca profundidad: ");
        int profundidad = Integer.parseInt(br.readLine());

        int[][][] matriz = new int[filas][columnas][profundidad];

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[0].length; j++) {
                for(int k = 0; k < matriz[0][0].length; k++) {
                    System.out.println("Introduzca el valor de la posición " + "[" + i + "]" + "[" + j + "]" + "[" + k + "]: ");
                    matriz[i][j][k] = Integer.parseInt(br.readLine());
                }
            }
        }
        return matriz;
    }

    public static void main(String[] args) throws  IOException{
        int[][][] v = leerMatriz();
    }
}
