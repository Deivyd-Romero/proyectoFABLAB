package NEGOCIO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Inscripcion {

    // Posibles valores del atributo estadoParticipante
    public static final String INSCRITO = "INSCRITO";
    public static final String RETIRADO = "RETIRADO";
    public static final String APROBADO = "APROBADO";
    public static final String NO_APROBADO = "NO_APROBADO";

    private final int numInscripcion;
    private final LocalDate fechaInscripcion;
    private double porcentajeAsistencia;
    private double notaFinal;
    private String estadoParticipante;
    private final Participante myParticipante;
    private String causaNoCertificado;   // si no se certifico, aqui se guarda el motivo

    // Datos que el participante declara EN ESTA inscripcion (pueden cambiar de un curso a otro)
    private final String procedencia;
    private final String tipoPoblacion;
    private final String vinculacion;

    public Inscripcion(int numInscripcion, LocalDate fechaInscripcion, Participante myParticipante,
            String procedencia, String tipoPoblacion, String vinculacion) {
        this.numInscripcion = numInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.myParticipante = myParticipante;
        this.procedencia = procedencia;
        this.tipoPoblacion = tipoPoblacion;
        this.vinculacion = vinculacion;
        this.porcentajeAsistencia = 0.0;
        this.notaFinal = 0.0;
        this.estadoParticipante = INSCRITO;
        this.causaNoCertificado = "";
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public double getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public String getEstadoParticipante() {
        return estadoParticipante;
    }

    public boolean retirar() {
        if (!INSCRITO.equals(estadoParticipante)) {
            return false;
        }
        estadoParticipante = RETIRADO;
        return true;
    }

    public boolean isCertificado() {
        return APROBADO.equals(estadoParticipante);
    }

    public Participante getMyParticipante() {
        return myParticipante;
    }

    static String validarResultado(double asistencia, double nota) {
        if (!(asistencia >= 0 && asistencia <= 100)) {
            return "La asistencia debe estar entre 0 y 100.";
        }
        if (!(nota >= 0 && nota <= 5)) {
            return "La nota final debe estar entre 0.0 y 5.0.";
        }
        return "";
    }

    void registrarResultado(double asistencia, double nota) {
        if (!INSCRITO.equals(estadoParticipante) || !validarResultado(asistencia, nota).isEmpty()) {
            throw new IllegalStateException("El resultado no se puede registrar.");
        }
        porcentajeAsistencia = asistencia;
        notaFinal = nota;
        if (asistencia < 80) {
            causaNoCertificado = "Asistencia insuficiente";
        }
        if (nota < 3.0) {
            causaNoCertificado += (causaNoCertificado.isEmpty() ? "Nota" : " y nota") + " insuficiente";
        }
        estadoParticipante = causaNoCertificado.isEmpty() ? APROBADO : NO_APROBADO;
    }

    public boolean isResultadoRegistrado() {
        return APROBADO.equals(estadoParticipante) || NO_APROBADO.equals(estadoParticipante);
    }

    public String getCausaNoCertificado() {
        return causaNoCertificado;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public String getTipoPoblacion() {
        return tipoPoblacion;
    }

    public String getVinculacion() {
        return vinculacion;
    }

    @Override
    public String toString() {
        return "Numero de Inscripcion = " + this.numInscripcion + "\n"
                + "Fecha de inscripción = " + this.fechaInscripcion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n"
                + "Porcentaje de asistencia = " + this.porcentajeAsistencia + "\n"
                + "Nota final = " + this.notaFinal + "\n"
                + "Estado del participante = " + this.estadoParticipante + "\n"
                + "Certificado = " + isCertificado() + "\n"
                + "Participante = " + this.myParticipante.getNombre() + "\n"
                + "Procedencia = " + this.procedencia + "\n"
                + "Tipo de población = " + this.tipoPoblacion + "\n"
                + "Vinculación = " + this.vinculacion + "\n"
                + "Causa de la no certificación = " + this.causaNoCertificado;
    }
}