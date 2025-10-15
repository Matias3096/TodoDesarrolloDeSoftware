package org.example.util;

import jakarta.persistence.EntityManager;
import org.example.entidades.*;
import org.example.servicios.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class DatosDePrueba {

    public static void cargar(EntityManager em) {
        MedicoDAO medicoDAO = new MedicoDAO(em);
        PacienteDAO pacienteDAO = new PacienteDAO(em);
        CitaManager citaManager = new CitaManager(em);

        Random rnd = new Random();
        String[] nombres = {"Juan", "Ana", "Carlos", "Lucía", "María", "José"};
        String[] apellidos = {"Pérez", "González", "López", "Fernández", "Ramírez"};

        // Crear 3 médicos
        for (int i = 0; i < 3; i++) {
            Medico m = Medico.of(
                    nombres[rnd.nextInt(nombres.length)],
                    apellidos[rnd.nextInt(apellidos.length)],
                    generarDniValido(),
                    LocalDate.of(1980 + rnd.nextInt(10), 1 + rnd.nextInt(12), 1 + rnd.nextInt(28)),
                    TipoSangre.values()[rnd.nextInt(TipoSangre.values().length)],
                    "MP-" + (1000 + i),
                    EspecialidadMedica.values()[rnd.nextInt(EspecialidadMedica.values().length)]
            );
            medicoDAO.guardar(m);
        }

        // Crear 5 pacientes
        for (int i = 0; i < 5; i++) {
            Paciente p = Paciente.of(
                    nombres[rnd.nextInt(nombres.length)],
                    apellidos[rnd.nextInt(apellidos.length)],
                    generarDniValido(),
                    LocalDate.of(1990 + rnd.nextInt(10), 1 + rnd.nextInt(12), 1 + rnd.nextInt(28)),
                    TipoSangre.values()[rnd.nextInt(TipoSangre.values().length)],
                    "261" + (100000 + rnd.nextInt(899999)),
                    "Dirección " + (i + 1)
            );
            pacienteDAO.guardar(p);
        }

        // Crear 3 citas aleatorias
        var medicos = medicoDAO.listarTodos();
        var pacientes = pacienteDAO.listarTodos();
        for (int i = 0; i < 3; i++) {
            citaManager.agendarCita(
                    medicos.get(rnd.nextInt(medicos.size())),
                    pacientes.get(rnd.nextInt(pacientes.size())),
                    LocalDateTime.now().plusDays(1 + rnd.nextInt(10)),
                    1000 + rnd.nextInt(2000)
            );
        }

        System.out.println("✅ Datos de prueba cargados correctamente.");
    }

    // Genera un DNI numérico válido (7 u 8 dígitos)
    private static String generarDniValido() {
        int dni = 10_000_000 + (int) (Math.random() * 90_000_000);
        return String.valueOf(dni);
    }
}
