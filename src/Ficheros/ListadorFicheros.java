package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListadorFicheros {
    static long tamTotal = 0;

    public static void listadorSubficheros(String ruta) {
        File subdirectorio = new File(ruta);

        if (subdirectorio.isDirectory()) {
            File[] subficheros = subdirectorio.listFiles();

            for (int i = 0; i < subficheros.length; i++) {
                if (subficheros[i].isFile()) {
                    System.out.println("--> Archivo '" + subficheros[i].getName() + "'");
                    System.out.println("Tamaño: " + subficheros[i].length() + " Bytes");
                    System.out.println("Carpeta de origen: " + subdirectorio.getName());
                    System.out.println();
                    tamTotal += subficheros[i].length();
                } else {
                    System.out.println("--> Carpeta '" + subficheros[i].getName() + "'");
                    System.out.println("Tamaño: " + subficheros[i].length() + " Bytes");
                    System.out.println("Carpeta de origen: " + subdirectorio.getName());
                    System.out.println();
                    tamTotal += subficheros[i].length();
                    listadorSubficheros(subficheros[i].getAbsolutePath());
                }
            }
        }
    }

    public static void listador(File file, String ruta) {
        File raiz = new File(ruta);

        File[] subficheros = raiz.listFiles();
        boolean existe = false;

        for (int i = 0; i < subficheros.length; i++) {
            if (subficheros[i].getName().equals(file.getName()))
                existe = true;
        }

        if (!existe) {
            for (int j = 0; j < subficheros.length; j++) {
                if (subficheros[j].isDirectory()) {
                    listador(subficheros[j], subficheros[j].getAbsolutePath());
                }
            }
        } else {
            File f = new File(ruta + "/" + file.getName());

            File[] subsubfichero = f.listFiles();

            for (int k = 0; k < subsubfichero.length; k++) {
                if (subsubfichero[k].isDirectory()) {
                    System.out.println("-->Carpeta '" + subsubfichero[k].getName() + "'");
                    System.out.println("Tamaño: " + subsubfichero[k].length() + " Bytes");
                    System.out.println("Carpeta de origen: " + file.getName());
                    System.out.println();
                    tamTotal += subsubfichero[k].length();
                    listadorSubficheros(subsubfichero[k].getAbsolutePath());
                } else {
                    System.out.println("-->Archivo '" + subsubfichero[k].getName() + "'");
                    System.out.println("Tamaño: " + subsubfichero[k].length() + " Bytes");
                    System.out.println("Carpeta de origen: " + file.getName());
                    System.out.println();
                    tamTotal += subsubfichero[k].length();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca la ruta donde se encuentra el fichero (finalizando con '/')");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rutaFichero = br.readLine();
        System.out.println("Introduzca nombre del fichero a partir del cual listar (incluida la extension)");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String nombreFichero = br2.readLine();

        File f = new File(rutaFichero + nombreFichero);
        System.out.println("FICHEROS CONTENIDOS EN LA CARPETA '" + f.getName() + " '");
        listador(f, rutaFichero);
        System.out.println("TAMAÑO TOTAL: " + tamTotal + " Bytes");
    }
}
