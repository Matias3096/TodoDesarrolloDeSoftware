package observer;

import java.util.ArrayList;
import java.util.List;

public class AlumnoObserver implements Observer {
    private String nombre;
    private String email;
    private List<String> notificaciones;
    private boolean notificacionesPorEmail;

    public AlumnoObserver(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.notificaciones = new ArrayList<>();
        this.notificacionesPorEmail = true;
    }

    @Override
    public void update(String mensaje, String tipoCambio) {
        notificaciones.add(mensaje);

        // Mostrar la notificación según preferencias
        System.out.println("\n📱 NOTIFICACIÓN para " + nombre + ":");
        System.out.println(mensaje);

        if (notificacionesPorEmail) {
            enviarEmail(mensaje, tipoCambio);
        }
    }

    private void enviarEmail(String mensaje, String tipoCambio) {
        // Simulación de envío de email
        System.out.println("   📧 Email enviado a: " + email);
        System.out.println("   Asunto: [" + tipoCambio + "] Actualización de curso");
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNotificacionesPorEmail(boolean activar) {
        this.notificacionesPorEmail = activar;
        System.out.println("🔔 Notificaciones por email " +
                (activar ? "activadas" : "desactivadas") + " para " + nombre);
    }

    public void verHistorialNotificaciones() {
        System.out.println("\n📜 HISTORIAL DE NOTIFICACIONES - " + nombre + ":");
        if (notificaciones.isEmpty()) {
            System.out.println("   (no hay notificaciones)");
        } else {
            for (int i = 0; i < notificaciones.size(); i++) {
                System.out.println("\n   " + (i + 1) + ". " + notificaciones.get(i));
            }
        }
        System.out.println();
    }

    public int getCantidadNotificaciones() {
        return notificaciones.size();
    }
}