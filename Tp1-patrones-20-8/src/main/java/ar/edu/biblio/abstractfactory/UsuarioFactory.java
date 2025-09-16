package ar.edu.biblio.abstractfactory;

public class UsuarioFactory implements UIFactory{
    @Override
    public InterfazUI crearUI() {
        return new UsuarioUI();
    }

    @Override
    public MetodoEnvio crearEnvio() {
        return new EnvioNormal();
    }
}
