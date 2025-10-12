package visitor;

public class AlumnoIntercambio implements AlumnoVisitable {
    private String nombre;
    private String matricula;
    private String paisOrigen;
    private String universidadOrigen;
    private int mesesEstancia;
    private double mensualidad;

    public AlumnoIntercambio(String nombre, String matricula, String paisOrigen,
                             String universidadOrigen, int mesesEstancia, double mensualidad) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.paisOrigen = paisOrigen;
        this.universidadOrigen = universidadOrigen;
        this.mesesEstancia = mesesEstancia;
        this.mensualidad = mensualidad;
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
        return "Intercambio";
    }

    // Getters y Setters
    public String getMatricula() { return matricula; }
    public String getPaisOrigen() { return paisOrigen; }
    public String getUniversidadOrigen() { return universidadOrigen; }
    public int getMesesEstancia() { return mesesEstancia; }
    public double getMensualidad() { return mensualidad; }
    public void setMensualidad(double mensualidad) { this.mensualidad = mensualidad; }

    @Override
    public String toString() {
        return "Alumno Intercambio: " + nombre + " (País: " + paisOrigen +
                ", Universidad: " + universidadOrigen + ", Estancia: " + mesesEstancia + " meses)";
    }
}