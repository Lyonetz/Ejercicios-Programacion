package ExamenAbril;

import java.util.Random;

public class Pregunta8 {
    public static int[] generarPrimitiva() {
        int[] primitiva = new int[6];
        Random r = new Random();
        int contador = 0;

        for(int i = 0; i < 6; i++) {
            primitiva[i] = r.nextInt(49) + 1;
            for(int j = 0; j < i-1; j++) {
                if(primitiva[i] == primitiva[j]) {
                    contador++;
                }
            }
        }
        if(contador > 1)
            generarPrimitiva();
        return primitiva;
    }

    public static void mostrarPrimitiva(int[] primitiva) {
        for(int i = 0; i < 6; i++) {
            System.out.println(primitiva[i]);
        }
    }

    public static void main(String[] args) {
        mostrarPrimitiva(generarPrimitiva());
    }
}
