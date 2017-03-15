package Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static int calcularFactorial(int a){
        if(a == 1) {
            return a;
        } else {
            return a * calcularFactorial(a - 1);
        }
    }
    public static void main(String[] args) throws IOException {

        System.out.println("Introduzca un numero: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int res = calcularFactorial(a);
        System.out.println("El factorial de " + a + " es: " + res);
    }
}
