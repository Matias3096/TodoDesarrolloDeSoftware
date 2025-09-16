//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Caja<String> cajaDeTexto = new Caja<>();
            cajaDeTexto.setContenido("Hola, Genéricos!");
            System.out.println(cajaDeTexto.getContenido());

            Caja<Integer> cajaDeNumeros = new Caja<>();
            cajaDeNumeros.setContenido(123);
            System.out.println(cajaDeNumeros.getContenido());
        }
    }
