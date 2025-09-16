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
}
