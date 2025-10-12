package memento;

import java.util.Stack;

public class HistorialExamen {

    private Stack<ExamenMemento> historial;
    private int limiteGuardados;

    public HistorialExamen(int limiteGuardados) {
        this.historial = new Stack<>();
        this.limiteGuardados = limiteGuardados;
    }
    public void guardarEstado(ExamenMemento examen) {
        //Si llegamos al limite, eliminamos el mas antiguo

        if(historial.size() >= limiteGuardados) {
            historial.remove(0); //Elimina el primero(mas antiguo)
            System.out.println("Limite alcanzado, eliminando guardado mas antiguo");
        }
        historial.push(memento);
        System.out.println("Estado guardado. Total Guardados: " + historial.size());
    }
    public ExamenMemento obtenerUltimoEstado(){
        if(!historial.isEmpty()){
            return historial.pop();
        }
        System.out.println("No hay estados guardados");
        return null;
    }
    public ExamenMemento verUltimoEstado(){
        if (!historial.isEmpty()){
            return historial.peek();
        }
        return null;
    }
    public int getCantidadGuardados() {
        return historial.size();
    }
    public void limpiarHistorial(){
        historial.clear();
        System.out.println("Historial Limpiado");
    }

    public void mostrarHistorial(){
        System.out.println("\n HISTORIAL DE GUARDADOS  (" + historial.size() + "):");
        if (!historial.isEmpty()){
            System.out.println("\n  (vacio)  ");
        } else {
            for (int i = 0; i < historial.size(); i++){
                ExamenMemento m = historial.get(i);
                System.out.println("  " + (i + 1) + ": " + m.getFechaGuardado()
                + "| Pregunta: " + (m.getPreguntaActual() + 1)
                + "|Tiempo: " + m.getTiempoRestante() + "min");
            }
        }
        System.out.println();
    }
}

//Justificacion: Limite de guardados evita consumir demasiada memoria
//Stack mantiene el orden cronologico
//Gestion automatica elimina guardados antiguos