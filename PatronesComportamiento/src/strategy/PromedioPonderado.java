package strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota {
    private List<Double> pesos; // Porcentajes que suman 100

    public PromedioPonderado(List<Double> pesos) {
        this.pesos = pesos;
        validarPesos();
    }

    private void validarPesos() {
        double suma = 0;
        for (Double peso : pesos) {
            suma += peso;
        }
        if (Math.abs(suma - 100.0) > 0.01) {
            throw new IllegalArgumentException(
                    "Los pesos deben sumar 100%. Suma actual: " + suma);
        }
    }

    @Override
    public double calcular(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }

        if (notas.size() != pesos.size()) {
            throw new IllegalArgumentException(
                    "La cantidad de notas (" + notas.size() +
                            ") debe coincidir con la cantidad de pesos (" + pesos.size() + ")");
        }

        double notaPonderada = 0;
        System.out.println(" Cálculo: Promedio Ponderado");

        for (int i = 0; i < notas.size(); i++) {
            double contribucion = notas.get(i) * (pesos.get(i) / 100.0);
            notaPonderada += contribucion;
            System.out.println("   Nota " + (i + 1) + ": " + notas.get(i) +
                    " × " + pesos.get(i) + "% = " + String.format("%.2f", contribucion));
        }

        System.out.println("   Resultado final: " + String.format("%.2f", notaPonderada));
        return notaPonderada;
    }

    @Override
    public String obtenerDescripcion() {
        return "Promedio Ponderado (cada nota tiene un peso específico: " + pesos + ")";
    }
}