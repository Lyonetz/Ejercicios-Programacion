package AD.Tarea2;

import java.io.*;

public class Ejercicio3 {
    public static void cambiarMayusculas(String ruta, String rutaDestino) {
        String[] palabras;
        try{
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaDestino));
            String linea = br.readLine();

            while(linea != null) {
                palabras = linea.split(" ");

                for(int i = 0; i < palabras.length; i++) {
                    if(palabras[i].length() > 0){
                        if(Character.isUpperCase(palabras[i].charAt(0))) {
                            bw.append("MAYUSCULAS ");
                            System.out.println("MAYUSCULAS");
                        } else {
                            bw.append(palabras[i] + " ");
                            System.out.println(palabras[i]);
                        }
                    } else {
                        bw.newLine();
                        bw.newLine();
                    }
                }
                linea = br.readLine();
            }
            bw.close();
        }catch (FileNotFoundException e) {
            e.getMessage();
        }catch (IOException e) {
            e.getMessage();
        }

    }

    public static void main(String[] args) {
        String ruta = "/home/carlos/Desktop/textoEjemplo.txt";
        String rutaDestino = "/home/carlos/Desktop/textoEjemploModificado.txt";

        cambiarMayusculas(ruta,rutaDestino);
    }
}
