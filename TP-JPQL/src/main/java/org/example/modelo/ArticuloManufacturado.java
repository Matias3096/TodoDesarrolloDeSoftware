package org.example.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder


public class ArticuloManufacturado extends Articulo{
    @Column(name = "DESCRIPCION", length = 500)
    private String descripcion;

    @Column(name = "PREPARACION", length = 1000)
    private String preparacion;

    @Column(name = "TIEMPOESTIMADOMINUTOS")
    private Integer tiempoEstimadoMinutos;

}
