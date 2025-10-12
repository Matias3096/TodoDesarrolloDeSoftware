package memento;

import java.util.HashMap;
import java.util.Map;

public class ExamenEnLinea {
    private String nombreExamen;
    private Map<Integer, String> respuestas;
    private int preguntaActual;
    private int tiempoRestante; //Medido en minutos
    private String [] preguntas;

    public ExamenEnLinea(String nombreExamen, String [] preguntas, int preguntaActual, int tiempoLimite) {
        this.nombreExamen = nombreExamen;
        this.preguntas = preguntas.clone(); //Copia defensiva
        this.respuestas = new HashMap<>();
        this.preguntaActual = 0;
        this.tiempoRestante = tiempoLimite;
    }
    public void responderPregunta (int numeroPregunta, String respuesta ) {
        if (numeroPregunta >= 0 && numeroPregunta < preguntas.length) {
            respuestas.put(numeroPregunta, respuesta);
            System.out.println("Pregunta " + (numeroPregunta + 1) + "respondida:  " + respuesta);
        }
    }

    public void  avanzarPregunta() {
        if (preguntaActual < preguntas.length - 1) {
            preguntaActual++;
            System.out.println("Avanzando a pregunta" + (preguntaActual + 1));
        }
    }
    public void reducirTiempo(int minutos){
        tiempoRestante = Math.max(0, tiempoRestante - minutos);
    }

    // Crear memento (guardar estado)
    public ExamenMemento guardarProgreso(){
        System.out.println("Guardando progreso del examen");
        return new ExamenMemento(respuestas, preguntaActual, tiempoRestante);
    }

    //Restaurar desde el memento
    public void restaurarProgreso(ExamenMemento memento){
        if (memento != null){
            this.respuestas = new HashMap<>(memento.getRespuestas());
            this.preguntaActual = memento.getPreguntaActual();
            this.tiempoRestante = memento.getTiempoRestante();
            System.out.println("Restaurando progreso del examen desde: " + memento.getFechaGuardado());
            System.out.println("Pregunta actual: " + (preguntaActual + 1));
            System.out.println("Respuestas Guardadas" + respuestas.size());
            System.out.println("Tiempo Restante: " + tiempoRestante + " minutos");
        }
    }

    public void mostrarEstadoActual(){
        System.out.println("\n ESTADO ACTUAL DEL EXAMEN" + nombreExamen);
        System.out.println("Pregunta actual: " + (preguntaActual + 1) + "/" + preguntas.length);
        System.out.println("Pregunta: " + preguntas[preguntaActual]);
        System.out.println("Respuestas completadas " + respuestas.size());
        System.out.println("Tiempo restante: " + tiempoRestante + " minutos");

        if (!respuestas.isEmpty()){
            System.out.println("Respuestas guardadas: ");
            respuestas.forEach((num, resp) ->
                    System.out.println("     " + (num + 1)  + ". " + resp));
        }
        System.out.println();
    }

    //Getters

    public String getNombreExamen() {
        return nombreExamen;
    }
    public int getPreguntaActual() {
        return preguntaActual;
    }
    public int getTiempoRestante() {
        return tiempoRestante;
    }
    public Map<Integer, String> getPreguntas() {
        return new HashMap<>(respuestas);
    }
}
