package TP5_Backtracking.Ejercicio05Corregido;

/* Ejercicio 5

Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo
de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
minimizar el tiempo de ejecución del total de tareas. */

import java.util.*;

public class AsignacionTareasAProcesadores {
    static ArrayList<Procesador> mejorAsignacion = new ArrayList<>();
    static int mejorTiempo = 100;

    public static ArrayList<Procesador> backProcesadores(ArrayList<Procesador> procesadores, ArrayList<Tarea> tareas) {
        tareas.sort(new ComparadorTiempoEjecucion()); // Longest Processing Time First

        backProcesadores(procesadores, tareas, 0);

        return mejorAsignacion;
    }

    private static void backProcesadores(ArrayList<Procesador> procesadores, ArrayList<Tarea> tareas, int tareaActual) {
        if (tareaActual == tareas.size()) { // Encontramos una asignación válida, actualizar mejor tiempo
            if (mejorAsignacion.isEmpty()) {
                // Buscamos el mayor tiempo de ejecución de la asignación
                int maxTiempo = 0;
                for (Procesador p : procesadores) {
                    maxTiempo = Math.max(maxTiempo, p.getTiempoEjecucion());
                }

                if (maxTiempo < mejorTiempo) {
                    mejorTiempo = maxTiempo;
                    mejorAsignacion = new ArrayList<>();

                    for (Procesador p : procesadores) {
                        Procesador copia = new Procesador();

                        for (Tarea t : p.getTareasAsignadas()) {
                            copia.addTarea(t);
                        }

                        mejorAsignacion.add(copia);
                    }
                }
            }

            return;
        }

        for (Procesador p : procesadores) {
            // Asignamos la tarea al procesador
            p.addTarea(tareas.get(tareaActual));

            // Poda
            if (p.getTiempoEjecucion() < mejorTiempo) {
                backProcesadores(procesadores, tareas, tareaActual + 1);
            }

            // Bactrack: Deshacemos la asignación
            p.removeTarea(tareas.get(tareaActual));
        }
    }

    public static void main(String[] args) {
        // Procesadores
        ArrayList<Procesador> procesadores = new ArrayList<>();

        Procesador p1 = new Procesador();
        Procesador p2 = new Procesador();
        Procesador p3 = new Procesador();
        Procesador p4 = new Procesador();

        procesadores.add(p1);
        procesadores.add(p2);
        procesadores.add(p3);
        procesadores.add(p4);

        // Tareas
        ArrayList<Tarea> tareas = new ArrayList<>();

        Tarea t1 = new Tarea(10);
        Tarea t2 = new Tarea(20);
        Tarea t3 = new Tarea(30);
        Tarea t4 = new Tarea(40);
        Tarea t5 = new Tarea(50);
        Tarea t6 = new Tarea(60);
        Tarea t7 = new Tarea(70);
        Tarea t8 = new Tarea(80);

        tareas.add(t1);
        tareas.add(t2);
        tareas.add(t3);
        tareas.add(t4);
        tareas.add(t5);
        tareas.add(t6);
        tareas.add(t7);
        tareas.add(t8);

        // Llamado a Bactracking
        System.out.println(backProcesadores(procesadores, tareas));
        System.out.println("Mejor tiempo: " + mejorTiempo);
    }
}
