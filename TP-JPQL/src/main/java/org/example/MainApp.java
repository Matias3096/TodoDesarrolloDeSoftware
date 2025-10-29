package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.modelo.*;

import java.time.LocalDate;
import java.util.List;

public class MainApp {

    // === COLORES ANSI (funcionan en IntelliJ y terminales modernas) ===
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

    // === Método auxiliar para imprimir títulos de secciones ===
    private static void printSection(String title) {
        System.out.println();
        System.out.println(CYAN + "******************************************************" + RESET);
        System.out.println(BOLD + "[+]" + title.toUpperCase() + RESET);
        System.out.println(CYAN + "******************************************************" + RESET);
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        // --- CARGA INICIAL ---
        printSection("CARGA INICIAL");
        em.getTransaction().begin();
        long count = em.createQuery("SELECT COUNT(u) FROM UnidadMedida u", Long.class).getSingleResult();
        em.getTransaction().commit();

        if (count == 0) {
            DataLoader.loadInitialData(em);
            System.out.println(GREEN + " Datos iniciales cargados correctamente." + RESET);
        } else {
            System.out.println(YELLOW + " Datos ya presentes, no se recargaron." + RESET);
        }

        JPQLService service = new JPQLService(em);

        // --- 1) MANUFACTURADOS ---
        printSection("1) MANUFACTURADOS");
        List<ArticuloManufacturado> manufacturados = service.listarManufacturados();
        JPQLService.printManufacturados(manufacturados);

        // --- 2) INSUMOS CON STOCK < 60 ---
        printSection("2) INSUMOS CON STOCK < 60");
        List<ArticuloInsumo> lowStock = service.insumosConStockMenorQue(60);
        JPQLService.printInsumos(lowStock);

        // --- 3) ARTÍCULOS POR CATEGORÍA ---
        printSection("3) ARTÍCULOS POR CATEGORÍA 'INSUMOS'");
        List<Articulo> porCat = service.articulosPorCategoria("Insumos");
        JPQLService.printArticulos(porCat);

        // --- 4) ARTÍCULOS CON IMAGEN ---
        printSection("4) ARTÍCULOS CON IMAGEN");
        List<Articulo> conImg = service.articulosConImagen();
        JPQLService.printArticulos(conImg);

        // --- 5) TOTAL FACTURADO POR CLIENTE ---
        printSection("5) TOTAL FACTURADO POR CLIENTE");
        List<Object[]> totales = service.totalFacturadoPorCliente();
        JPQLService.printClientesTotales(totales);

        // --- 6) FACTURAS EN RANGO ---
        printSection("6) FACTURAS EN RANGO");
        List<Factura> facturas = service.facturasEntre(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        System.out.println("📄 Facturas encontradas: " + facturas.size());

        // --- 7) TOP ARTÍCULOS MÁS VENDIDOS ---
        printSection("7) TOP ARTÍCULOS MÁS VENDIDOS");
        List<Object[]> top = service.topArticulosMasVendidos(5);
        JPQLService.printTopArticulos(top);

        // --- 8) PROMEDIO PRECIO POR CATEGORÍA ---
        printSection("8) PROMEDIO PRECIO POR CATEGORÍA");
        List<Object[]> promedios = service.promedioPrecioPorCategoria();
        promedios.forEach(r -> System.out.printf("🔹 %s → %.2f%n", r[0], ((Number) r[1]).doubleValue()));

        // --- 9) CONTEO DE ARTÍCULOS POR CATEGORÍA ---
        printSection("9) CONTEO ARTÍCULOS POR CATEGORÍA");
        List<Object[]> conteo = service.conteoArticulosPorCategoria();
        conteo.forEach(r -> System.out.printf("📊 %s → %d%n", r[0], ((Number) r[1]).intValue()));

        // --- 10) BUSCAR ARTÍCULO POR CÓDIGO ---
        printSection("10) BUSCAR ARTÍCULO POR CÓDIGO");
        Articulo a = service.buscarArticuloPorCodigo("M001");
        System.out.println("🔎 Buscar 'M001' → " + a);

        // --- 11) AUMENTAR PRECIO POR CATEGORÍA ---
        printSection("11) AUMENTAR PRECIO POR CATEGORÍA");
        int afectados = service.aumentarPrecioVentaPorCategoria("Elaborados", 0.10);
        System.out.println(GREEN + "💲 Precios aumentados correctamente (" + afectados + " artículos)." + RESET);

        // --- 12) ARTÍCULOS SIN IMAGEN ---
        printSection("12) ARTÍCULOS SIN IMAGEN");
        List<Articulo> sinImg = service.articulosSinImagen();
        JPQLService.printArticulos(sinImg);

        // --- 13) FACTURAS CON DETALLES ---
        printSection("13) FACTURAS CON DETALLES");
        List<Factura> facturasCargadas = service.facturasConDetallesYCargados();
        System.out.println("🧾 Facturas con detalles cargadas: " + facturasCargadas.size());

        // --- FINALIZAR ---
        printSection("EJECUCIÓN FINALIZADA");
        System.out.println(GREEN + "🎉 Programa ejecutado correctamente sin errores." + RESET);

        em.close();
        JPAUtil.shutdown();
    }
}
