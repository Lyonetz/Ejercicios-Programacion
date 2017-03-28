package Búsqueda;

public class BusquedaBinaria {
    static int busquedaBinaria(int v[],int n) {
        int tam = v.length;

        int centro, inf = 0, sup = tam - 1;

        while(inf <= sup) {
            centro = (sup + inf) / 2;
            if(v[centro] == n)
                return centro;
            else if(n < v[centro])
                sup = centro - 1;
            else
                inf = centro + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int vect[] = {1,3,8,12,15,30};

        int res = busquedaBinaria(vect,10);

        System.out.println(res);
    }
}
