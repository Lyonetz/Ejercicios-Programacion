package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*Listar el contenido de un directorio formateado, mostrando información de cada elemento. Mostrar también el tamaño total del
* directorio en Kb (la suma total de los directorios que forman el directorio) */

public class ListarFicheros {
    public static void listadorSubficheros(String ruta) {
        File subdirectorio = new File(ruta);

        if(subdirectorio.isDirectory()) {
            File[] subficheros = subdirectorio.listFiles();

            for(int i = 0; i < subficheros.length; i++) {
                if(subficheros[i].isFile()) {
                    System.out.println("\t--> Archivo '" + subficheros[i].getName() + "'");
                    System.out.println("\tTamaño: " + subficheros[i].length() + " Bytes");
                    System.out.println("\tOrigen: " + subdirectorio.getName());
                    System.out.println();
                } else {
                    System.out.println("\t--> Carpeta '" + subficheros[i].getName() + "'");
                    System.out.println("\tTamaño: " + subficheros[i].length() + " Bytes");
                    System.out.println("\tOrigen: " + subdirectorio.getName());
                    System.out.println();
                }
            }
        }
    }

    public static void listador(File file, String ruta) {
        File raiz = new File(ruta);

        File[] subficheros = raiz.listFiles();
        boolean existe = false;

        for(int i = 0; i < subficheros.length; i++) {
            if(subficheros[i].getName().equals(file.getName()))
                existe = true;
        }

        if(!existe) {
            for(int j = 0; j < subficheros.length; j++) {
                if(subficheros[j].isDirectory()) {
                    listador(subficheros[j],subficheros[j].getAbsolutePath());
                }
            }
        } else {
            File f = new File(ruta + "/" + file.getName());

            File[] subsubfichero = f.listFiles();

            for(int k = 0; k < subsubfichero.length; k++) {
                if(subsubfichero[k].isDirectory()) {
                    System.out.println("-->Carpeta '" + subsubfichero[k].getName() + "'");
                    System.out.println("Tamaño: " + subsubfichero[k].length() + " Bytes");
                    System.out.println();
                    listadorSubficheros(subsubfichero[k].getAbsolutePath());
                } else {
                    System.out.println("-->Archivo '" + subsubfichero[k].getName() + "'");
                    System.out.println("Tamaño: " + subsubfichero[k].length() + " Bytes");
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Introduzca la ruta donde se encuentra el fichero (finalizando con '/')");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rutaFichero = br.readLine();
        System.out.println("Introduzca nombre del fichero a partir del cual listar (incluida la extension)");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String nombreFichero = br2.readLine();

        File f = new File(rutaFichero + nombreFichero);
        listador(f, rutaFichero);
    }
}
