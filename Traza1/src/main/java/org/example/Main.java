package org.example;

import org.example.modelo.*;

import java.time.LocalTime;

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

        //Creando una localidad (la plata)
        Localidad LaPlata = Localidad.builder()
                .id(2)
                .nombre("La Plata")
                .provincia(buenosAires)
                .build();
        buenosAires.getLocalidades().add(LaPlata);

        //Domicilio para la plata
        Domicilio domiLaPlata = Domicilio.builder()
                .id(2)
                .cp(1002)
                .numero(2002)
                .calle("Avenida Santa Fe")
                .localidad(LaPlata)
                .build();
        LaPlata.getDomicilios().add(domiLaPlata);

        //Creando Cordoba
        Provincia Cordoba = Provincia.builder()
                .id(2)
                .nombre("Cordoba")
                .pais(paisArgentina)
                .build();
        paisArgentina.getProvincias().add(Cordoba);

        //Localidad para cordoba
        Localidad cordobaCapital = Localidad.builder()
                .id(3)
                .nombre("Cordoba Capital")
                .provincia(Cordoba)
                .build();
        Cordoba.getLocalidades().add(cordobaCapital);

        //Creando un domicilio para CordobaCapital
        Domicilio domiCordobaCapital = Domicilio.builder()
                .id(3)
                .cp(1003)
                .numero(2003)
                .calle("La mona Gimenez")
                .localidad(cordobaCapital)
                .build();
        cordobaCapital.getDomicilios().add(domiCordobaCapital);

        //Creando otra localidad de cordoba

        Localidad VillaCarlozPaz = Localidad.builder()
                .id(4)
                .nombre("Villa Carlos Paz")
                .provincia(Cordoba)
                .build();
        Cordoba.getLocalidades().add(VillaCarlozPaz);

        //Creando un domicilio para Carlos Paz
        Domicilio domiCarlosP = Domicilio.builder()
                .id(4)
                .cp(1004)
                .numero(2004)
                .calle("Peatonal Cachumba")
                .localidad(VillaCarlozPaz)
                .build();
        cordobaCapital.getDomicilios().add(domiCarlosP);

        //Ahora a cruzar los dedos y crear la sucursal
        Sucursal sucursal1 = Sucursal.builder()
                .id(1)
                .nombre("Sucursal1 CABA")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilioCaba)
                .build();
        // Creando una sucursal 2 para la plata
        Sucursal sucursal2 = Sucursal.builder()
                .id(2)
                .nombre("Sucursal La Plata")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(false)
                .domicilio(domiLaPlata)
                .build();
        //Creando la sucursal 3 y penultima
        Sucursal sucursal3 = Sucursal.builder()
                .id(3)
                .nombre("Sucursal3 Cordoba capital")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(false)
                .domicilio(domiCordobaCapital)
                .build();
        //Cuarta y ultima sucursal
        Sucursal sucursal4 = Sucursal.builder()
                .id(4)
                .nombre("Sucursal Villa Carlos Paz")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(false)
                .domicilio(domiCarlosP)
                .build();
        //Creando una empresa y asociando la sucursal
        Empresa empresa = Empresa.builder()
                .id(1)
                .nombre("CuyoTecno")
                .razonSocial("CuyoTecno SRL")
                .logo("Logologo")
                .cuit(20345678902L)
                .build();
        empresa.getSucursales().add(sucursal1);
        empresa.getSucursales().add(sucursal2);

        //Creando otra empresa para sucursales 3 y 4
        Empresa empresa2 = Empresa.builder()
                .id(2)
                .nombre("CentroTecno")
                .razonSocial("CentroTecno SRL")
                .logo("Logologo")
                .cuit(20345678932L)
                .build();
        empresa.getSucursales().add(sucursal3);
        empresa.getSucursales().add(sucursal4);


        //Mostrando por pantalla
        System.out.println("Empresa: " + empresa.getNombre());
        System.out.println("Pais" + paisArgentina.getNombre());
        System.out.println("Provincia" + buenosAires.getNombre());
        System.out.println("Localidad" + LaPlata.getNombre());
        System.out.println("Domicilio" + domicilioCaba.getCalle());

    }
}