package visitor;

public class AlumnoBecado implements AlumnoVisitable {
    private String nombre;
    private String matricula;
    private double mensualidad;
    private int porcentajeBeca; // 25, 50, 75, 100
    private double promedioActual;

    public AlumnoBecado(String nombre, String matricula, double mensualidad,
                        int porcentajeBeca, double promedioActual) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.mensualidad = mensualidad;
        this.porcentajeBeca = porcentajeBeca;
        this.promedioActual = promedioActual;
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
        return "Becado";
    }

    // Getters y Setters
    public String getMatricula() { return matricula; }
    public double getMensualidad() { return mensualidad; }
    public void setMensualidad(double mensualidad) { this.mensualidad = mensualidad; }
    public int getPorcentajeBeca() { return porcentajeBeca; }
    public void setPorcentajeBeca(int porcentajeBeca) { this.porcentajeBeca = porcentajeBeca; }
    public double getPromedioActual() { return promedioActual; }

    @Override
    public String toString() {
        return "Alumno Becado: " + nombre + " (Matrícula: " + matricula +
                ", Beca: " + porcentajeBeca + "%, Promedio: " + promedioActual + ")";
    }
}