package templatemethod;

import java.util.List;
import java.util.ArrayList;

public class ReporteCurso extends ReporteAcademico {
    private String nombreCurso;
    private String codigo;
    private String profesor;
    private int cantidadEstudiantes;
    private double promedioGeneral;
    private List<String> estudiantesDestacados;

    public ReporteCurso(String codigo, String nombreCurso, String profesor,
                        int cantidadEstudiantes, double promedioGeneral) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.promedioGeneral = promedioGeneral;
        this.estudiantesDestacados = new ArrayList<>();
    }

    public void agregarEstudianteDestacado(String estudiante) {
        estudiantesDestacados.add(estudiante);
    }

    @Override
    protected String obtenerTipoReporte() {
        return "CURSO";
    }

    @Override
    protected void imprimirContenido() {
        System.out.println("\n📚 INFORMACIÓN DEL CURSO:");
        System.out.println("   Código: " + codigo);
        System.out.println("   Nombre: " + nombreCurso);
        System.out.println("   Profesor: " + profesor);
        System.out.println("   Estudiantes inscritos: " + cantidadEstudiantes);

        System.out.println("\n📊 RENDIMIENTO:");
        System.out.println("   Promedio general: " + String.format("%.2f", promedioGeneral));
        System.out.println("   Estado: " + obtenerEstadoCurso());

        if (!estudiantesDestacados.isEmpty()) {
            System.out.println("\n🏆 ESTUDIANTES DESTACADOS:");
            for (int i = 0; i < estudiantesDestacados.size(); i++) {
                System.out.println("   " + (i + 1) + ". " + estudiantesDestacados.get(i));
            }
        }
    }

    @Override
    protected void imprimirEstadisticas() {
        System.out.println("\n📈 ESTADÍSTICAS ADICIONALES:");
        int aprobados = (int)(cantidadEstudiantes * 0.75); // Simulación
        int reprobados = cantidadEstudiantes - aprobados;

        System.out.println("   Aprobados estimados: " + aprobados +
                " (" + String.format("%.1f", (aprobados * 100.0 / cantidadEstudiantes)) + "%)");
        System.out.println("   Reprobados estimados: " + reprobados +
                " (" + String.format("%.1f", (reprobados * 100.0 / cantidadEstudiantes)) + "%)");
        System.out.println("   Tasa de asistencia: 87.5%");
    }

    private String obtenerEstadoCurso() {
        if (promedioGeneral >= 8.0) return "Excelente ⭐⭐⭐";
        if (promedioGeneral >= 7.0) return "Muy bueno ⭐⭐";
        if (promedioGeneral >= 6.0) return "Bueno ⭐";
        return "Requiere atención ⚠️";
    }
}