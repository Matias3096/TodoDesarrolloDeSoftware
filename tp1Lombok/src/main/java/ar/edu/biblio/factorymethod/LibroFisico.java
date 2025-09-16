package ar.edu.biblio.factorymethod;
import ar.edu.biblio.model.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LibroFisico implements Libro {
    private final String titulo;

    @Override
    public String titulo(){

        return titulo;
    }
    @Override
    public String tipo (){

        return "FISICO";
    }
    @Override  // Agrego esta modificacion, para mostrar el libro, y no la direccion en memoria. Porque era ilegible
    public String toString() {
        return "LibroFisico: " + titulo;
    }
}
