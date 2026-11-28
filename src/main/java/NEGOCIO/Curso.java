package NEGOCIO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Curso {

    // Posibles valores del atributo estadoCurso
    public static final String PROGRAMADO = "PROGRAMADO";
    public static final String INSCRIPCIONES_ABIERTAS = "INSCRIPCIONES_ABIERTAS";
    public static final String EN_FORMACION = "EN_FORMACION";
    public static final String PENDIENTE_CERTIFICACION = "PENDIENTE_CERTIFICACION";
    public static final String FINALIZADO = "FINALIZADO";
    public static final String CANCELADO = "CANCELADO";

    public static final String GENERAL = "General";
    public static final String ENTIDAD_UFPS = "Comunidad UFPS";

    private final String nombreCurso;
    private final String areaTecnologica;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final LocalTime horarioInicio;
    private final LocalTime horarioFin;
    private final int cupoCurso;
    private final String poblacionObjetivo;
    private final String entidadSolicitante;
    private String estadoCurso;
    private final String codigo;
    private final Instructor myInstructor;
    private final Laboratorio myLaboratorio;

    // Recursos que el curso se llevo: cada EntregaRecurso une este curso con un recurso
    private final ArrayList<EntregaRecurso> myEntregas;

    // Inscripciones de este curso: de aqui sale la cantidad de inscritos (no se guarda aparte)
    private final ArrayList<Inscripcion> myInscripciones;

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
        this.myEntregas = new ArrayList<EntregaRecurso>();
        this.myInscripciones = new ArrayList<Inscripcion>();
    }

    public boolean recibeInscripciones() {
        return PROGRAMADO.equals(this.estadoCurso) || INSCRIPCIONES_ABIERTAS.equals(this.estadoCurso);
    }

    /** Cantidad de inscritos, calculada a partir de las inscripciones del curso. */
    public int getCantidadInscritos() {
        int activos = 0;
        for (Inscripcion inscrito : myInscripciones) {
            if (!Inscripcion.RETIRADO.equals(inscrito.getEstadoParticipante())) {
                activos++;
            }
        }
        return activos;
    }

    Inscripcion buscarInscripcion(String documento) {
        if (documento != null) {
            for (Inscripcion inscrito : myInscripciones) {
                if (inscrito.getMyParticipante().getDocumento().equalsIgnoreCase(documento.strip())) {
                    return inscrito;
                }
            }
        }
        return null;
    }

    /** Registra una inscripcion asociada a este curso. */
    void agregarInscripcion(Inscripcion inscripcion) {
        this.myInscripciones.add(inscripcion);
        this.estadoCurso = INSCRIPCIONES_ABIERTAS;
    }

    /** Devuelve una copia de las inscripciones para evitar exponer la lista interna. */
    public ArrayList<Inscripcion> getMyInscripciones() {
        return new ArrayList<>(this.myInscripciones);
    }
    
    /** Registra una entrega de recursos asociada a este curso. */
    void agregarEntrega(EntregaRecurso entrega) {
        this.myEntregas.add(entrega);
    }

    /** Devuelve una copia de las entregas para evitar exponer la lista interna. */
    public ArrayList<EntregaRecurso> getMyEntregas() {
        return new ArrayList<>(this.myEntregas);
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getAreaTecnologica() {
        return areaTecnologica;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFin() {
        return horarioFin;
    }

    public int getCupoCurso() {
        return cupoCurso;
    }

    public String getEntidadSolicitante() {
        return entidadSolicitante;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    void setEstadoCurso(String nuevoEstado) {
        boolean permitido = (recibeInscripciones() && (EN_FORMACION.equals(nuevoEstado) || CANCELADO.equals(nuevoEstado)))
                || (EN_FORMACION.equals(estadoCurso) && PENDIENTE_CERTIFICACION.equals(nuevoEstado))
                || (PENDIENTE_CERTIFICACION.equals(estadoCurso) && FINALIZADO.equals(nuevoEstado));
        if (!permitido) {
            throw new IllegalStateException("El curso no puede pasar de " + estadoCurso + " a " + nuevoEstado);
        }
        this.estadoCurso = nuevoEstado;
    }

    public String getCodigo() {
        return codigo;
    }

    public Laboratorio getMyLaboratorio() {
        return myLaboratorio;
    }

    public Instructor getMyInstructor() {
        return myInstructor;
    }

    public String getPoblacionObjetivo() {
        return poblacionObjetivo;
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
