package NEGOCIO;

public class Laboratorio {
    private String nombreLab;
    private String codigoLab;
    private String tipoLab;
    private int capacidadMax;
    private String estadoLab;
    private RecursoTecnologico[] myRecursosTecnologicos;
    private Curso myCurso;

    public Laboratorio(String nombreLab, String codigoLab, String tipoLab, int capacidadMax, String estadoLab, Curso myCurso) {
        this.nombreLab = nombreLab;
        this.codigoLab = codigoLab;
        this.tipoLab = tipoLab;
        this.capacidadMax = capacidadMax;
        this.estadoLab = estadoLab;
        this.myRecursosTecnologicos = new RecursoTecnologico[5];
        this.myCurso = myCurso;
    }

    public String getNombreLab() {
        return nombreLab;
    }

    public void setNombreLab(String nombreLab) {
        this.nombreLab = nombreLab;
    }

    public String getCodigoLab() {
        return codigoLab;
    }

    public void setCodigoLab(String codigoLab) {
        this.codigoLab = codigoLab;
    }

    public String getTipoLab() {
        return tipoLab;
    }

    public void setTipoLab(String tipoLab) {
        this.tipoLab = tipoLab;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public String getEstadoLab() {
        return estadoLab;
    }

    public void setEstadoLab(String estadoLab) {
        this.estadoLab = estadoLab;
    }

    public Curso getMyCurso() {
        return myCurso;
    }

    public void setMyCurso(Curso myCurso) {
        this.myCurso = myCurso;
    }

    @Override
    public String toString() {
        return "Nombre laboratorio = " + this.nombreLab + "\n" +
               "Codigo = " + this.codigoLab + "\n" + 
               "Tipo de laboratorio = " + this.tipoLab + "\n" + 
               "Capacidad máxima = " + this.capacidadMax + "\n" + 
               "Estado = " + this.estadoLab + "\n" +
               "Curso = " + this.myCurso.getNombreCurso();
    }
    
    
    
    
    
}
