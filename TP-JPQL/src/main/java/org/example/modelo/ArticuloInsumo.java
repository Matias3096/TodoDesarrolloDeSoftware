package org.example.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table (name = "ARTICULOINSUMO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( callSuper = true)
@SuperBuilder

public class ArticuloInsumo extends Articulo {

    @Column(name ="ESPARAELABORAR", nullable = false)
    private Boolean esParaElaborar;

    @Column(name = "PRECIOCOMPRA")
    private Double precioCompra;

    @Column(name = "STOCKACTUAL")
    private Integer stockActual;

    @Column(name = "STOCKMAXIMO")
    private Integer stockMaximo;
}
