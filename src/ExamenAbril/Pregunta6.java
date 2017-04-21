package ExamenAbril;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

class Paquete {
    class Contenido {
        int valor;
        String descripcion;

        public Contenido(int valor, String descripcion) {
            this.valor = valor;
            this.descripcion = descripcion;
        }

        public int getValor() {
            return valor;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }

    class Origen {
        String remitente;
        String pais;
        String direccion;
        String codigoPostal;
        String comentarios;

        public Origen(String remitente, String pais, String direccion, String codigoPostal, String comentarios) {
            this.remitente = remitente;
            this.pais = pais;
            this.direccion = direccion;
            this.codigoPostal = codigoPostal;
            this.comentarios = comentarios;
        }

        public String getRemitente() {
            return remitente;
        }

        public void setRemitente(String remitente) {
            this.remitente = remitente;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getCodigoPostal() {
            return codigoPostal;
        }

        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
        }

        public String getComentarios() {
            return comentarios;
        }

        public void setComentarios(String comentarios) {
            this.comentarios = comentarios;
        }
    }

    class Destino {
        String receptor;
        String pais;
        String direccion;
        String codigoPostal;

        public Destino(String receptor, String pais, String direccion, String codigoPostal) {
            this.receptor = receptor;
            this.pais = pais;
            this.direccion = direccion;
            this.codigoPostal = codigoPostal;
        }

        public String getReceptor() {
            return receptor;
        }

        public void setReceptor(String receptor) {
            this.receptor = receptor;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getCodigoPostal() {
            return codigoPostal;
        }

        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
        }
    }

    public void enviarPaquete(int valor, String descripcion, String remitente, String paisO, String direccionO, String codigoPostalO, String comentarios, String receptor, String paisD, String direccionD, String codigoPostalD) {
        Contenido c = new Contenido(valor, descripcion);
        Origen o = new Origen(remitente, paisO, direccionO, codigoPostalO, comentarios);
        Destino d = new Destino(receptor, paisD, direccionD, codigoPostalD);

        System.out.println("--PAQUETE ENVIADO--");
        System.out.println("CONTENIDO");
        System.out.println("Valor: " + c.getValor());
        System.out.println("Descripcion: " + c.getDescripcion());
        System.out.println("___________________");
        System.out.println("ORIGEN");
        System.out.println("Remitente: " + o.getRemitente());
        System.out.println("País origen: " + o.getPais());
        System.out.println("Dirección origen: " + o.getDireccion());
        System.out.println("Código postal origen: " + o.getCodigoPostal());
        System.out.println("Comentarios: " + o.getComentarios());
        System.out.println("___________________");
        System.out.println("DESTINO");
        System.out.println("Receptor: " + d.getReceptor());
        System.out.println("País destino: " + d.getPais());
        System.out.println("Dirección destino: " + d.getDireccion());
        System.out.println("Código postal destino: " + d.getCodigoPostal());

    }
}

public class Pregunta6 {
    public static void main(String[] args) {
        Paquete p = new Paquete();

        p.enviarPaquete(50, "Portátiles DELL","Carlos Javier León","España","Chiclana","11130","Portátiles de nueva generación DELL","FORINSUR","España","Calle Forinsur 123","14780");
    }
}
