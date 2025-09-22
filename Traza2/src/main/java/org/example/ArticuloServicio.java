package org.example;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Collectors;

public class ArticuloServicio {

    private final Set<Categoria> categorias = new HashSet<>();
    private final Map<Integer, Articulo> articulos = new HashMap<>();

    //Agregar categoria
    public void agregarCategoria(Categoria c) {
        if (c!=null)
            this.categorias.add(c);
    }

    //Agregar articulo (insumo o manufacturado)
    public void agregarArticulo(Articulo a) {
        if (a!=null && a.getId()!=null) {
            this.articulos.put(a.getId(), a);
        }
    }

    //Mostrar todas las categorias
    public void mostrarCategorias() {
        System.out.println("======Categorias======");
        if (categorias.isEmpty()){
            System.out.println("No Categorias");
            return;
        }
        categorias.forEach(c-> System.out.println("ID: "+c.getId()+" Nombre: "+c.getNombre()));
    }
    public void mostrarInsumos() {
        System.out.println("======Insumos======");
        List<Articulo> insumos = articulos.values().stream()
                .filter( a-> a.getTipo () == TipoArticulo.INSUMO)
                .collect(Collectors.toList());
        if (insumos.isEmpty()){
            System.out.println("No Insumos registrados");
            return;
        }
        insumos.forEach(a-> System.out.println("ID: "+a.getId()+
                " Nombre: "+a.getNombre() + "|Unidad: " + a.getUnidadMedida()
                + "|Es para elaborar: " + a.getEsParaElaborar()));
    }

    //Mostrar todos los articulos que son manufacturados
    public void mostrarManufacturados() {
        System.out.println("======Manufacturados======");
        List<Articulo> man = articulos.values().stream()
                .filter(a-> a.getTipo() == TipoArticulo.MANUFACTURADO
                        .collect(Collectors.toList()));
        if (man.isEmpty()){
            System.out.println("No Manufacturados registrados");
            return;
        }
        man.forEach(this::mostrarDetalleArticulo);
    }

    //Buscar manufacturado por id
    public Articulo buscarManufacturadoPorId(Integer id) {
        Articulo a = articulos.get(id);
        if (a!=null && a.getTipo() == TipoArticulo.MANUFACTURADO)
            return a;
        return null;
    }

    //Actualizar manufacturado (por ejemplo: por nombre y precio)
    public boolean actualizarManufacturado(Integer id, String nuevoNombre, Double nuevoPrecio) {
        Articulo a = buscarManufacturadoPorId(id);
        if (a == null) return false;
        if (nuevoNombre==null && !nuevoNombre.isBlank()) a.setNombre(nuevoNombre);
        if(nuevoPrecio != null ) a.setPrecio(nuevoPrecio);
        return true;
    }
    //Eliminar manufacturado por id
    public boolean eliminarManufacturado(Integer id) {
        Articulo a = articulos.get(id);
        if (a==null || a.getTipo() != TipoArticulo.MANUFACTURADO) return false;
        articulos.remove(id);
        return true;
    }

    //Creimos util mostrar detalle completo de un articulo para manufacturarlos
    public void mostrarDetalleArticulo(Articulo a) {
        if (a==null) return;
        System.out.println("------------------");
        System.out.println("ID: "+a.getId()+" Nombre: "+a.getNombre() + "|$ " + a.getPrecio());
        System.out.println("Categoria" + (a.getCategoria()!=null?a.getCategoria().getNombre():" Sin categoria");
        System.out.println("Unidad: " + a.getUnidadMedida());
        System.out.println("Tipo: " + a.getTipo());
        if (!a.getImagenes().isEmpty()) {
            System.out.println("Imagenes: ");
            a.getImagenes().forEach(image -> System.out.println("Imagen: " + image.getNombre() +
                    "(" + image.getRuta()")"));
        }
        if (!a.getDetalleArticulos().isEmpty()){
            System.out.println("Detalle Articulos(Insumo -cantidad): ");
            a.getDetalleArticulos().forEach(d->
                    System.out.println(" - " + d.getInsumo()
                            .getNombre() +
                            " (" + d.getCantidad() + ")")
            );
        }
        System.out.println("____________________________");
    }
}

//esta clase centraliza datos y operaciones, Usamos Map<Integer, Articulo>
// para acceso rapido por id.
// MostrarInsumos, mostrarManufacturados, buscarManufacturadosPorId, actualizar,
// eliminar, respetan lo pedido del tp
