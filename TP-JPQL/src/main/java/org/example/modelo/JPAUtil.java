package org.example.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;


public class JPAUtil {

    //Instancia unica de EntityManagerFactory (creada una sola vez)
    //Patron Singleton: solo una fabrica por aplicacion
    @Getter
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    /*
    Retorna un nuevo EntityManager a partir de la fabrica
     */
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /*
    Cierra la entityManagerFactory (Al finalizar del programa)
     */
    public static void shutdown() {
        if (entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

}
