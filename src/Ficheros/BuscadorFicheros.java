package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuscadorFicheros {
    public static void buscador(File file, String ruta) {
        File directorio = new File(ruta);

        File[] ficheros = directorio.listFiles();
        boolean existe = false;

        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].getName().equals(file.getName()))
                existe = true;
        }

        if (!existe) {
            for (int j = 0; j < ficheros.length; j++) {
                if (ficheros[j].isDirectory()) {
                    System.out.println("Buscando en la carpeta '" + ficheros[j].getName() + "'...");
                    buscador(file, ficheros[j].getAbsolutePath());
                }
            }

        } else {
            File f = new File(ruta + "/" + file.getName());

            System.out.println("¡Archivo encontrado!");
            System.out.println("INFORMACIÓN DEL FICHERO");
            System.out.println(f.getAbsolutePath());
            System.out.println(f.length() + " Bytes");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca la ruta donde desea iniciar la búsqueda (finalizando con '/')");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rutaFichero = br.readLine();
        System.out.println("Introduzca nombre del fichero a buscar (incluida la extensión)");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String nombreFichero = br2.readLine();

        File f = new File(rutaFichero + nombreFichero);
        buscador(f, rutaFichero);
    }
}
