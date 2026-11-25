package NEGOCIO;

public class RecursoTecnologico {

    private String identificador;
    private String descripcion;
    private String tipoRecurso;
    private int valorUnitario;
    private String estado;
    private int cantidadTotal;
    private int cantidadDisponible;
    private int cantidadEnUso;
    private int cantidadDaniada;
    private int cantidadPerdida;

    public RecursoTecnologico(String identificador, String descripcion, String tipoRecurso, int cantidadTotal, int valorUnitario) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.tipoRecurso = tipoRecurso;
        this.valorUnitario = valorUnitario;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadTotal;
        this.cantidadEnUso = 0;
        this.cantidadDaniada = 0;
        this.cantidadPerdida = 0;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /** Unidades disponibles para nuevas entregas. */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /** Unidades que actualmente están asignadas a cursos. */
    public int getCantidadEnUso() {
        return cantidadEnUso;
    }

    /** Unidades que han regresado dañadas. */
    public int getCantidadDaniada() {
        return cantidadDaniada;
    }

    /** Unidades reportadas como perdidas. */
    public int getCantidadPerdida() {
        return cantidadPerdida;
    }

    /**
     * Registra una entrega si hay suficientes unidades disponibles.
     * Mantiene el inventario controlado desde la capa de negocio.
     */
    public boolean entregar(int cantidad) {
        if (cantidad <= 0 || cantidad > cantidadDisponible) {
            return false;
        }
        cantidadDisponible -= cantidad;
        cantidadEnUso += cantidad;
        return true;
    }

    /** Devuelve al inventario las unidades que estaban en uso. */
    public boolean conciliar(int buenas, int daniadas, int perdidas) {
        if (buenas < 0 || daniadas < 0 || perdidas < 0
                || buenas + daniadas + perdidas > cantidadEnUso) {
            return false;
        }
        int totalConciliado = buenas + daniadas + perdidas;
        cantidadEnUso -= totalConciliado;
        cantidadDisponible += buenas;
        cantidadDaniada += daniadas;
        cantidadPerdida += perdidas;
        cantidadTotal -= perdidas;
        return true;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        int comprometidas = this.cantidadEnUso + this.cantidadDaniada + this.cantidadPerdida;
        if (cantidadTotal >= comprometidas) {
            this.cantidadTotal = cantidadTotal;
            this.cantidadDisponible = cantidadTotal - comprometidas;
        }
    }

    @Override
    public String toString() {
        return "Identificador = " + this.identificador + "\n"
                + "Descripcion = " + this.descripcion + "\n"
                + "Tipo de Recurso = " + this.tipoRecurso + "\n"
                + "Valor Unitario = " + this.valorUnitario;
    }
}
