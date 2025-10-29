package org.example.modelo;

import org.example.modelo.*;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;



/*
Carga inicial de datos en la base de datos usando JPA
Simula los INSERTs del script SQL del TP
 */
public class DataLoader {
    public static void loadInitialData(EntityManager em) {
        em.getTransaction().begin();

        //Unidades de medida
        UnidadMedida unidad = UnidadMedida.builder().denominacion("Unidad").build();
        UnidadMedida kg = UnidadMedida.builder().denominacion("Kg").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();


        em.persist(unidad);
        em.persist(kg);
        em.persist(litro);

        //Categorias

        Categoria catInsumos = Categoria.builder().denominacion("Insumos").esInsumo(true).build();
        Categoria catElaborados = Categoria.builder().denominacion("Elaborados").esInsumo(false).build();
        em.persist(catInsumos);
        em.persist(catElaborados);

        //Articulos
        ArticuloInsumo harina = ArticuloInsumo.builder()
                .codigo("A001")
                .denominacion("Harina")
                .precioVenta(700.0)
                .precioCompra(500.0)
                .esParaElaborar(true)
                .stockActual(100)
                .stockMaximo(300)
                .unidadMedida(kg)
                .categoria(catInsumos)
                .build();

        ArticuloInsumo queso = ArticuloInsumo.builder()
                .codigo("A002")
                .denominacion("Queso")
                .precioVenta(1500.0)
                .precioCompra(1000.0)
                .esParaElaborar(true)
                .stockActual(50)
                .stockMaximo(200)
                .unidadMedida(kg)
                .categoria(catInsumos)
                .build();

        ArticuloManufacturado pizza = ArticuloManufacturado.builder()
                .codigo("M001")
                .denominacion("Pizza Muzarella")
                .precioVenta(4500.0)
                .descripcion("Pizza Clasica con queso muzzarella")
                .preparacion("Hornear 15 minutos a 200°C")
                .tiempoEstimadoMinutos(15)
                .unidadMedida(unidad)
                .categoria(catElaborados)
                .build();
        em.persist(harina);
        em.persist(queso);
        em.persist(pizza);

        //Clientes

        Cliente juan = Cliente.builder()
                .nombre("Juan")
                .apellido("Perez")
                .email("Juan.perez@gmail.com")
                .build();

        Cliente maria = Cliente.builder()
                .nombre("Maria")
                .apellido("Sosa")
                .email("mariasosa@gmail.com")
                .build();

        em.persist(juan);
        em.persist(maria);


        //Facturas
        Factura factura1 = Factura.builder()
                .fecha(LocalDate.now())
                .total(9000.1)
                .cliente(juan)
                .build();
        em.persist(factura1);

        //Detalles
        FacturaDetalle det1 = FacturaDetalle.builder()
                .cantidad(2)
                .subtotal(9000.1)
                .factura(factura1)
                .articulo(pizza)
                .build();

        em.persist(det1);

        //Imagenes
        Imagen imgPizza = Imagen.builder()
                .url("https://www.freepik.es/fotos-vectores-gratis/pizza")
                .articulo(pizza)
                .build();

        em.persist(imgPizza);

        em.getTransaction().commit();
        System.out.println("Datos iniciales cargados correctamente");
    }

}
