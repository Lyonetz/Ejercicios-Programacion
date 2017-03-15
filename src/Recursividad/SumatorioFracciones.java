package Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumatorioFracciones {
    public static double fracciones(Double n) {
        if(n == 0) {
            return 0;
        } else {
            return 1/n + fracciones(n-1);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca un numero a: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double a = Double.parseDouble(br.readLine());

        double res = fracciones(a);

        System.out.println(res);
    }
}
