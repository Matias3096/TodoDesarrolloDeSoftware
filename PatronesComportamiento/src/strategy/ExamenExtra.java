package strategy;

import java.util.List;

public class ExamenExtra implements CalculoNota {
    private double notaMinima;

    public ExamenExtra(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    @Override
    public double calcular(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }

        // Calcular promedio simple primero
        double suma = 0;
        for (Double nota : notas) {
            suma += nota;
        }
        double promedioInicial = suma / notas.size();

        System.out.println("Cálculo: Con Examen Extra");
        System.out.println("   Notas regulares: " + notas);
        System.out.println("   Promedio inicial: " + String.format("%.2f", promedioInicial));

        // Si está por debajo de la nota mínima, no aprueba
        if (promedioInicial < notaMinima) {
            System.out.println("   No alcanza la nota mínima (" + notaMinima + ")");
            System.out.println("   Puede rendir examen extra para recuperar");
            return promedioInicial;
        }

        // Si aprueba, puede mejorar con examen extra (bonus del 10%)
        double bonus = promedioInicial * 0.10;
        double notaFinal = Math.min(10.0, promedioInicial + bonus);

        System.out.println("  Nota aprobatoria. Bonus por examen extra: +" +
                String.format("%.2f", bonus));
        System.out.println("   Resultado final: " + String.format("%.2f", notaFinal));

        return notaFinal;
    }

    @Override
    public String obtenerDescripcion() {
        return "Con Examen Extra (nota mínima: " + notaMinima +
                ", bonus del 10% si aprueba)";
    }
}