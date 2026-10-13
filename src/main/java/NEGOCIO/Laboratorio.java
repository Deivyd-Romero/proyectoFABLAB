package NEGOCIO;

public class Laboratorio {
    private String disponible = "DISPONIBLE";
    private String ocupado = "OCUPADO";
    private String mantenimiento = "MANTENIMIENTO";
    private int maxRecursos = 5;
    private int maxCursos = 20;

    private String codigoLab;
    private String nombreLab; 
    private String tipoLab;
    private int capacidadMax;
    private String estadoLab;
    private RecursoTecnologico[] myRecursosTecnologicos;
    private Curso[] myCursos;

    public Laboratorio(String codigoLab, String nombreLab, String tipoLab, int capacidadMax) {
        this.codigoLab = codigoLab;
        this.nombreLab = nombreLab;
        this.tipoLab = tipoLab;
        this.capacidadMax = capacidadMax;
        this.estadoLab = disponible;
        this.myRecursosTecnologicos = new RecursoTecnologico[maxRecursos];
        this.myCursos = new Curso[maxCursos];
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

    @Override
    public String toString() {
        return "Nombre laboratorio = " + this.nombreLab + "\n" +
               "Codigo = " + this.codigoLab + "\n" + 
               "Tipo de laboratorio = " + this.tipoLab + "\n" + 
               "Capacidad máxima = " + this.capacidadMax + "\n" + 
               "Estado = " + this.estadoLab + "\n" +
               "Cursos programados = " + this.contarCursos();
    }

    //Metodo privado para contar los cursos del laboratorio
    private int contarCursos() {
        int total = 0;
        for (int i = 0; i < this.myCursos.length; i++) {
            if (this.myCursos[i] != null) {
                total++;
            }
        }
        return total;
    }    
}
