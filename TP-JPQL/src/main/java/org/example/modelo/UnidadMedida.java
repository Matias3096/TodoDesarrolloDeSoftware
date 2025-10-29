package org.example.modelo;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.io.Serializable;

@Entity
@Table(name = "UNIDADMEDIDA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder



public class UnidadMedida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //En el script SQL se llama DENOMINACION
    @Column(name = "DENOMINACION", nullable = false,unique = true, length = 100)
    private String denominacion;

}
