package state;

public class Cancelado implements EstadoInscripcion {

    @Override
    public void confirmar(Inscripcion inscripcion) {
        System.out.println("🔄 Reactivando inscripción...");
        System.out.println("   Verificando disponibilidad de cupos...");
        inscripcion.cambiarEstado(new EnEspera());
    }

    @Override
    public void ponerEnEspera(Inscripcion inscripcion) {
        System.out.println("🔄 Moviendo de cancelado a lista de espera...");
        inscripcion.cambiarEstado(new EnEspera());
    }

    @Override
    public void cancelar(Inscripcion inscripcion) {
        System.out.println("⚠️ La inscripción ya está cancelada");
    }

    @Override
    public void solicitarCertificado(Inscripcion inscripcion) {
        System.out.println("❌ No puede solicitar certificado con inscripción cancelada");
        System.out.println("   Debe reactivar su inscripción primero");
    }

    @Override
    public String obtenerEstado() {
        return "CANCELADO";
    }
}