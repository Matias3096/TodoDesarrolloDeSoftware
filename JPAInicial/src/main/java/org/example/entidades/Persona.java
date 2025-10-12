package org.example.entidades;


import jakarta.persistence.*;

@Entity
@Table (name = "persona_tabla")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;
    @Column(name = "nombre_persona")
    private String nombre;
}
