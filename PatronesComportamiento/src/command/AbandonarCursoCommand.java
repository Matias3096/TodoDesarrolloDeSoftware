package command;

public class AbandonarCursoCommand implements command{

    private Alumno alumno;
    private String curso;
    private boolean estabaInscrito;
    private boolean fueEjecutado;

    public AbandonarCursoCommand(Alumno alumno, String curso){
        this.alumno = alumno;
        this.curso = curso;
        this.fueEjecutado = false;
    }

    @Override
    public void execute() {
        if (!fueEjecutado) {
            estabaInscrito = alumno.getCursosInscritos().contains(curso);
            alumno.abandonarCurso(curso);
            fueEjecutado = true;
        }
    }
    @Override
    public void undo() {
        if (fueEjecutado && estabaInscrito) {
            alumno.inscribirseEnCurso(curso);
            fueEjecutado = false;
            System.out.println("La operacion abandono de curso fue deshecha para curso: " + curso);
        }
    }

    @Override
    public String getDescripcion() {
        return "Abandonar curso: " + curso;
    }
}
