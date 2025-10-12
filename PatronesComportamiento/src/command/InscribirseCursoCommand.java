package command;

import java.util.ArrayList;

public class InscribirseCursoCommand implements command {
    private Alumno alumno;
    private String curso;
    private boolean fueEjecutado;

    public InscribirseCursoCommand(Alumno alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.fueEjecutado = false;
    }

    @Override
    public void execute() {
        if (!fueEjecutado) {
            alumno.inscribirseEnCurso(curso);
            fueEjecutado = true;
        }
    }

    @Override
    public void undo() {
        if (fueEjecutado) {
            alumno.abandonarCurso(curso);
            fueEjecutado = false;
            System.out.println("La inscripcion de: " + curso + "fue borrada");
        }
    }

    @Override
    public String getDescripcion() {
        return "Inscribirse en curso: " + curso;

    }
}
