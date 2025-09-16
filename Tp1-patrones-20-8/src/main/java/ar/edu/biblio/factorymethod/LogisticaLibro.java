package ar.edu.biblio.factorymethod;
import ar.edu.biblio.model.Libro;

public class LogisticaLibro {
    public static Libro crear( String tipo, String titulo){
        return switch (tipo.toUpperCase()){
            case "FISICO" -> new LibroFisico(titulo);
            case "DIGITAL" -> new LibroDigital(titulo);
            default -> throw new IllegalArgumentException("Tipo desconocido: "+tipo);
        };
    }

}
