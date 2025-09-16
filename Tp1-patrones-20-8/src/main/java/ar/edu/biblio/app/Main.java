package ar.edu.biblio.app;

import ar.edu.biblio.singleton.Database;
import ar.edu.biblio.factorymethod.LogisticaLibro;
import ar.edu.biblio.model.Libro;
import ar.edu.biblio.abstractfactory.*;
import ar.edu.biblio.builder.Usuario;
import ar.edu.biblio.prototype.Prestamo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main (String [] args){
        // Factory Method y singleton
        Libro l1 = LogisticaLibro.crear("Fisico","Patrones creacionales");

        // Creación de la base de datos
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        db1.agregarLibro(l1);

        // Compara y muestra por pantalla si la base de datos son las mismas
        System.out.println("¿db1 y db2 son la misma instancia? " + (db1 == db2)); // Debería ser 'true'
        db1.listarLibros();

        List<String> titulos = Arrays.asList(
                "El Código Da Vinci",
                "1984",
                "Un Mundo Feliz",
                "Cien Años de Soledad",
                "El Hobbit", "Algebra Lineal y Geometria Analitica", "Patrones UML"
        );

        // Generador de números aleatorios
        Random random = new Random();

        // Bucle para crear y agregar libros aleatorios a la base de datos
        System.out.println("Creando y agregando 5 libros aleatorios...");
        for (int i = 0; i < 5; i++){
            // Obtenemos un título aleatorio
            String tituloAleatorio = titulos.get(random.nextInt(titulos.size()));

            // Creamos un tipo de libro aleatorio (Fisico o Digital)
            String tipoAleatorio = random.nextBoolean() ? "Fisico" : "Digital";

            // Usamos el Factory Method para crear el libro
            Libro nuevoLibro = LogisticaLibro.crear(tipoAleatorio, tituloAleatorio);

            // Agregamos el libro a la base de datos a través del Singleton
            db1.agregarLibro(nuevoLibro);
        }

        System.out.println("\nVerificando los libros en la base de datos:");
        // Usamos el metodo listarLibros() para obtener la lista
        List<Libro> librosEnDB = db1.listarLibros();

        // Itera y muestra cada libro
        librosEnDB.forEach(libro -> System.out.println("- " + libro.titulo() + " (" + libro.tipo() + ")"));

        // === Factory Method ===
        System.out.println("=== Factory Method ===");

        // Creamos libros con el metodo fábrica
        Libro l3 = LogisticaLibro.crear("FISICO", "Patrones GoF");
        Libro l2 = LogisticaLibro.crear("DIGITAL", "Clean Code");

        // Mostramos de que tipo es
        System.out.println(l1.titulo() + " - " + l1.tipo());
        System.out.println(l3.titulo() + " - " + l3.tipo());
        System.out.println(l2.titulo() + " - " + l2.tipo());

        //Abstract Factory
        System.out.println("==Probando Abstract Factory==");

        //Fabrica para Usuario Normal
        UIFactory usuarioFactory = new UsuarioFactory();
        System.out.println(usuarioFactory.crearUI().render());
        System.out.println(usuarioFactory.crearEnvio().enviar("El Hobbit"));

        //Fabrica para admin
        UIFactory adminFactory = new AdminFactory();
        System.out.println(adminFactory.crearUI().render());
        System.out.println(adminFactory.crearEnvio().enviar("Algebra Lineal"));

        //Builder
        System.out.println("==Builder==");

        //Creamos el primer usuario (adaptado para el builder manual)
        Usuario u1  = new Usuario.Builder()
                .nombre("Valerina")
                .email("valerinavalerina@gmail.com")
                .build();
        //Otro usuario diferente (adaptado para el builder manual)
        Usuario u2 = new Usuario.Builder()
                .nombre("Sergio")
                .telefono("2634323344")
                .direccion("Calle san pedro")
                .build();

        //Muestro ambos usuarios
        System.out.println(u1);
        System.out.println(u2);

        //====Prototype====
        System.out.println("===Prototype===");

        // Prestamo p1 necesita una instancia de Usuario, así que usamos u1
        Prestamo p1 = new Prestamo(l1, u1, LocalDate.now(), LocalDate.now().plusDays(7));
        Prestamo p2 = p1.clone().conFin(LocalDate.now().plusDays(14));
        Prestamo p3 = p1.clone();
        p3.conFechaInicio(LocalDate.now().plusDays(7));//Modificamos la fecha de inicio
        p3.conFechaInicio(LocalDate.now().plusDays(10));

        System.out.println("Original: " + p1);
        System.out.println("Clon 1: " + p2);
        System.out.println("Clon 2: " + p3);
    }
}
