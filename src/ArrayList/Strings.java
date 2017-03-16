package ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Strings {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        String s;
        boolean check = false;

        do {
            System.out.println("Introduzca un nuevo String (asdf para parar): ");
            s = br.readLine();
            if(s.equalsIgnoreCase("asdf")) {
                check = true;
            } else {
                arrayList.add(s);
            }
        }while(!check);

        for(String e : arrayList){
            System.out.println("- " + e);
        }
    }
}
