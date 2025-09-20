package org.example;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
// Desicion: Cada linea de detalle relaciona un manufacturado con un insumo y una cantidad
public class DetalleArticuloManufacturado {

    @EqualsAndHashCode.Include

    private Integer id;
    private Double cantidad; //Cantidad del insumo usada
    private Articulo insumo; // Referencia al articulo insumo (tipo INSUMO)

}

