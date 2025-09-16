package org.example.modelo;


import lombok.*;

import java.util.HashSet;
import java.util.Set;

//Implementacion de lombok
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Provincia {
    private Integer id; // identificador de provincia
    private String nombre;
    @EqualsAndHashCode.Exclude
    private Pais pais;  // Relacion con la clase pais, una provincia tiene solo un pais
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>(); //Coleccion de la relacion una provincia tiene muchas localidades.

}
