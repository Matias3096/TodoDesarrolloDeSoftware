package strategy;

import java.util.List;

public interface CalculoNota {
    double calcular(List<Double> notas);
    String obtenerDescripcion();
}