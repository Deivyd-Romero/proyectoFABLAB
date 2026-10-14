package NEGOCIO;

public class RecursoTecnologico {
    private String disponible = "Disponible";
    private String enUso = "En uso";
    private String danado = "Dañado";
    private String fueraDeServicio = "Fuera de Servicio";

    private String identificador;
    private String descripcion;
    private String tipoRecurso;
    private int valorUnitario;
    private int cantidadTotal;
    private String estado;
    private int cantidadDisponible;
    private int cantidadDaniada;
    private int cantidadPerdidaAcumulada;
    private int cantidadEnUso;

    public RecursoTecnologico(String identificador, String descripcion, String tipoRecurso, int valorUnitario, int cantidadTotal) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.tipoRecurso = tipoRecurso;
        this.valorUnitario = valorUnitario;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadTotal;
        this.cantidadEnUso = 0;
        this.cantidadDaniada = 0;
        this.cantidadPerdidaAcumulada = 0;
        this.estado = disponible;
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

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadDaniada() {
        return cantidadDaniada;
    }

    public void setCantidadDaniada(int cantidadDaniada) {
        this.cantidadDaniada = cantidadDaniada;
    }

    public int getCantidadPerdidaAcumulada() {
        return cantidadPerdidaAcumulada;
    }

    public void setCantidadPerdidaAcumulada(int cantidadPerdidaAcumulada) {
        this.cantidadPerdidaAcumulada = cantidadPerdidaAcumulada;
    }

    public int getCantidadEnUso() {
        return cantidadEnUso;
    }

    public void setCantidadEnUso(int cantidadEnUso) {
        this.cantidadEnUso = cantidadEnUso;
    }

    @Override
    public String toString() {
        return "Identificador = " + this.identificador + "\n" + 
                "Descripcion = " + this.descripcion + "\n" + 
                "Tipo de Recurso = " + this.tipoRecurso + "\n" +
                "Valor Unitario = " + this.valorUnitario + "\n" +
                "Cantidad Total = " + this.cantidadTotal + "\n" +
                "Estado = " + this.estado + "\n" +
                "Cantidad Disponible = " + this.cantidadDisponible + "\n" +
                "Cantidad En Uso = " + this.cantidadEnUso + "\n" +
                "Cantidad Dañada = " + this.cantidadDaniada + "\n" +
                "Cantidad Perdida Acumulada = " + this.cantidadPerdidaAcumulada;
    }    
}
