package org.example;

import org.example.modelo.*;

import java.time.LocalTime;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //Crear un pais con builder
        Pais paisArgentina = Pais.builder()
                .id(1)
                .nombre("Argentina")
                .build();

        //Creando una provincia para luego relacionarla con un pais
        Provincia buenosAires= Provincia.builder()
                .nombre("Buenos Aires")
                .pais(paisArgentina)
                .build();
        paisArgentina.getProvincias().add(buenosAires);

        //Creando una localidad de Buenos Aires
        Localidad caba = Localidad.builder()
                .id(1)
                .nombre("CABA")
                .provincia(buenosAires)
                .build();
        buenosAires.getLocalidades().add(caba);
        

        //Creando un domicilio para Caba
        Domicilio domicilioCaba = Domicilio.builder()
                .id(1)
                .cp(1001)
                .numero(2001)
                .calle("Burgos")
                .localidad(caba)
                .build();
        caba.getDomicilios().add(domicilioCaba);

        //Ahora a cruzar los dedos y crear la sucursal
        Sucursal sucursal1 = Sucursal.builder()
                .id(1)
                .nombre("Sucursal1 CABA")
                .horarioApertura(LocalTime.of(8, 0))
                
                .build();

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