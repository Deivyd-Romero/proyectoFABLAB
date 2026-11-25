package NEGOCIO;

public class Instructor extends Persona {

    public static final String ROL = "INSTRUCTOR";

    public Instructor(String nombre, String correo, String telefono, String documento) {
        super(nombre, correo, telefono, documento, ROL);
    }
}
