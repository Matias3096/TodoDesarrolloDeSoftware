package mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private List<Usuario> usuarios;

    public ChatRoom() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("🌟 " + usuario.toString() + " se unió al chat");
        notificarNuevoUsuario(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("👋 " + usuario.toString() + " salió del chat");
    }

    @Override
    public void enviarMensaje(String mensaje, Usuario remitente) {
        for (Usuario usuario : usuarios) {
            // No enviamos el mensaje de vuelta al remitente
            if (usuario != remitente) {
                usuario.recibir(mensaje, remitente);
            }
        }
    }

    @Override
    public void mostrarUsuariosConectados() {
        System.out.println("\n👥 USUARIOS CONECTADOS:");
        if (usuarios.isEmpty()) {
            System.out.println("   (nadie conectado)");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println("   - " + usuario.toString());
            }
        }
        System.out.println();
    }

    private void notificarNuevoUsuario(Usuario nuevoUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario != nuevoUsuario) {
                usuario.recibir("¡" + nuevoUsuario.toString() + " se unió al chat!", null);
            }
        }
    }
}