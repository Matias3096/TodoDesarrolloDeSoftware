//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        Contenedor<String> contenedor = new ContenedorSimple<>();
        contenedor.agregar("Elemento Genérico");
        System.out.println(contenedor.obtener());

    }