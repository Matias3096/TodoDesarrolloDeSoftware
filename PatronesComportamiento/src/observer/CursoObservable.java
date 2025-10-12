package observer;

import java.util.ArrayList;
import java.util.List;

public class CursoObservable implements Subject {
    private String nombreCurso;
    private String codigo;
    private String horario;
    private List<Observer> observadores;
    private List<String> avisos;

    public CursoObservable(String codigo, String nombreCurso, String horario) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.horario = horario;
        this.observadores = new ArrayList<>();
        this.avisos = new ArrayList<>();
    }

    @Override
    public void agregarObservador(Observer observer) {
        if (!observadores.contains(observer)) {
            observadores.add(observer);
            System.out.println("✅ " + observer.getNombre() +
                    " se suscribió a notificaciones de " + nombreCurso);
        }
    }

    @Override
    public void removerObservador(Observer observer) {
        if (observadores.remove(observer)) {
            System.out.println("❌ " + observer.getNombre() +
                    " se desuscribió de notificaciones de " + nombreCurso);
        }
    }

    @Override
    public void notificarObservadores(String mensaje, String tipoCambio) {
        System.out.println("\n📢 NOTIFICANDO a " + observadores.size() +
                " estudiante(s) de " + nombreCurso);
        for (Observer observer : observadores) {
            observer.update(mensaje, tipoCambio);
        }
    }

    // Métodos de negocio que disparan notificaciones
    public void cambiarHorario(String nuevoHorario) {
        String horarioAnterior = this.horario;
        this.horario = nuevoHorario;

        String mensaje = "⏰ CAMBIO DE HORARIO en " + nombreCurso + "\n" +
                "   Anterior: " + horarioAnterior + "\n" +
                "   Nuevo: " + nuevoHorario;

        notificarObservadores(mensaje, "CAMBIO_HORARIO");
    }

    public void publicarAviso(String aviso) {
        avisos.add(aviso);

        String mensaje = "📌 NUEVO AVISO en " + nombreCurso + ":\n" +
                "   " + aviso;

        notificarObservadores(mensaje, "NUEVO_AVISO");
    }

    public void cancelarClase(String fecha, String motivo) {
        String mensaje = "🚫 CLASE CANCELADA - " + nombreCurso + "\n" +
                "   Fecha: " + fecha + "\n" +
                "   Motivo: " + motivo;

        notificarObservadores(mensaje, "CANCELACION");
    }

    public void publicarCalificaciones() {
        String mensaje = "📊 CALIFICACIONES PUBLICADAS - " + nombreCurso + "\n" +
                "   Revisa tu portal de estudiante";

        notificarObservadores(mensaje, "CALIFICACIONES");
    }

    // Getters
    public String getNombreCurso() { return nombreCurso; }
    public String getCodigo() { return codigo; }
    public String getHorario() { return horario; }
    public int getCantidadObservadores() { return observadores.size(); }
}
