package iterator;

public class Curso {
    private String nombre;
    private String codigo;
    private int creditos;


    public Curso(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }
    @Override
    public String toString(){
        return codigo + " - " + nombre + " (" + creditos + " creditos)";
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getCreditos() {
        return creditos;
    }
}
