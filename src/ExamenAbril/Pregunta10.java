package ExamenAbril;

import java.util.Random;

public class Pregunta10 {
    public static int[] generarVector() {
        int[] vector = new int[1000000];
        Random r = new Random();

        for(int i = 0; i < vector.length; i++) {
            vector[i] = r.nextInt(100) + 1;
        }
        return vector;
    }

    public static Double OrdenarVector(int vector[]) {
        int menor,pos,tmp;

        double tiempoInicio = System.currentTimeMillis();
        for (int i = 0; i < vector.length - 1; i++) {
            menor = vector[i];
            pos = i;
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[j] < menor) {
                    menor = vector[j];
                    pos = j;
                }
            }
            if (pos != i) {
                tmp = vector[i];
                vector[i] = vector[pos];
                vector[pos] = tmp;
            }
        }
        double tiempoFin = System.currentTimeMillis();

        return tiempoFin - tiempoInicio;
    }

    public static void main(String[] args) {
        System.out.println("Tarda " + OrdenarVector(generarVector()) + "milisec en ordenar el vector");
    }
}
