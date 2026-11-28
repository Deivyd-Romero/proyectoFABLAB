package PRESENTACION;

import NEGOCIO.FABLAB;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Ventana {

    // La posición de cada opción conserva su código aunque se repitan los nombres.
    static void cargarOpciones(JComboBox<String> combo, ArrayList<String> codigos, String lista) {
        combo.removeAllItems();
        codigos.clear();
        codigos.add("");
        combo.addItem("<NO SELECCIONADO>");
        for (String opcion : lista.split("/")) {
            if (!opcion.isEmpty()) {
                String[] campos = opcion.split(" - ", 2);
                String codigo = FABLAB.leerCampoLista(campos[0]);
                codigos.add(codigo);
                combo.addItem(codigo + " - " + FABLAB.leerCampoLista(campos[1]));
            }
        }
    }

    static String codigoSeleccionado(JComboBox<String> combo, ArrayList<String> codigos) {
        int indice = combo.getSelectedIndex();
        return indice < 0 || indice >= codigos.size() ? "" : codigos.get(indice);
    }

    public static void imp(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void imp(int valor, String titulo) {
        imp(String.valueOf(valor), titulo);
    }

    public static void imp(double valor, String titulo) {
        imp(String.valueOf(valor), titulo);
    }

    public static void imp(byte valor, String titulo) {
        imp(String.valueOf(valor), titulo);
    }

    public static void imp(short valor, String titulo) {
        imp(String.valueOf(valor), titulo);
    }

    public static void imp(float valor, String titulo) {
        imp(String.valueOf(valor), titulo);
    }

    public static void imp(long valor, String titulo) {
        imp(String.valueOf(valor), titulo);
    }

    public static int leerInt(String mensaje) {
        return Integer.parseInt(leerCadena(mensaje));
    }

    public static double leerDouble(String mensaje) {
        return Double.parseDouble(leerCadena(mensaje));
    }

    public static long leerLong(String mensaje) {
        return Long.parseLong(leerCadena(mensaje));
    }

    public static byte leerByte(String mensaje) {
        return Byte.parseByte(leerCadena(mensaje));
    }

    public static float leerFloat(String mensaje) {
        return Float.parseFloat(leerCadena(mensaje));
    }

    public static char leerChar(String mensaje) {
        String texto = leerCadena(mensaje);
        if (texto == null || texto.isEmpty()) {
            throw new IllegalArgumentException("Se requiere un carácter.");
        }
        return texto.charAt(0);
    }

    public static String leerCadena(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public static int leerOption(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Sistema FABLAB",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
    }
}
