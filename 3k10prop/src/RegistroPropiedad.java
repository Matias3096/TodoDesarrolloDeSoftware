import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder

public class RegistroPropiedad {
    private int idRegistro;
    private String nombreRegistro;
    private static int nextNumeroEscritura = 0;

    @Builder.Default
    private List<Escritura> escrituras = new ArrayList<>();  //Registra las exrituras de forma automatica, se deja arraylist para que despues se pueda cambiar por un vector

    public void registrarLote(Lote lote, String fechaEscritura){
        nextNumeroEscritura = nextNumeroEscritura + 1;
        System.out.println(nextNumeroEscritura);

        Escritura escritura = new Escritura(nextNumeroEscritura, lote,this, fechaEscritura);

        escrituras.add(escritura);

        System.out.println("\n Lote registrado en : " + nombreRegistro + "\n con escritura numero: " +  nextNumeroEscritura );
    }

    public void construirEdificio(Lote lote,Edificio edificio) {
        if (lote.isConstruible()){

            lote.setEdificioConstruido(edificio);
            System.out.println("\nEdificio:  " + edificio.getNombre() + " \nconstruido en el lote " + lote.getIdPadron());
        } else {
            System.out.println("\nNo se puede construir en el lote " + lote.getIdPadron() + " porque ya tiene un edificio" );
        }
    }
    public  List<Escritura> getEscrituras(){
        System.out.println("Estoy en escrituras");
        System.out.println(escrituras);
        System.out.println("despues de imprimir");
        return escrituras;
    }
}
