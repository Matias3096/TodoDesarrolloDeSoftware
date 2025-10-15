package org.example.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;


import java.time.LocalDate;
import java.time.Period;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@ToString



public abstract class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String apellido;

    @Column(nullable = false, length = 8)
    private String dni; // validamos formato en setter/constructor

    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private TipoSangre tipoSangre;

    protected Persona(String nombre,String apellido, String dni, LocalDate fechaNacimiento,  TipoSangre tipoSangre) {
        this.nombre = validarString(nombre, "nombre");
        this.apellido = validarString(apellido,"apellido");
        this.dni = validarDni(dni);
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
    }
    private String validarString(String value, String campo){
        if (StringUtils.isEmpty(value)){
            throw new IllegalArgumentException("El campo "+ campo + "no puede estar vacio");
        }
        return value.trim();
    }

    private String validarDni(String dni) {
        if (dni == null || !dni.matches("\\d{7,8}")){
            throw new IllegalArgumentException("Dni invalido. Debe tener 7 u 8 digitos numericos");
        }
        return dni;
    }

    public int getEdad(){
        if (fechaNacimiento == null) return -1;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }


}
