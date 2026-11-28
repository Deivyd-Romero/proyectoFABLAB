package NEGOCIO;

/**
 * Registra la cantidad de un recurso tecnológico entregada a un curso.
 * La relación con el curso es unidireccional: Curso contiene sus entregas,
 * por eso esta clase no guarda referencias a Curso ni a Laboratorio.
 */
public class EntregaRecurso {
    private final String codigoRecurso;
    private final int cantidadEntregada;
    // Estas cantidades se registran al cerrar el curso (RF5).
    private int cantidadBuena;
    private int cantidadDaniada;
    private int cantidadPerdida;

    public EntregaRecurso(String codigoRecurso, int cantidadEntregada) {
        if (codigoRecurso == null || codigoRecurso.isBlank() || cantidadEntregada <= 0) {
            throw new IllegalArgumentException("La entrega requiere un código y una cantidad positiva.");
        }
        this.codigoRecurso = codigoRecurso.strip();
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

    public int getCantidadBuena() {
        return cantidadBuena;
    }

    public int getCantidadDaniada() {
        return cantidadDaniada;
    }

    public int getCantidadPerdida() {
        return cantidadPerdida;
    }

    void registrarDevolucion(int buenas, int daniadas, int perdidas) {
        if (buenas < 0 || daniadas < 0 || perdidas < 0 || (long) buenas + daniadas + perdidas != cantidadEntregada) {
            throw new IllegalArgumentException("Las cantidades deben sumar el total entregado.");
        }
        cantidadBuena = buenas;
        cantidadDaniada = daniadas;
        cantidadPerdida = perdidas;
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
