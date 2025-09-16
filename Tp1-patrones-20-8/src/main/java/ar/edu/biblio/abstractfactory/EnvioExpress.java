package ar.edu.biblio.abstractfactory;

public class EnvioExpress implements MetodoEnvio{

    @Override
    public String enviar(String tituloLibro) {
        return "Envio EXPRESS del libro" + tituloLibro;
    }
}
