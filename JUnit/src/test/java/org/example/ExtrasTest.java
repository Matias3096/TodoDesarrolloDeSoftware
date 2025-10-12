package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

public class ExtrasTest {
    @BeforeAll
    static void initAll() {
        System.out.println("Ejecuta una vez antes TODOS los tests");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Ejecuta una vez despues de TODOS los tests");
    }

    @Test
    void testAssertNullYNotNull(){
        String nombre = null;
        assertNull(nombre);

        nombre = "JUnit";
        assertNotNull(nombre);
    }
    @Test
    void testAssertAll(){
        int x = 5;
        int y = 10;
        assertAll("Operaciones Aritmeticas",
                () -> assertEquals(15, x + y),
                () -> assertTrue(y > x ),
                () -> assertFalse (x > y)
        );
    }

    @Test
    void testAssertIterableEquals(){
        List<String> esperado = Arrays.asList("A", "B", "C");
        List<String> real = Arrays.asList("A", "B", "C");
        assertIterableEquals(esperado, real);
    }
}
