package org.example.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"medico", "paciente"})
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false)
    private double costo;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    public Cita(Medico medico, Paciente paciente, LocalDateTime fechaHora, double costo) {
        if (medico == null || paciente == null)
            throw new IllegalArgumentException("Médico y paciente son obligatorios");

        if (fechaHora == null || fechaHora.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("La cita no puede ser en el pasado");

        if (costo <= 0)
            throw new IllegalArgumentException("El costo debe ser mayor que cero");

        this.medico = medico;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
        this.costo = costo;
        this.estado = EstadoCita.PENDIENTE;

        // Actualizamos las relaciones bidireccionales
        medico.agregarCita(this);
        paciente.agregarCita(this);
    }

    public boolean seSuperponeCon(Cita otra) {
        if (otra == null) return false;
        long diff = Math.abs(Duration.between(this.fechaHora, otra.fechaHora).toMinutes());
        return diff < 120; // menos de 2 horas
    }

    @Override
    public String toString() {
        return String.format(
                "[%d] %s | Dr. %s %s → %s %s | $%.2f | Estado: %s",
                getId(),
                getFechaHora(),
                getMedico() != null ? getMedico().getApellido() : "N/A",
                getMedico() != null ? getMedico().getNombre() : "",
                getPaciente() != null ? getPaciente().getApellido() : "N/A",
                getPaciente() != null ? getPaciente().getNombre() : "",
                getCosto(),
                getEstado()
        );
    }


}
