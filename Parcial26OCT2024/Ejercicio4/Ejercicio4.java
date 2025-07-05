package Parcial26OCT2024.Ejercicio4;

/* Ejercicio 4

Dado un conjunto de productos N donde cada producto tiene un peso Pi y un valor económico Vi, y una mochila con capacidad máxima
de K kilos. Se desea encontrar el subconjunto de productos a ubicar en la mochila que maximice el valor económico total, sin superar
los K kilos disponibles. Se sabe que los productos no pueden ser fraccionados, es decir, si se elige poner el producto X en
la mochila deberá hacerse en su totalidad.

a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué información se lleva en los estados.

b) Escriba el pseudo.java del algoritmo que resuelva el problema mediante Backtracking. */

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    private int K;
    private int mejorValor;
    private List<Producto> mejorSolucion;

    public Ejercicio4() {
        this.K = 100;
        this.mejorValor = Integer.MIN_VALUE;
        this.mejorSolucion = new ArrayList<>();
    }

    public List<Producto> back(List<Producto> N) {
        back(N, new ArrayList<>(), 0, 0, 0);
        return mejorSolucion;
    }

    private void back(List<Producto> N, List<Producto> solActual, int valorActual, int pesoActual, int posActual) {
        if (posActual == N.size()) {
            if (pesoActual <= K && valorActual > mejorValor) {
                mejorSolucion.clear();
                mejorSolucion.addAll(solActual);
                mejorValor = valorActual;
            }

            return;
        }

        Producto p = N.get(posActual);

        // Poda
        if (pesoActual + p.getP() <= K) {
            // Intento de asignación
            solActual.add(p);
            valorActual += p.getV();
            pesoActual += p.getP();

            // Recursión
            back(N, solActual, valorActual, pesoActual, posActual + 1);

            // Backtrack
            solActual.remove(solActual.size() - 1);
            valorActual -= p.getV();
            pesoActual -= p.getP();
        }

        back(N, solActual, valorActual, pesoActual, posActual + 1);
    }
}
