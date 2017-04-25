package Flujo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EscribirPersonas {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = null;

        try {
            fw = new FileWriter("/home/carlos/Desktop/escritura.txt");

            System.out.println("Número de personas a añadir: ");
            int num = Integer.parseInt(br.readLine());

            for(int i = 0; i < num; i++) {
                System.out.println("Nombre Persona " + (i+1) + ": ");
                String s = br.readLine();
                fw.write(s + ";");
                System.out.println("Apellidos Persona " + (i+1) + ": ");
                s = br.readLine();
                fw.write(s + ";");
                System.out.println("Telefono Persona " + (i+1) + ": ");
                s = br.readLine();
                fw.write(s + ";");
                fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
