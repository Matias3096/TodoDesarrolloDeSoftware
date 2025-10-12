package strategy;

import java.util.ArrayList;
import java.util.List;

public class AlumnoConNotas {
    private String nombre;
    private String curso;
    private List<Double> notas;
    private CalculoNota estrategiaCalculo;

    public AlumnoConNotas(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
        this.notas = new ArrayList<>();
        // Estrategia por defecto
        this.estrategiaCalculo = new PromedioSimple();
    }

    public void agregarNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            notas.add(nota);
            System.out.println("✅ Nota agregada: " + nota + " para " + nombre);
        } else {
            System.out.println("⚠️ Nota inválida. Debe estar entre 0 y 10");
        }
    }

    public void setEstrategiaCalculo(CalculoNota estrategia) {
        this.estrategiaCalculo = estrategia;
        System.out.println("\n🔄 Estrategia de cálculo cambiada:");
        System.out.println("   " + estrategia.obtenerDescripcion());
        System.out.println();
    }

    public double calcularNotaFinal() {
        if (notas.isEmpty()) {
            System.out.println("⚠️ No hay notas registradas para " + nombre);
            return 0.0;
        }

        System.out.println("\n🎓 Calculando nota final para: " + nombre);
        System.out.println("   Curso: " + curso);
        double notaFinal = estrategiaCalculo.calcular(notas);

        // Determinar si aprobó
        String resultado = notaFinal >= 6.0 ? "APROBADO ✅" : "REPROBADO ❌";
        System.out.println("   Estado: " + resultado + "\n");

        return notaFinal;
    }

    public void mostrarResumen() {
        System.out.println("\n📋 RESUMEN ACADÉMICO");
        System.out.println("   Alumno: " + nombre);
        System.out.println("   Curso: " + curso);
        System.out.println("   Cantidad de notas: " + notas.size());
        System.out.println("   Notas: " + notas);
        System.out.println("   Estrategia: " + estrategiaCalculo.obtenerDescripcion());
        if (!notas.isEmpty()) {
            System.out.println("   Nota final: " + String.format("%.2f", calcularNotaFinal()));
        }
        System.out.println();
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCurso() { return curso; }
    public List<Double> getNotas() { return new ArrayList<>(notas); }
}