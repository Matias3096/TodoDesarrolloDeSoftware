package command;

public class SolicitarCertificadoCommand implements command {
    private Alumno alumno;
    private String curso;
    private boolean fueEjecutado;


    public SolicitarCertificadoCommand(Alumno alumno, String curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.fueEjecutado = false;
    }

    @Override
    public void execute() {
        if (fueEjecutado) {
            //En un sistema real, cancelariamos la solicitud en la base de datos
            System.out.println("La solicitud de certificado fue cancelada: " + curso);
            fueEjecutado = false;
        }
    }
    @Override
    public String getDescripcion(){
        return "Solicitar certificado" + curso;
    }
}
