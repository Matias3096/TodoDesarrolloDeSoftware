package ChainofResponsibility;

public class Solicitud {

    private String descripcion, estudiante;
    private int nivelComplejidad; // 1: Basico, 2:Intermedio, 3: Avanzado

    public Solicitud(String descripcion, int nivelComplejidad, String estudiante) {
        this.descripcion = descripcion;
        this.nivelComplejidad = nivelComplejidad;
        this.estudiante = estudiante;
    }

    //Getters
    public String getDescripcion() {
        return descripcion;}

    public int getNivelComplejidad() {
        return nivelComplejidad;
    }
    public String getEstudiante() {
        return estudiante;
    }
}
