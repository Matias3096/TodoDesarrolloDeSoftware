package visitor;

public class GenerarReportesVisitor implements Visitor {
    private int contadorRegulares = 0;
    private int contadorBecados = 0;
    private int contadorIntercambio = 0;

    @Override
    public void visitar(AlumnoRegular alumno) {
        contadorRegulares++;
        System.out.println("\n📄 REPORTE - " + alumno.getNombre());
        System.out.println("   Categoría: Alumno Regular");
        System.out.println("   Matrícula: " + alumno.getMatricula());
        System.out.println("   Créditos inscritos: " + alumno.getCreditosInscritos());
        System.out.println("   Estado: " + (alumno.getCreditosInscritos() >= 12 ?
                "Tiempo completo" : "Tiempo parcial"));
    }

    @Override
    public void visitar(AlumnoBecado alumno) {
        contadorBecados++;
        System.out.println("\n📄 REPORTE - " + alumno.getNombre());
        System.out.println("   Categoría: Alumno Becado");
        System.out.println("   Matrícula: " + alumno.getMatricula());
        System.out.println("   Porcentaje de beca: " + alumno.getPorcentajeBeca() + "%");
        System.out.println("   Promedio actual: " + alumno.getPromedioActual());
        System.out.println("   Estado beca: " + obtenerEstadoBeca(alumno.getPromedioActual()));
    }

    @Override
    public void visitar(AlumnoIntercambio alumno) {
        contadorIntercambio++;
        System.out.println("\n📄 REPORTE - " + alumno.getNombre());
        System.out.println("   Categoría: Estudiante de Intercambio");
        System.out.println("   Matrícula: " + alumno.getMatricula());
        System.out.println("   País de origen: " + alumno.getPaisOrigen());
        System.out.println("   Universidad origen: " + alumno.getUniversidadOrigen());
        System.out.println("   Duración estancia: " + alumno.getMesesEstancia() + " meses");
        System.out.println("   Programa: Intercambio Internacional");
    }

    private String obtenerEstadoBeca(double promedio) {
        if (promedio >= 9.0) return "Excelente - Elegible para aumento";
        if (promedio >= 8.0) return "Bueno - Beca asegurada";
        if (promedio >= 7.0) return "Satisfactorio - Beca en revisión";
        return "En riesgo - Requiere mejora";
    }

    public void mostrarEstadisticas() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📊 ESTADÍSTICAS GENERALES");
        System.out.println("=".repeat(60));
        System.out.println("Alumnos regulares: " + contadorRegulares);
        System.out.println("Alumnos becados: " + contadorBecados);
        System.out.println("Estudiantes de intercambio: " + contadorIntercambio);
        System.out.println("TOTAL: " + (contadorRegulares + contadorBecados + contadorIntercambio));
        System.out.println("=".repeat(60) + "\n");
    }
}