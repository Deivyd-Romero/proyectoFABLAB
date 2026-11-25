package NEGOCIO;

/**
 * Registra la cantidad de un recurso tecnológico entregada a un curso.
 * La relación con el curso es unidireccional: Curso contiene sus entregas,
 * por eso esta clase no guarda referencias a Curso ni a Laboratorio.
 */
public class EntregaRecurso {
    private final String codigoRecurso;
    private int cantidadEntregada;
    // Estas cantidades se registran al cerrar el curso (RF5).
    private int cantidadBuena;
    private int cantidadDaniada;
    private int cantidadPerdida;

    public EntregaRecurso(String codigoRecurso, int cantidadEntregada) {
        this.codigoRecurso = codigoRecurso;
        this.cantidadEntregada = cantidadEntregada;
        this.cantidadBuena = 0;
        this.cantidadDaniada = 0;
        this.cantidadPerdida = 0;
    }

    public String getCodigoRecurso() {
        return codigoRecurso;
    }

    public int getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(int cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public int getCantidadBuena() {
        return cantidadBuena;
    }

    public void setCantidadBuena(int cantidadBuena) {
        this.cantidadBuena = cantidadBuena;
    }

    public int getCantidadDaniada() {
        return cantidadDaniada;
    }

    public void setCantidadDaniada(int cantidadDaniada) {
        this.cantidadDaniada = cantidadDaniada;
    }

    public int getCantidadPerdida() {
        return cantidadPerdida;
    }

    public void setCantidadPerdida(int cantidadPerdida) {
        this.cantidadPerdida = cantidadPerdida;
    }

    @Override
    public String toString() {
        return "Recurso = " + this.codigoRecurso + "\n" +
               "Cantidad entregada = " + this.cantidadEntregada + "\n" +
               "Cantidad buena = " + this.cantidadBuena + "\n" +
               "Cantidad dañada = " + this.cantidadDaniada + "\n" +
               "Cantidad perdida = " + this.cantidadPerdida;
    }
}
