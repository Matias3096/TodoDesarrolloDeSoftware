package org.example.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class JPQLService {

    private final EntityManager em;

    public JPQLService(EntityManager em) {
        this.em = em;
    }

    //consulta 1: Listar manufacturados
    //Lista todos los articulosManufacturado
    //JPQL: selecciona por la entidad concreta(polimorfismo)

    public List<ArticuloManufacturado> listarManufacturados(){
        String jpql = "SELECT a FROM ArticuloManufacturado a";
        TypedQuery<ArticuloManufacturado> q = em.createQuery(jpql, ArticuloManufacturado.class);
        return q.getResultList();
    }

    //consulta 2: insumos con stock menor a un umbral
    //devuelve ArticuloInsumo cuyo stockActual < threshold
    //util para gestionar reposiciones
    public List<ArticuloInsumo> insumosConStockMenorQue(int threshold) {
        String jpql = "SELECT a FROM ArticuloInsumo a WHERE a.stockActual < :umbral";
        TypedQuery<ArticuloInsumo> q = em.createQuery(jpql, ArticuloInsumo.class);
        q.setParameter("umbral", threshold);
        return q.getResultList();
    }

    //consulta 3: articulos por categoria( por nombre de categoria)
    //busca articulos cuya categoria.denominacion coincide(case-sensitive)
    //Usa LOWER(..) para busquedas case-insensitive si se quiere

    public List<Articulo> articulosPorCategoria(String nombreCategoria) {
        String jpql = "SELECT a FROM Articulo a WHERE a.categoria.denominacion = :nom";
        TypedQuery<Articulo> q = em.createQuery(jpql, Articulo.class);
        q.setParameter("nom", nombreCategoria);
        return q.getResultList();
    }

    //Consulta 4: articulos con imagenes (JOIN)
    //Lista pares(Articulo, imagen) - en JPQL devolvemos la entidad Imagen o articulo segun convenga
    //Aqui devolvemos Articulo que tienen al menos una imagen

    public  List<Articulo> articulosConImagen(){
        String jpql = "SELECT DISTINCT i.articulo FROM Imagen i";
        TypedQuery<Articulo> q  = em.createQuery(jpql, Articulo.class);
        return q.getResultList();
    }

    /*
    Consulta 5: clientes con facturas y total facturado
    Devuelve lista de Object[]: [Cliente, SUM(f.total)] agrupando por cliente.
     En caso de solo querer  clientes con total > X, filtrar con HAVING.
     */
    public List<Object[]> totalFacturadoPorCliente() {
        String jpql = "SELECT f.cliente, SUM(f.total) FROM Factura f GROUP BY f.cliente";
        TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
        return q.getResultList();
    }

    // CONSULTA 6: facturas en un rango de fechas
    public List<Factura> facturasEntre(LocalDate desde, LocalDate hasta) {
        String jpql = "SELECT f FROM Factura f WHERE f.fecha BETWEEN :desde AND :hasta";
        TypedQuery<Factura> q = em.createQuery(jpql, Factura.class);
        q.setParameter("desde", desde);
        q.setParameter("hasta", hasta);
        return q.getResultList();
    }

    /*
     CONSULTA 7: top N artículos más vendidos (por cantidad sumada en FacturaDetalle)
     Devuelve Object[]: [Articulo, SUM(det.cantidad)] ordenado desc por cantidad total.
     */
    public List<Object[]> topArticulosMasVendidos(int topN) {
        String jpql = "SELECT d.articulo, SUM(d.cantidad) FROM FacturaDetalle d " +
                "GROUP BY d.articulo ORDER BY SUM(d.cantidad) DESC";
        TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
        q.setMaxResults(topN);
        return q.getResultList();
    }

    // CONSULTA 8: promedio de precio por categoría
    public List<Object[]> promedioPrecioPorCategoria() {
        String jpql = "SELECT a.categoria.denominacion, AVG(a.precioVenta) FROM Articulo a GROUP BY a.categoria.denominacion";
        TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
        return q.getResultList();
    }

    // CONSULTA 9: conteo de artículos por categoría
    public List<Object[]> conteoArticulosPorCategoria() {
        String jpql = "SELECT a.categoria.denominacion, COUNT(a) FROM Articulo a GROUP BY a.categoria.denominacion";
        TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
        return q.getResultList();
    }

    // CONSULTA 10: buscar artículo por código (parametrizado)
    public Articulo buscarArticuloPorCodigo(String codigo) {
        String jpql = "SELECT a FROM Articulo a WHERE a.codigo = :cod";
        TypedQuery<Articulo> q = em.createQuery(jpql, Articulo.class);
        q.setParameter("cod", codigo);
        List<Articulo> res = q.getResultList();
        return res.isEmpty() ? null : res.get(0);
    }

    /* CONSULTA 11: actualización masiva de precios (UPDATE)
        Aumenta el precio de venta en un porcentaje (por ejemplo 0.10 para +10%).
        Importante: JPQL UPDATE devuelve número de filas afectadas.
     */
    public int aumentarPrecioVentaPorCategoria(String denomCategoria, double porcentaje) {
        em.getTransaction().begin();

        String jpql = """
        UPDATE Articulo a
        SET a.precioVenta = a.precioVenta * (1.0 + :pct)
        WHERE a.categoria.denominacion = :cat
        """;

        Query q = em.createQuery(jpql);
        q.setParameter("pct", porcentaje);
        q.setParameter("cat", denomCategoria);

        int afectados = q.executeUpdate();
        em.getTransaction().commit();

        System.out.println("✅ Precios actualizados (" + afectados + " artículos).");
        return afectados;
    }


    // CONSULTA 12: eliminar artículo por código (DELETE)
    public int eliminarArticuloPorCodigo(String codigo) {
        em.getTransaction().begin();
        String jpql = "DELETE FROM Articulo a WHERE a.codigo = :cod";
        Query q = em.createQuery(jpql);
        q.setParameter("cod", codigo);
        int afectados = q.executeUpdate();
        em.getTransaction().commit();
        return afectados;
    }

    /*
    CONSULTA 13: subconsulta / EXISTS — artículos que no tienen imagen.
    Encuentra artículos para los cuales NO existe una Imagen asociada.
     */
    public List<Articulo> articulosSinImagen() {
        String jpql = "SELECT a FROM Articulo a WHERE NOT EXISTS (SELECT i FROM Imagen i WHERE i.articulo = a)";
        TypedQuery<Articulo> q = em.createQuery(jpql, Articulo.class);
        return q.getResultList();
    }

    /*
     CONSULTA 14: ejemplo JOIN FETCH para evitar N+1 (traer factura con detalles y artículos)
     Muestra cómo recuperar facturas junto a sus detalles y artículos en una sola consulta.
     Usamos DISTINCT para evitar duplicados cuando hay multiples detalles.
     */
    public List<Factura> facturasConDetallesYCargados() {
        String jpql = "SELECT DISTINCT f FROM Factura f LEFT JOIN FETCH f.detalles d LEFT JOIN FETCH d.articulo";
        TypedQuery<Factura> q = em.createQuery(jpql, Factura.class);
        return q.getResultList();
    }

    // Métodos utilitarios de impresión (para MainApp)
    public static void printArticulos(List<Articulo> list) {
        System.out.println("---- ARTICULOS (" + list.size() + ") ----");
        list.forEach(a -> System.out.println(a));
    }

    public static void printInsumos(List<ArticuloInsumo> list) {
        System.out.println("---- INSUMOS (" + list.size() + ") ----");
        list.forEach(i -> System.out.println(i));
    }

    public static void printManufacturados(List<ArticuloManufacturado> list) {
        System.out.println("---- MANUFACTURADOS (" + list.size() + ") ----");
        list.forEach(m -> System.out.println(m));
    }

    public static void printClientesTotales(List<Object[]> rows) {
        System.out.println("---- CLIENTE - TOTALFACTURADO ----");
        rows.forEach(r -> {
            Cliente c = (Cliente) r[0];
            Number total = (Number) r[1];
            System.out.printf("%s %s -> %.2f%n", c.getNombre(), c.getApellido(), total.doubleValue());
        });
    }

    public static void printTopArticulos(List<Object[]> rows) {
        System.out.println("---- TOP ARTICULOS ----");
        rows.forEach(r -> {
            Articulo a = (Articulo) r[0];
            Number qty = (Number) r[1];
            System.out.printf("%s (%s) -> qty=%d%n", a.getDenominacion(), a.getCodigo(), qty.intValue());
        });
    }
}
