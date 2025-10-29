package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entidades.Medico;

public class MedicoDAO extends GenericDAO<Medico> {
    public MedicoDAO(EntityManager em) {
        super(em, Medico.class);
    }

    public Medico buscarPorDni(String dni) {
        try {
            return em.createQuery("SELECT m FROM Medico m WHERE m.dni = :dni", Medico.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void guardar(Medico medico) {  //Mejora agregada, para no repetir dni
        if (buscarPorDni(medico.getDni()) != null) {
            throw new IllegalArgumentException("Ya existe un médico con el DNI " + medico.getDni());
        }
        super.guardar(medico);
    }
}
