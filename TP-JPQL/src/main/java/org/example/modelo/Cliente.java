package org.example.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

// Un cliente tiene muchas facturas

@Entity
@Table(name = "CLIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name ="APELLIDO", nullable = false, length = 100)
    private String apellido;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;
}
