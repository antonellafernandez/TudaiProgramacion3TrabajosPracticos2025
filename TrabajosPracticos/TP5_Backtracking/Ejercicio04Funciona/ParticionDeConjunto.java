package TP5_Backtracking.Ejercicio04Funciona;

/* Ejercicio 4

Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en
dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma. */

// Disjuntos, que no tienen elementos en común

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticionDeConjunto {
    private static int SUBCONJUNTOS = 2;
    private List<List<Integer>> solucion;

    public List<List<Integer>> backParticion(List<Integer> conjunto) {
        solucion = new ArrayList<>();
        List<Integer> auxiliar1 = new ArrayList<>();
        List<Integer> auxiliar2 = new ArrayList<>();
        backParticion(conjunto, 0, auxiliar1, auxiliar2, 0, 0);
        return solucion;
    }

    private void backParticion(List<Integer> conjunto, Integer actual, List<Integer> aux1, List<Integer> aux2, Integer sum1, Integer sum2) {
        if (actual == conjunto.size()) { // Caso base
            if (sum1 == sum2 && !aux1.isEmpty() && !aux2.isEmpty() && solucion.size() < SUBCONJUNTOS) {
                solucion.add(new ArrayList<>(aux1));
                solucion.add(new ArrayList<>(aux2));
            }
            return;
        } else {
            int num = conjunto.get(actual);
            // Opción 1: Intento de asignación en aux1
            aux1.add(num);
            backParticion(conjunto, actual + 1, aux1, aux2, sum1 + num, sum2); // Recursión
            aux1.remove(aux1.size() - 1); // Backtrack

            // Opción 2: Intento de asignación en aux2
            aux2.add(num);
            backParticion(conjunto, actual + 1, aux1, aux2, sum1, sum2 + num); // Recursión
            aux2.remove(aux2.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(1, 5, 11, 5);
        ParticionDeConjunto pdc = new ParticionDeConjunto();
        List<List<Integer>> resultado = pdc.backParticion(conjunto);

        System.out.println("Subconjuntos: " + resultado);
    }
}
