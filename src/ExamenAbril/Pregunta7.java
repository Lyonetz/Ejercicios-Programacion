package ExamenAbril;

public class Pregunta7 {
    public static void main(String[] args) {
        String cad1 = "Virgen del Camino Seco";
        String cad2 = "Virgen del Camino Seco";

        if(cad1.equals(cad2)) {
            System.out.println("Operador ==: Las cadenas " + cad1 + " y " + cad2 + " son iguales");
        } else {
            System.out.println("Operador ==: Las cadenas " + cad1 + " y " + cad2 + " son distintas");
        }

        /*Podríamos usar el método 'equals()' o el método 'equalsIgnoreCase()'. El primero te compararía
        las dos cadenas, incluso comparando mayúsculas y minúsculas. El segundo método te las compararía
        ignorando si son mayúsculas o minúsculas.*/
    }
}
