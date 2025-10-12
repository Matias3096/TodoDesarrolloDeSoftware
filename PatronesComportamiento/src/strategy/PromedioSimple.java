package strategy;

import java.util.List;

public class PromedioSimple implements CalculoNota {

    @Override
    public double calcular(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }

        double suma = 0;
        for (Double nota : notas) {
            suma += nota;
        }

        double promedio = suma / notas.size();
        System.out.println("📊 Cálculo: Promedio Simple");
        System.out.println("   Notas: " + notas);
        System.out.println("   Resultado: " + String.format("%.2f", promedio));

        return promedio;
    }

    @Override
    public String obtenerDescripcion() {
        return "Promedio Simple (todas las notas tienen el mismo peso)";
    }
}
