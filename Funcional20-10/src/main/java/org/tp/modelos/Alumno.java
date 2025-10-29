package org.tp.modelos;


import lombok.*;
import org.gradle.api.Generated;
import org.w3c.dom.Entity;
//Value crea:  private final fields, getters, all-args constructor,
// * equals/hashCode, toString. Ideal para modelo inmutable en programas funcionales.

@Value
public class Alumno {
   String nombre;
   double nota;
   String curso;

}
