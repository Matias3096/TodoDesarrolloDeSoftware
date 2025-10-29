package org.example.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ARTICULO")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Codigo visible al usuario, no PK pero unico
    @Column(name= "CODIGO", unique = true, nullable = false, length = 20)
    private String codigo;

    @Column(name = "DENOMINACION",nullable = false, length = 200)
    private String denominacion;

    @Column(name = "PRECIOVENTA", nullable = false)
    private Double precioVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNIDADMEDIDA_ID")
    private UnidadMedida unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;
}
