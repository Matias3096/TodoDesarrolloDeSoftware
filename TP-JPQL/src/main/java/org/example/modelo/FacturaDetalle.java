package org.example.modelo;

import jakarta.persistence.*;
import lombok.*;

/*
Detalle de factura: cantidad, subtotal y articulo vinculado
 */

@Entity
@Table(name = "FACTURADETALLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FacturaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "SUBTOTAL", nullable = false)
    private Double subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACTURA_ID")
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICULO_ID")
    private Articulo articulo;
}
