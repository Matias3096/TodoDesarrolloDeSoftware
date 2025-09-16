//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public class Util {
        public static <T> void imprimir(T elemento) {
            System.out.println(elemento);
        }

        public static void main(String[] args) {
            Util.imprimir("Hola, Mundo!");
            Util.imprimir(123);
            Util.imprimir(45.67);
        }
    }

}