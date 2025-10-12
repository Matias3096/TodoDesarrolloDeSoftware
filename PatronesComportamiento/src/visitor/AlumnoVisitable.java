package visitor;

public interface AlumnoVisitable {
    void aceptar(Visitor visitor);
    String getNombre();
    String getTipo();
}