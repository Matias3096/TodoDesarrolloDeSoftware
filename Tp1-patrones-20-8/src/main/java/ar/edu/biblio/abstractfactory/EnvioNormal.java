package ar.edu.biblio.abstractfactory;

public class EnvioNormal implements MetodoEnvio{
    @Override
    public String enviar(String tituloLibro) {
        return "Envio NORMAL del libro" + tituloLibro;
    }
}
