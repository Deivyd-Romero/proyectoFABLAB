package NEGOCIO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

public class FABLAB {

    private static final boolean CARGAR_CURSOS_DE_EJEMPLO = true;

    private Laboratorio[] myLaboratorios;
    private HashSet<Persona> myPersonas;
    private int siguienteInscripcion = 1;
    private ArrayList<Recurso> myInventario;
    private ArrayList<Curso> myCursos;

    /*
    Requerimiento 1 inicializar la operacion del FABLAB
    Requerimiento 2 programar un curso de formacion
    Requerimiento 3 gestionar la inscripcion de participantes
    Requerimiento 4 preparar e iniciar un curso mediante entrega de recursos
    Requerimiento 5 cerrar el curso y conciliar los recursos utilizados
    Requerimiento 6 finalizar la formacion y determinar la certificacion
    Requerimiento 7 consultas e informes de control
     */
    //RF1 - inicializa el FABLAB: colecciones, recursos, laboratorios y usuarios base
    public FABLAB() {
        this(CARGAR_CURSOS_DE_EJEMPLO);
    }

    public FABLAB(boolean conCursosDeEjemplo) {
        crearEspacioMemoria();
        crearRecursos();
        crearLaboratorios();
        asignarRecursosLaboratorio();
        crearPersonas();
        if (conCursosDeEjemplo) {
            cargarCursosDeEjemplo();
        }
    }

    //RF1 - crea las colecciones vacias
    private void crearEspacioMemoria() {
        this.myLaboratorios = new Laboratorio[5];
        this.myPersonas = new HashSet<>();
        this.myInventario = new ArrayList<>();
        this.myCursos = new ArrayList<>();
    }

    //RF1 - carga el inventario inicial de recursos tecnologicos
    private void crearRecursos() {
        this.myInventario.add(new Recurso("DR-01", "Drone de formación", "EQUIPO", 6, 1500000));
        this.myInventario.add(new Recurso("DR-02", "Control remoto", "EQUIPO", 6, 450000));
        this.myInventario.add(new Recurso("DR-03", "Batería recargable", "EQUIPO", 12, 350000));
        this.myInventario.add(new Recurso("RA-01", "Visor de realidad aumentada", "EQUIPO", 10, 1800000));
        this.myInventario.add(new Recurso("RA-02", "Tablet de apoyo", "EQUIPO", 10, 900000));
        this.myInventario.add(new Recurso("I3-01", "Impresora 3D", "EQUIPO", 6, 2800000));
        this.myInventario.add(new Recurso("I3-02", "Filamento PLA (unidad académica)", "MATERIAL", 20, 90000));
        this.myInventario.add(new Recurso("IO-01", "Kit Arduino", "EQUIPO", 20, 180000));
        this.myInventario.add(new Recurso("IO-02", "Kit de sensores", "EQUIPO", 20, 120000));
        this.myInventario.add(new Recurso("IO-03", "Protoboard", "EQUIPO", 20, 30000));
        this.myInventario.add(new Recurso("CD-01", "Cámara digital", "EQUIPO", 6, 3200000));
        this.myInventario.add(new Recurso("CD-02", "Micrófono inalámbrico", "EQUIPO", 8, 650000));
        this.myInventario.add(new Recurso("CD-03", "Kit de iluminación LED", "EQUIPO", 6, 750000));
        this.myInventario.add(new Recurso("CD-04", "Trípode para cámara", "EQUIPO", 6, 280000));
        this.myInventario.add(new Recurso("CD-05", "Tableta digitalizadora", "EQUIPO", 10, 550000));
    }

    //RF1 - crea los cinco laboratorios (todos DISPONIBLE) y les entrega sus recursos
    private void crearLaboratorios() {
        ArrayList<Recurso> recursosDeDrones = new ArrayList<>(this.myInventario.subList(0, 3));
        ArrayList<Recurso> recursosDeRealidadAumentada = new ArrayList<>(this.myInventario.subList(3, 5));
        ArrayList<Recurso> recursosDeImpresion3D = new ArrayList<>(this.myInventario.subList(5, 7));
        ArrayList<Recurso> recursosDeIoT = new ArrayList<>(this.myInventario.subList(7, 10));
        ArrayList<Recurso> recursosDeContenidosDigitales = new ArrayList<>(this.myInventario.subList(10, 15));
        this.myLaboratorios[0] = new Laboratorio("L01", "Drones", 20, Laboratorio.DISPONIBLE, recursosDeDrones);
        this.myLaboratorios[1] = new Laboratorio("L02", "Realidad Aumentada", 18, Laboratorio.DISPONIBLE, recursosDeRealidadAumentada);
        this.myLaboratorios[2] = new Laboratorio("L03", "Impresión 3D", 15, Laboratorio.DISPONIBLE, recursosDeImpresion3D);
        this.myLaboratorios[3] = new Laboratorio("L04", "Internet de las cosas (IoT)", 24, Laboratorio.DISPONIBLE, recursosDeIoT);
        this.myLaboratorios[4] = new Laboratorio("L05", "Contenidos digitales", 20, Laboratorio.DISPONIBLE, recursosDeContenidosDigitales);

    }

    //RF1 - sin uso: los recursos ya se asignan a cada laboratorio en crearLaboratorios
    private void asignarRecursosLaboratorio() {

    }

    //RF1 - registra los instructores y participantes base para probar la programacion, la inscripcion y el inicio de cursos
    private void crearPersonas() {
        this.registrarPersona("1090123456", "Carlos Pérez", "carlosperez@ufps.edu.co", "3001112233", Instructor.ROL);
        this.registrarPersona("1090234567", "Laura Gómez", "lauragomez@ufps.edu.co", "3002223344", Instructor.ROL);
        this.registrarPersona("1090345678", "Andrés Rodríguez", "andresrodriguez@ufps.edu.co", "3003334455", Instructor.ROL);
        this.registrarPersona("1090444444", "Ana Pérez", "ana.perez@ufps.edu.co", "3002220001", Participante.ROL);
        this.registrarPersona("1090555555", "Juan Rojas", "juan.rojas@gmail.com", "3002220002", Participante.ROL);
        this.registrarPersona("1090666666", "Sofía Díaz", "sofia.diaz@ufps.edu.co", "3002220003", Participante.ROL);
        this.registrarPersona("1090777777", "Pedro Ramírez", "pedro.ramirez@empresa.com", "3002220004", Participante.ROL);
    }

    //RF1 - retorna los datos de todos los laboratorios con sus recursos
    public String listarLaboratorios() {
        String cad = "";
        for (Laboratorio l : this.myLaboratorios) {
            cad += l.toString() + "\n" + "===============" + "\n";
        }
        return cad;
    }

