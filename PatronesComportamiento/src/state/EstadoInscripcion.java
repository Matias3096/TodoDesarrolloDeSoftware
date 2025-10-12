package state;

public interface EstadoInscripcion {
    void confirmar(Inscripcion inscripcion);
    void ponerEnEspera(Inscripcion inscripcion);
    void cancelar(Inscripcion inscripcion);
    void solicitarCertificado(Inscripcion inscripcion);
    String obtenerEstado();
}