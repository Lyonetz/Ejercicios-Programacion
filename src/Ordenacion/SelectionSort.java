package Ordenacion;

public class SelectionSort {
    public static int[] selectionSort(int A[]) {
        int menor,pos,tmp;

        for (int i = 0; i < A.length - 1; i++) {
            menor = A[i];
            pos = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < menor) {
                    menor = A[j];
                    pos = j;
                }
            }
            if (pos != i) {
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
            }
        }
        return A;
    }
    public static void main(String[] args) {
        int vect[] = {1,3,8,5,4,10};

        vect = selectionSort(vect);

        for (int a : vect) {
            System.out.println(a);
        }
    }
}
