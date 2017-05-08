package Ficheros;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EliminadorFicheros {
    public static void eliminador(File file, String ruta) throws IOException {
        File directorio = new File(ruta);

        File[] ficheros = directorio.listFiles();
        boolean existe = false;

        for(int i = 0; i< ficheros.length; i++) {
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

            if(f.isDirectory()) {
                for(int k = 0; k < ficheros.length; k++){
                    eliminador(ficheros[k],ficheros[k].getAbsolutePath());
                }

            } else {
                f.delete();
            }
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
