package Búsqueda;

public class BusquedaSecuencial {
    static int busquedaSecuencial(int v[],int n) {
        int i = 0;

        while(v[i] != n && i < v.length - 1) {
            i++;
        }

        if(v[i] == n)
            return i;
        else
            return -1;
    }

    public static void main(String[] args) {
        int vect[] = {1,3,8,5,4,10};

        int res = busquedaSecuencial(vect,10);

        System.out.println(res);
    }
}
