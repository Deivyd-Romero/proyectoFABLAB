package NEGOCIO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Curso {

    // Posibles valores del atributo estadoCurso
    public static final String PROGRAMADO = "PROGRAMADO";
    public static final String INSCRIPCIONES_ABIERTAS = "INSCRIPCIONES_ABIERTAS";
    public static final String EN_FORMACION = "EN_FORMACION";
    public static final String FINALIZADO = "FINALIZADO";
    public static final String CANCELADO = "CANCELADO";

    public static final String GENERAL = "General";
    public static final String ENTIDAD_UFPS = "Comunidad UFPS";

    private String nombreCurso;
    private String areaTecnologica;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;
    private int cupoCurso;
    private String poblacionObjetivo;
    private String entidadSolicitante;
    private String estadoCurso;
    private String codigo;
    private Instructor myInstructor;
    private int cantidadInscritos;
    private Laboratorio myLaboratorio;

    // Recursos que el curso se llevo: cada entrega identifica el laboratorio, el código y la cantidad
    private ArrayList<EntregaRecurso> myEntregas;

    public Curso(String nombreCurso, String areaTecnologica, LocalDate fechaInicio, LocalDate fechaFin,
            LocalTime horarioInicio, LocalTime horarioFin, int cupoCurso, String poblacionObjetivo,
            String entidadSolicitante, String codigo, Laboratorio myLaboratorio, Instructor myInstructor) {
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
        this.myLaboratorio = myLaboratorio;
        this.myInstructor = myInstructor;
        this.estadoCurso = PROGRAMADO;
        this.cantidadInscritos = 0;
        this.myEntregas = new ArrayList<EntregaRecurso>();
    }

    public boolean recibeInscripciones() {
        return PROGRAMADO.equals(this.estadoCurso) || INSCRIPCIONES_ABIERTAS.equals(this.estadoCurso);
    }

    public int getCantidadInscritos() {
        return cantidadInscritos;
    }

    public void setCantidadInscritos(int cantidadInscritos) {
        this.cantidadInscritos = cantidadInscritos;
    }
    
    /** Registra una entrega de recursos asociada a este curso. */
    public void agregarEntrega(EntregaRecurso entrega) {
        this.myEntregas.add(entrega);
    }

    /** Devuelve una copia de las entregas para evitar exponer la lista interna. */
    public ArrayList<EntregaRecurso> getMyEntregas() {
        return new ArrayList<>(this.myEntregas);
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(LocalTime horarioFin) {
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

    public Laboratorio getMyLaboratorio() {
        return myLaboratorio;
    }

    public void setMyLaboratorio(Laboratorio myLaboratorio) {
        this.myLaboratorio = myLaboratorio;
    }

    public Instructor getMyInstructor() {
        return myInstructor;
    }

    public void setMyInstructor(Instructor myInstructor) {
        this.myInstructor = myInstructor;
    }

    public String getPoblacionObjetivo() {
        return poblacionObjetivo;
    }

    public void setPoblacionObjetivo(String poblacionObjetivo) {
        this.poblacionObjetivo = poblacionObjetivo;
    }

    @Override
    public String toString() {
        String lab = (this.myLaboratorio == null) ? "" : this.myLaboratorio.getCodigoLab();
        String instructor = (this.myInstructor == null) ? "" : this.myInstructor.getNombre();
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
                + "Laboratorio = " + lab + "\n"
                + "Instructor = " + instructor + "\n";
    }
}
