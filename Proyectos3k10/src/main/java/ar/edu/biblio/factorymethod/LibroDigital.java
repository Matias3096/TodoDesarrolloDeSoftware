package ar.edu.biblio.factorymethod;
import  ar.edu.biblio.model.Libro;
public class LibroDigital implements Libro{
    private final String titulo;
    public LibroDigital (String titulo){
        this.titulo = titulo;
    }
    public String titulo(){
        return titulo;
    }
    public String tipo(){
        return "DIGITAL";
    }
}
