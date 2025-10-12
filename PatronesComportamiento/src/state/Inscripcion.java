package state;

import java.time.LocalDateTime;

public class Inscripcion {
    private String nombreEstudiante;
    private String nombreCurso;
    private EstadoInscripcion estado;
    private LocalDateTime fechaInscripcion;
    private int progreso; // 0-100

    public Inscripcion(String nombreEstudiante, String nombreCurso) {
        this.nombreEstudiante = nombreEstudiante;
        this.nombreCurso = nombreCurso;
        this.fechaInscripcion = LocalDateTime.now();
        this.progreso = 0;
        // Estado inicial
        this.estado = new EnEspera();
        System.out.println("📝 Nueva inscripción creada: " + nombreEstudiante +
                " → " + nombreCurso);
    }

    // Métodos que delegan al estado actual
    public void confirmar() {
        estado.confirmar(this);
    }

    public void ponerEnEspera() {
        estado.ponerEnEspera(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void solicitarCertificado() {
        estado.solicitarCertificado(this);
    }

    // Cambiar el estado interno
    public void cambiarEstado(EstadoInscripcion nuevoEstado) {
        String estadoAnterior = this.estado.obtenerEstado();
        this.estado = nuevoEstado;
        System.out.println("🔄 Estado cambiado: " + estadoAnterior + " → " +
                nuevoEstado.obtenerEstado());
    }

    // Métodos de negocio
    public void actualizarProgreso(int nuevoProgreso) {
        if (nuevoProgreso >= 0 && nuevoProgreso <= 100) {
            this.progreso = nuevoProgreso;
            System.out.println("📈 Progreso actualizado: " + progreso + "%");

            // Si completa el curso, puede solicitar certificado
            if (progreso == 100 && estado instanceof Inscripto) {
                System.out.println(" ¡Curso completado! Puedes solicitar tu certificado.");
            }
        }
    }

    public void mostrarInformacion() {
        System.out.println("\nINFORMACIÓN DE INSCRIPCIÓN");
        System.out.println("   Estudiante: " + nombreEstudiante);
        System.out.println("   Curso: " + nombreCurso);
        System.out.println("   Estado: " + estado.obtenerEstado());
        System.out.println("   Progreso: " + progreso + "%");
        System.out.println("   Fecha inscripción: " + fechaInscripcion);
        System.out.println();
    }

    // Getters y Setters
    public String getNombreEstudiante() { return nombreEstudiante; }
    public String getNombreCurso() { return nombreCurso; }
    public EstadoInscripcion getEstado() { return estado; }
    public int getProgreso() { return progreso; }
    public LocalDateTime getFechaInscripcion() { return fechaInscripcion; }
}