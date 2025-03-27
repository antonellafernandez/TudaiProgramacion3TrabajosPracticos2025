package TP5_Backtracking.Ejercicio5;

import java.util.ArrayList;

public class Procesador {
    private ArrayList<Tarea> tareasAsignadas;

    public Procesador() {
        this.tareasAsignadas = new ArrayList<>();
    }

    public ArrayList<Tarea> getTareasAsignadas() {
        return new ArrayList<>(this.tareasAsignadas);
    }

    public void addTarea(Tarea t) {
        if (!this.tareasAsignadas.contains(t)) {
            this.tareasAsignadas.add(t);
        }
    }

    public void removeTarea(Tarea t) {
        this.tareasAsignadas.remove(t);
    }

    public int getTiempoEjecucion() {
        int tiempo = 0;

        for (Tarea t : this.tareasAsignadas) {
            tiempo += t.getTiempoEjecucion();
        }

        return tiempo;
    }

    @Override
    public String toString() {
        return "Procesador{" +
                "tareasAsignadas=" + tareasAsignadas +
                "} \n";
    }
}
