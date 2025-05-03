package TP5_Backtracking.Ejercicio10Corregido;

import java.util.*;

/* Ejercicio 10

Utilizando la técnica Backtracking, escriba un algoritmo que dado un conjunto de números enteros,
devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro), cuyas sumas
sean exactamente cero. Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos
que suman cero son: {-7, -1, 8} y {-3, -2, 5}. */

public class SubconjuntosSuma {
    private final int N = 3;
    private final int SUMA = 0;
    private List<List<Integer>> soluciones;

    public List<List<Integer>> backSubconjuntos(List<Integer> conjunto) {
        soluciones = new ArrayList<>();
        ArrayList<Integer> auxiliar = new ArrayList<>();
        backSubconjuntos(conjunto, 0, 0, auxiliar);
        return soluciones;
    }

    private void backSubconjuntos(List<Integer> conjunto, Integer actual, Integer suma, List<Integer> auxiliar) {
        if (auxiliar.size() == N) { // Caso base
            if (suma == SUMA) {
                soluciones.add(new ArrayList<>(auxiliar));
            }

            return; // Salir de la recursión
        } else {
            for (int i = actual; i < conjunto.size(); i++) {
                auxiliar.add(conjunto.get(i));
                backSubconjuntos(conjunto, i + 1, suma + conjunto.get(i), auxiliar); // Recursión
                auxiliar.remove(auxiliar.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(-7, -3, -2, -1, 5, 8);
        SubconjuntosSuma sc = new SubconjuntosSuma();
        List<List<Integer>> resultado = sc.backSubconjuntos(conjunto);

        System.out.println("Subconjuntos que suman cero: " + resultado);
    }
}