    //RF2 - retorna el mensaje de curso programado o la causa por la cual no se pudo programar
    public String programarCurso(String codigo, String nombreCurso, LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin, int cupoCurso, String poblacionObjetivo,
            String codigoLab, String documentoInstructor, String areaTecnologica, String entidadSolicitante) {

        codigo = limpiar(codigo);
        nombreCurso = limpiar(nombreCurso);
        poblacionObjetivo = limpiar(poblacionObjetivo);
        entidadSolicitante = limpiar(entidadSolicitante);
        if (codigo.isEmpty() || nombreCurso.isEmpty()) {
            return "No se puede programar: indique el código y el nombre del curso.";
        }
        if (!poblacionValida(poblacionObjetivo)) {
            return "No se puede programar: seleccione una población objetivo válida.";
        }
        String errorHorario = validarHorario(fechaInicio, fechaFin, horarioInicio, horarioFin);
        if (!errorHorario.isEmpty()) {
            return "No se puede programar: " + errorHorario;
        }
        if (buscarCurso(codigo) != null) {
            return "No se puede programar: ya existe un curso con el código " + codigo + ".";
        }
        if (cupoCurso <= 0) {
            return "No se puede programar: el cupo debe ser mayor que cero.";
        }
        Laboratorio laboratorio = buscarLaboratorio(codigoLab);
        if (laboratorio == null) {
            return "No se puede programar: el laboratorio indicado no existe.";
        }
        if (!Laboratorio.DISPONIBLE.equalsIgnoreCase(laboratorio.getEstadoLab())) {
            return "No se puede programar: el laboratorio " + codigoLab + " no está disponible (estado: "
                    + laboratorio.getEstadoLab() + ").";
        }
        if (!laboratorio.getTipoLab().equalsIgnoreCase(limpiar(areaTecnologica))) {
            return "No se puede programar: el área tecnológica seleccionada no coincide con el tipo de laboratorio ("
                    + laboratorio.getTipoLab() + ").";
        }
        if (cupoCurso > laboratorio.getCapacidadMax()) {
            return "No se puede programar: el cupo (" + cupoCurso + ") supera la capacidad del laboratorio ("
                    + laboratorio.getCapacidadMax() + ").";
        }
        if (entidadSolicitante.isEmpty()) {
            return "No se puede programar: debe indicar la entidad solicitante.";
        }

        Instructor instructor = buscarInstructor(documentoInstructor);
        if (instructor == null) {
            return "No se puede programar: el instructor indicado no está registrado.";
        }

        if (laboratorioOcupado(laboratorio.getCodigoLab(), fechaInicio, fechaFin, horarioInicio, horarioFin)) {
            return "No se puede programar: el laboratorio " + codigoLab + " ya está ocupado en una fecha "
                    + "y horario que se cruza con otro curso.";
        }
        if (instructorOcupado(instructor.getDocumento(), fechaInicio, fechaFin, horarioInicio, horarioFin)) {
            return "No se puede programar: el instructor ya tiene un curso asignado en una fecha y horario que se cruza.";
        }

        Curso nuevoCurso = new Curso(nombreCurso, laboratorio.getTipoLab(), fechaInicio, fechaFin,
                horarioInicio, horarioFin, cupoCurso, poblacionObjetivo,
                entidadSolicitante, codigo, laboratorio, instructor);
        this.myCursos.add(nuevoCurso);

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "CURSO PROGRAMADO\n"
                + "Código: " + codigo + "\n"
                + "Nombre: " + nombreCurso + "\n"
                + "Laboratorio: " + laboratorio.getCodigoLab() + " - " + laboratorio.getTipoLab() + "\n"
                + "Instructor: " + instructor.getDocumento() + " - " + instructor.getNombre() + "\n"
                + "Fecha: " + fechaInicio.format(formatoFecha) + " al " + fechaFin.format(formatoFecha) + "\n"
                + "Horario: " + horarioInicio + " - " + horarioFin + "\n"
                + "Cupo máximo: " + cupoCurso + "\n"
                + "Población objetivo: " + poblacionObjetivo + "\n"
                + "Entidad solicitante: " + entidadSolicitante + "\n"
                + "Estado: " + nuevoCurso.getEstadoCurso();
    }

    private static String limpiar(String texto) {
        return texto == null ? "" : texto.strip();
    }

    private boolean poblacionValida(String poblacion) {
        return Curso.GENERAL.equalsIgnoreCase(poblacion) || "Vulnerable".equalsIgnoreCase(poblacion)
                || "Empresarial".equalsIgnoreCase(poblacion);
    }

    private String validarHorario(LocalDate inicio, LocalDate fin, LocalTime desde, LocalTime hasta) {
        if (inicio == null || fin == null || desde == null || hasta == null) {
            return "indique ambas fechas y ambas horas.";
        }
        if (inicio.isAfter(fin)) {
            return "la fecha inicial no puede ser posterior a la final.";
        }
        if (!desde.isBefore(hasta)) {
            return "la hora inicial debe ser anterior a la final.";
        }
        return "";
    }

    // Conserva los separadores de las listas incluso en nombres como CAD/CAM.
    private static String campoLista(String texto) {
        String campo = texto.replace("%", "%25").replace("/", "%2F").replace("|", "%7C");
        return campo.contains(" - ") ? campo.replace("-", "%2D") : campo;
    }

    public static String leerCampoLista(String texto) {
        return texto.replace("%2D", "-").replace("%7C", "|").replace("%2F", "/").replace("%25", "%");
    }

    private String opcionInstructor(Persona instructor) {
        return campoLista(instructor.getNombre()).replace("-", "%2D") + "-"
                + campoLista(instructor.getDocumento()).replace("-", "%2D");
    }

    private String opcionCurso(Curso curso) {
        return campoLista(curso.getCodigo()) + " - " + campoLista(curso.getNombreCurso()) + "/";
    }

    //RF2 - retorna los codigos (separados por /) de los laboratorios disponibles y libres en esas fechas y horas
    public String consultarLaboratorios(LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin) {
        if (!validarHorario(fechaInicio, fechaFin, horarioInicio, horarioFin).isEmpty()) {
            return "";
        }
        String lista = "";
        for (Laboratorio laboratorio : this.myLaboratorios) {
            if (laboratorio != null
                    && Laboratorio.DISPONIBLE.equalsIgnoreCase(laboratorio.getEstadoLab())
                    && !laboratorioOcupado(laboratorio.getCodigoLab(), fechaInicio, fechaFin, horarioInicio, horarioFin)) {
                lista += laboratorio.getCodigoLab() + "/";
            }
        }
        return lista;
    }

    //RF2 - retorna los instructores (nombre-documento separados por /) libres en esas fechas y horas
    public String consultarInstructores(LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin) {
        if (!validarHorario(fechaInicio, fechaFin, horarioInicio, horarioFin).isEmpty()) {
            return "";
        }
        String lista = "";
        for (Persona persona : this.myPersonas) {
            if (persona instanceof Instructor
                    && !instructorOcupado(persona.getDocumento(), fechaInicio, fechaFin, horarioInicio, horarioFin)) {
                lista += opcionInstructor(persona) + "/";
            }
        }
        return lista;
    }

