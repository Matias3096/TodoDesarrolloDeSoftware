package org.example.modelo;

import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;

/*
Imagen asociada a un articulo(URL o Ruta)
 */

@Entity
@Table(name = "IMAGEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "URL", nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICULO_ID")
    private Articulo articulo;
}
