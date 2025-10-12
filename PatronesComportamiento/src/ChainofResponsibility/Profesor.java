package ChainofResponsibility;

import java.util.logging.Handler;

public class Profesor extends Handler {
    @Override
    protected boolean puedeResolver (Solicitud solicitud) {
        return  solicitud.getNivelComplejidad() = 2;
    }
    @Override
    protected void resolver( Solicitud solicitud){
        System.out.println("Profesor resuelve la solicitud " + solicitud.getEstudiante()
            + ": " +solicitud.getDescripcion());
        System.out.println(" Programando consulta personalizada \n");
    }
}
