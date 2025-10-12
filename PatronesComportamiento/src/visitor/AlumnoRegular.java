package visitor;

public class AlumnoRegular implements AlumnoVisitable {
    private String nombre;
    private String matricula;
    private double mensualidad;
    private int creditosInscritos;

    public AlumnoRegular(String nombre, String matricula, double mensualidad, int creditosInscritos) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.mensualidad = mensualidad;
        this.creditosInscritos = creditosInscritos;
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTipo() {
        return "Regular";
    }

    // Getters y Setters
    public String getMatricula() { return matricula; }
    public double getMensualidad() { return mensualidad; }
    public void setMensualidad(double mensualidad) { this.mensualidad = mensualidad; }
    public int getCreditosInscritos() { return creditosInscritos; }

    @Override
    public String toString() {
        return "Alumno Regular: " + nombre + " (Matrícula: " + matricula +
                ", Mensualidad: $" + mensualidad + ", Créditos: " + creditosInscritos + ")";
    }
}
