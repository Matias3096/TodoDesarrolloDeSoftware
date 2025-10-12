package chainofresponsibility;

import ChainofResponsibility.Solicitud;

public abstract class Handler {
    protected Handler siguiente;

    // Establece el siguiente en la cadena
    public void setSiguiente(Handler siguiente) {
        this.siguiente = siguiente;
    }

    // Método template que maneja la lógica de la cadena
    public void manejarSolicitud( Solicitud solicitud) {
        if (puedeResolver(solicitud)) {
            resolver(solicitud);
        } else if (siguiente != null) {
            System.out.println(this.getClass().getSimpleName() +
                    " no puede resolver, pasando al siguiente nivel...");
            siguiente.manejarSolicitud(solicitud);
        } else {
            System.out.println("Ningún handler puede resolver la solicitud de " +
                    solicitud.getEstudiante());
        }
    }

    // Métodos abstractos que implementarán las clases concretas
    protected abstract boolean puedeResolver(Solicitud solicitud);
    protected abstract void resolver(Solicitud solicitud);
}