package NEGOCIO;

/*
 Clase asociacion entre Curso y RecursoTecnologico.
 Cada objeto guarda lo que UN curso se llevo de UN recurso:
 cuantas unidades se entregaron y como volvieron (buenas, daniadas o perdidas).
*/
public class EntregaRecurso {
    private Curso myCurso;
    private RecursoTecnologico myRecurso;
    private int cantidadEntregada;
    // Las tres cantidades siguientes se llenan al cerrar el curso (RF5), por eso empiezan en 0
    private int cantidadBuena;
    private int cantidadDaniada;
    private int cantidadPerdida;

    public EntregaRecurso(Curso myCurso, RecursoTecnologico myRecurso, int cantidadEntregada) {
        this.myCurso = myCurso;
        this.myRecurso = myRecurso;
        this.cantidadEntregada = cantidadEntregada;
        this.cantidadBuena = 0;
        this.cantidadDaniada = 0;
        this.cantidadPerdida = 0;
    }

    public Curso getMyCurso() {
        return myCurso;
    }

    public void setMyCurso(Curso myCurso) {
        this.myCurso = myCurso;
    }

    public RecursoTecnologico getMyRecurso() {
        return myRecurso;
    }

    public void setMyRecurso(RecursoTecnologico myRecurso) {
        this.myRecurso = myRecurso;
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
        // Solo se muestra el nombre del curso y el identificador del recurso (no los objetos completos)
        return "Curso = " + this.myCurso.getNombreCurso() + "\n" +
               "Recurso = " + this.myRecurso.getIdentificador() + "\n" +
               "Cantidad entregada = " + this.cantidadEntregada + "\n" +
               "Cantidad buena = " + this.cantidadBuena + "\n" +
               "Cantidad dañada = " + this.cantidadDaniada + "\n" +
               "Cantidad perdida = " + this.cantidadPerdida;
    }
}
