package command;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private List<String> cursosInscritos;
    private List<String> certificadosSolicitados;

    //Constructor
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.cursosInscritos = new ArrayList<>();
        this.certificadosSolicitados = new ArrayList<>();
    }

    //Operaciones que realizaran los comandos
    public void inscribirseEnCurso(String curso) {
        if (!cursosInscritos.contains(curso)) {
            cursosInscritos.add(curso);
            System.out.println("*" + nombre + " se inscribio en: " + curso);
        } else  {
            System.out.println("*" + nombre + " Ya esta inscripto en:  " + curso);
        }
    }

    public void abandonarCurso(String curso) {
        if (cursosInscritos.contains(curso)) {
            System.out.println("x" + nombre + " abandono el curso: " + curso);
        } else {
            System.out.println("x" + nombre + " no estaba inscripto en el curso: " + curso);
        }
    }

    public void solicitarCertificado(String curso) {
        if(cursosInscritos.contains(curso)) {
            certificadosSolicitados.add(curso);
            System.out.println("*" + nombre + " solicito el certificado de: " + curso);
        } else
            System.out.println("*" + nombre + " no puede solicitar el certificado de: " + curso + "No esta inscripto");
    }

    //Get's
    public String getNombre() {
        return nombre;
    }

    public List<String> getCursosInscritos() {
        return new ArrayList<>(cursosInscritos);}
    public List<String> getCertificadosSolicitados() {
        return new ArrayList<>(certificadosSolicitados);}
}
