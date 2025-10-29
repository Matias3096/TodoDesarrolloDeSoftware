package org.example.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

/*
Representa una factura
Tiene una relacion N--1 con Cliente y 1--N con FacturaDetalle
 */

@Entity
@Table(name = "FACTURA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "TOTAL", nullable = false)
    private Double total;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturaDetalle> detalles;



}
