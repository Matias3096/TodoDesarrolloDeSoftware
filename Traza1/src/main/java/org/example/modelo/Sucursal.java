package org.example.modelo;


import lombok.*;

import java.time.LocalTime;

//Implementacion de lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sucursal {
    private Integer id; //Identificador de la sucursal
    private String nombre;
    private LocalTime horarioApertura, horarioCierre; // atributos para horarios de apertura y cierre
    private Boolean esCasaMatriz; //Atributo para saber si es casa matriz
    @EqualsAndHashCode.Exclude
    private Domicilio domicilio; //Relacion con la clase domicilio
}
