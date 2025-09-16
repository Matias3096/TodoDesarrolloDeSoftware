public class Person {

    private String nombre, apellido;
    private int edad;
    public Person() {

    }
    public Person(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    public Person(String nombre) {
        this.nombre = nombre;
    }
    private void Comer(){
        System.out.println("Comemos por la boca");
    }
    private void saludar(){
        System.out.println("Saludamos con las manos");
    }
    private void sayHello() {
        System.out.println("Hello, my name is " + nombre);
    }

}
