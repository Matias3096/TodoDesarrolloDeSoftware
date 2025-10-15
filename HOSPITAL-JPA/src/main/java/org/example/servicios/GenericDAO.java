package org.example.servicios;

import jakarta.persistence.EntityManager;
import java.util.List;

public class GenericDAO<T> {
    protected final EntityManager em;
    private final Class<T> tipo;

    public GenericDAO(EntityManager em, Class<T> tipo) {
        this.em = em;
        this.tipo = tipo;
    }

    public void guardar(T entidad) {
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    public T buscarPorId(Long id) {
        return em.find(tipo, id);
    }

    public List<T> listarTodos() {
        return em.createQuery("SELECT e FROM " + tipo.getSimpleName() + " e", tipo)
                .getResultList();
    }

    public void eliminar(Long id) {
        em.getTransaction().begin();
        T entidad = buscarPorId(id);
        if (entidad != null) em.remove(entidad);
        em.getTransaction().commit();
    }
}
