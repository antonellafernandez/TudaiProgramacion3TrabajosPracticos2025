package TrabajosPracticos.TP6_Greedy.Ejercicio03;

public class Actividad {
    private int tiempoComienzo; // ci
    private int tiempoFinalizacion; // fi

    public Actividad(int tiempoComienzo, int tiempoFinalizacion) {
        this.tiempoComienzo = tiempoComienzo;
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    public int getTiempoComienzo() {
        return tiempoComienzo;
    }

    public void setTiempoComienzo(int tiempoComienzo) {
        this.tiempoComienzo = tiempoComienzo;
    }

    public int getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoFinalizacion(int tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "tiempoComienzo=" + tiempoComienzo +
                ", tiempoFinalizacion=" + tiempoFinalizacion +
                '}';
    }
}
