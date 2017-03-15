package Recursividad;

import java.io.*;

public class CuentaAtras {
    public static int cuentaAtras(int n){
        if(n == 0){
            System.out.println(n);
            return n;
        } else {
            System.out.println(n);
            return cuentaAtras(n - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        int a;

        do{
            System.out.println("Introduzca un numero: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            a = Integer.parseInt(br.readLine());
        }while(a < 0);


        cuentaAtras(a);

    }
}

