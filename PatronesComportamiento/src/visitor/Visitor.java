package visitor;

public interface Visitor {
    void visitar(AlumnoRegular alumno);
    void visitar(AlumnoBecado alumno);
    void visitar(AlumnoIntercambio alumno);
}