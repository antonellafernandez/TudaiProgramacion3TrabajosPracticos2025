package TP2_RecursionYOrdenamiento;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1
        int[] A = {1, 2, 3, 4, 5}; // Array ordenado
        System.out.println(estaOrdenado(A, 0)); // true

        int[] B = {1, 3, 2, 4, 5}; // No ordenado
        System.out.println(estaOrdenado(B, 0)); // false

        // Ejercicio 2
        int[] C = {-5, 1, 4, 5, 8, 10, 15, 19, 23, 25, 26, 27, 33, 40, 41, 44, 48, 50, 51, 55, 58};

        // ¿El número 41 está en el array?
        int X = 41, inicio = 0, fin = C.length - 1;
        System.out.println(41 == C[BinariaRecursiva(C, X, inicio, fin)]);

        // Ejercicio 3
        int xNotacionDecimal = 26;
        ArrayList<Integer> xNotacionBinaria = new ArrayList<>();

        System.out.println(conversorDecimalABinario(xNotacionBinaria, xNotacionDecimal));

        //Ejercicio 4
        ArrayList<Integer> D = new ArrayList<>();
        int N = 6;

        fibonacci(D, N);
        System.out.println(D);

    }

    /* Ejercicio 1
    Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado y
    responda:

    1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
    La complejidad en el peor caso es O(N), donde N es el tamaño del arreglo.
    Esto se debe a que el algoritmo recursivo recorre el arreglo una vez,
    realizando una comparación por cada llamada recursiva.

    2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
    La recursión crea una pila de llamadas, lo que significa que para arreglos grandes,
    podríamos agotar la pila de llamadas (desbordamiento de pila).
    Esto puede causar un StackOverflowError en Java si el tamaño del arreglo es demasiado grande.

    3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
    Al usar una lista, podríamos tener una ligera penalización de desempeño en comparación con los arreglos,
    ya que las listas en Java no permiten acceso directo a los elementos por índice de manera tan eficiente como los arreglos. */

    public static boolean estaOrdenado(int[] A, int inicio) {
        if (inicio == A.length - 1) {
            return true; // Se llegó al final sin encontrar desorden
        }

        if (A[inicio] > A[inicio + 1]) {
            return false; // Desorden encontrado
        }

        return estaOrdenado(A, inicio + 1); // Llamado recursivo
    }

    /* Ejercicio 2
    Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
    ascendentemente. */

    // Algoritmo de Búsqueda Binaria Recursiva
    // Devuelve la posición del número buscado en el Array
    // En el peor de los casos la complejidad es O(log₂ n)
    public static int BinariaRecursiva(int[] A, int X, int inicio, int fin) {
        int medio;

        if (inicio > fin) {
            return -1; // Sucederá si noo se encuentra el elemento
        } else {
            medio = (inicio + fin) / 2; // Al ser medio un int, se realiza truncado

            if (X > A[medio]) {
                return BinariaRecursiva(A, X, medio + 1, fin);
            } else {
                if (X < A[medio]) {
                    return BinariaRecursiva(A, X, inicio, medio - 1);
                } else {
                    return medio;
                }
            }
        }
    }

    /* Ejercicio 3
    Implemente un algoritmo recursivo que convierta un número en notación decimal a su
    equivalente en notación binaria. */

    // Complejidad es O(log X) siendo X el número a convertir
    public static ArrayList<Integer> conversorDecimalABinario(ArrayList<Integer> A, int X) {
        if (X < 2) {
            A.add(X % 2);

            Collections.reverse(A);
            return A;
        } else {
            A.add(X % 2);
            X = X / 2;

            A = conversorDecimalABinario(A, X);
            return A;
        }
    }

    /* Ejercicio 4
    Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
    Fibonacci.
    Por ej. los 6 primeros términos son: 0 1 1 2 3 5 */
    public static void fibonacci(ArrayList<Integer> A, int N) {
        if (A.size() == N) {
            return;
        }

        if (A.size() == 0) {
            A.add(0);
        } else if (A.size() == 1) {
            A.add(1);
        } else {
            // Agregar el siguiente término sumando los dos anteriores
            A.add(A.get(A.size() - 1) + A.get(A.size() - 2));
        }

        fibonacci(A, N); // Llamado recursivo
    }

}
