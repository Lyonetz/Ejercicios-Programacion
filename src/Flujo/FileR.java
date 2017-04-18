package Flujo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileR {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/carlos/Desktop/prueba.txt"));
            String linea = br.readLine();

            while(linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
