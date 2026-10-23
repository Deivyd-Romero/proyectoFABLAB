package NEGOCIO;

import java.util.ArrayList;

public class FABLAB {

    private ArrayList<Laboratorio> myLaboratorios;
    // Aqui van todas las personas (instructores y participantes)
    private ArrayList<Persona> myPersonas;
    // Todas las inscripciones del FABLAB (cada curso tambien guarda las suyas)
    private ArrayList<Inscripcion> myInscripciones;

    /*
    Requerimiento 1 inicializar la operacion del FABLAB
    Requerimiento 2 programar un curso de formacion
    Requerimiento 3 gestionar la inscripcion de participantes
    Requerimiento 4 preparar e iniciar un curso mediante entrega de recursos
    Requerimiento 5 cerrar el curso y conciliar los recursos utilizados
    Requerimiento 6 finalizar la formacion y determinar la certificacion
    Requerimiento 7 consultas e informes de control
     */
    public FABLAB() {
        this.myLaboratorios = new ArrayList<Laboratorio>();
        this.myPersonas = new ArrayList<Persona>();
        this.myInscripciones = new ArrayList<Inscripcion>();
        this.crearLaboratorios();
        this.crearRecursos();
        this.crearUsuariosBase();
    }

    //RF1 - metodos para inicializar el FABLAB
    private void crearLaboratorios() {

    }

    private void crearRecursos() {

    }

    private void crearUsuariosBase() {

    }

    //RF2 - retorna el mensaje de curso programado o la causa por la cual no se pudo programar
    public String programarCurso(String codigo, String nombreCurso, String areaTecnologica, String fechaInicio, String fechaFin,
            String horarioInicio, String horarioFin, int cupoCurso, String poblacionObjetivo,
            String entidadSolicitante, String codigoLab, String documentoInstructor) {
        return "";
    }

    //RF3 - registra la persona que aun no existe en el sistema
    public String registrarParticipante(String documento, String nombre, String correo, String telefono,
            String procedencia, String tipoPoblacion, String vinculacion) {
        return "";
    }

    //RF3 - retorna el mensaje de inscripcion exitosa o la causa por la cual no se pudo inscribir
    public String inscribirParticipante(String codigoCurso, String documento, String fechaInscripcion) {
        return "";
    }

    //RF4 - las listas son paralelas: la cantidad solicitada de cada recurso esta en la misma posicion
    //(Integer es la version "objeto" de int: las listas no aceptan tipos primitivos)
    public String iniciarCurso(String codigoCurso, ArrayList<String> codigosRecursos, ArrayList<Integer> cantidadesSolicitadas) {
        return "";
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

    //Metodos privados de buscar objetos
    private Laboratorio buscarLaboratorio(String codigoLab) {
        return null;
    }

    private Curso buscarCurso(String codigoCurso) {
        return null;
    }

    private Persona buscarPersona(String documento) {
        return null;
    }

}
