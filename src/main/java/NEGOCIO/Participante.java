package NEGOCIO;

public class Participante extends Persona {

    public static final String ROL = "PARTICIPANTE";
    public static final String ESTUDIANTE_UFPS = "ESTUDIANTE_UFPS";
    public static final String EXTERNO = "EXTERNO";
    public static final String DOCENTE_UFPS = "DOCENTE_UFPS";

    public Participante(String nombre, String correo, String telefono, String documento) {
        super(nombre, correo, telefono, documento, ROL);
    }
}
