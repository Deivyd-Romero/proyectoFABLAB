package NEGOCIO;

public class Recurso {

    private final String identificador;
    private final String descripcion;
    private final String tipoRecurso;
    private final int valorUnitario;
    private int cantidadTotal;
    private int cantidadDisponible;
    private int cantidadEnUso;
    private int cantidadDaniada;
    private int cantidadPerdida;

    public Recurso(String identificador, String descripcion, String tipoRecurso, int cantidadTotal, int valorUnitario) {
        if (identificador == null || identificador.isBlank() || cantidadTotal < 0 || valorUnitario < 0) {
            throw new IllegalArgumentException("El recurso requiere un código y cantidades y valores no negativos.");
        }
        this.identificador = identificador.strip();
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

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public int getValorUnitario() {
        return valorUnitario;
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
                || (long) buenas + daniadas + perdidas > cantidadEnUso) {
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
        if (cantidadDisponible > 0) {
            return "DISPONIBLE";
        }
        if (cantidadEnUso > 0) {
            return "EN USO";
        }
        return cantidadDaniada > 0 ? "DAÑADO" : "FUERA DE SERVICIO";
    }

    long calcularCostoDanio(int unidades) {
        long valor = (long) unidades * valorUnitario;
        // Separa pesos y residuo antes de multiplicar para evitar desbordar el long.
        return (valor / 10) * 3 + (valor % 10) * 3 / 10;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    @Override
    public String toString() {
        return "Identificador = " + this.identificador + "\n"
                + "Descripcion = " + this.descripcion + "\n"
                + "Tipo de Recurso = " + this.tipoRecurso + "\n"
                + "Valor Unitario = " + this.valorUnitario + "\n"
                + "Total = " + cantidadTotal + " | Disponibles = " + cantidadDisponible;
    }
}
