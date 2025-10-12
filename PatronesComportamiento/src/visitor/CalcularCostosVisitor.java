package visitor;

public class CalcularCostosVisitor implements Visitor {
    private double costoTotalAcumulado = 0;

    @Override
    public void visitar(AlumnoRegular alumno) {
        double costoSemestral = alumno.getMensualidad() * 6; // 6 meses por semestre
        double costoCreditosAdicionales = alumno.getCreditosInscritos() > 24 ?
                (alumno.getCreditosInscritos() - 24) * 150 : 0;
        double costoTotal = costoSemestral + costoCreditosAdicionales;

        costoTotalAcumulado += costoTotal;

        System.out.println("\n💰 CÁLCULO DE COSTOS - " + alumno.getNombre());
        System.out.println("   Tipo: Alumno Regular");
        System.out.println("   Mensualidad: $" + String.format("%.2f", alumno.getMensualidad()));
        System.out.println("   Costo semestral base: $" + String.format("%.2f", costoSemestral));

        if (costoCreditosAdicionales > 0) {
            System.out.println("   Créditos adicionales: $" +
                    String.format("%.2f", costoCreditosAdicionales));
        }

        System.out.println("   📊 TOTAL: $" + String.format("%.2f", costoTotal));
    }

    @Override
    public void visitar(AlumnoBecado alumno) {
        double mensualidadOriginal = alumno.getMensualidad() /
                (1 - alumno.getPorcentajeBeca() / 100.0);
        double descuentoBeca = mensualidadOriginal - alumno.getMensualidad();
        double costoSemestral = alumno.getMensualidad() * 6;

        costoTotalAcumulado += costoSemestral;

        System.out.println("\n💰 CÁLCULO DE COSTOS - " + alumno.getNombre());
        System.out.println("   Tipo: Alumno Becado (" + alumno.getPorcentajeBeca() + "%)");
        System.out.println("   Mensualidad original: $" + String.format("%.2f", mensualidadOriginal));
        System.out.println("   Descuento por beca: -$" + String.format("%.2f", descuentoBeca));
        System.out.println("   Mensualidad final: $" + String.format("%.2f", alumno.getMensualidad()));
        System.out.println("   Costo semestral: $" + String.format("%.2f", costoSemestral));
        System.out.println("   💾 Ahorro semestral: $" + String.format("%.2f", descuentoBeca * 6));
        System.out.println("   📊 TOTAL A PAGAR: $" + String.format("%.2f", costoSemestral));
    }

    @Override
    public void visitar(AlumnoIntercambio alumno) {
        double costoSemestral = alumno.getMensualidad() * alumno.getMesesEstancia();
        double seguroMedico = 300 * alumno.getMesesEstancia();
        double alojamiento = 800 * alumno.getMesesEstancia() * 0.6; // 40% descuento
        double costoTotal = costoSemestral + seguroMedico + alojamiento;

        costoTotalAcumulado += costoTotal;

        System.out.println("\n💰 CÁLCULO DE COSTOS - " + alumno.getNombre());
        System.out.println("   Tipo: Alumno Intercambio");
        System.out.println("   País: " + alumno.getPaisOrigen());
        System.out.println("   Duración: " + alumno.getMesesEstancia() + " meses");
        System.out.println("\n   Desglose:");
        System.out.println("   - Matrícula: $" + String.format("%.2f", costoSemestral));
        System.out.println("   - Seguro médico: $" + String.format("%.2f", seguroMedico));
        System.out.println("   - Alojamiento (40% desc): $" + String.format("%.2f", alojamiento));
        System.out.println("   📊 TOTAL: $" + String.format("%.2f", costoTotal));
    }

    public double getCostoTotalAcumulado() {
        return costoTotalAcumulado;
    }

    public void mostrarResumenTotal() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📊 RESUMEN TOTAL DE COSTOS");
        System.out.println("=".repeat(60));
        System.out.println("Costo total acumulado: $" + String.format("%.2f", costoTotalAcumulado));
        System.out.println("=".repeat(60) + "\n");
    }
}