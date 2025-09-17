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
public class Empresa {
    private Integer id; //Identificador de la clase
    private String nombre, razonSocial, logo; //Atributos segun el DC
    private Long cuit;//atributo segun el DC
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

}
