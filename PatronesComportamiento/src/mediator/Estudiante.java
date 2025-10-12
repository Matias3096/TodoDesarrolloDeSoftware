package mediator;

public class Estudiante extends Usuario {

    public Estudiante(ChatMediator mediator, String nombre) {
        super(mediator, nombre, "Estudiante");
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println(nombre + "(Estudiante): envia: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }

    @Override
    public void recibir(String mensaje, Usuario remitente) {
        System.out.println(nombre + "recibe de " + remitente.toString() + ": " +mensaje);
    }
}
