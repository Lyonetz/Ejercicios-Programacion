package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EliminadorFicheros {

    public static void eliminadorSubcarpetas(String ruta) {
        File subdirectorio = new File(ruta);

        if(subdirectorio.isDirectory()) {
            File[] subficheros = subdirectorio.listFiles();

            for (int i = 0; i < subficheros.length; i++) {
                if (subdirectorio.isFile()) {
                    File temp = new File(ruta + " " + subficheros[i].getName());
                    temp.delete();
                } else {
                    eliminadorSubcarpetas(subficheros[i].getAbsolutePath());
                }
            }
        }
        subdirectorio.delete();
    }

    public static void eliminador(File file, String ruta) throws IOException {
        File directorio = new File(ruta);

        File[] ficheros = directorio.listFiles();
        boolean existe = false;

        for(int i = 0; i < ficheros.length; i++) {
            if(ficheros[i].getName().equals(file.getName()))
                existe = true;
        }

        if(!existe) {
            for(int j = 0; j < ficheros.length; j++){
                if(ficheros[j].isDirectory())
                    eliminador(file, ficheros[j].getAbsolutePath());
            }
        } else {
            File f = new File(ruta + "/" + file.getName());

            File[] subficheros = f.listFiles();

            for(int i = 0; i < subficheros.length; i++){

                if(subficheros[i].isDirectory()) {
                    eliminadorSubcarpetas(subficheros[i].getAbsolutePath());
                } else {
                    subficheros[i].delete();
                }
            }
            f.delete();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca nombre del archivo a borrar (incluida la extension)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nombre = br.readLine();

        File f = new File("/home/carlos/Documents/Prueba Ficheros Java/" + nombre);
        eliminador(f, "/home/carlos/Documents/Prueba Ficheros Java/");
    }
}
