package memento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ExamenMemento {

    private final Map<Integer, String> respuestas;
    private final int preguntaActual;
    private final LocalDateTime fechaGuardado;
    private final int tiempoRestante; //Medido en minutos

    public ExamenMemento(Map<Integer, String> respuestas, int preguntaActual, int tiempoRestante){
        //Copia defensiva para mantener inmutabilidad
        this.respuestas = new HashMap<>(respuestas);
        this.preguntaActual = preguntaActual;
        this.tiempoRestante = tiempoRestante;
        this.fechaGuardado = LocalDateTime.now();
    }

    //Solo agregamos getters - el memento es inmutable
    public Map<Integer, String> getRespuestas() {
        return new HashMap<>(respuestas); //Aqui implementamos otra copia defensiva
    }

    public int getPreguntaActual() {
        return preguntaActual;
    }
    public int getTiempoRestante() {
        return tiempoRestante;
    }
    public LocalDateTime getFechaGuardado() {
        return fechaGuardado;
    }


    //Lo consideramos inmutable en cuanto a integridad para que nadie modifique un estado guardado
    //En seguridad, no dejamos que los datos del examen sean alterados
    //En cuanto a confiabilidad, siempre sabemos que memento representa un estado valido.¿
}
