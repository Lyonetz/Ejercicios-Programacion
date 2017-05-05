package Flujo;

import java.io.File;

public class ObjetoFile {
    public static void main(String[] args) {
        File f1 = new File("/home/carlos/Desktop");

        if(f1.isDirectory()) {
            System.out.println("Ruta absoluta: " + f1.getAbsolutePath());
            System.out.println("Ruta relativa: " + f1.getPath());
            System.out.println("Nombre del directorio: " + f1.getName());
        }
    }
}
