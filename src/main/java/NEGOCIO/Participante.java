package NEGOCIO;

public class Participante extends Persona {
    private String procedencia;
    private String tipoPoblacion;
    private String vinculacion;

    public Participante(String procedencia, String tipoPoblacion, String vinculacion, String nombre, String correo, String telefono, String documento) {
        super(nombre, correo, telefono, documento);
        this.procedencia = procedencia;
        this.tipoPoblacion = tipoPoblacion;
        this.vinculacion = vinculacion;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getTipoPoblacion() {
        return tipoPoblacion;
    }

    public void setTipoPoblacion(String tipoPoblacion) {
        this.tipoPoblacion = tipoPoblacion;
    }

    public String getVinculacion() {
        return vinculacion;
    }

    public void setVinculacion(String vinculacion) {
        this.vinculacion = vinculacion;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n" +
               "Procedencia = " + this.procedencia + "\n" +
               "Tipo de población: " + this.tipoPoblacion + "\n" +
               "Asociado a: " + this.vinculacion;
    }

    
    
    
}
