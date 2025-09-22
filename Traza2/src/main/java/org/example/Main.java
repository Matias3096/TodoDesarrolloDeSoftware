package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArticuloServicio servicio = new ArticuloServicio();

        //Creando categorias
        Categoria catPizzas = Categoria.builder()
                .id(1)
                .nombre("Pizza")
                .build();
        Categoria catSanguche = Categoria.builder()
                .id(2)
                .nombre("Sanguche")
                .build();
        Categoria catLomos = Categoria.builder()
                .id(3)
                .nombre("Lomos")
                .build();
        Categoria catInsumos = Categoria.builder()
                .id(4)
                .nombre("Insumo")
                .build();


        servicio.agregarCategoria(catPizzas);
        servicio.agregarCategoria(catSanguche);
        servicio.agregarCategoria(catLomos);
        servicio.agregarCategoria(catInsumos);

        //Unidad de medida (enum) ya estan disponibles: Kilogramos, litros, gramos

        //Creando articulos insumos: sal, aceite, carne, y harina (esParaelaborar = true)
        Articulo sal= Articulo.builder()
                .id(1)
                .nombre("Sal")
                .precio(890.0)
                .categoria(catInsumos).unidadMedida(UnidadMedida.KILOGRAMOS)
                .esParaElaborar(true).tipoArticulo(TipoArticulo.INSUMO)
                .build();

        Articulo aceite = Articulo.builder()
                .id(2)
                .nombre("Aceite")
                .precio(2900.0)
                .categoria(catInsumos).unidadMedida(UnidadMedida.LITROS)
                .esParaElaborar(true).tipoArticulo(TipoArticulo.INSUMO)
                .build();

        Articulo carne = Articulo.builder()
                .id(3)
                .nombre("Carne")
                .precio(7900.0)
                .categoria(catInsumos).unidadMedida(UnidadMedida.KILOGRAMOS)
                .esParaElaborar(true).tipoArticulo(TipoArticulo.INSUMO)
                .build();

        Articulo harina = Articulo.builder()
                .id(4)
                .nombre("Harina")
                .categoria(catInsumos).unidadMedida(UnidadMedida.KILOGRAMOS)
                .esParaElaborar(true).tipoArticulo(TipoArticulo.INSUMO)
                .build();

        servicio.agregarArticulo(sal);
        servicio.agregarArticulo(aceite);
        servicio.agregarArticulo(carne);
        servicio.agregarArticulo(harina);

        //Crear imagenes simulando flyer para el menu
        Imagen img1 = Imagen.builder().id(1).nombre("imagen 1").ruta("jamonCrudoYrucula.jpg").build();
        Imagen img2 = Imagen.builder().id(2).nombre("Imagen 2").ruta("Especial.jpg").build();
        Imagen img3 = imagen
    }
}