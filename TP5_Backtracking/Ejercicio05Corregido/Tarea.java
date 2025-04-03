package TP5_Backtracking.Ejercicio05Corregido;

public class Tarea {
    private int tiempoEjecucion;

    public Tarea(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "tiempoEjecucion=" + tiempoEjecucion +
                '}';
    }
}
