package NEGOCIO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

public class FABLAB {

    private Laboratorio[] myLaboratorios;
    private HashSet<Persona> myPersonas;
    private ArrayList<Inscripcion> myInscripciones;
    private ArrayList<RecursoTecnologico> myInventario;
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
        this.crearEspacioMemoria();
        this.crearRecursos();
        this.crearLaboratorios();
        this.asignarRecursosLaboratorio();
        this.crearPersonas();
    }

    //RF1 - crea las colecciones vacias
    private void crearEspacioMemoria() {
        this.myLaboratorios = new Laboratorio[5];
        this.myPersonas = new HashSet<>();
        this.myInscripciones = new ArrayList<>();
        this.myInventario = new ArrayList<>();
        this.myCursos = new ArrayList<>();
    }

    //RF1 - carga el inventario inicial de recursos tecnologicos
    private void crearRecursos() {
        this.myInventario.add(new RecursoTecnologico("DR-01", "Drone de formación", "EQUIPO", 6, 1500000));
        this.myInventario.add(new RecursoTecnologico("DR-02", "Control remoto", "EQUIPO", 6, 450000));
        this.myInventario.add(new RecursoTecnologico("DR-03", "Batería recargable", "EQUIPO", 12, 350000));
        this.myInventario.add(new RecursoTecnologico("RA-01", "Visor de realidad aumentada", "EQUIPO", 10, 1800000));
        this.myInventario.add(new RecursoTecnologico("RA-02", "Tablet de apoyo", "EQUIPO", 10, 900000));
        this.myInventario.add(new RecursoTecnologico("I3-01", "Impresora 3D", "EQUIPO", 6, 2800000));
        this.myInventario.add(new RecursoTecnologico("I3-02", "Filamento PLA (unidad académica)", "MATERIAL", 20, 90000));
        this.myInventario.add(new RecursoTecnologico("IO-01", "Kit Arduino", "EQUIPO", 20, 180000));
        this.myInventario.add(new RecursoTecnologico("IO-02", "Kit de sensores", "EQUIPO", 20, 120000));
        this.myInventario.add(new RecursoTecnologico("IO-03", "Protoboard", "EQUIPO", 20, 30000));
        this.myInventario.add(new RecursoTecnologico("CD-01", "Cámara digital", "EQUIPO", 6, 3200000));
        this.myInventario.add(new RecursoTecnologico("CD-02", "Micrófono inalámbrico", "EQUIPO", 8, 650000));
        this.myInventario.add(new RecursoTecnologico("CD-03", "Kit de iluminación LED", "EQUIPO", 6, 750000));
        this.myInventario.add(new RecursoTecnologico("CD-04", "Trípode para cámara", "EQUIPO", 6, 280000));
        this.myInventario.add(new RecursoTecnologico("CD-05", "Tableta digitalizadora", "EQUIPO", 10, 550000));
    }

    //RF1 - crea los cinco laboratorios (todos DISPONIBLE) y les entrega sus recursos
    private void crearLaboratorios() {
        ArrayList<RecursoTecnologico> recursosDeDrones = new ArrayList<>(this.myInventario.subList(0, 3));
        ArrayList<RecursoTecnologico> recursosDeRealidadAumentada = new ArrayList<>(this.myInventario.subList(3, 5));
        ArrayList<RecursoTecnologico> recursosDeImpresion3D = new ArrayList<>(this.myInventario.subList(5, 7));
        ArrayList<RecursoTecnologico> recursosDeIoT = new ArrayList<>(this.myInventario.subList(7, 10));
        ArrayList<RecursoTecnologico> recursosDeContenidosDigitales = new ArrayList<>(this.myInventario.subList(10, 15));
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
        if (!laboratorio.getTipoLab().equalsIgnoreCase(areaTecnologica)) {
            return "No se puede programar: el área tecnológica seleccionada no coincide con el tipo de laboratorio ("
                    + laboratorio.getTipoLab() + ").";
        }
        if (cupoCurso > laboratorio.getCapacidadMax()) {
            return "No se puede programar: el cupo (" + cupoCurso + ") supera la capacidad del laboratorio ("
                    + laboratorio.getCapacidadMax() + ").";
        }
        if (fechaInicio.isAfter(fechaFin)) {
            return "No se puede programar: la fecha de inicio debe ser antes de la fecha de finalización.";
        }
        if (!horarioInicio.isBefore(horarioFin)) {
            return "No se puede programar: la hora de inicio debe ser antes de la hora de finalización.";
        }
        if (entidadSolicitante == null || entidadSolicitante.trim().isEmpty()) {
            return "No se puede programar: debe indicar la entidad solicitante.";
        }

        String documento = extraerDocumento(documentoInstructor);
        Instructor instructor = buscarInstructor(documento);
        if (instructor == null) {
            return "No se puede programar: el instructor indicado no está registrado.";
        }

        if (laboratorioOcupado(codigoLab, fechaInicio, fechaFin, horarioInicio, horarioFin)) {
            return "No se puede programar: el laboratorio " + codigoLab + " ya está ocupado en una fecha "
                    + "y horario que se cruza con otro curso.";
        }
        if (instructorOcupado(documento, fechaInicio, fechaFin, horarioInicio, horarioFin)) {
            return "No se puede programar: el instructor ya tiene un curso asignado en una fecha y horario que se cruza.";
        }

        Curso nuevoCurso = new Curso(nombreCurso, areaTecnologica, fechaInicio, fechaFin,
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

    //RF2 - retorna los codigos (separados por /) de los laboratorios disponibles y libres en esas fechas y horas
    public String consultarLaboratorios(LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin) {
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
        String lista = "";
        for (Persona persona : this.myPersonas) {
            if (persona instanceof Instructor
                    && !instructorOcupado(persona.getDocumento(), fechaInicio, fechaFin, horarioInicio, horarioFin)) {
                lista += persona.getNombre() + "-" + persona.getDocumento() + "/";
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
        return verificarCruzesFechasYHoras(fechaInicio, fechaFin, horarioInicio, horarioFin,
                curso.getFechaInicio(), curso.getFechaFin(), curso.getHorarioInicio(), curso.getHorarioFin());
    }

    //RF2 - retorna true si los rangos de fechas se solapan y tambien los rangos de horas
    private boolean verificarCruzesFechasYHoras(LocalDate f1Inicio, LocalDate f1Fin,
            LocalTime h1Inicio, LocalTime h1Fin, LocalDate f2Inicio, LocalDate f2Fin,
            LocalTime h2Inicio, LocalTime h2Fin) {

        if (!f1Inicio.isAfter(f2Fin) && !f2Inicio.isAfter(f1Fin)) {
            if (h1Inicio.isBefore(h2Fin) && h2Inicio.isBefore(h1Fin)) {
                return true;
            }
        }

        return false;
    }

    //RF2 - retorna el laboratorio con ese codigo o null si no existe
    private Laboratorio buscarLaboratorio(String codigoLab) {
        if (codigoLab == null) {
            return null;
        }
        for (int i = 0; i < this.myLaboratorios.length; i++) {
            if (this.myLaboratorios[i] != null
                    && this.myLaboratorios[i].getCodigoLab().equals(codigoLab)) {
                return this.myLaboratorios[i];
            }
        }
        return null;
    }

    //RF2 - retorna el curso con ese codigo o null si no existe
    private Curso buscarCurso(String codigoCurso) {
        if (codigoCurso == null) {
            return null;
        }
        for (int i = 0; i < this.myCursos.size(); i++) {
            if (this.myCursos.get(i).getCodigo().equals(codigoCurso)) {
                return this.myCursos.get(i);
            }
        }
        return null;
    }

    //RF2 - retorna el documento de una opcion con formato "nombre-documento"
    private String extraerDocumento(String seleccion) {
        int separador = seleccion.lastIndexOf('-');
        return separador >= 0 ? seleccion.substring(separador + 1).trim() : seleccion.trim();
    }

    //RF2 - retorna el instructor con ese documento o null si no existe
    private Instructor buscarInstructor(String documento) {
        Persona persona = buscarPersonaExistente(documento);
        if (persona instanceof Instructor) {
            return (Instructor) persona;
        }
        return null;
    }

    //RF3 - registra la persona que aun no existe en el sistema
    public String registrarPersona(String documento, String nombre, String correo, String telefono,
            String rol) {
        if (buscarPersonaExistente(documento) != null) {
            return "Ya hay una persona registrada con ese documento";
        }

        Persona persona;
        if (Participante.ROL.equalsIgnoreCase(rol)) {
            persona = new Participante("", "", "", nombre, correo, telefono, documento, Participante.ROL);
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
            cad += myP.getNombre() + "/" + myP.getCorreo() + "/" + myP.getTelefono() + "/" + myP.getRol() + "/";
        }

        return cad;
    }

    //RF3 - retorna la persona con ese documento o null si no esta registrada
    private Persona buscarPersonaExistente(String documento) {
        for (Persona p : this.myPersonas) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }

    //RF3 - retorna el numero que le corresponde a la proxima inscripcion
    public int contadorInscripciones() {
        return this.myInscripciones.size() + 1;
    }

    //RF3 - retorna los cursos que reciben inscripciones como "codigo - nombre" separados por /
    public String listarCursos() {
        String cad = "";
        for (Curso c : this.myCursos) {
            if (c.recibeInscripciones()) {
                cad += c.getCodigo() + " - " + c.getNombreCurso() + "/";
            }
        }
        return cad;
    }

    //RF3 - retorna true si el curso existe y todavia recibe inscripciones
    public boolean cursoDisponible(String idCurso) {
        Curso curso = buscarCurso(idCurso);
        return curso != null && curso.recibeInscripciones();
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

    //RF3 - retorna true si el participante ya esta inscrito en el curso
    private boolean comprobarInscripcionesRepetidas(String idCurso, String documento) {
        for (Inscripcion inscripcion : this.myInscripciones) {
            String codigoInscrito = inscripcion.getMyCurso().getCodigo();
            String documentoInscrito = inscripcion.getMyParticipante().getDocumento();

            if (codigoInscrito.equals(idCurso) && documentoInscrito.equals(documento)) {
                return true;
            }
        }
        return false;
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
    public String realizarInscripcion(String idCurso, String fechaInscripcion, String documento,
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
        if (comprobarInscripcionesRepetidas(idCurso, documento)) {
            return "No puede inscribirse dos veces al mismo curso";
        }
        if (consultarCuposDisponibles(idCurso) <= 0) {
            return "No hay cupos disponibles en el curso.";
        }
        String causaPoblacion = validarPoblacionObjetivo(curso, tipoPoblacion, vinculacion);
        if (!causaPoblacion.isEmpty()) {
            return causaPoblacion;
        }

        participante.setProcedencia(procedencia);
        participante.setTipoPoblacion(tipoPoblacion);
        participante.setVinculacion(vinculacion);

        Inscripcion inscripcion = new Inscripcion(contadorInscripciones(), fechaInscripcion, participante, curso);
        this.myInscripciones.add(inscripcion);
        curso.setCantidadInscritos(curso.getCantidadInscritos() + 1);

        return "INSCRIPCIÓN EXITOSA\n"
                + "Inscripción: I-" + String.format("%03d", inscripcion.getNumInscripcion()) + "\n"
                + "Participante: " + participante.getDocumento() + " - " + participante.getNombre() + "\n"
                + "Vinculación: " + vinculacion + "\n"
                + "Curso: " + curso.getCodigo() + " - " + curso.getNombreCurso() + "\n"
                + "Estado: " + inscripcion.getEstadoParticipante() + "\n"
                + "Cupos disponibles: " + consultarCuposDisponibles(idCurso);
    }

    //RF4 - retorna true si el curso todavia no ha iniciado (esta PROGRAMADO o con INSCRIPCIONES_ABIERTAS)
    private boolean cursoListoParaIniciar(Curso curso) {
        return Curso.PROGRAMADO.equals(curso.getEstadoCurso())
                || Curso.INSCRIPCIONES_ABIERTAS.equals(curso.getEstadoCurso());
    }

    //RF4 - retorna los cursos que se pueden iniciar como "codigo - nombre" separados por /
    public String listarCursosParaIniciar() {
        String lista = "";
        for (Curso curso : this.myCursos) {
            if (cursoListoParaIniciar(curso)) {
                lista += curso.getCodigo() + " - " + curso.getNombreCurso() + "/";
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
        for (RecursoTecnologico recurso : curso.getMyLaboratorio().getRecursos()) {
            lista += recurso.getIdentificador() + "|" + recurso.getDescripcion()
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
        if (!cursoListoParaIniciar(curso)) {
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

        ArrayList<RecursoTecnologico> recursosSeleccionados = new ArrayList<>();
        for (int i = 0; i < codigosRecursos.size(); i++) {
            String codigo = codigosRecursos.get(i);
            int cantidad = cantidadesSolicitadas.get(i) == null ? 0 : cantidadesSolicitadas.get(i);
            RecursoTecnologico encontrado = laboratorio.buscarRecurso(codigo);
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
            RecursoTecnologico recurso = recursosSeleccionados.get(i);
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

    //RF5 - las listas son paralelas: la conciliacion de cada recurso esta en la misma posicion
    public String cerrarCurso(String codigoCurso, ArrayList<String> codigosRecursos, ArrayList<Integer> cantidadesBuenas,
            ArrayList<Integer> cantidadesDaniadas, ArrayList<Integer> cantidadesPerdidas) {
        return "";
    }

    //RF6 - registra asistencia y nota de un participante y retorna si queda certificado o la causa
    public String registrarResultadoParticipante(String codigoCurso, String documento, double porcentajeAsistencia, double notaFinal) {
        return "";
    }

    //RF6 - retorna el resumen de certificacion del curso o la causa por la cual no se pudo finalizar
    public String finalizarCurso(String codigoCurso) {
        return "";
    }

    //RF7 - informes de control
    public String informeCurso(String codigoCurso) {
        return "";
    }

    public String informeInventario(String codigoLab) {
        return "";
    }

    public String informeConsolidado() {
        return "";
    }
}
