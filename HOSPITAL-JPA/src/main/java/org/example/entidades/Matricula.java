package org.example.entidades;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;

@Embeddable
@Getter
@ToString

public class Matricula {
    private static final Pattern PATTERN = Pattern.compile("MP-\\d{4,6}");

    private String numero;

    //JPA necesita constructor sin args
    protected Matricula(){}

    public Matricula(String numero){
        if(numero == null || !PATTERN.matcher(numero).matches()){
            throw new IllegalArgumentException("Matricula invalida. Debe tener formato MP-XXXX(4-6 digitos).");
        }
        this.numero = numero;
    }
}
