package state;

public class Inscripto implements EstadoInscripcion {

    @Override
    public void confirmar(Inscripcion inscripcion) {
        System.out.println("⚠️ Ya está inscrito en el curso");
    }

    @Override
    public void ponerEnEspera(Inscripcion inscripcion) {
        System.out.println("⏸️ Poniendo inscripción en espera...");
        inscripcion.cambiarEstado(new EnEspera());
    }

    @Override
    public void cancelar(Inscripcion inscripcion) {
        System.out.println("❌ Cancelando inscripción...");
        inscripcion.cambiarEstado(new Cancelado());
    }

    @Override
    public void solicitarCertificado(Inscripcion inscripcion) {
        if (inscripcion.getProgreso() >= 100) {
            System.out.println("🏆 ¡Certificado generado exitosamente!");
            System.out.println("   Estudiante: " + inscripcion.getNombreEstudiante());
            System.out.println("   Curso: " + inscripcion.getNombreCurso());
            System.out.println("   El certificado ha sido enviado a su email");
        } else {
            System.out.println("⚠️ Debe completar el 100% del curso para obtener el certificado");
            System.out.println("   Progreso actual: " + inscripcion.getProgreso() + "%");
        }
    }

    @Override
    public String obtenerEstado() {
        return "INSCRITO";
    }
}