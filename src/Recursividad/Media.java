package Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Media {

    public static float media(int n, int suma, int cont) throws IOException{
        System.out.println("Introduzca el siguiente valor: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n == 0) {
            return suma/cont;
        } else {
            return media(n, suma + n, cont+1);
        }

    }
    public static void main(String[] args) throws IOException {
        float res = media(0,0,0);
        System.out.println(res);
    }
}

