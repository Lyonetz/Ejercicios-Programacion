package ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Strings {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        String checker = "ayylmao";
        boolean check = false;

        do {
            System.out.println("Introduzca un nuevo String ("  + checker + " para parar): ");
            String s = br.readLine();
            if(s.equalsIgnoreCase(checker))
                check = true;
            else
                arrayList.add(s);
        }while(!check);

        arrayList.sort(null);

        for(String e : arrayList)
            System.out.println("- " + e);
    }
}
