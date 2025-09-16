import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder

@ToString(exclude = "registro")   //este y el siguiente le dice a Lombok que excluya el campo llamado registro de la generación de esos métodos.
@EqualsAndHashCode(exclude = "registro")

public class Escritura {
    private int numeroEscritura;
    private Lote lote;

    private RegistroPropiedad registro;  //Referencia al registro

    private String fechaEscritura;



}
