package Recursividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.pow;

public class BinarioDecimal {
    public static double binario2decimal(String a, int n) {
        if(n >= a.length()) {
            return 0;
        }else if(Character.getNumericValue(a.charAt(n)) == 0){
            //System.out.println(a.charAt(n));
            return binario2decimal(a, n+1);
        }else{
            //System.out.println(a.charAt(n));
            return pow(2,a.length()-n-1) + binario2decimal(a, n+1);
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca un numero en binario: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int n = 0;

        double res = binario2decimal(a, 0);
        System.out.println(res);
    }
}