    //RF2 - retorna true si el laboratorio ya tiene un curso que se cruza con esas fechas y horas
    private boolean laboratorioOcupado(String codigoLab, LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin) {
        for (Curso curso : this.myCursos) {
            if (curso.getMyLaboratorio().getCodigoLab().equalsIgnoreCase(codigoLab)
                    && seCruzaConCurso(curso, fechaInicio, fechaFin, horarioInicio, horarioFin)) {
                return true;
            }
        }
        return false;
    }

    //RF2 - retorna true si el instructor ya tiene un curso que se cruza con esas fechas y horas
    private boolean instructorOcupado(String documento, LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin) {
        for (Curso curso : this.myCursos) {
            if (curso.getMyInstructor().getDocumento().equalsIgnoreCase(documento)
                    && seCruzaConCurso(curso, fechaInicio, fechaFin, horarioInicio, horarioFin)) {
                return true;
            }
        }
        return false;
    }

    //RF2 - retorna true si el curso (que no este cancelado) se cruza con esas fechas y horas
    private boolean seCruzaConCurso(Curso curso, LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin) {
        if (Curso.CANCELADO.equals(curso.getEstadoCurso())) {
            return false;
        }
        return verificarCrucesFechasYHoras(fechaInicio, fechaFin, horarioInicio, horarioFin,
                curso.getFechaInicio(), curso.getFechaFin(), curso.getHorarioInicio(), curso.getHorarioFin());
    }

    //RF2 - retorna true si los rangos de fechas se solapan y tambien los rangos de horas
    private boolean verificarCrucesFechasYHoras(LocalDate f1Inicio, LocalDate f1Fin,
            LocalTime h1Inicio, LocalTime h1Fin, LocalDate f2Inicio, LocalDate f2Fin,
            LocalTime h2Inicio, LocalTime h2Fin) {

        return !f1Inicio.isAfter(f2Fin) && !f2Inicio.isAfter(f1Fin)
                && h1Inicio.isBefore(h2Fin) && h2Inicio.isBefore(h1Fin);
    }

    //RF2 - retorna el laboratorio con ese codigo o null si no existe
    private Laboratorio buscarLaboratorio(String codigoLab) {
        if (codigoLab == null) {
            return null;
        }
        for (Laboratorio myLaboratorio : this.myLaboratorios) {
            if (myLaboratorio != null && myLaboratorio.getCodigoLab().equalsIgnoreCase(limpiar(codigoLab))) {
                return myLaboratorio;
            }
        }
        return null;
    }

    //RF2 - retorna el curso con ese codigo o null si no existe
    private Curso buscarCurso(String codigoCurso) {
        if (codigoCurso == null) {
            return null;
        }
        for (Curso curso : this.myCursos) {
            if (curso.getCodigo().equalsIgnoreCase(limpiar(codigoCurso))) {
                return curso;
            }
        }
        return null;
    }

    private Instructor buscarInstructor(String seleccion) {
        Persona persona = buscarPersonaExistente(seleccion);
        if (persona instanceof Instructor instructor) {
            return instructor;
        }
        // También acepta la opción nombre-documento de la lista de instructores.
        for (Persona candidato : myPersonas) {
            if (candidato instanceof Instructor instructor) {
                if (opcionInstructor(candidato).equalsIgnoreCase(limpiar(seleccion))) {
                    return instructor;
                }
            }
        }
        return null;
    }

    //RF3 - registra la persona que aun no existe en el sistema
    public String registrarPersona(String documento, String nombre, String correo, String telefono,
            String rol) {
        documento = limpiar(documento);
        nombre = limpiar(nombre);
        correo = limpiar(correo);
        telefono = limpiar(telefono);
        rol = limpiar(rol);
        if (documento.isEmpty() || nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            return "Indique el documento, el nombre, el correo y el teléfono.";
        }
        if (!correo.matches("[^\\s@]+@[^\\s@]+")) {
            return "El correo debe contener un usuario y un dominio separados por @.";
        }
        if (!telefono.matches("[+0-9() .-]+") || !telefono.matches(".*[0-9].*")) {
            return "El teléfono debe contener dígitos. Puede incluir prefijo, espacios o guiones.";
        }
        if (buscarPersonaExistente(documento) != null) {
            return "Ya hay una persona registrada con ese documento";
        }

        Persona persona;
        if (Participante.ROL.equalsIgnoreCase(rol)) {
            persona = new Participante(nombre, correo, telefono, documento);
        } else if (Instructor.ROL.equalsIgnoreCase(rol)) {
            persona = new Instructor(nombre, correo, telefono, documento);
        } else {
            return "El rol indicado no es válido (use INSTRUCTOR o PARTICIPANTE).";
        }
        this.myPersonas.add(persona);

        return "Se ha registrado correctamente\nPor favor valide el documento de nuevo.";
    }

    //RF3 - retorna "nombre/correo/telefono/rol/" de la persona o vacio si no esta registrada
    public String verificarPersonaExistente(String documento) {
        String cad = "";
        Persona myP = buscarPersonaExistente(documento);
        if (myP != null) {
            cad += campoLista(myP.getNombre()) + "/" + campoLista(myP.getCorreo()) + "/" + campoLista(myP.getTelefono()) + "/" + myP.getRol() + "/";
        }

        return cad;
    }

    //RF3 - retorna la persona con ese documento o null si no esta registrada
    private Persona buscarPersonaExistente(String documento) {
        for (Persona p : this.myPersonas) {
            if (p.getDocumento().equalsIgnoreCase(limpiar(documento))) {
                return p;
            }
        }
        return null;
    }

    //RF3 - retorna el numero que le corresponde a la proxima inscripcion
    public int contadorInscripciones() {
        return siguienteInscripcion;
    }

    //RF3 - retorna los cursos que reciben inscripciones como "codigo - nombre" separados por /
    public String listarCursos() {
        String cad = "";
        for (Curso c : this.myCursos) {
            if (c.recibeInscripciones() && c.getCantidadInscritos() < c.getCupoCurso()) {
                cad += opcionCurso(c);
            }
        }
        return cad;
    }

    //RF3 - retorna true si el curso existe y todavia recibe inscripciones
    public boolean cursoDisponible(String idCurso) {
        Curso curso = buscarCurso(idCurso);
        return curso != null && curso.recibeInscripciones() && curso.getCantidadInscritos() < curso.getCupoCurso();
    }

    //RF3 - retorna los cupos libres del curso (cupo maximo menos inscritos), 0 si no existe o esta lleno
    public int consultarCuposDisponibles(String idCurso) {
        Curso curso = buscarCurso(idCurso);
        if (curso == null) {
            return 0;
        }
        int libres = curso.getCupoCurso() - curso.getCantidadInscritos();
        return Math.max(libres, 0);
    }

