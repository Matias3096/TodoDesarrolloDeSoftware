package ar.edu.biblio.singleton;
import ar.edu.biblio.model.Libro;
import java.util.*;

public class Database {
    //Constructor privado
    private Database (){

    }
    // thread-safe, usamos holder porque es mas limpio y moderno
    private static class Holder{
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance(){
        return Holder.INSTANCE;
    }
    private final List<Libro> libros= new ArrayList<>();
    public void agregarLibro(Libro libro){
        libros.add(libro); }
    public List<Libro> listarLibros(){
        return Collections.unmodifiableList(libros);
    }
}



