package Ficheros;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class AplicarFiltros {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void aplicarFiltro(String p1, String s1, String p2, String s2) throws IOException {

        try {
            BufferedReader brFile = new BufferedReader(new FileReader("/home/carlos/Desktop/sincensurar.txt"));
            BufferedWriter bwFile = new BufferedWriter(new FileWriter("/home/carlos/Desktop/censurado.txt"));

            Map<String, String> ht = new HashMap();
            ht.put(p1, s1);
            ht.put(p2, s2);

            String linea;

            while ((linea = brFile.readLine()) != null) {
                String[] palabras = linea.split(" ");

                for (int i = 0; i < palabras.length; i++) {
                    if (ht.containsKey(palabras[i])) {
                        palabras[i] = ht.get(palabras[i]);
                    }
                    bwFile.write(palabras[i]);
                    System.out.println(palabras[i]);
                    bwFile.write(" ");
                }
                bwFile.newLine();
            }
            bwFile.close();
        }catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca la palabra 1: ");
        String palabra1 = br.readLine();
        System.out.println("Introduzca la palabra a sustituir palabra 1");
        String sustituto1 = br.readLine();

        System.out.println("Introduzca la palabra 2: ");
        String palabra2 = br.readLine();
        System.out.println("Introduzca la palabra a sustituir palabra 2");
        String sustituto2 = br.readLine();

        aplicarFiltro(palabra1,sustituto1,palabra2,sustituto2);

    }
}
