package Parcial16JUN2023;

/* Ejercicio 3

Dados un conjunto N de números enteros distintos, se desea encontrar, si existen, 4 subconjntos no vacíos y
disjuntos que sean partición de N (o sea la unión de los 4 subconjuntos es igual al conjunto N), tal que la suma
de los elementos de cada subconjunto sea igual a un número T dado como parámetro.

Por ej. N = {5, 19, 3, 7, 9, 2, 1, -10} y T = 9. Una solución sería {5, 3, 1} {7, 2} {9} {19, -10}

a) Dibuje el árbol de exploración del algoritmo, indicando qué descisiones se toman en cada paso y que
información se lleva en los estados.

b) Escriba un pseudo-java del algoritmo que resuelva el problema mediante Backtracking. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio3 {
    private static int P = 4; // Subconjuntos
    private static int T = 9; // Suma objetivo
    private static int[] sumas;
    private static List<List<Integer>> solucion;

    public static List<List<Integer>> backSubconjuntosParticion(List<Integer> conjunto) {
        solucion = new ArrayList<>();
        sumas = new int[P];

        // Inicializar los subconjuntos
        for (int i = 0; i < P; i++) {
            solucion.add(new ArrayList<>());
        }

        if (backSubconjuntosParticion(conjunto, 0)) {
            return solucion;
        } else {
            return new ArrayList<>();
        }
    }

    private static boolean backSubconjuntosParticion(List<Integer> conjunto, int indice) {
        if (indice == conjunto.size()) { // Caso base: La unión de los 4 subconjuntos es igual al conjunto N
            // Verificar si todas las sumas son iguales a T
            for (int suma : sumas) {
                if (suma != T) {
                    return false;
                }
            }
            return true;
        } else {
            int n = conjunto.get(indice);

            for (int i = 0; i < P; i++) {
                // Intento de asignación
                solucion.get(i).add(n);
                sumas[i] += n;

                // Recursión
                if (backSubconjuntosParticion(conjunto, indice + 1)) {
                    return true;
                }

                // Backtrack
                solucion.get(i).remove(solucion.get(i).size() - 1);
                sumas[i] -= n;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        List<Integer> N = new ArrayList<>(Arrays.asList(5, 19, 3, 7, 9, 2, 1, -10));
        System.out.println(backSubconjuntosParticion(N));
    }
}
