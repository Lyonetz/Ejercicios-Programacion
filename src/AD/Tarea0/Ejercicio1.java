package AD.Tarea0;

import java.io.*;

public class Ejercicio1 {

    public static void renameFiles(String ruta) {
        File[] ficheros = new File(ruta).listFiles();

        for (File f: ficheros) {
            if(f.isFile()) {
                String[] nombreFichero = f.getName().split("\\.");
                f.renameTo(new File(ruta + "/" + nombreFichero[0] + "_old." + nombreFichero[1]));
            } else {
                renameFiles(f.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        String ruta = "/home/carlos/Desktop/tupac"; //Sustituir el string vacío por la ruta.

        renameFiles(ruta);
    }
}
