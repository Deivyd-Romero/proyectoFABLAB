package NEGOCIO;

public abstract class Persona {

    private String nombre;
    private String correo;
    private String telefono;
    private final String documento;
    private final String rol;

    protected Persona(String nombre, String correo, String telefono, String documento, String rol) {

        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.documento = documento;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Nombre = " + this.getNombre() + "\n"
                + "Correo = " + this.getCorreo() + "\n"
                + "Telefono = " + this.getTelefono() + "\n"
                + "Identificacion = " + this.getDocumento() + "\n"
                + "Rol = " + this.getRol();
    }
}