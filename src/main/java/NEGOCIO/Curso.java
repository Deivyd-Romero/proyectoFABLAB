package NEGOCIO;

import java.util.*;

public class Curso {

    // Posibles valores del atributo estadoCurso
    private String programado = "PROGRAMADO";
    private String inscripcionesAbiertas = "INSCRIPCIONES_ABIERTAS";
    private String enFormacion = "EN_FORMACION";
    private String finalizado = "FINALIZADO";
    private String cancelado = "CANCELADO";

    private String nombreCurso;
    private String areaTecnologica;
    private String fechaInicio;
    private String fechaFin;
    private String horarioInicio;
    private String horarioFin;
    private int cupoCurso;
    private String poblacionObjetivo;
    private String entidadSolicitante;
    private String estadoCurso;
    private String codigo;
    private Persona myInstructor;
    
    // Inscripciones del curso.
    private ArrayList<Inscripcion> myInscripciones;
    // Recursos que el curso se llevo: cada EntregaRecurso une este curso con un recurso
    private ArrayList<EntregaRecurso> myEntregas;

    public Curso(String nombreCurso, String areaTecnologica, String fechaInicio, String fechaFin,
            String horarioInicio, String horarioFin, int cupoCurso, String poblacionObjetivo,
            String entidadSolicitante, String codigo, Persona myInstructor) {
        this.nombreCurso = nombreCurso;
        this.areaTecnologica = areaTecnologica;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.cupoCurso = cupoCurso;
        this.poblacionObjetivo = poblacionObjetivo;
        this.entidadSolicitante = entidadSolicitante;
        this.codigo = codigo;
        this.myInstructor = myInstructor;
        this.estadoCurso = programado;
        // Las listas empiezan vacias y crecen solas al agregar elementos
        this.myInscripciones = new ArrayList<Inscripcion>();
        this.myEntregas = new ArrayList<EntregaRecurso>();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getAreaTecnologica() {
        return areaTecnologica;
    }

    public void setAreaTecnologica(String areaTecnologica) {
        this.areaTecnologica = areaTecnologica;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

    public int getCupoCurso() {
        return cupoCurso;
    }

    public void setCupoCurso(int cupoCurso) {
        this.cupoCurso = cupoCurso;
    }

    public String getEntidadSolicitante() {
        return entidadSolicitante;
    }

    public void setEntidadSolicitante(String entidadSolicitante) {
        this.entidadSolicitante = entidadSolicitante;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPoblacionObjetivo() {
        return poblacionObjetivo;
    }

    public void setPoblacionObjetivo(String poblacionObjetivo) {
        this.poblacionObjetivo = poblacionObjetivo;
    }

    public Persona getMyInstructor() {
        return myInstructor;
    }

    public void setMyInstructor(Persona myInstructor) {
        this.myInstructor = myInstructor;
    }

    @Override
    public String toString() {
        return "Nombre del curso = " + this.nombreCurso + "\n"
                + "Area Tecnologica = " + this.areaTecnologica + "\n"
                + "Fecha de inicio = " + this.fechaInicio + "\n"
                + "Fecha de finalización = " + this.fechaFin + "\n"
                + "Horario de inicio = " + this.horarioInicio + "\n"
                + "Horario de finalización = " + this.horarioFin + "\n"
                + "Cupos = " + this.cupoCurso + "\n"
                + "Poblacion objetivo = " + this.poblacionObjetivo + "\n"
                + "Entidad solicitante = " + this.entidadSolicitante + "\n"
                + "Estado del curso=" + this.estadoCurso + "\n"
                + "Código = " + this.codigo + "\n"
                + //Si no hay instructor muestra "Sin asignar"
                "Instructor = " + (this.myInstructor == null ? "Sin asignar" : this.myInstructor.getNombre());
    }
}
