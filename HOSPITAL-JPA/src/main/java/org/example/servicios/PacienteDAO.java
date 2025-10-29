package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entidades.Paciente;

public class PacienteDAO extends GenericDAO<Paciente> {
    public PacienteDAO(EntityManager em) {
        super(em, Paciente.class);
    }

    public Paciente buscarPorDni(String dni) {
        try {
            return em.createQuery("SELECT p FROM Paciente p WHERE p.dni = :dni", Paciente.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void guardar(Paciente paciente) {
        if (buscarPorDni(paciente.getDni()) != null) {
            throw new IllegalArgumentException("Ya existe un paciente con el DNI " + paciente.getDni());
        }
        super.guardar(paciente);
    }
}

