package command;

import java.util.ArrayList;
import java.util.List;

public class PlataformaEducativa {
    private List<command> historialComandos;

    public PlataformaEducativa(){
        this.historialComandos = new ArrayList<>();
    }
    public void ejecutarComando(command comando){
        System.out.println("Ejecutando comando: " + comando.getDescripcion());
        comando.execute();
        historialComandos.add(comando);
    }
    public void deshacerUltimoComando(){
        if(!historialComandos.isEmpty()){
            command ultimoComando = historialComandos.get(historialComandos.size()-1);
            ultimoComando.undo();
            historialComandos.remove(historialComandos.size()-1);
        } else {
            System.out.println("No hay comandos para deshacer");
        }
    }
    public void mostrarHistorialComandos(){
        System.out.println("HISTORIAL DE COMANDOS: ");
        if(historialComandos.isEmpty()){
            System.out.println("   (Vacio)   ");
        } else  {
            for (int i=0; i<historialComandos.size(); i++){
                System.out.println("    " + (i + 1) + " . "+ historialComandos.get(i).getDescripcion());
            }
        }
        System.out.println();
    }
}
