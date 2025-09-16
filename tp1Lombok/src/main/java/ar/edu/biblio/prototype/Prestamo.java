package ar.edu.biblio.prototype;

import ar.edu.biblio.model.Libro;
import ar.edu.biblio.builder.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor

public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

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

}