    //RF3 - retorna vacio si el participante cumple la poblacion objetivo del curso, o la causa si no la cumple
    private String validarPoblacionObjetivo(Curso curso, String tipoPoblacion, String vinculacion) {
        String objetivo = curso.getPoblacionObjetivo();
        if (objetivo != null && !Curso.GENERAL.equalsIgnoreCase(objetivo) && !objetivo.equalsIgnoreCase(tipoPoblacion)) {
            return "El participante no cumple la población objetivo del curso (" + objetivo + ").";
        }
        if (Curso.ENTIDAD_UFPS.equalsIgnoreCase(curso.getEntidadSolicitante())
                && !Participante.ESTUDIANTE_UFPS.equalsIgnoreCase(vinculacion)
                && !Participante.DOCENTE_UFPS.equalsIgnoreCase(vinculacion)) {
            return "El curso es institucional UFPS: solo pueden inscribirse estudiantes y docentes de la UFPS.";
        }
        return "";
    }

    //RF3 - retorna el mensaje de inscripcion exitosa o la causa por la cual no se pudo inscribir
    public String realizarInscripcion(String idCurso, LocalDate fechaInscripcion, String documento,
            String procedencia, String tipoPoblacion, String vinculacion) {
        Persona persona = buscarPersonaExistente(documento);
        if (persona == null) {
            return "Primero debes registrar a la persona.";
        }
        if (!(persona instanceof Participante)) {
            return "La persona registrada no tiene perfil de participante.";
        }

        Participante participante = (Participante) persona;
        Curso curso = buscarCurso(idCurso);
        if (curso == null) {
            return "El curso seleccionado no existe.";
        }
        if (!curso.recibeInscripciones()) {
            return "El curso ya no está recibiendo inscripciones.";
        }
        if (curso.buscarInscripcion(documento) != null) {
            return "No puede inscribirse dos veces al mismo curso";
        }
        if (consultarCuposDisponibles(idCurso) <= 0) {
            return "No hay cupos disponibles en el curso.";
        }
        procedencia = limpiar(procedencia);
        tipoPoblacion = limpiar(tipoPoblacion);
        vinculacion = limpiar(vinculacion);
        if (fechaInscripcion == null || procedencia.isEmpty()) {
            return "Indique la fecha de inscripción y la procedencia.";
        }
        if (fechaInscripcion.isAfter(curso.getFechaFin())) {
            return "La inscripción no puede ser posterior a la fecha final del curso.";
        }
        if (!poblacionValida(tipoPoblacion)) {
            return "Seleccione un tipo de población válido.";
        }
        if (!Participante.ESTUDIANTE_UFPS.equalsIgnoreCase(vinculacion)
                && !Participante.DOCENTE_UFPS.equalsIgnoreCase(vinculacion)
                && !Participante.EXTERNO.equalsIgnoreCase(vinculacion)) {
            return "Seleccione una vinculación válida.";
        }
        String causaPoblacion = validarPoblacionObjetivo(curso, tipoPoblacion, vinculacion);
        if (!causaPoblacion.isEmpty()) {
            return causaPoblacion;
        }

        Inscripcion inscripcion = new Inscripcion(contadorInscripciones(), fechaInscripcion, participante,
                procedencia, tipoPoblacion, vinculacion);
        curso.agregarInscripcion(inscripcion);
        siguienteInscripcion++;

        return "INSCRIPCIÓN EXITOSA\n"
                + "Inscripción: I-" + String.format("%03d", inscripcion.getNumInscripcion()) + "\n"
                + "Participante: " + participante.getDocumento() + " - " + participante.getNombre() + "\n"
                + "Vinculación: " + vinculacion + "\n"
                + "Curso: " + curso.getCodigo() + " - " + curso.getNombreCurso() + "\n"
                + "Estado: " + inscripcion.getEstadoParticipante() + "\n"
                + "Cupos disponibles: " + consultarCuposDisponibles(idCurso);
    }

    //RF4 - retorna los cursos que se pueden iniciar como "codigo - nombre" separados por /
    public String listarCursosParaIniciar() {
        String lista = "";
        for (Curso curso : this.myCursos) {
            if (curso.recibeInscripciones()) {
                lista += opcionCurso(curso);
            }
        }
        return lista;
    }

