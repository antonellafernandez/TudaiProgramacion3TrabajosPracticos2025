package TP5_Backtracking.Ejercicio10;

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
    private Set<Integer> visitados;

    public List<List<Integer>> backSubconjuntos(List<Integer> conjunto) {
        soluciones = new ArrayList<>();
        visitados = new HashSet<>();

        ArrayList<Integer> auxiliar = new ArrayList<>();

        backSubconjuntos(conjunto, 0, auxiliar);

        return soluciones;
    }

    private void backSubconjuntos(List<Integer> conjunto, Integer suma, List<Integer> auxiliar) {
        if (auxiliar.size() == N) { // Caso base
            if (suma == SUMA) {
                soluciones.add(new ArrayList<>(auxiliar));
            }

            return; // Salir de la recursión
        } else {
            for (Integer n : conjunto) {
                if (!visitados.contains(n)) { // Intento de asignación
                    visitados.add(n);
                    auxiliar.add(n);
                    suma += n;
                    backSubconjuntos(conjunto, suma, auxiliar); // Recursión

                    // Backtrack
                    visitados.remove(n);
                    auxiliar.remove(auxiliar.size() - 1);
                    suma -= n;
                }
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
