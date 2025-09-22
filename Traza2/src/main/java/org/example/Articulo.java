package org.example;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


public class Articulo {
    @EqualsAndHashCode.Include
    private Integer id;
    private String nombre;
    private Double precio;
    private Categoria categoria;
    private UnidadMedida unidadMedida;
    private Boolean esParaElaborar;  // Si este insumo se usa para elaborar otros, sirve para marcar insumos que participan en fabricacion, respetando el enunciado el tp
    private TipoArticulo tipoArticulo;  //Insumo Manufacturado

    @ToString.Exclude
    @Builder.Default

    private Set<Imagen> imagenes = new HashSet<>();

    @ToString.Exclude
    @Builder.Default
    private Set<DetalleArticuloManufacturado> detalleArticulos = new HashSet<>();


    //Elegi un solo tipo de Articulo con tipo para evitar la jerarquia de clases, es decir menos complejidad para el tp y las busquedas
    //Imagenes y detalles estan listos para manufacturados, para insumos permanecen vacios

}
