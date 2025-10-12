package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AlumnosConCursos {
    private String nombre;
    private List<Curso> cursosInscriptos;

    public AlumnosConCursos(String nombre) {
        this.nombre = nombre;
        this.cursosInscriptos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursosInscriptos.add(curso);
        System.out.println(" + " + nombre + " agregado a: " + curso.getNombre());
    }

    public void removerCurso(Curso codigocurso) {
        cursosInscriptos.removeIf(curso -> curso.getCodigo().equals(codigocurso));
        System.out.println("---" + nombre + " eliminado del curso: " + codigocurso);
    }

    //Metodo factory para crear el iterador
    public CursoIterator crearIterador(){
        return new CursoIteratorImpl();
    }
    public int getCantidadCursos(){
        return cursosInscriptos.size();
    }
    public String getNombre() {
        return nombre;
    }

    //Iterator interno (implementacion privada)
    private class CursoIteratorImpl implements CursoIterator{
        private int posicionActual= 0;

        @Override
        public boolean hasNext() {
            return posicionActual<cursosInscriptos.size();
        }

        @Override
        public Curso next() {
            if (!hasNext()) {
                throw new RuntimeException("No hay mas cursos");
            }
            return cursosInscriptos.get(posicionActual++);
        }

        @Override
        public void reset() {
            posicionActual = 0;
        }
    }
}
