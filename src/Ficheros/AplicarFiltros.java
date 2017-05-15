package Ficheros;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class AplicarFiltros {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void aplicarFiltro(String[] f, String[] s) throws IOException {

        try {
            BufferedReader brFile = new BufferedReader(new FileReader("C:\\Users\\Carlos\\Desktop\\prueba ficheros\\sincensurar.txt"));
            BufferedWriter bwFile = new BufferedWriter(new FileWriter("C:\\Users\\Carlos\\Desktop\\prueba ficheros\\censurado.txt"));

            Map<String, String> ht = new HashMap();
            for(int i = 0; i < f.length; i++) {
                ht.put(f[i], s[i]);
            }

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
        System.out.println("Introduzca número de palabras a sustituir: ");
        int num = Integer.parseInt(br.readLine());
        String[] filtros = new String[num];
        String[] sustitutos = new String[num];

        for(int i = 0; i < num; i++) {
            System.out.println("Introduzca palabra " + (i+1) + ": ");
            String f = br.readLine();
            filtros[i] = f;
            System.out.println("La palabra" + (i+1) + " se sustituirá por: ");
            String s = br.readLine();
            sustitutos[i] = s;
        }

        aplicarFiltro(filtros, sustitutos);

    }
}
