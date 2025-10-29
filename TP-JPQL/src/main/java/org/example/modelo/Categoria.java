package org.example.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "CATEGORIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DENOMINACION", nullable = false, length =150 )
    private String denominacion;

    @Column ( name = "ESINSUMO", nullable = false)
    private Boolean esInsumo;
}
