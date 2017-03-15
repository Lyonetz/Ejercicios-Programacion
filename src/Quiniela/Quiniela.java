package Quiniela;

import java.util.Random;

public class Quiniela {
    public static void main(String[] args) {
        Random rnd = new Random();
        int n;

        for (int i = 0; i < 15; i++) {
            if(i < 14) {
                System.out.print("Partido " + (i+1) + ": ");
                n = rnd.nextInt(3);
                if(n == 2)
                    System.out.println("X");
                else
                    System.out.println(n+1);
            } else {
                System.out.print("Pleno al 15: ");

                n = rnd.nextInt(4);
                if(n == 3)
                    System.out.print("M - ");
                else
                    System.out.print(n + " - ");

                n = rnd.nextInt(4);
                if(n == 3)
                    System.out.println("M");
                else
                    System.out.println(n);
            }
        }
    }
}

