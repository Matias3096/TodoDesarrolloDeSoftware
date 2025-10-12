package iterator;

public interface CursoIterator {
    boolean hasNext();
    Curso next();
    void reset();  // Esto nos sirve para reiniciar el recorrido
}
