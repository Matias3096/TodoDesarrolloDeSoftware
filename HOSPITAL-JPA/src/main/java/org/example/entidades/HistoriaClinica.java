package org.example.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historias_clinicas")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "paciente")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private Paciente paciente;

    @ElementCollection
    @CollectionTable(name = "historial_diagnosticos", joinColumns = @JoinColumn(name = "historia_id"))
    @Column(name = "diagnostico")
    private List<String> diagnosticos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "historial_tratamientos", joinColumns = @JoinColumn(name = "historia_id"))
    @Column(name = "tratamiento")
    private List<String> tratamientos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "historial_alergias", joinColumns = @JoinColumn(name = "historia_id"))
    @Column(name = "alergia")
    private List<String> alergias = new ArrayList<>();

    private LocalDateTime fechaCreacion;

    public HistoriaClinica(Paciente paciente) {
        if (paciente == null) throw new IllegalArgumentException("Paciente obligatorio para la historia clínica");
        this.paciente = paciente;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void agregarDiagnostico(String diag) {
        if (diag != null && !diag.isBlank()) diagnosticos.add(diag.trim());
    }

    public void agregarTratamiento(String trat) {
        if (trat != null && !trat.isBlank()) tratamientos.add(trat.trim());
    }

    public void agregarAlergia(String alergia) {
        if (alergia != null && !alergia.isBlank()) alergias.add(alergia.trim());
    }
}
