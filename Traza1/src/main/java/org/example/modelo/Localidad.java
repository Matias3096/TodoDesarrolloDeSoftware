package org.example.modelo;


import lombok.*;

import java.util.HashSet;
import java.util.Set;

//Implementacion de lombok
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

//Clase
public class Localidad {
    //Atributos
    private Integer id; //Identificador de la localidad
    private String nombre;
    @EqualsAndHashCode.Exclude
    private Provincia provincia; // Relacion con la clase provincia
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>(); // Coleccion para la relacion una localidad tiene muchos domicilios

}
