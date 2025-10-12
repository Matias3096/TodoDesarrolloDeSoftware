package command;

public interface command {
    void execute();  //Ejecuta acciones
    void undo();  //Para poder deshacer/revertir operaciones
    String getDescripcion();  //para mostrar al usuario que accion va a realizar
}
