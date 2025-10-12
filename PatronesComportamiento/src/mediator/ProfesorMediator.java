package mediator;

public class ProfesorMediator extends Usuario{
    public ProfesorMediator(ChatMediator mediator, String nombre) {
        super(mediator, nombre, "Profesor");
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println(nombre + " (Profesor) envia: " + mensaje);
        mediator.enviarMensaje(mensaje, this);
    }

    @Override
    public void recibir(String mensaje, Usuario remitente) {
        System.out.println(nombre + "recibe de " + remitente.toString() + ": " +mensaje);
    }
}
