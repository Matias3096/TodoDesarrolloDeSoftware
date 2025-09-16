package org.example;



//Lombok

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Persona {
    private Long id;
    private String nombre, apellido;
    private LocalDate fechaNacimiento; //Decidi usar un local date en vez de un int, cosa de que se actualice solo

   public void comer(){
       System.out.println("Estoy comiendo.");
   }
   public void saludar(){
       System.out.println("Hola como estas? Mi nombre es: " + nombre + " " + apellido);
   }
   //Calcular la edad de forma dinamica
    public int getEdad(){
       if (fechaNacimiento == null) return 0;
       return Period.between(fechaNacimiento, LocalDate.now()).getYears(); //Calculo que obtiene la edad al dia de hoy


       }
}
