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
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Paciente extends Persona {

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 300)
    private String direccion;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private HistoriaClinica historiaClinica;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();

    protected Paciente(String nombre, String apellido, String dni, java.time.LocalDate fechaNacimiento,
                       TipoSangre tipoSangre, String telefono, String direccion) {
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        this.telefono = validarString(telefono, "telefono");
        this.direccion = validarString(direccion, "direccion");
        this.citas = new ArrayList<>();
        // auto-generar historia clínica (regla crítica)
        this.historiaClinica = new HistoriaClinica(this);
    }

    public static Paciente of(String nombre, String apellido, String dni, java.time.LocalDate fechaNacimiento,
                              TipoSangre tipoSangre, String telefono, String direccion) {
        return new Paciente(nombre, apellido, dni, fechaNacimiento, tipoSangre, telefono, direccion);
    }

    // helper para mantener bidireccionalidad si agregás citas
    public void agregarCita(Cita cita) {
        if (cita == null) return;
        this.citas.add(cita);
        cita.setPaciente(this);
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }

    // validación reutilizable (mismo que en Persona) duplicada por simplicidad local
    private String validarString(String value, String campo) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        }
        return value.trim();
    }

    @Override
    public String toString() {
        return String.format(
                "[%d] %s %s (DNI: %s) - %s - Tel: %s - Dir: %s",
                getId(),
                getNombre(),
                getApellido(),
                getDni(),
                getTipoSangre(),
                getTelefono(),
                getDireccion()
        );
    }

}
