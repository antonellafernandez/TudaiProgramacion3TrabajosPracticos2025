package TP5_Backtracking.Ejercicio5;

/* Ejercicio 5

Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo
de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
minimizar el tiempo de ejecución del total de tareas. */

import java.util.ArrayList;
import java.util.Collections;

public class AsignacionTareasAProcesadores {
    private ArrayList<Procesador> procesadores;
    private ArrayList<Tarea> tareas;

    private int mejorTiempo;
    private ArrayList<Procesador> mejorAsignacion; // Almacena la mejor solución

    public static void main(String[] args) {
        AsignacionTareasAProcesadores asignacion = new AsignacionTareasAProcesadores();
        asignacion.mejorAsignacion = asignacion.Backtracking();

        // Imprimir la mejor asignación encontrada
        for (int i = 0; i < asignacion.mejorAsignacion.size(); i++) {
            System.out.println("Procesador " + i + ": " + asignacion.mejorAsignacion.get(i));
        }
    }

    public AsignacionTareasAProcesadores() {
        this.procesadores = new ArrayList<>();
        this.tareas = new ArrayList<>();
        this.mejorTiempo = Integer.MAX_VALUE; // Inicializar con un valor muy alto

        // Crear y agregar procesadores
        for (int i = 0; i < 3; i++) {
            this.procesadores.add(new Procesador());
        }

        // Crear y agregar tareas
        int[] tiempos = {10, 15, 20, 25, 30, 3, 52, 2, 51, 1};
        for (int tiempo : tiempos) {
            this.tareas.add(new Tarea(tiempo));
        }
    }

    public ArrayList<Procesador> Backtracking() {
        // Ordenar tareas de mayor a menor

        // Heurística de "Largest Processing Time First" (LPT).
        // Asignar primero las tareas más pesadas ayuda a equilibrar la carga
        // entre procesadores y reduce el tiempo máximo de ejecución.
        Collections.sort(this.tareas, new ComparadorTiempoEjecucion());

        // Array para almacenar los tiempos de carga de cada procesador
        int[] cargaProcesadores = new int[procesadores.size()];

        // Llamado a la función recursiva
        resolverBacktracking(0, cargaProcesadores);

        return procesadores;
    }

    private void resolverBacktracking(int index, int[] cargaProcesadores) {
        if (index == tareas.size()) { // Caso base: todas las tareas fueron asignadas
            int tiempoMaximo = encontrarTiempoMaximo(cargaProcesadores);
            mejorTiempo = Math.min(mejorTiempo, tiempoMaximo);
            mejorAsignacion = procesadores; // Guardar la mejor solucion

            return;
        }

        Tarea tareaActual = tareas.get(index); // Obtener la tarea que vamos a asignar

        for (int i = 0; i < procesadores.size(); i++) { // Intentar asignar a cada procesador
            cargaProcesadores[i] += tareaActual.getTiempoEjecucion(); // Asignar temporalmente
            procesadores.get(i).addTarea(tareaActual); // Agregar la tarea al procesador

            if (cargaProcesadores[i] < mejorTiempo) { // Poda: evitar seguir si ya es peor que la mejor solución
                resolverBacktracking(index + 1, cargaProcesadores);
            }

            // Deshacer la asignación para probar otras combinaciones (Backtrack)
            cargaProcesadores[i] -= tareaActual.getTiempoEjecucion();
            procesadores.get(i).removeTarea(tareaActual);
        }
    }

    private int encontrarTiempoMaximo(int[] cargaProcesadores) {
        int max = 0;

        for (int carga : cargaProcesadores) {
            max = Math.max(max, carga); // Math.max devuelve el mayor de los dos valores
        }

        // max contiene la mayor carga de los procesadores
        return max;
    }
}
