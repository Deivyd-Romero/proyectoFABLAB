package NEGOCIO;

public class FABLAB {
    private int numLaboratorios = 5;
    private int maxPersonas = 100;
    private int maxInscripciones = 200;

    private Laboratorio[] myLaboratorios;
    private Persona[] myPersonas;
    private Inscripcion[] myInscripciones;

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
        this.myLaboratorios = new Laboratorio[numLaboratorios];
        this.myPersonas = new Persona[maxPersonas];
        this.myInscripciones = new Inscripcion[maxInscripciones];
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

    //RF4 - los arreglos son paralelos: la cantidad solicitada de cada recurso esta en la misma posicion
    public String iniciarCurso(String codigoCurso, String[] codigosRecursos, int[] cantidadesSolicitadas) {
        return "";
    }

    //RF5 - los arreglos son paralelos: la conciliacion de cada recurso esta en la misma posicion
    public String cerrarCurso(String codigoCurso, String[] codigosRecursos, int[] cantidadesBuenas,
            int[] cantidadesDaniadas, int[] cantidadesPerdidas) {
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
