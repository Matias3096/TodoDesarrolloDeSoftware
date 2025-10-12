package templatemethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ReporteAcademico {

    // Template Method - define el algoritmo general
    public final void generarReporte() {
        imprimirEncabezado();
        imprimirContenido();
        imprimirEstadisticas();
        imprimirPie();
    }

    // Pasos comunes (implementados aquí)
    private void imprimirEncabezado() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          REPORTE ACADÉMICO - " + obtenerTipoReporte());
        System.out.println("=".repeat(60));
        System.out.println("Fecha de generación: " + obtenerFechaActual());
        System.out.println("Institución: Universidad Nacional de Ejemplo");
        System.out.println("-".repeat(60));
    }

    private void imprimirPie() {
        System.out.println("-".repeat(60));
        System.out.println("Generado automáticamente por el Sistema Académico");
        System.out.println("Para consultas: academico@universidad.edu");
        System.out.println("=".repeat(60) + "\n");
    }

    private String obtenerFechaActual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    // Métodos abstractos que deben implementar las subclases
    protected abstract void imprimirContenido();
    protected abstract String obtenerTipoReporte();

    // Hook method - opcional para las subclases
    protected void imprimirEstadisticas() {
        // Implementación por defecto vacía
        // Las subclases pueden sobrescribir si lo necesitan
    }
}