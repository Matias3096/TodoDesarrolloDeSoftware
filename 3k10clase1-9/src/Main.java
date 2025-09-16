import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Crear una instancia de Person
            Person person = new Person("John");

            // Obtener la clase de la instancia
            Class<?> clazz = person.getClass();



            // Acceder y modificar el campo privado 'name'
            Field nameField = clazz.getDeclaredField("nombre");
            nameField.setAccessible(true);
            nameField.set(person, "Matias Fernandez");

            // Invocar el metodo privado 'sayHello'
            Method sayHelloMethod = clazz.getDeclaredMethod("sayHello");
            Method saludar = clazz.getDeclaredMethod("saludar");
            saludar.setAccessible(true);
            saludar.invoke(person);
            sayHelloMethod.setAccessible(true);
            sayHelloMethod.invoke(person);

            System.out.println("Nombre de la clase: " + clazz.getName());
            System.out.println("\nConstructores: ");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(" " + constructor);
            }

            // Obtener los métodos de la clase
            Method[] methods = clazz.getMethods();
            Constructor<?>cons = clazz.getDeclaredConstructor(String.class, String.class , int.class);
            cons.setAccessible(true);
            Object person2 = cons.newInstance("Maria","Moyano", 34);

            //Invocando un metodo para el nuevo objeto
            Method comer = clazz.getDeclaredMethod("Comer");
            comer.setAccessible(true);
            comer.invoke(person2);

            System.out.println("\nMétodos:");
            for (Method method : methods) {
                System.out.println(" " + method.getName());
            }

            // Obtener los campos de la clase
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nCampos:");
            for (Field field : fields) {
                System.out.println(" " + field.getName());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
