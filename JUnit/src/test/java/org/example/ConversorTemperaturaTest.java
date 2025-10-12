package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.example.ConversorTemperatura;

public class ConversorTemperaturaTest {
    @Test
    void testCelsiusAFahrenheit(){
        ConversorTemperatura conv = new ConversorTemperatura();
        assertEquals(32, conv.celsiusAFahrenheit(0), 0.001);
        assertEquals(212, conv.celsiusAFahrenheit(100), 0.001);
    }

    @Test
    void testFahrenheitACelsius(){
        ConversorTemperatura conv = new ConversorTemperatura();
        assertEquals(0, conv.fahrenheitACelcius(32),0.001);
        assertEquals(100, conv.fahrenheitACelcius(212), 0.001);

    }
}
