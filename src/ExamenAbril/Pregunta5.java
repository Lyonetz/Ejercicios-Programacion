package ExamenAbril;

class Persona {
    protected String nombre;

    public Persona(String n) {
        nombre = n;
    }

    public String getNombre() {
        return nombre;
    }
}

public class Pregunta5 {
    public static void IntercambiarPersonas(Persona p1, Persona p2) {
        Persona pAux;

        System.out.println("Nombres antes del intercambio");
        System.out.println("Persona 1: " + p1.getNombre());
        System.out.println("Persona 2: " + p2.getNombre());

        pAux = p1;
        p1 = p2;
        p2 = pAux;

        System.out.println("Nombres después del intercambio");
        System.out.println("Persona 1: " + p1.getNombre());
        System.out.println("Persona 2: " + p2.getNombre());
    }

    public static void main(String[] args) {
        Persona p1 = new Persona("Carlos");
        Persona p2 = new Persona("Javier");

        IntercambiarPersonas(p1,p2);
    }

}


