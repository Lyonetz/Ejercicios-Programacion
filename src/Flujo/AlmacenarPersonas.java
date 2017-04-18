package Flujo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AlmacenarPersonas {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/carlos/Desktop/prueba.txt"));
            String linea = br.readLine();

            while(linea != null) {
                Persona p = new Persona();
                String[] res = linea.split(";");

                for (int i = 0; i < res.length; i++) {
                    switch (i) {
                        case 0:
                            p.setNombre(res[i]);
                            break;
                        case 1:
                            p.setApellidos(res[i]);
                            break;
                        case 2:
                            p.setTelefono(res[i]);
                            break;
                    }
                }

                personas.add(p);

                linea = br.readLine();
            }
            br.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        for(Persona per: personas) {
            System.out.println(per.getNombre());
        }
    }
}
