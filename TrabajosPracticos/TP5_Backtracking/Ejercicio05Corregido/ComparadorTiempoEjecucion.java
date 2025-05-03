package TrabajosPracticos.TP5_Backtracking.Ejercicio05Corregido;

import java.util.Comparator;

public class ComparadorTiempoEjecucion implements Comparator<Tarea> {
    private Tarea t1, t2;

    @Override
    public int compare(Tarea t1, Tarea t2) {
        return Integer.compare(t2.getTiempoEjecucion(), t1.getTiempoEjecucion()); // Orden descendente
    }
}
