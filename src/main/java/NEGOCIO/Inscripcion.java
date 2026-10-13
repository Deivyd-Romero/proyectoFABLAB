package NEGOCIO;
public class Inscripcion {
    private int numInscripcion;
    private String fechaInscripcion;
    private double porcentajeAsistencia;
    private double notaFinal;
    private String estadoParticipante;
    private boolean certificado;
    private Participante myParticipante;
    private Curso myCurso;
    private String causaNoCertificado;

    public Inscripcion(int numInscripcion, String fechaInscripcion, Participante myParticipante, Curso myCurso) {
        this.numInscripcion = numInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.myParticipante = myParticipante;
        this.myCurso = myCurso;
        this.porcentajeAsistencia = 0.0;
        this.notaFinal = 0.0;
        this.estadoParticipante = "Inscrito";
        this.certificado = false;
        this.causaNoCertificado = "";
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public void setNumInscripcion(int numInscripcion) {
        this.numInscripcion = numInscripcion;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public double getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    public void setPorcentajeAsistencia(double porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getEstadoParticipante() {
        return estadoParticipante;
    }

    public void setEstadoParticipante(String estadoParticipante) {
        this.estadoParticipante = estadoParticipante;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public Participante getMyParticipante() {
        return myParticipante;
    }

    public void setMyParticipante(Participante myParticipante) {
        this.myParticipante = myParticipante;
    }

    public Curso getMyCurso() {
        return myCurso;
    }

    public void setMyCurso(Curso myCurso) {
        this.myCurso = myCurso;
    }

    public String getCausaNoCertificado() {
        return causaNoCertificado;
    }

    public void setCausaNoCertificado(String causaNoCertificado) {
        this.causaNoCertificado = causaNoCertificado;
    }

    @Override
    public String toString() {
        return "Numero de Inscripcion = " + this.numInscripcion + "\n" + 
               "Fecha de inscripción = " + this.fechaInscripcion + "\n" +
               "Porcentaje de asistencia = " + this.porcentajeAsistencia + "\n" +
               "Nota final = " + this.notaFinal + "\n" +
               "Estado del participante = " + this.estadoParticipante + "\n" +
               "Certificado = " + this.certificado + "\n" +
               "Participante = " + this.myParticipante.getNombre() + "\n" +
               "Nombre del curso = " + this.myCurso.getNombreCurso() + "\n" +
               "Causa de la no certificación = " + this.causaNoCertificado;
    }

    
    

    
    
    
    
    
}
