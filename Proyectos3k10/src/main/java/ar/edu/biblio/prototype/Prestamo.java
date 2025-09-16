package ar.edu.biblio.prototype;

import ar.edu.biblio.model.Libro;
import ar.edu.biblio.builder.Usuario;
import java.time.LocalDate;

public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Prestamo(Libro libro, Usuario usuario, LocalDate ini, LocalDate fin){
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = ini;
        this.fechaFin = fin;
    }

    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone(); // 👈 devolvemos un Prestamo
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Prestamo conFin(LocalDate fin) {
        this.fechaFin = fin;
        return this;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }


    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro.titulo() +
                ", usuario=" + usuario +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
