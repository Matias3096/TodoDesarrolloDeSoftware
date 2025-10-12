package templatemethod;

import java.util.HashMap;
import java.util.Map;

public class ReporteAlumno extends ReporteAcademico {
    private String nombreAlumno;
    private String matricula;
    private String carrera;
    private Map<String, Double> notasPorCurso;
    private int creditosAcumulados;
    private int creditosTotales;

    public ReporteAlumno(String matricula, String nombreAlumno, String carrera,
                         int creditosAcumulados, int creditosTotales) {
        this.matricula = matricula;
        this.nombreAlumno = nombreAlumno;
        this.carrera = carrera;
        this.creditosAcumulados = creditosAcumulados;
        this.creditosTotales = creditosTotales;
        this.notasPorCurso = new HashMap<>();
    }

    public void agregarNota(String curso, double nota) {
        notasPorCurso.put(curso, nota);
    }

    @Override
    protected String obtenerTipoReporte() {
        return "ALUMNO";
    }

    @Override
    protected void imprimirContenido() {
        System.out.println("\n👤 INFORMACIÓN DEL ESTUDIANTE:");
        System.out.println("   Matrícula: " + matricula);
        System.out.println("   Nombre: " + nombreAlumno);
        System.out.println("   Carrera: " + carrera);

        System.out.println("\n📚 PROGRESO ACADÉMICO:");
        System.out.println("   Créditos acumulados: " + creditosAcumulados + "/" + creditosTotales);
        double porcentajeAvance = (creditosAcumulados * 100.0) / creditosTotales;
        System.out.println("   Avance: " + String.format("%.1f", porcentajeAvance) + "%");

        if (!notasPorCurso.isEmpty()) {
            System.out.println("\n📊 CALIFICACIONES:");
            double sumaNotas = 0;
            for (Map.Entry<String, Double> entrada : notasPorCurso.entrySet()) {
                String estado = entrada.getValue() >= 6.0 ? "✅" : "❌";
                System.out.println("   " + estado + " " + entrada.getKey() + ": " +
                        String.format("%.2f", entrada.getValue()));
                sumaNotas += entrada.getValue();
            }

            double promedioGeneral = sumaNotas / notasPorCurso.size();
            System.out.println("\n   Promedio General: " + String.format("%.2f", promedioGeneral));
            System.out.println("   Rendimiento: " + obtenerRendimiento(promedioGeneral));
        }
    }

    @Override
    protected void imprimirEstadisticas() {
        System.out.println("\n🎯 ANÁLISIS DE DESEMPEÑO:");

        int cursosAprobados = 0;
        int cursosReprobados = 0;

        for (Double nota : notasPorCurso.values()) {
            if (nota >= 6.0) cursosAprobados++;
            else cursosReprobados++;
        }

        System.out.println("   Cursos aprobados: " + cursosAprobados);
        System.out.println("   Cursos reprobados: " + cursosReprobados);
        System.out.println("   Total de cursos: " + notasPorCurso.size());

        if (!notasPorCurso.isEmpty()) {
            double tasaAprobacion = (cursosAprobados * 100.0) / notasPorCurso.size();
            System.out.println("   Tasa de aprobación: " + String.format("%.1f", tasaAprobacion) + "%");
        }

        // Predicción de graduación
        int creditosFaltantes = creditosTotales - creditosAcumulados;
        int semestresEstimados = (int)Math.ceil(creditosFaltantes / 20.0);
        System.out.println("\n   Semestres estimados para graduación: " + semestresEstimados);
    }

    private String obtenerRendimiento(double promedio) {
        if (promedio >= 9.0) return "Sobresaliente 🌟";
        if (promedio >= 8.0) return "Distinguido 🎖️";
        if (promedio >= 7.0) return "Bueno 👍";
        if (promedio >= 6.0) return "Satisfactorio ✓";
        return "Insuficiente ⚠️";
    }
}
