package org.example.modelo;


import lombok.*;

//Implementacion de lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Domicilio {
    private Integer id, cp, numero; // Identificador de domicilio, juntos con los atributos que si estan en el DC
    private String calle;
    @EqualsAndHashCode.Exclude
    private Localidad localidad; // Relacion con la clase localidad



}
