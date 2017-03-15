package Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cifras {
    public static int cifras(int n, int cont){
        if(n <= 0){
            return cont;
        } else {
            return cifras(n/10,cont + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        do {
            System.out.println("Introduzca un número (mayor que 0): ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
        }while(n <= 0);

        int res = cifras(n,0);

        System.out.println("El número tiene " + res + " cifras.");

    }
}
