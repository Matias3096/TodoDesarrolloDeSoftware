package ar.edu.biblio.builder;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class Usuario {
    private final String nombre, email, direccion,telefono;
    private final LocalDate fechaNacimiento;


}
