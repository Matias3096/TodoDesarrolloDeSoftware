package ar.edu.biblio.factorymethod;
import  ar.edu.biblio.model.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LibroDigital implements Libro{
    private final String titulo;
    public String titulo(){

        return titulo;
    }
    public String tipo(){

        return "DIGITAL";
    }
}
