package Parcial14JUN2024ResueltoCatedra.Ejercicio2;

import java.util.Comparator;

public class ComparadorPuntajeDesc implements Comparator<Tarea> {
    @Override
    public int compare(Tarea t1, Tarea t2) {
        return Integer.compare(t2.getP(), t1.getP());
    }
}
