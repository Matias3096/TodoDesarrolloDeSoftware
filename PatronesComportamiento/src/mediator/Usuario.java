package mediator;

public abstract class Usuario {
    protected ChatMediator mediator;
    protected String nombre;
    protected String tipo; //Aca es donde diferenciamos si es estudiante o profesor

    public  Usuario(ChatMediator mediator,String nombre, String tipo) {
        this.mediator = mediator;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public  abstract void enviar(String mensaje);
    public abstract void recibir(String mensaje, Usuario remitente);

    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return  tipo;
    }

    @Override
    public String toString() {
        return tipo + ": " + nombre;
    }

}
