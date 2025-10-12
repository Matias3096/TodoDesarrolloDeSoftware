package visitor;

public class AplicarBecaVisitor implements Visitor {

    @Override
    public void visitar(AlumnoRegular alumno) {
        System.out.println("\n🎓 Evaluando beca para: " + alumno.getNombre());

        if (alumno.getCreditosInscritos() >= 30) {
            double descuento = alumno.getMensualidad() * 0.15;
            double nuevaMensualidad = alumno.getMensualidad() - descuento;
            alumno.setMensualidad(nuevaMensualidad);

            System.out.println("   ✅ Beca por carga académica completa: 15%");
            System.out.println("   💰 Descuento: $" + String.format("%.2f", descuento));
            System.out.println("   💵 Nueva mensualidad: $" + String.format("%.2f", nuevaMensualidad));
        } else {
            System.out.println("   ℹ️ No califica para beca (requiere 30+ créditos)");
        }
    }

    @Override
    public void visitar(AlumnoBecado alumno) {
        System.out.println("\n🏆 Revisando beca existente para: " + alumno.getNombre());

        if (alumno.getPromedioActual() >= 8.5) {
            int nuevoPorcentaje = Math.min(100, alumno.getPorcentajeBeca() + 10);
            if (nuevoPorcentaje > alumno.getPorcentajeBeca()) {
                alumno.setPorcentajeBeca(nuevoPorcentaje);
                System.out.println("   🌟 ¡Excelente desempeño! Beca aumentada a: " +
                        nuevoPorcentaje + "%");
            } else {
                System.out.println("   ✅ Beca mantenida: " + alumno.getPorcentajeBeca() + "% (máximo alcanzado)");
            }
        } else if (alumno.getPromedioActual() < 7.0) {
            int nuevoPorcentaje = Math.max(0, alumno.getPorcentajeBeca() - 15);
            alumno.setPorcentajeBeca(nuevoPorcentaje);
            System.out.println("   ⚠️ Promedio bajo. Beca reducida a: " + nuevoPorcentaje + "%");
        } else {
            System.out.println("   ✅ Beca mantenida: " + alumno.getPorcentajeBeca() + "%");
        }

        double mensualidadBase = alumno.getMensualidad();
        double descuento = mensualidadBase * (alumno.getPorcentajeBeca() / 100.0);
        double nuevaMensualidad = mensualidadBase - descuento;
        alumno.setMensualidad(nuevaMensualidad);

        System.out.println("   💵 Mensualidad final: $" + String.format("%.2f", nuevaMensualidad));
    }

    @Override
    public void visitar(AlumnoIntercambio alumno) {
        System.out.println("\n🌎 Evaluando beneficios para estudiante de intercambio: " +
                alumno.getNombre());

        double descuento = alumno.getMensualidad() * 0.30;
        double nuevaMensualidad = alumno.getMensualidad() - descuento;
        alumno.setMensualidad(nuevaMensualidad);

        System.out.println("   ✈️ Descuento programa internacional: 30%");
        System.out.println("   🌍 País de origen: " + alumno.getPaisOrigen());
        System.out.println("   💰 Descuento: $" + String.format("%.2f", descuento));
        System.out.println("   💵 Nueva mensualidad: $" + String.format("%.2f", nuevaMensualidad));

        System.out.println("   🎁 Beneficios adicionales:");
        System.out.println("      - Alojamiento universitario con 40% de descuento");
        System.out.println("      - Seguro médico incluido");
        System.out.println("      - Tutor académico asignado");
    }
}