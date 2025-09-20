package org.example;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Categoria {
    @EqualsAndHashCode.Include
    private Integer id;
    private String nombre;

}