    //RF4 - retorna los recursos del laboratorio del curso como "codigo|descripcion|disponibles" separados por /
    public String listarRecursosCurso(String codigoCurso) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null || curso.getMyLaboratorio() == null) {
            return "";
        }
        String lista = "";
        for (Recurso recurso : curso.getMyLaboratorio().getRecursos()) {
            lista += campoLista(recurso.getIdentificador()) + "|" + campoLista(recurso.getDescripcion())
                    + "|" + recurso.getCantidadDisponible() + "/";
        }
        return lista;
    }

    //RF4 - las listas son paralelas: la cantidad solicitada de cada recurso esta en la misma posicion
    //(Integer es la version "objeto" de int: las listas no aceptan tipos primitivos)
    //retorna el resumen de inicio del curso o la causa por la cual no se pudo iniciar
    public String iniciarCurso(String codigoCurso, ArrayList<String> codigosRecursos, ArrayList<Integer> cantidadesSolicitadas) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null) {
            return "No se puede iniciar: el curso seleccionado no existe.";
        }
        if (!curso.recibeInscripciones()) {
            return "No se puede iniciar: el curso no está en estado PROGRAMADO o INSCRIPCIONES_ABIERTAS.";
        }
        if (curso.getCantidadInscritos() < 1) {
            return "No se puede iniciar el curso: debe tener al menos un participante inscrito.";
        }
        if (codigosRecursos == null || cantidadesSolicitadas == null
                || codigosRecursos.size() != cantidadesSolicitadas.size()
                || codigosRecursos.isEmpty()) {
            return "Debe indicar al menos un recurso y su cantidad.";
        }
        Laboratorio laboratorio = curso.getMyLaboratorio();
        if (laboratorio == null || !Laboratorio.DISPONIBLE.equalsIgnoreCase(laboratorio.getEstadoLab())) {
            return "No se puede iniciar: el laboratorio no está DISPONIBLE.";
        }

        ArrayList<Recurso> recursosSeleccionados = new ArrayList<>();
        for (int i = 0; i < codigosRecursos.size(); i++) {
            String codigo = limpiar(codigosRecursos.get(i));
            int cantidad = cantidadesSolicitadas.get(i) == null ? 0 : cantidadesSolicitadas.get(i);
            Recurso encontrado = laboratorio.buscarRecurso(codigo);
            if (encontrado == null) {
                return "El recurso " + codigo + " no pertenece al laboratorio del curso.";
            }
            if (cantidad <= 0) {
                return "La cantidad solicitada para " + codigo + " debe ser mayor que cero.";
            }
            if (cantidad > encontrado.getCantidadDisponible()) {
                return "No hay suficientes unidades de " + encontrado.getDescripcion()
                        + ". Disponibles: " + encontrado.getCantidadDisponible()
                        + ", solicitadas: " + cantidad + ".";
            }
            if (recursosSeleccionados.contains(encontrado)) {
                return "El recurso " + codigo + " está repetido en la solicitud.";
            }
            recursosSeleccionados.add(encontrado);
        }

        String resumen = "INICIO DE CURSO: " + curso.getCodigo() + " - "
                + curso.getNombreCurso() + "\n"
                + "Instructor: " + curso.getMyInstructor().getNombre() + "\n\n"
                + "RECURSOS ENTREGADOS\n";
        for (int i = 0; i < recursosSeleccionados.size(); i++) {
            Recurso recurso = recursosSeleccionados.get(i);
            int cantidad = cantidadesSolicitadas.get(i);
            // La lista de recursos se obtiene del laboratorio asignado al curso.
            recurso.entregar(cantidad);
            curso.agregarEntrega(new EntregaRecurso(recurso.getIdentificador(), cantidad));
            resumen += recurso.getDescripcion() + ": " + cantidad + "\n";
        }
        curso.setEstadoCurso(Curso.EN_FORMACION);
        laboratorio.setEstadoLab(Laboratorio.OCUPADO);
        resumen += "\nCurso: " + curso.getEstadoCurso()
                + "\nLaboratorio " + laboratorio.getCodigoLab() + ": " + laboratorio.getEstadoLab();
        return resumen;
    }

    
    //RF5 - retorna los cursos EN_FORMACION como "codigo - nombre" separados por /
    public String listarCursosParaCerrar() {
        String lista = "";
        for (Curso curso : this.myCursos) {
            if (Curso.EN_FORMACION.equals(curso.getEstadoCurso())) {
                lista += opcionCurso(curso);
            }
        }
        return lista;
    }

    //RF5 - retorna los recursos entregados al curso como "codigo|descripcion|entregadas" separados por /
    public String listarRecursosEntregados(String codigoCurso) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null) {
            return "";
        }
        String lista = "";
        for (EntregaRecurso entrega : curso.getMyEntregas()) {
            Recurso recurso = curso.getMyLaboratorio().buscarRecurso(entrega.getCodigoRecurso());
            lista += campoLista(entrega.getCodigoRecurso()) + "|"
                    + campoLista(recurso == null ? entrega.getCodigoRecurso() : recurso.getDescripcion())
                    + "|" + entrega.getCantidadEntregada() + "/";
        }
        return lista;
    }

    //RF5 - retorna la entrega del recurso con ese codigo o null si el curso no lo recibio
    private EntregaRecurso buscarEntrega(ArrayList<EntregaRecurso> entregas, String codigoRecurso) {
        for (EntregaRecurso entrega : entregas) {
            if (entrega.getCodigoRecurso().equalsIgnoreCase(codigoRecurso)) {
                return entrega;
            }
        }
        return null;
    }

    //RF5 - retorna el valor con formato de pesos, por ejemplo $450.000
    private String formatoPesos(long valor) {
        String pesos = String.valueOf(valor);
        for (int i = pesos.length() - 3; i > 0; i -= 3) {
            pesos = pesos.substring(0, i) + "." + pesos.substring(i);
        }
        return "$" + pesos;
    }

    //RF5 - las listas son paralelas: la conciliacion de cada recurso esta en la misma posicion
    //solo cierra si todos los recursos entregados quedan conciliados (entregado = bien + danado + perdido)
    //retorna el reporte de cierre o la causa por la cual no se pudo cerrar
    public String cerrarCurso(String codigoCurso, ArrayList<String> codigosRecursos, ArrayList<Integer> cantidadesBuenas,
            ArrayList<Integer> cantidadesDaniadas, ArrayList<Integer> cantidadesPerdidas) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null) {
            return "No se puede cerrar: el curso seleccionado no existe.";
        }
        if (!Curso.EN_FORMACION.equals(curso.getEstadoCurso())) {
            return "No se puede cerrar: el curso no está EN_FORMACION.";
        }
        if (codigosRecursos == null || cantidadesBuenas == null || cantidadesDaniadas == null || cantidadesPerdidas == null
                || codigosRecursos.size() != cantidadesBuenas.size()
                || codigosRecursos.size() != cantidadesDaniadas.size()
                || codigosRecursos.size() != cantidadesPerdidas.size()) {
            return "Debe indicar la conciliación de cada recurso entregado.";
        }

        ArrayList<EntregaRecurso> entregas = curso.getMyEntregas();
        Laboratorio laboratorio = curso.getMyLaboratorio();
        ArrayList<Recurso> recursos = new ArrayList<>();
        ArrayList<EntregaRecurso> conciliadas = new ArrayList<>();
        int[] buenas = new int[codigosRecursos.size()];
        int[] daniadas = new int[codigosRecursos.size()];
        int[] perdidas = new int[codigosRecursos.size()];
        for (int i = 0; i < codigosRecursos.size(); i++) {
            String codigo = limpiar(codigosRecursos.get(i));
            EntregaRecurso entrega = buscarEntrega(entregas, codigo);
            if (entrega == null) {
                return "El recurso " + codigo + " no fue entregado a este curso.";
            }
            if (conciliadas.contains(entrega)) {
                return "El recurso " + codigo + " está repetido en la conciliación.";
            }
            if (cantidadesBuenas.get(i) == null || cantidadesDaniadas.get(i) == null || cantidadesPerdidas.get(i) == null) {
                return "Complete las tres cantidades para " + codigo + ".";
            }
            buenas[i] = cantidadesBuenas.get(i);
            daniadas[i] = cantidadesDaniadas.get(i);
            perdidas[i] = cantidadesPerdidas.get(i);
            if (buenas[i] < 0 || daniadas[i] < 0 || perdidas[i] < 0) {
                return "Las cantidades de " + codigo + " no pueden ser negativas.";
            }
            Recurso recurso = laboratorio.buscarRecurso(entrega.getCodigoRecurso());
            if (recurso == null || recurso.getCantidadEnUso() < entrega.getCantidadEntregada()) {
                return "Revise el inventario del laboratorio para el recurso " + codigo + ".";
            }
            long reportadas = (long) buenas[i] + daniadas[i] + perdidas[i];
            if (reportadas != entrega.getCantidadEntregada()) {
                return "La conciliación de " + recurso.getDescripcion() + " no cuadra: entregadas "
                        + entrega.getCantidadEntregada() + " y reportadas " + reportadas
                        + " (bien + dañadas + perdidas).";
            }
            recursos.add(recurso);
            conciliadas.add(entrega);
        }
        for (EntregaRecurso entrega : entregas) {
            if (!conciliadas.contains(entrega)) {
                return "Falta conciliar el recurso " + entrega.getCodigoRecurso() + ".";
            }
        }

        String reporte = "CIERRE DEL CURSO " + curso.getCodigo() + "\n"
                + "Laboratorio: " + laboratorio.getCodigoLab() + " - " + laboratorio.getTipoLab() + "\n";
        long totalAfectacion = 0;
        for (int i = 0; i < conciliadas.size(); i++) {
            EntregaRecurso entrega = conciliadas.get(i);
            Recurso recurso = recursos.get(i);
            recurso.conciliar(buenas[i], daniadas[i], perdidas[i]);
            entrega.registrarDevolucion(buenas[i], daniadas[i], perdidas[i]);

            long costoDanio = recurso.calcularCostoDanio(daniadas[i]);
            long valorPerdida = (long) perdidas[i] * recurso.getValorUnitario();
            totalAfectacion += costoDanio + valorPerdida;

            reporte += "\n" + recurso.getDescripcion() + "\n"
                    + "Entregadas: " + entrega.getCantidadEntregada() + " | Bien: " + buenas[i]
                    + " | Dañadas: " + daniadas[i] + " | Perdidas: " + perdidas[i] + "\n";
            if (daniadas[i] > 0) {
                reporte += "Costo estimado daño: " + formatoPesos(costoDanio) + "\n";
            }
            if (perdidas[i] > 0) {
                reporte += "Valor pérdida: " + formatoPesos(valorPerdida) + "\n";
            }
        }

        // RF5: los recursos ya quedaron conciliados. El curso pasa a espera
        // de evaluación académica; RF6 será quien lo marque FINALIZADO.
        curso.setEstadoCurso(Curso.PENDIENTE_CERTIFICACION);
        if (Laboratorio.OCUPADO.equalsIgnoreCase(laboratorio.getEstadoLab())) {
            laboratorio.setEstadoLab(Laboratorio.DISPONIBLE);
        }
        reporte += "\nVALOR TOTAL AFECTACIÓN: " + formatoPesos(totalAfectacion) + "\n"
                + "Curso: " + curso.getEstadoCurso() + "\n"
                + "Laboratorio: " + laboratorio.getEstadoLab();
        return reporte;
    }

    public boolean pendienteDeCertificacion(String codigo) {
        Curso curso = buscarCurso(codigo);
        return curso != null && Curso.PENDIENTE_CERTIFICACION.equals(curso.getEstadoCurso());
    }

    // RF6: cursos con recursos conciliados que esperan el registro académico.
    public String listarCursosParaCertificar() {
        String lista = "";
        for (Curso curso : this.myCursos) {
            if (Curso.PENDIENTE_CERTIFICACION.equals(curso.getEstadoCurso())) {
                lista += opcionCurso(curso);
            }
        }
        return lista;
    }

    // RF6: participantes del curso. Formato: documento|nombre|procesado|asistencia|nota.
    // Se incluyen aprobados/no aprobados para permitir retomar un proceso interrumpido.
    public String listarParticipantesParaCertificar(String codigoCurso) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null || !Curso.PENDIENTE_CERTIFICACION.equals(curso.getEstadoCurso())) {
            return "";
        }
        String lista = "";
        for (Inscripcion inscripcion : curso.getMyInscripciones()) {
            if (!Inscripcion.RETIRADO.equals(inscripcion.getEstadoParticipante())) {
                lista += campoLista(inscripcion.getMyParticipante().getDocumento()) + "|"
                        + campoLista(inscripcion.getMyParticipante().getNombre()) + "|"
                        + inscripcion.isResultadoRegistrado() + "|"
                        + inscripcion.getPorcentajeAsistencia() + "|"
                        + inscripcion.getNotaFinal() + "/";
            }
        }
        return lista;
    }

    // RF6: registra la asistencia y nota, determina la certificación y conserva la causa.
    public String registrarResultadoParticipante(String codigoCurso, String documento,
            double porcentajeAsistencia, double notaFinal) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null) {
            return "No se encontró el curso seleccionado.";
        }
        if (!Curso.PENDIENTE_CERTIFICACION.equals(curso.getEstadoCurso())) {
            return "El curso debe tener sus recursos conciliados antes de registrar resultados.";
        }
        Inscripcion inscripcion = curso.buscarInscripcion(documento);
        if (inscripcion == null || !Inscripcion.INSCRITO.equals(inscripcion.getEstadoParticipante())) {
            return "El participante no está inscrito en este curso o ya fue procesado.";
        }
        String error = Inscripcion.validarResultado(porcentajeAsistencia, notaFinal);
        if (!error.isEmpty()) {
            return error;
        }
        inscripcion.registrarResultado(porcentajeAsistencia, notaFinal);
        return "RESULTADO REGISTRADO\n" + inscripcion.getMyParticipante().getNombre()
                + " | Asistencia: " + porcentajeAsistencia + "% | Nota: " + notaFinal
                + (inscripcion.isCertificado() ? "\nCERTIFICADO" : "\nNO CERTIFICADO - " + inscripcion.getCausaNoCertificado());
    }

    // Valida toda la tabla antes de aplicar el primer resultado.
    public String finalizarCurso(String codigo, ArrayList<String> documentos,
            ArrayList<Double> asistencias, ArrayList<Double> notas) {
        Curso curso = buscarCurso(codigo);
        if (curso == null || !Curso.PENDIENTE_CERTIFICACION.equals(curso.getEstadoCurso())) {
            return "El curso ya no está pendiente de certificación.";
        }
        if (documentos == null || asistencias == null || notas == null
                || documentos.size() != asistencias.size() || documentos.size() != notas.size()) {
            return "Complete la asistencia y la nota de cada participante.";
        }
        ArrayList<Inscripcion> pendientes = new ArrayList<>();
        for (int i = 0; i < documentos.size(); i++) {
            Inscripcion inscrito = curso.buscarInscripcion(documentos.get(i));
            if (inscrito == null || !Inscripcion.INSCRITO.equals(inscrito.getEstadoParticipante())
                    || pendientes.contains(inscrito)) {
                return "Revise la selección del curso: un participante está repetido o ya fue procesado.";
            }
            if (asistencias.get(i) == null || notas.get(i) == null) {
                return "Complete la asistencia y la nota de " + inscrito.getMyParticipante().getNombre() + ".";
            }
            String error = Inscripcion.validarResultado(asistencias.get(i), notas.get(i));
            if (!error.isEmpty()) {
                return inscrito.getMyParticipante().getNombre() + ": " + error;
            }
            pendientes.add(inscrito);
        }
        for (Inscripcion inscrito : curso.getMyInscripciones()) {
            if (Inscripcion.INSCRITO.equals(inscrito.getEstadoParticipante()) && !pendientes.contains(inscrito)) {
                return "Falta registrar el resultado de " + inscrito.getMyParticipante().getNombre() + ".";
            }
        }
        for (int i = 0; i < pendientes.size(); i++) {
            pendientes.get(i).registrarResultado(asistencias.get(i), notas.get(i));
        }
        return finalizarCurso(codigo);
    }

    // RF6: finaliza académicamente solo cuando todos los inscritos tienen resultado.
    public String finalizarCurso(String codigoCurso) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null) {
            return "No se encontró el curso seleccionado.";
        }
        if (!Curso.PENDIENTE_CERTIFICACION.equals(curso.getEstadoCurso())) {
            return "El curso debe tener los recursos conciliados y estar pendiente de certificación.";
        }

        int inscritos = 0;
        int certificados = 0;
        int noCertificados = 0;
        String detalle = "";
        for (Inscripcion inscripcion : curso.getMyInscripciones()) {
            if (!Inscripcion.RETIRADO.equals(inscripcion.getEstadoParticipante())) {
                inscritos++;
                if (!inscripcion.isResultadoRegistrado()) {
                    return "No se puede finalizar: falta registrar asistencia y nota de "
                            + inscripcion.getMyParticipante().getNombre() + ".";
                }
                if (inscripcion.isCertificado()) {
                    certificados++;
                    detalle += inscripcion.getMyParticipante().getNombre()
                            + " | Asistencia: " + inscripcion.getPorcentajeAsistencia()
                            + "% | Nota: " + inscripcion.getNotaFinal() + " | CERTIFICADO\n";
                } else {
                    noCertificados++;
                    detalle += inscripcion.getMyParticipante().getNombre()
                            + " | Asistencia: " + inscripcion.getPorcentajeAsistencia()
                            + "% | Nota: " + inscripcion.getNotaFinal()
                            + " | NO CERTIFICADO - " + inscripcion.getCausaNoCertificado() + "\n";
                }
            }
        }
        if (curso.getMyInscripciones().isEmpty()) {
            return "No se puede finalizar: el curso no tiene inscripciones.";
        }

        curso.setEstadoCurso(Curso.FINALIZADO);
        String porcentaje = inscritos == 0 ? "sin participantes evaluados"
                : String.format(java.util.Locale.US, "%.1f%%", certificados * 100.0 / inscritos);
        return "CURSO: " + curso.getCodigo() + " - " + curso.getNombreCurso() + "\n"
                + detalle + "\nInscritos: " + inscritos + " | Certificados: " + certificados
                + " | No certificados: " + noCertificados
                + "\nPorcentaje certificación: " + porcentaje
                + "\nEstado del curso: " + curso.getEstadoCurso();
    }

    
    //RF7 - informes de control
    public String informeCurso(String codigoCurso) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null) {
            return "El curso seleccionado no existe.";
        }

        String certificados = "";
        String noCertificados = "";
        String pendientes = "";
        String retirados = "";
        int totalCertificados = 0;
        int totalNoCertificados = 0;
        int inscritos = curso.getCantidadInscritos();

        for (Inscripcion inscripcion : curso.getMyInscripciones()) {
            Participante participante = inscripcion.getMyParticipante();
            String persona = participante.getDocumento() + " - " + participante.getNombre();
            String estado = inscripcion.getEstadoParticipante();

            if (null == estado) {
                pendientes += persona + "\n";
            } else switch (estado) {
                case Inscripcion.APROBADO -> {
                    certificados += persona + "\n";
                    totalCertificados++;
                }
                case Inscripcion.NO_APROBADO -> {
                    noCertificados += persona + " - " + inscripcion.getCausaNoCertificado() + "\n";
                    totalNoCertificados++;
                }
                case Inscripcion.RETIRADO -> retirados += persona + "\n";
                default -> pendientes += persona + "\n";
            }
        }

        Laboratorio laboratorio = curso.getMyLaboratorio();

        String informe = "INFORME DEL CURSO " + curso.getCodigo() + " - "
                + curso.getNombreCurso() + "\n";
        informe += "Estado: " + curso.getEstadoCurso() + "\n";
        informe += "Instructor: " + curso.getMyInstructor().getNombre() + "\n";
        informe += "Área tecnológica: " + curso.getAreaTecnologica() + "\n";
        informe += "Laboratorio: " + laboratorio.getCodigoLab() + " - "
                + laboratorio.getTipoLab() + "\n";
        informe += "Fechas: " + curso.getFechaInicio() + " al " + curso.getFechaFin() + "\n";
        informe += "Horario: " + curso.getHorarioInicio() + " a " + curso.getHorarioFin() + "\n";
        informe += "Población objetivo: " + curso.getPoblacionObjetivo() + "\n";
        informe += "Entidad solicitante: " + curso.getEntidadSolicitante() + "\n";

        informe += "\nCupo máximo: " + curso.getCupoCurso() + "\n";
        informe += "Inscritos: " + inscritos + "\n";
        informe += "Cupos disponibles: " + consultarCuposDisponibles(codigoCurso) + "\n";

        if (inscritos == 0 && retirados.isEmpty()) {
            return informe + "\nEl curso no tiene participantes inscritos.";
        }

        informe += "\nCERTIFICADOS (" + totalCertificados + ")\n" + certificados;
        informe += "\nNO CERTIFICADOS (" + totalNoCertificados + ")\n" + noCertificados;

        if (!retirados.isEmpty()) {
            informe += "\nRETIRADOS\n" + retirados;
        }

        if (!pendientes.isEmpty()) {
            informe += "\nPENDIENTES DE EVALUACIÓN\n" + pendientes;
            informe += "\nPorcentaje de certificación: pendiente.";
        } else if (totalCertificados + totalNoCertificados == 0) {
            informe += "\nPorcentaje de certificación: sin participantes evaluados.";
        } else {
            double porcentaje = 100.0 * totalCertificados / (totalCertificados + totalNoCertificados);
            informe += "\nPorcentaje de certificación: "
                    + String.format(java.util.Locale.US, "%.1f", porcentaje) + "%";
        }

        return informe;
    }

    public String informeInventario(String codigoLab) {
        Laboratorio laboratorio = buscarLaboratorio(codigoLab);
        if (laboratorio == null) {
            return "El laboratorio seleccionado no existe.";
        }

        String informe = "INVENTARIO DEL LABORATORIO " + laboratorio.getCodigoLab()
                + " - " + laboratorio.getTipoLab() + "\n";

        long totalUnidadesDaniadas = 0;
        long totalDanios = 0;
        long totalPerdidas = 0;

        for (Recurso recurso : laboratorio.getRecursos()) {
            int daniadas = recurso.getCantidadDaniada();
            int perdidas = recurso.getCantidadPerdida();
            long valorUnitario = recurso.getValorUnitario();

            totalUnidadesDaniadas += daniadas;
            totalDanios += recurso.calcularCostoDanio(daniadas);
            totalPerdidas += perdidas * valorUnitario;

            informe += "\n" + recurso.getIdentificador() + " - " + recurso.getDescripcion() + "\n";
            informe += "Total actual: " + recurso.getCantidadTotal()
                    + " | Disponibles: " + recurso.getCantidadDisponible()
                    + " | En uso: " + recurso.getCantidadEnUso() + "\n";
            informe += "Dañadas: " + daniadas
                    + " | Pérdidas acumuladas: " + perdidas + "\n";
        }

        informe += "\nTotal de unidades dañadas: " + totalUnidadesDaniadas + "\n";
        informe += "Costo estimado de los daños: " + formatoPesos(totalDanios) + "\n";
        informe += "Valor de las pérdidas: " + formatoPesos(totalPerdidas) + "\n";
        informe += "Valor total de las afectaciones: "
                + formatoPesos(totalDanios + totalPerdidas);

        return informe;
    }

    public String informeConsolidado() {
        int programados = 0;
        int inscripcionesAbiertas = 0;
        int enFormacion = 0;
        int pendientesCertificacion = 0;
        int finalizados = 0;
        int cancelados = 0;

        // Contar los cursos según su estado.
        for (Curso curso : this.myCursos) {
            String estado = curso.getEstadoCurso();

            if (null != estado) switch (estado) {
                case Curso.PROGRAMADO -> programados++;
                case Curso.INSCRIPCIONES_ABIERTAS -> inscripcionesAbiertas++;
                case Curso.EN_FORMACION -> enFormacion++;
                case Curso.PENDIENTE_CERTIFICACION -> pendientesCertificacion++;
                case Curso.FINALIZADO -> finalizados++;
                case Curso.CANCELADO -> cancelados++;
                default -> {
                }
            }
        }

        int mayorCantidad = 0;
        String areasConMasCursos = "";
        long totalDanios = 0;
        long totalPerdidas = 0;

        for (Laboratorio laboratorio : this.myLaboratorios) {
            if (laboratorio != null) {
                // En el proyecto, cada laboratorio corresponde a un área distinta.
                String area = laboratorio.getTipoLab();
                int cantidadRealizados = 0;

                for (Curso curso : this.myCursos) {
                    if (Curso.FINALIZADO.equals(curso.getEstadoCurso())
                            && area.equalsIgnoreCase(curso.getAreaTecnologica())) {
                        cantidadRealizados++;
                    }
                }

                if (cantidadRealizados > mayorCantidad) {
                    mayorCantidad = cantidadRealizados;
                    areasConMasCursos = area;
                } else if (cantidadRealizados > 0 && cantidadRealizados == mayorCantidad) {
                    areasConMasCursos += ", " + area;
                }

                // Sumar las afectaciones de los recursos de este laboratorio.
                for (Recurso recurso : laboratorio.getRecursos()) {
                    long valorUnitario = recurso.getValorUnitario();
                    totalDanios += recurso.calcularCostoDanio(recurso.getCantidadDaniada());
                    totalPerdidas += recurso.getCantidadPerdida() * valorUnitario;
                }
            }
        }

        String informe = "INFORME CONSOLIDADO DEL FABLAB\n";
        informe += "\nCURSOS POR ESTADO\n";
        informe += "Programados: " + programados + "\n";
        informe += "Con inscripciones abiertas: " + inscripcionesAbiertas + "\n";
        informe += "En formación: " + enFormacion + "\n";
        informe += "Pendientes de certificación: " + pendientesCertificacion + "\n";
        informe += "Finalizados: " + finalizados + "\n";
        informe += "Cancelados: " + cancelados + "\n";

        informe += "\nÁREA CON MÁS CURSOS REALIZADOS\n";
        if (mayorCantidad == 0) {
            informe += "Todavía no hay cursos finalizados.\n";
        } else {
            informe += "Área(s): " + areasConMasCursos + "\n";
            informe += "Cursos finalizados por área indicada: " + mayorCantidad + "\n";
        }

        informe += "\nAFECTACIONES DEL FABLAB\n";
        informe += "Costo estimado de los daños: " + formatoPesos(totalDanios) + "\n";
        informe += "Valor de las pérdidas: " + formatoPesos(totalPerdidas) + "\n";
        informe += "Valor total de las afectaciones: "
                + formatoPesos(totalDanios + totalPerdidas);

        return informe;
    }

    public String listarTodosLosCursos() {
        String cad = "";
        for (Curso curso : this.myCursos) {
            cad += opcionCurso(curso);
        }
        return cad;
    }

    public String listarLosLaboratorios() {
        String cad = "";
        for (Laboratorio laboratorio : this.myLaboratorios) {
            if (laboratorio != null) {
                cad += campoLista(laboratorio.getCodigoLab()) + " - " + campoLista(laboratorio.getTipoLab()) + "/";
            }
        }
        return cad;
    }

    private void cargarCursosDeEjemplo() {
        LocalDate hoy = LocalDate.now();

        // Programar un curso por laboratorio.
        programarCurso("C001", "Pilotaje de drones", hoy, hoy.plusDays(2),
                LocalTime.of(8, 0), LocalTime.of(10, 0), 10, "General",
                "L01", "1090123456", "Drones", "Comunidad UFPS");

        programarCurso("C002", "Introducción a realidad aumentada", hoy, hoy.plusDays(2),
                LocalTime.of(10, 0), LocalTime.of(12, 0), 8, "General",
                "L02", "1090234567", "Realidad Aumentada", "Comunidad UFPS");

        programarCurso("C003", "Diseño e impresión 3D", hoy, hoy.plusDays(2),
                LocalTime.of(14, 0), LocalTime.of(16, 0), 6, "General",
                "L03", "1090345678", "Impresión 3D", "Comunidad UFPS");

        // Inscribir a dos participantes en cada curso.
        realizarInscripcion("C001", hoy, "1090444444", "Cúcuta", "General", "ESTUDIANTE_UFPS");
        realizarInscripcion("C001", hoy, "1090555555", "Cúcuta", "General", "ESTUDIANTE_UFPS");

        realizarInscripcion("C002", hoy, "1090666666", "Cúcuta", "General", "ESTUDIANTE_UFPS");
        realizarInscripcion("C002", hoy, "1090777777", "Cúcuta", "General", "ESTUDIANTE_UFPS");

        realizarInscripcion("C003", hoy, "1090444444", "Cúcuta", "General", "ESTUDIANTE_UFPS");
        realizarInscripcion("C003", hoy, "1090666666", "Cúcuta", "General", "ESTUDIANTE_UFPS");

        // Iniciar cada curso con dos tipos de recurso de su laboratorio.
        iniciarCursoDeEjemplo("C001", "DR-01", 2, "DR-03", 4);
        iniciarCursoDeEjemplo("C002", "RA-01", 2, "RA-02", 2);
        iniciarCursoDeEjemplo("C003", "I3-01", 1, "I3-02", 3);
    }

    private void iniciarCursoDeEjemplo(String curso, String recurso1, int cantidad1,
            String recurso2, int cantidad2) {

        ArrayList<String> codigos = new ArrayList<>();
        codigos.add(recurso1);
        codigos.add(recurso2);

        ArrayList<Integer> cantidades = new ArrayList<>();
        cantidades.add(cantidad1);
        cantidades.add(cantidad2);

        iniciarCurso(curso, codigos, cantidades);
    }
}
