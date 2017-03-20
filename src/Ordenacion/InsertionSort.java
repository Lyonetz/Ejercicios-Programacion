package Ordenacion;

public class InsertionSort {
    public static int[] insertionSort(int A[]) {
        int aux,j;

        for (int i = 1; i < A.length; i++) {
            aux = A[i];
            j = i - 1;

            while(j >= 0 && A[j] > aux) {
                A[j+1] = A[j];
                j = j - 1;
            }
            A[j+1] = aux;
        }
        return A;
    }

    public static void main(String[] args) {
        int vect[] = {2,9,7,1};

        vect = insertionSort(vect);

        for (int i = 0; i < vect.length; i++) {
            System.out.println(vect[i]);
        }
    }
}
