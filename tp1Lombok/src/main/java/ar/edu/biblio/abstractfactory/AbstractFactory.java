package ar.edu.biblio.abstractfactory;

import ar.edu.biblio.model.Libro;

public abstract class AbstractFactory {
    public abstract InterfazUI crearInterfazUI();
    public abstract MetodoEnvio crearMetodoEnvio();
}
