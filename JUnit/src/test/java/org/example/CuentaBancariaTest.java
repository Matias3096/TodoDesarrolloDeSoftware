package org.example;

import org.example.example.CuentaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {
    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp(){
        cuenta = new CuentaBancaria(100); // saldo inicial correcto
    }

    @Test
    void testSaldoInicial(){
        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void testDepositoValido(){
        cuenta.depositar(50); // no 500
        assertEquals(150, cuenta.getSaldo());
        assertTrue(cuenta.getSaldo() > 0);
    }

    @Test
    void testDepositoNegativo(){
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-10));
    }

    @Test
    void testRetiroValido(){
        cuenta.retirar(50);
        assertEquals(50, cuenta.getSaldo());
    }

    @Test
    void testRetiroExcedeSaldo(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(200));
        assertEquals("Fondos insuficientes", ex.getMessage());
    }
}
