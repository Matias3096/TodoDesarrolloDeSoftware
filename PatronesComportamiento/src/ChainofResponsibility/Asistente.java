package ChainofResponsibility;

public class Asistente  extends chainofresponsibility.Handler {
    @Override
    protected boolean puedeResolver (Solicitud solicitud){
        return solicitud.getNivelComplejidad() = 1;
    }
    @Override
    protected void resolver (Solicitud solicitud){
        System.out.println("\nAsistente puede resolver" + solicitud.getEstudiante() +
                ": " + solicitud.getDescripcion());
        System.out.println("\nAdjuntando material basico y enlaces utiles");

    }
}
