package ChainofResponsibility;

import java.util.logging.Handler;

public class Coordinador extends Handler {
    @Override
    protected boolean puedeResolver (Solicitud solicitud){
        return solicitud.getNivelComplejidad() >=3;
    }
    @Override
    protected void resolver (Solicitud solicitud) {
        System.out.println( "El coordinador resuelve... " +
                solicitud.getEstudiante() +
                ": " +solicitud.getDescripcion());
        System.out.println("Asignado un tutor especializado y recursos avanzados\n");
    }
}
