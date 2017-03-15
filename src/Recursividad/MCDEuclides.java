package Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MCDEuclides {
    public static int euclides(int a, int b) {
        if(a < b){
            return 0;
        }else if(b <= 0) {
            return a;
        } else {
            return euclides(b, a%b);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca un numero a: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        System.out.println("Introduzca un numero b: ");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());

        int res = euclides(a,b);

        System.out.println(res);
    }
}
