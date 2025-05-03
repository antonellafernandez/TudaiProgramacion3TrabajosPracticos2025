package Parcial14JUN2024ResueltoCatedra.Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ejercicio2 {
    private static Procesador P;
    private static List<Tarea> S; // Solución

    public ejercicio2(Procesador p) {
        this.P = p;
    }

    public static List<Tarea> greedy(List<Tarea> T) {
        // Maximizar el puntaje obtenido --> Agregando desde las tareas con mayor puntaje
        Collections.sort(T, new ComparadorPuntajeDesc()); // Ordenar de mayor a menor por puntaje
        S = new ArrayList<>();

        int i = 0;

        while (i < T.size()) {
            Tarea t = T.get(i);

            if (factible(S, t)) {
                S.add(t);
            } else {
                i++; // Probar con la tarea siguiente
            }
        }

        return S;
    }

    public static boolean factible(List<Tarea> S, Tarea t) {
        for (Tarea tarea : S) {
            if (tarea.getC() == t.getC()) {
                return false; // Ya hay una tarea con ese C
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Tarea t1 = new Tarea(10, 2);
        Tarea t2 = new Tarea(20, 1);
        Tarea t3 = new Tarea(8, 2);

        List<Tarea> T = new ArrayList<>();
        T.add(t1);
        T.add(t2);
        T.add(t3);

        System.out.println(greedy(T));
    }
}
