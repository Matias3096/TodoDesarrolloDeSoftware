package mediator;

public interface ChatMediator {
    void enviarMensaje(String mensaje, Usuario usuario);
    void agregarUsuario(Usuario usuario);
    void removerUsuario(Usuario usuario);
    void mostrarUsuariosConectados();
}
