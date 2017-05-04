package Ordenacion;

public class BubbleSort {
    public static int[] bubbleSort(int A[]) {
        int aux;

        for (int i = A.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if(A[j] > A[j + 1]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int vect[] = {2,9,7,1};

        vect = bubbleSort(vect);

        for (int i = 0; i < vect.length; i++) {
            System.out.println(vect[i]);
        }
    }

}
