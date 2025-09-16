package org.example.modelo;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data // Anotacion de lombok que genera getters, setters, toStringm equals y hashcode
@NoArgsConstructor  // Anotacion de lombok que genera constructor sin argumentos
@AllArgsConstructor  //Anotacion de lombok que genera constructor con todos sus argumentos

public class Pais {
    //Atributos
    private Integer id;
    private String nombre;
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();

}
