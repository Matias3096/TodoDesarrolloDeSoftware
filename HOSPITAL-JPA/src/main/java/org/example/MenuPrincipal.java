package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entidades.*;
import org.example.servicios.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");
        EntityManager em = emf.createEntityManager();

        MedicoDAO medicoDAO = new MedicoDAO(em);
        PacienteDAO pacienteDAO = new PacienteDAO(em);
        CitaManager citaManager = new CitaManager(em);

        Scanner sc = new Scanner(System.in);
        int opcion;

        // Cargar datos de prueba
        System.out.println("¿Cargar datos de prueba? (s/n)");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            org.example.util.DatosDePrueba.cargar(em);
        }

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN HOSPITALARIA ===");
            System.out.println("1. Registrar médico");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Agendar cita");
            System.out.println("4. Listar citas");
            System.out.println("5. Listar pacientes");
            System.out.println("6. Listar médicos");
            System.out.println("7. Listar citas por médico");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();

                    if (medicoDAO.buscarPorDni(dni) != null) {
                        System.out.println("⚠️ Ya existe un médico con ese DNI.");
                        break;
                    }

                    System.out.print("Nro Matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.println("Seleccione tipo de sangre:");
                    for (TipoSangre ts : TipoSangre.values()) {
                        System.out.println("- " + ts.name());
                    }
                    System.out.print("Tipo: ");
                    String tipoStr = sc.nextLine().toUpperCase();

                    TipoSangre tipo;
                    try {
                        tipo = TipoSangre.valueOf(tipoStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido, se asigna O_POSITIVO.");
                        tipo = TipoSangre.O_POSITIVO;
                    }

                    Medico medico = Medico.of(
                            nombre, apellido, dni,
                            LocalDate.of(1980, 1, 1),
                            tipo, matricula, EspecialidadMedica.CARDIOLOGIA
                    );

                    try {
                        medicoDAO.guardar(medico);
                        System.out.println("Médico guardado con ID " + medico.getId());
                    } catch (Exception e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();

                    if (pacienteDAO.buscarPorDni(dni) != null) {
                        System.out.println("⚠️ Ya existe un paciente con ese DNI.");
                        break;
                    }

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    System.out.println("Seleccione tipo de sangre:");
                    for (TipoSangre ts : TipoSangre.values()) {
                        System.out.println("- " + ts.name());
                    }
                    System.out.print("Tipo: ");
                    String tipoStr = sc.nextLine().toUpperCase();

                    TipoSangre tipo;
                    try {
                        tipo = TipoSangre.valueOf(tipoStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido, se asigna O_POSITIVO.");
                        tipo = TipoSangre.O_POSITIVO;
                    }

                    Paciente paciente = Paciente.of(
                            nombre, apellido, dni,
                            LocalDate.of(1990, 1, 1),
                            tipo, telefono, direccion
                    );

                    try {
                        pacienteDAO.guardar(paciente);
                        System.out.println("Paciente guardado con ID " + paciente.getId());
                    } catch (Exception e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.print("DNI del médico: ");
                    String dniM = sc.nextLine();
                    System.out.print("DNI del paciente: ");
                    String dniP = sc.nextLine();
                    Medico medico = medicoDAO.buscarPorDni(dniM);
                    Paciente paciente = pacienteDAO.buscarPorDni(dniP);

                    if (medico == null || paciente == null) {
                        System.out.println("⚠️ Médico o paciente no encontrados.");
                        break;
                    }

                    Cita cita = citaManager.agendarCita(medico, paciente, LocalDateTime.now().plusDays(1), 2000.0);
                    System.out.println("Cita creada con ID " + cita.getId());
                }

                case 4 -> {
                    System.out.println("\n=== LISTA DE CITAS ===");
                    em.createQuery("SELECT c FROM Cita c", Cita.class)
                            .getResultList()
                            .forEach(System.out::println);
                }

                case 5 -> {
                    System.out.println("\n=== LISTA DE PACIENTES ===");
                    pacienteDAO.listarTodos().forEach(System.out::println);
                }

                case 6 -> {
                    System.out.println("\n=== LISTA DE MÉDICOS ===");
                    medicoDAO.listarTodos().forEach(System.out::println);
                }

                case 7 -> {
                    System.out.print("Ingrese ID del médico: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    em.createQuery("SELECT c FROM Cita c WHERE c.medico.id = :id", Cita.class)
                            .setParameter("id", id)
                            .getResultList()
                            .forEach(System.out::println);
                }

                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        em.close();
        emf.close();
        System.out.println("Sistema finalizado.");
    }
}
