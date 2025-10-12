//import chainofresponsibility.*;
import ChainofResponsibility.Asistente;
import ChainofResponsibility.Coordinador;
import ChainofResponsibility.Profesor;
import ChainofResponsibility.Solicitud;
import command.*;
import iterator.*;
import mediator.*;
import memento.*;
import observer.*;
import state.*;
import strategy.*;
//import templatemethod.*;
import visitor.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("      SISTEMA DE PLATAFORMA DE APRENDIZAJE EN LÍNEA");
        System.out.println("           Demostración de Patrones de Comportamiento");
        System.out.println("=".repeat(80));

        // ===============================================
        // 1. CHAIN OF RESPONSIBILITY
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  1. CHAIN OF RESPONSIBILITY - Sistema de Solicitud de Tutorías           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: chainofresponsibility/");
        System.out.println("Propósito: Pasar solicitudes a través de una cadena de manejadores.");
        System.out.println("Uso: Sistema multinivel de soporte técnico académico.\n");

        demonstrarChainOfResponsibility();

        esperarTecla();

        // ===============================================
        // 2. COMMAND
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  2. COMMAND - Sistema de Gestión de Cursos                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: command/");
        System.out.println("Propósito: Convertir solicitudes en objetos independientes con historial.");
        System.out.println("Uso: Inscripciones, abandonos y solicitudes con funcionalidad undo.\n");

        demonstrarCommand();

        esperarTecla();

        // ===============================================
        // 3. ITERATOR
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  3. ITERATOR - Recorrido de Cursos Inscritos                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: iterator/");
        System.out.println("Propósito: Recorrer colecciones sin exponer su estructura interna.");
        System.out.println("Uso: Navegar por lista de cursos de un estudiante.\n");

        demonstrarIterator();

        esperarTecla();

        // ===============================================
        // 4. MEDIATOR
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  4. MEDIATOR - Sistema de Mensajería Interna                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: mediator/");
        System.out.println("Propósito: Reducir dependencias entre objetos mediante un mediador central.");
        System.out.println("Uso: Chat entre estudiantes y profesores.\n");

        demonstrarMediator();

        esperarTecla();

        // ===============================================
        // 5. MEMENTO
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  5. MEMENTO - Guardado de Progreso de Examen                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: memento/");
        System.out.println("Propósito: Guardar y restaurar estado de objetos sin violar encapsulamiento.");
        System.out.println("Uso: Sistema de autoguardado de exámenes en línea.\n");

        demonstrarMemento();

        esperarTecla();

        // ===============================================
        // 6. OBSERVER
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  6. OBSERVER - Sistema de Notificaciones de Curso                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: observer/");
        System.out.println("Propósito: Notificar automáticamente a múltiples observadores de cambios.");
        System.out.println("Uso: Avisos de cambios de horario y publicaciones de curso.\n");

        demonstrarObserver();

        esperarTecla();

        // ===============================================
        // 7. STATE
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  7. STATE - Estados de Inscripción a Curso                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: state/");
        System.out.println("Propósito: Cambiar comportamiento de un objeto según su estado interno.");
        System.out.println("Uso: Gestión de estados de inscripción (Inscrito, En Espera, Cancelado).\n");

        demonstrarState();

        esperarTecla();

        // ===============================================
        // 8. STRATEGY
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  8. STRATEGY - Cálculo de Notas Finales                                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: strategy/");
        System.out.println("Propósito: Definir familia de algoritmos intercambiables.");
        System.out.println("Uso: Diferentes métodos de cálculo de calificaciones.\n");

        demonstrarStrategy();

        esperarTecla();

        // ===============================================
        // 9. TEMPLATE METHOD
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  9. TEMPLATE METHOD - Generación de Reportes Académicos                  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: templatemethod/");
        System.out.println("Propósito: Definir estructura de algoritmo, permitiendo pasos personalizados.");
        System.out.println("Uso: Reportes con estructura común pero contenido específico.\n");

        demonstrarTemplateMethod();

        esperarTecla();

        // ===============================================
        // 10. VISITOR
        // ===============================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  10. VISITOR - Sistema de Becas y Descuentos                             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Patrón implementado en: visitor/");
        System.out.println("Propósito: Agregar operaciones a objetos sin modificar sus clases.");
        System.out.println("Uso: Aplicar diferentes cálculos a distintos tipos de alumnos.\n");

        demonstrarVisitor();

        // ===============================================
        // FINALIZACIÓN
        // ===============================================
        System.out.println("\n\n" + "=".repeat(80));
        System.out.println("                    ✅ DEMOSTRACIÓN COMPLETADA");
        System.out.println("=".repeat(80));
        System.out.println("Todos los patrones de comportamiento han sido implementados exitosamente.");
        System.out.println("Revisa el código fuente para entender cada implementación en detalle.");
        System.out.println("=".repeat(80) + "\n");
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 1: Chain of Responsibility
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarChainOfResponsibility() {
        System.out.println("🔗 Configurando cadena de responsabilidad...\n");

        // Crear los manejadores
        Handler asistente = new Asistente();
        Handler profesor = new Profesor();
        Handler coordinador = new Coordinador();

        // Configurar la cadena
        asistente.setSiguiente(profesor);
        profesor.setSiguiente(coordinador);

        // Crear solicitudes de diferentes niveles
        Solicitud solicitud1 = new Solicitud("Juan Pérez",
                "¿Cómo accedo a la plataforma?", 1);
        Solicitud solicitud2 = new Solicitud("María García",
                "Necesito ayuda con algoritmos de ordenamiento", 2);
        Solicitud solicitud3 = new Solicitud("Carlos López",
                "Quiero desarrollar un proyecto de investigación", 3);

        // Procesar solicitudes
        System.out.println("📨 Procesando solicitudes:\n");
        asistente.manejarSolicitud(solicitud1);
        asistente.manejarSolicitud(solicitud2);
        asistente.manejarSolicitud(solicitud3);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 2: Command
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarCommand() {
        System.out.println("💻 Iniciando sistema de comandos...\n");

        // Crear receptor (alumno)
        Alumno alumno = new Alumno("Ana Martínez");

        // Crear invoker (plataforma)
        PlataformaEducativa plataforma = new PlataformaEducativa();

        // Crear comandos
        Command inscribirJava = new InscribirseCursoCommand(alumno, "Programación Java");
        Command inscribirPython = new InscribirseCursoCommand(alumno, "Python Avanzado");
        Command inscribirBD = new InscribirseCursoCommand(alumno, "Bases de Datos");
        Command abandonarPython = new AbandonarCursoCommand(alumno, "Python Avanzado");
        Command certificadoJava = new SolicitarCertificadoCommand(alumno, "Programación Java");

        // Ejecutar comandos
        System.out.println("📚 Ejecutando operaciones:\n");
        plataforma.ejecutarComando(inscribirJava);
        plataforma.ejecutarComando(inscribirPython);
        plataforma.ejecutarComando(inscribirBD);

        plataforma.mostrarHistorial();

        System.out.println("📊 Estado actual de cursos:");
        System.out.println("   Inscritos: " + alumno.getCursosInscritos() + "\n");

        // Abandonar un curso
        plataforma.ejecutarComando(abandonarPython);

        // Solicitar certificado
        plataforma.ejecutarComando(certificadoJava);

        // Deshacer último comando
        System.out.println("\n🔙 Deshaciendo último comando:");
        plataforma.deshacerUltimoComando();

        plataforma.mostrarHistorial();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 3: Iterator
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarIterator() {
        System.out.println("📚 Creando colección de cursos...\n");

        // Crear alumno con cursos
        AlumnoConCursos alumno = new AlumnoConCursos("Roberto Sánchez");

        // Agregar cursos
        alumno.agregarCurso(new Curso("CS101", "Introducción a la Programación", 4));
        alumno.agregarCurso(new Curso("CS201", "Estructuras de Datos", 5));
        alumno.agregarCurso(new Curso("CS301", "Algoritmos Avanzados", 5));
        alumno.agregarCurso(new Curso("MAT101", "Matemáticas Discretas", 4));

        System.out.println("\n🔄 Iterando sobre los cursos inscritos:\n");

        // Obtener iterator y recorrer
        CursoIterator iterator = alumno.crearIterator();

        int totalCreditos = 0;
        int contador = 1;

        while (iterator.hasNext()) {
            Curso curso = iterator.next();
            System.out.println("   " + contador + ". " + curso);
            totalCreditos += curso.getCreditos();
            contador++;
        }

        System.out.println("\n📊 Resumen:");
        System.out.println("   Total de cursos: " + alumno.getCantidadCursos());
        System.out.println("   Total de créditos: " + totalCreditos);

        // Recorrer de nuevo (demostrar reset)
        System.out.println("\n🔄 Recorriendo nuevamente (solo nombres):");
        iterator.reset();
        while (iterator.hasNext()) {
            System.out.println("   • " + iterator.next().getNombre());
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 4: Mediator
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarMediator() {
        System.out.println("💬 Configurando sala de chat...\n");

        // Crear mediator
        ChatMediator chatRoom = new ChatRoom();

        // Crear usuarios
        Usuario estudiante1 = new Estudiante(chatRoom, "Laura");
        Usuario estudiante2 = new Estudiante(chatRoom, "Diego");
        Usuario estudiante3 = new Estudiante(chatRoom, "Sofia");
        Usuario profesor1 = new ProfesorMediator(chatRoom, "Dr. Fernández");
        Usuario profesor2 = new ProfesorMediator(chatRoom, "Dra. Rodríguez");

        // Agregar usuarios al chat
        chatRoom.agregarUsuario(estudiante1);
        chatRoom.agregarUsuario(estudiante2);
        chatRoom.agregarUsuario(profesor1);

        chatRoom.mostrarUsuariosConectados();

        // Enviar mensajes
        System.out.println("📨 Intercambio de mensajes:\n");
        estudiante1.enviar("Hola a todos! ¿Alguien tiene dudas sobre el examen?");

        System.out.println();
        estudiante2.enviar("Sí, tengo una pregunta sobre el tema 5");

        System.out.println();
        profesor1.enviar("Con gusto les ayudo. ¿Qué necesitan saber?");

        // Agregar más usuarios
        System.out.println("\n👥 Nuevos participantes:");
        chatRoom.agregarUsuario(estudiante3);
        chatRoom.agregarUsuario(profesor2);

        System.out.println();
        estudiante3.enviar("Hola! Recién me uno");

        chatRoom.mostrarUsuariosConectados();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 5: Memento
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarMemento() {
        System.out.println("📝 Iniciando examen en línea...\n");

        // Crear examen
        String[] preguntas = {
                "¿Qué es un patrón de diseño?",
                "¿Cuál es la diferencia entre herencia y composición?",
                "¿Qué es el polimorfismo?",
                "¿Para qué sirve el patrón Singleton?"
        };

        ExamenEnLinea examen = new ExamenEnLinea("Patrones de Diseño", preguntas, 60);
        HistorialExamen historial = new HistorialExamen(5);

        // Simular que el estudiante responde preguntas
        System.out.println("✏️ Estudiante respondiendo examen:\n");

        examen.mostrarEstadoActual();
        examen.responderPregunta(0, "Un patrón de diseño es una solución reutilizable a un problema común");

        // Guardar progreso
        historial.guardarEstado(examen.guardarProgreso());

        examen.avanzarPregunta();
        examen.responderPregunta(1, "Herencia es 'es-un', composición es 'tiene-un'");

        // Guardar progreso nuevamente
        historial.guardarEstado(examen.guardarProgreso());

        examen.avanzarPregunta();
        examen.responderPregunta(2, "Polimorfismo permite que objetos de diferentes clases respondan a la misma interfaz");

        // Simular desconexión
        System.out.println("\n⚠️ Simulando desconexión inesperada...\n");

        // Guardar antes de desconectar
        historial.guardarEstado(examen.guardarProgreso());
        historial.mostrarHistorial();

        // Simular reconexión
        System.out.println("🔄 Reconectando y restaurando progreso...\n");

        ExamenEnLinea examenRecuperado = new ExamenEnLinea("Patrones de Diseño", preguntas, 60);
        examenRecuperado.restaurarProgreso(historial.obtenerUltimoEstado());

        examenRecuperado.mostrarEstadoActual();

        // Continuar con el examen
        examenRecuperado.avanzarPregunta();
        examenRecuperado.responderPregunta(3, "Singleton asegura que una clase tenga una única instancia");

        System.out.println("\n✅ Examen completado exitosamente");
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 6: Observer
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarObserver() {
        System.out.println("📢 Configurando sistema de notificaciones...\n");

        // Crear curso
        CursoObservable curso = new CursoObservable("CS301", "Patrones de Diseño", "Lunes y Miércoles 14:00-16:00");

        // Crear estudiantes observadores
        AlumnoObserver alumno1 = new AlumnoObserver("Patricia Gómez", "patricia@universidad.edu");
        AlumnoObserver alumno2 = new AlumnoObserver("Miguel Torres", "miguel@universidad.edu");
        AlumnoObserver alumno3 = new AlumnoObserver("Carmen Ruiz", "carmen@universidad.edu");

        // Suscribir estudiantes al curso
        System.out.println("👥 Estudiantes suscribiéndose al curso:\n");
        curso.agregarObservador(alumno1);
        curso.agregarObservador(alumno2);
        curso.agregarObservador(alumno3);

        // Publicar cambios
        System.out.println("\n📅 Cambio de horario:");
        curso.cambiarHorario("Martes y Jueves 16:00-18:00");

        esperarMomento();

        System.out.println("\n📌 Publicar aviso:");
        curso.publicarAviso("El próximo lunes habrá quiz sobre patrones creacionales");

        esperarMomento();

        // Un alumno desactiva notificaciones por email
        System.out.println("\n🔕 Miguel desactiva notificaciones por email:");
        alumno2.setNotificacionesPorEmail(false);

        System.out.println("\n🚫 Cancelar clase:");
        curso.cancelarClase("15 de Octubre", "Conferencia internacional del profesor");

        esperarMomento();

        System.out.println("\n📊 Publicar calificaciones:");
        curso.publicarCalificaciones();

        // Mostrar historial de un alumno
        alumno1.verHistorialNotificaciones();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 7: State
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarState() {
        System.out.println("📋 Gestionando estados de inscripción...\n");

        // Crear inscripción (comienza en estado En Espera)
        Inscripcion inscripcion = new Inscripcion("Fernando Díaz", "Inteligencia Artificial");

        inscripcion.mostrarInformacion();

        // Intentar solicitar certificado estando en espera
        System.out.println("🔸 Intento 1: Solicitar certificado en estado En Espera");
        inscripcion.solicitarCertificado();

        System.out.println("\n" + "-".repeat(60));

        // Confirmar inscripción
        System.out.println("\n🔸 Confirmando inscripción (hay cupo disponible):");
        inscripcion.confirmar();

        inscripcion.mostrarInformacion();

        // Actualizar progreso
        System.out.println("📈 Actualizando progreso del curso:");
        inscripcion.actualizarProgreso(30);
        inscripcion.actualizarProgreso(60);
        inscripcion.actualizarProgreso(100);

        System.out.println("\n" + "-".repeat(60));

        // Ahora sí puede solicitar certificado
        System.out.println("\n🔸 Intento 2: Solicitar certificado con curso completado:");
        inscripcion.solicitarCertificado();

        System.out.println("\n" + "-".repeat(60));

        // Crear otra inscripción para mostrar cancelación
        System.out.println("\n📝 Nueva inscripción de ejemplo:");
        Inscripcion inscripcion2 = new Inscripcion("Laura Morales", "Machine Learning");

        inscripcion2.confirmar();
        inscripcion2.actualizarProgreso(20);

        System.out.println("\n🔸 Cancelando inscripción:");
        inscripcion2.cancelar();

        System.out.println("\n🔸 Intento de solicitar certificado con inscripción cancelada:");
        inscripcion2.solicitarCertificado();

        System.out.println("\n🔸 Reactivando inscripción:");
        inscripcion2.confirmar();

        inscripcion2.mostrarInformacion();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 8: Strategy
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarStrategy() {
        System.out.println("🎓 Configurando sistema de calificaciones...\n");

        // Crear alumno
        AlumnoConNotas alumno = new AlumnoConNotas("Gabriela Herrera", "Ingeniería de Software");

        // Agregar notas
        System.out.println("📝 Agregando calificaciones:");
        alumno.agregarNota(8.5);
        alumno.agregarNota(7.0);
        alumno.agregarNota(9.0);
        alumno.agregarNota(6.5);

        System.out.println("\n" + "=".repeat(60));

        // Estrategia 1: Promedio Simple
        System.out.println("\n📊 ESTRATEGIA 1: Promedio Simple");
        System.out.println("-".repeat(60));
        alumno.setEstrategiaCalculo(new PromedioSimple());
        double notaSimple = alumno.calcularNotaFinal();

        esperarMomento();

        // Estrategia 2: Promedio Ponderado
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n📊 ESTRATEGIA 2: Promedio Ponderado");
        System.out.println("-".repeat(60));
        // Pesos: 20%, 20%, 30%, 30%
        List<Double> pesos = Arrays.asList(20.0, 20.0, 30.0, 30.0);
        alumno.setEstrategiaCalculo(new PromedioPonderado(pesos));
        double notaPonderada = alumno.calcularNotaFinal();

        esperarMomento();

        // Estrategia 3: Con Examen Extra
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n📊 ESTRATEGIA 3: Con Examen Extra");
        System.out.println("-".repeat(60));
        alumno.setEstrategiaCalculo(new ExamenExtra(6.0));
        double notaExtra = alumno.calcularNotaFinal();

        // Mostrar comparación
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📊 COMPARACIÓN DE ESTRATEGIAS");
        System.out.println("=".repeat(60));
        System.out.println(String.format("   Promedio Simple:     %.2f", notaSimple));
        System.out.println(String.format("   Promedio Ponderado:  %.2f", notaPonderada));
        System.out.println(String.format("   Con Examen Extra:    %.2f", notaExtra));
        System.out.println("=".repeat(60));
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 9: Template Method
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarTemplateMethod() {
        System.out.println("📄 Generando reportes académicos...\n");

        // Crear reporte de curso
        ReporteCurso reporteCurso = new ReporteCurso(
                "CS401",
                "Arquitectura de Software",
                "Dr. Ramírez",
                45,
                7.8
        );

        reporteCurso.agregarEstudianteDestacado("Ana María González - Promedio: 9.5");
        reporteCurso.agregarEstudianteDestacado("Pedro Jiménez - Promedio: 9.3");
        reporteCurso.agregarEstudianteDestacado("Isabel Vargas - Promedio: 9.1");

        System.out.println("📋 REPORTE 1: Reporte de Curso");
        System.out.println("-".repeat(60));
        reporteCurso.generarReporte();

        esperarMomento();

        // Crear reporte de alumno
        ReporteAlumno reporteAlumno = new ReporteAlumno(
                "2024-1001",
                "Andrés Castillo",
                "Ingeniería en Sistemas",
                120,
                160
        );

        reporteAlumno.agregarNota("Programación Orientada a Objetos", 8.5);
        reporteAlumno.agregarNota("Bases de Datos", 7.8);
        reporteAlumno.agregarNota("Redes de Computadoras", 9.0);
        reporteAlumno.agregarNota("Algoritmos y Estructuras", 8.2);
        reporteAlumno.agregarNota("Ingeniería de Software", 7.5);

        System.out.println("📋 REPORTE 2: Reporte de Alumno");
        System.out.println("-".repeat(60));
        reporteAlumno.generarReporte();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODO 10: Visitor
    // ═══════════════════════════════════════════════════════════════════════════
    private static void demonstrarVisitor() {
        System.out.println("🎯 Configurando sistema de visitantes...\n");

        // Crear diferentes tipos de alumnos
        AlumnoVisitable regular1 = new AlumnoRegular("José Ramírez", "2024-001", 5000, 32);
        AlumnoVisitable regular2 = new AlumnoRegular("Elena Castro", "2024-002", 5000, 18);
        AlumnoVisitable becado1 = new AlumnoBecado("Lucía Mendoza", "2024-003", 5000, 50, 8.9);
        AlumnoVisitable becado2 = new AlumnoBecado("Ricardo Flores", "2024-004", 5000, 75, 6.8);
        AlumnoVisitable intercambio1 = new AlumnoIntercambio("John Smith", "2024-INT-001",
                "Estados Unidos", "MIT", 6, 6000);
        AlumnoVisitable intercambio2 = new AlumnoIntercambio("Marie Dubois", "2024-INT-002",
                "Francia", "Sorbonne", 5, 6000);

        List<AlumnoVisitable> alumnos = Arrays.asList(
                regular1, regular2, becado1, becado2, intercambio1, intercambio2
        );

        // Visitor 1: Aplicar Becas
        System.out.println("🎓 VISITOR 1: Aplicando becas y descuentos");
        System.out.println("=".repeat(60));
        AplicarBecaVisitor becaVisitor = new AplicarBecaVisitor();

        for (AlumnoVisitable alumno : alumnos) {
            alumno.aceptar(becaVisitor);
        }

        esperarMomento();

        // Visitor 2: Calcular Costos
        System.out.println("\n\n💰 VISITOR 2: Calculando costos totales");
        System.out.println("=".repeat(60));
        CalcularCostosVisitor costosVisitor = new CalcularCostosVisitor();

        for (AlumnoVisitable alumno : alumnos) {
            alumno.aceptar(costosVisitor);
        }

        costosVisitor.mostrarResumenTotal();

        esperarMomento();

        // Visitor 3: Generar Reportes
        System.out.println("\n📊 VISITOR 3: Generando reportes individuales");
        System.out.println("=".repeat(60));
        GenerarReportesVisitor reportes;
        Visitor = new GenerarReportesVisitor();

        for (AlumnoVisitable alumno : alumnos) {
            alumno.aceptar(reportesVisitor);
        }

        reportesVisitor.mostrarEstadisticas();
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MÉTODOS AUXILIARES
    // ═══════════════════════════════════════════════════════════════════════════

    private static void esperarTecla() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("Presiona ENTER para continuar con el siguiente patrón...");
        System.out.println("─".repeat(80));
        try {
            System.in.read();
            // Limpiar buffer
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (Exception e) {
            // Ignorar excepciones
        }
    }

    private static void esperarMomento() {
        try {
            Thread.sleep(1000); // Pausa de 1 segundo para mejor visualización
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}