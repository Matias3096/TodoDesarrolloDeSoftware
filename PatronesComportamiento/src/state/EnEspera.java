package state;

public class EnEspera implements EstadoInscripcion {

    @Override
    public void confirmar(Inscripcion inscripcion) {
        System.out.println("✅ Confirmando inscripción...");
        System.out.println("   Se ha liberado un cupo en el curso");
        inscripcion.cambiarEstado(new Inscrito());
    }

    @Override
    public void ponerEnEspera(Inscripcion inscripcion) {
        System.out.println("⚠️ Ya está en lista de espera");
    }

    @Override
    public void cancelar(Inscripcion inscripcion) {
        System.out.println("❌ Saliendo de lista de espera...");
        inscripcion.cambiarEstado(new Cancelado());
    }

    @Override
    public void solicitarCertificado(Inscripcion inscripcion) {
        System.out.println("⚠️ No puede solicitar certificado estando en lista de espera");
        System.out.println("   Espere a que se confirme su inscripción");
    }

    @Override
    public String obtenerEstado() {
        return "EN_ESPERA";
    }
}