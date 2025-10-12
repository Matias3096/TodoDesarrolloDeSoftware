package org.example.example;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double monto){
        if (monto <= 0) throw new IllegalArgumentException("El deposito debe ser positivo");
        saldo += monto;
    }
    public void retirar(double monto){
        if (monto > saldo)
            throw new IllegalArgumentException("Fondos insuficientes");
        saldo -= monto;
    }
}
