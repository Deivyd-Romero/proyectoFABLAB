package NEGOCIO;

import java.util.ArrayList;

public class Laboratorio {

    public static final String DISPONIBLE = "DISPONIBLE";
    public static final String OCUPADO = "OCUPADO";
    public static final String MANTENIMIENTO = "MANTENIMIENTO";

    private final String codigoLab;
    private final String tipoLab;
    private final int capacidadMax;
    private String estadoLab;
    private final ArrayList<Recurso> myRecursosTecnologicos;

    public Laboratorio(String codigoLab, String tipoLab, int capacidadMax, String estadoLab) {
        if (codigoLab == null || codigoLab.isBlank() || tipoLab == null || tipoLab.isBlank() || capacidadMax <= 0) {
            throw new IllegalArgumentException("El laboratorio requiere código, área y capacidad positiva.");
        }
        this.codigoLab = codigoLab.strip();
        this.tipoLab = tipoLab.strip();
        this.capacidadMax = capacidadMax;
        setEstadoLab(estadoLab);
        this.myRecursosTecnologicos = new ArrayList<>();
    }

    public Laboratorio(String codigoLab, String tipoLab, int capacidadMax, String estadoLab,
            ArrayList<Recurso> recursos) {
        this(codigoLab, tipoLab, capacidadMax, estadoLab);
        if (recursos == null) {
            throw new IllegalArgumentException("Indique los recursos del laboratorio.");
        }
        for (Recurso recurso : recursos) {
            if (!agregarRecurso(recurso)) {
                throw new IllegalArgumentException("Recurso nulo o repetido en el laboratorio.");
            }
        }
    }

    public String getCodigoLab() {
        return codigoLab;
    }

    public boolean agregarRecurso(Recurso recurso) {

        if (recurso == null || buscarRecurso(recurso.getIdentificador()) != null) {
            return false;
        }

        myRecursosTecnologicos.add(recurso);
        return true;
    }

    public Recurso buscarRecurso(String codigo) {
        if (codigo == null) {
            return null;
        }
        for (Recurso recurso : myRecursosTecnologicos) {
            if (recurso.getIdentificador().equalsIgnoreCase(codigo.strip())) {
                return recurso;
            }
        }
        return null;
    }

    /** Devuelve una copia de los recursos del laboratorio. */
    public ArrayList<Recurso> getRecursos() {
        return new ArrayList<>(this.myRecursosTecnologicos);
    }

    public String listarRecursos() {
        String cad = "";
        for (Recurso r : this.myRecursosTecnologicos) {
            cad += r.toString() + "\n" + "===============" + "\n";
        }
        return cad;
    }

    public String getTipoLab() {
        return tipoLab;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public String getEstadoLab() {
        return estadoLab;
    }

    public void setEstadoLab(String estadoLab) {
        if (!DISPONIBLE.equals(estadoLab) && !OCUPADO.equals(estadoLab) && !MANTENIMIENTO.equals(estadoLab)) {
            throw new IllegalArgumentException("Estado de laboratorio inválido.");
        }
        this.estadoLab = estadoLab;
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
