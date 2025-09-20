package org.example;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Imagen {
    @EqualsAndHashCode.Include
    private Integer id;
    private String nombre, ruta; //ruta puede ser URL o nombre de archivo

}
