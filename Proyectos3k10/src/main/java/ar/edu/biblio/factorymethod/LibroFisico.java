package ar.edu.biblio.factorymethod;
import ar.edu.biblio.model.Libro;
public class LibroFisico implements Libro {
    private final String titulo;

    public LibroFisico(String titulo){
        this.titulo= titulo;
    }
    public String titulo(){

        return titulo;
    }
    public String tipo (){

        return "FISICO";
    }
    @Override  // Agrego esta modificacion, para mostrar el libro, y no la direccion en memoria. Porque era ilegible
    public String toString() {
        return "LibroFisico: " + titulo;
    }
}
