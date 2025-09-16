//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Bienvenido");

        //Creando un registro de propiedad
        RegistroPropiedad registro1 = RegistroPropiedad.builder()  // Usamos builder, y build(que encapsula)
                .nombreRegistro("Junin - Mendoza")
                .idRegistro(1)  //Asi funciona builder, que es lo mismo que crear un constructor con dos parametros
                .build();

        //Crear un lote
        Lote lote1 = Lote.builder()
                .idPadron(2634)
                .domicilio("Luis pasteur 50")
                .superficie(123.3)
                .build();  //Observar al final el build

        System.out.println("\nEl lote: " + lote1);  //Muestra lote, pero bastante primitivo, fue de prueba


        //Para registrar el lote:
        registro1.registrarLote(lote1, "02/08/2025");


        //Creamos edificio 1
        Edificio edificio1 = Edificio.builder()
                .idEdificio(1)
                .nombre("Rondeau")
                .superficieConstruida(80.02)
                .build();
        registro1.construirEdificio(lote1, edificio1);  //Aca construyo el edificio 1 en el lote ya registrado, pero el edificio debe estar construido

        //Creamos un lote 2
        Lote lote2 = Lote.builder()
                .idPadron(3634)
                .domicilio("Angel dindorf 50")
                .superficie(190.3)
                .build();

        //Creamos edificio 2
        Edificio edificio2 = Edificio.builder()
                .idEdificio(2)
                .nombre("Mi edificio")
                .superficieConstruida(90.02)
                .build();
        registro1.construirEdificio(lote2,edificio2);

        registro1.getEscrituras(); //devuelve la lista de escrituras que están registradas en el objeto RegistroPropiedad.
    }
}