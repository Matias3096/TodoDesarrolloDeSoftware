package org.example.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Medico extends Persona {

    @Embedded
    private Matricula matricula;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EspecialidadMedica especialidad;

    // OneToMany con Cita (no implementada aún). Inicializar lista en constructor (evitar problemas con Lombok @SuperBuilder)
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();

    protected Medico(String nombre, String apellido, String dni, java.time.LocalDate fechaNacimiento,
                     TipoSangre tipoSangre, Matricula matricula, EspecialidadMedica especialidad) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        if (matricula == null) throw new IllegalArgumentException("Matrícula obligatoria");
        if (especialidad == null) throw new IllegalArgumentException("Especialidad obligatoria");
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.citas = new ArrayList<>();
    }

    public static Medico of(String nombre, String apellido, String dni, java.time.LocalDate fechaNacimiento,
                            TipoSangre tipoSangre, String numeroMatricula, EspecialidadMedica especialidad) {
        return new Medico(nombre, apellido, dni, fechaNacimiento, tipoSangre, new Matricula(numeroMatricula), especialidad);
    }

    // helper para mantener bidireccionalidad
    public void agregarCita(Cita cita) {
        if (cita == null) return;
        this.citas.add(cita);
        cita.setMedico(this);
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }

    @Override
    public String toString() {
        return String.format(
                "[%d] %s %s (DNI: %s) - %s - Matrícula: %s - Sangre: %s",
                getId(),
                getNombre(),
                getApellido(),
                getDni(),
                getEspecialidad(),
                getMatricula().getNumero(),
                getTipoSangre()
        );
    }

}
