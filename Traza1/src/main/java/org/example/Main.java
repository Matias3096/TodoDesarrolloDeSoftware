package org.example;

import org.example.modelo.*;

import java.time.LocalTime;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //Crear un pais
        Pais paisArgentina = new Pais(1,"Argentina", new HashSet<>());

        //Creando una provincia para luego relacionarla con un pais
        Provincia buenosAires= new Provincia(1,"Buenos Aires", paisArgentina, new HashSet<>());

        //Creando una localidad de Buenos Aires
        Localidad caba = new Localidad(1,"Caba",buenosAires, new HashSet<>());
        buenosAires.getLocalidades().add(caba);
        

        //Creando un domicilio para Caba
        Domicilio domicilioCaba = new Domicilio(1,5573,123,"C100",caba);
        caba.getDomicilios().add(domicilioCaba);

        //Ahora a cruzar los dedos y crear la sucursal
        Sucursal sucursal1 = new Sucursal(1, "Sucursal CABA", LocalTime.of(9,0), LocalTime.of(18,0),true, domicilioCaba);

        //Creando una localidad (la plata)
        Localidad LaPlata = new Localidad(2,"La plata", buenosAires, new HashSet<>());

        //Domicilio para la plata
        Domicilio domiLaPlata = new Domicilio(1,3344,123,"AV santa fe",LaPlata);

        //Creando Cordoba
        Provincia Cordoba = new Provincia(2,"Córdoba ", paisArgentina, new HashSet<>());

        //Localidad para cordoba
        Localidad cordobaCapital = new Localidad(1,"Cordoba Capital",Cordoba, new HashSet<>());

    }
}