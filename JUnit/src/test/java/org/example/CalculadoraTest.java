package org.example;

import org.example.example.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculadoraTest {
    @Test
    void testSumar(){
        //Arrange
        Calculadora calculadora = new Calculadora();

        //Act
        int resultado = calculadora.sumar(2,3);

        //Assert
        assertEquals(5, resultado, "2 + 3 debe ser 5");
    }
    @Test
    void testDividir(){
        Calculadora calculadora = new Calculadora();
        assertEquals(5,calculadora.dividir(10,2));
    }
    @Test
    void testDividirPorCero(){
        Calculadora calculadora = new Calculadora();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.dividir(10,0);
        });
        assertEquals("Divisor no puede ser cero" , ex.getMessage());
    }
    @Test
    void testOperacionesConAssertTrueYFalse(){
        Calculadora calculadora = new Calculadora();
        assertTrue(calculadora.sumar(1,1) == 2);
        assertFalse(calculadora.multiplicar(2,2) == 5);
    }

}
