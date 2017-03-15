package Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Potencia {

    public static int calcularPotencia(int a, int b) {
        if(b == 0)
            return 1;
        else
            return a * calcularPotencia(a, b - 1);
    }

    public static void main(String[] args) throws IOException{

        int a,b;
        System.out.println("Introduzca la base: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());

        System.out.println("Introduzca el exponente: ");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        b = Integer.parseInt(br2.readLine());

        int res = calcularPotencia(a, b);

        System.out.println(a + " elevado a " + b + " es " + res);

    }

}
    