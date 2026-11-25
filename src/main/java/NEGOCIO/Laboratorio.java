package NEGOCIO;

import java.util.ArrayList;

public class Laboratorio {

    public static final String DISPONIBLE = "DISPONIBLE";
    public static final String OCUPADO = "OCUPADO";

    private String codigoLab;
    private String tipoLab;
    private int capacidadMax;
    private String estadoLab;
    private ArrayList<RecursoTecnologico> myRecursosTecnologicos;

    public Laboratorio(String codigoLab, String tipoLab, int capacidadMax, String estadoLab, ArrayList<RecursoTecnologico> myRecursosTecnologicos) {
        this.codigoLab = codigoLab;
        this.tipoLab = tipoLab;
        this.capacidadMax = capacidadMax;
        this.estadoLab = estadoLab;
        this.myRecursosTecnologicos = myRecursosTecnologicos;
    }

    public String getCodigoLab() {
        return codigoLab;
    }

    public boolean agregarRecurso(RecursoTecnologico recurso) {

        if (recurso == null) {
            return false;
        }

        for (RecursoTecnologico r : myRecursosTecnologicos) {
            if (r.getIdentificador().equals(recurso.getIdentificador())) {
                return false;
            }
        }

        myRecursosTecnologicos.add(recurso);
        return true;
    }

    public RecursoTecnologico buscarRecurso(String codigo) {
        for (RecursoTecnologico recurso : myRecursosTecnologicos) {
            if (recurso.getIdentificador().equalsIgnoreCase(codigo)) {
                return recurso;
            }
        }
        return null;
    }

    /** Devuelve una copia de los recursos del laboratorio. */
    public ArrayList<RecursoTecnologico> getRecursos() {
        return new ArrayList<>(this.myRecursosTecnologicos);
    }

    public String listarRecursos() {
        String cad = "";
        for (RecursoTecnologico r : this.myRecursosTecnologicos) {
            cad += r.toString() + "\n" + "===============" + "\n";
        }
        return cad;
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

    public void setMyRecursosTecnologicos(ArrayList<RecursoTecnologico> myRecursosTecnologicos) {
        this.myRecursosTecnologicos = myRecursosTecnologicos;
    }

    @Override
    public String toString() {
        return "Codigo = " + this.codigoLab + "\n"
                + "Tipo de laboratorio = " + this.tipoLab + "\n"
                + "Capacidad máxima = " + this.capacidadMax + "\n"
                + "Estado = " + this.estadoLab + "\n"
                + "Recursos Tecnológicos:"+"\n"+this.listarRecursos();
    }
}
