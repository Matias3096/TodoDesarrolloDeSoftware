package org.example.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entidades.Cita;
import org.example.entidades.Medico;
import org.example.entidades.Paciente;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class CitaManager {

    private final EntityManager em;

    public CitaManager(EntityManager em) {
        this.em = em;
    }

    public Cita agendarCita(Medico medico, Paciente paciente, LocalDateTime fechaHora, double costo) {
        validarCita(medico, paciente, fechaHora, costo);

        Cita nueva = new Cita(medico, paciente, fechaHora, costo);
        em.persist(nueva);
        return nueva;
    }

    private void validarCita(Medico medico, Paciente paciente, LocalDateTime fechaHora, double costo) {
        if (medico == null || paciente == null) {
            throw new IllegalArgumentException("Médico y paciente son obligatorios");
        }

        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se puede agendar una cita en el pasado");
        }

        if (costo <= 0) {
            throw new IllegalArgumentException("El costo de la cita debe ser mayor a cero");
        }

        // Buscar citas del mismo médico (solo fechas próximas relevantes)
        TypedQuery<Cita> q = em.createQuery(
                "SELECT c FROM Cita c WHERE c.medico = :medico", Cita.class);
        q.setParameter("medico", medico);
        List<Cita> citasMismoMedico = q.getResultList();

        for (Cita existente : citasMismoMedico) {
            long minutos = Math.abs(Duration.between(existente.getFechaHora(), fechaHora).toMinutes());
            if (minutos < 120) {
                throw new IllegalArgumentException("El médico ya tiene una cita dentro de las 2 horas previas/posteriores");
            }
        }

        // (Si luego agregás sala, repetir chequeo por sala aquí)
    }
}
