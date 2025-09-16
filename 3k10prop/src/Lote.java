import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Lote {

    private int idPadron;
    private String domicilio;
    private double superficie;

    private Edificio edificioConstruido; //Puntero que va desde lote a edificio

    public boolean isConstruible(){  // Regla de negocio, que para construir en un lote este este vacio
        return edificioConstruido == null; // Indica que en ese lote no hay nada construido.
    }
}
