import lombok.Builder;
import lombok.Data;

@Data //Simplificacion de getters y setters, to string
@Builder // generar constructores a demanda con n elementos


public class Edificio {

    private int idEdificio;
    private String nombre;
    private double superficieConstruida;


}
