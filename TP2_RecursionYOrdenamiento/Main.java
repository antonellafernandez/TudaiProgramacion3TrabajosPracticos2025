package TP2_RecursionYOrdenamiento;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1
        int[] A = {1, 2, 3, 4, 5}; // Array ordenado
        System.out.println("Ejercicio 1");
        System.out.println(estaOrdenado(A, 0)); // true

        int[] B = {1, 3, 2, 4, 5}; // No ordenado
        System.out.println(estaOrdenado(B, 0)); // false

        // Ejercicio 2
        int[] C = {-5, 1, 4, 5, 8, 10, 15, 19, 23, 25, 26, 27, 33, 40, 41, 44, 48, 50, 51, 55, 58};

        // ¿El número 41 está en el array?
        int X = 41, inicio = 0, fin = C.length - 1;
        System.out.println("========== Ejercicio 2 ==========");
        System.out.println(41 == C[BinariaRecursiva(C, X, inicio, fin)]);

        // Ejercicio 3
        int xNotacionDecimal = 26;

        System.out.println("========== Ejercicio 3 ==========");
        System.out.println(conversorDecimalABinario(xNotacionDecimal));

        //Ejercicio 4
        ArrayList<Integer> D = new ArrayList<>();
        int N = 6;

        fibonacci(D, N);

        System.out.println("========== Ejercicio 4 ==========");
        System.out.println(D);

        // Ejercicio 5
        int[] E = {-3, -1, 0, 2, 4, 6, 10};

        System.out.println("========== Ejercicio 5 ==========");
        System.out.println(determinarAlgunValorIgualPosicion(E, 0)); // true

        // Ejercicio 6
        int[] F = {8, 5, 7, 9, 11, 15, 25, 32, 41, 50};
        int[] G = {8, 5, 7, 9, 11, 15, 25, 32, 41, 50};

        System.out.println("========== Ejercicio 6 ==========");
        System.out.println("Arreglo 1 desordenado");
        imprimirArreglo(F);

        // Ordenar por selección
        seleccion(F);

        System.out.println("Arreglo ordenado por selección");
        imprimirArreglo(F);

        System.out.println("Arreglo 2 desordenado");
        imprimirArreglo(G);

        // Ordenar por burbujeo
        bubbleSortAdapt(G);

        System.out.println("Arreglo ordenado por burbujeo");
        imprimirArreglo(G);

        // Ejercicio 7
        int[] H = {8, 5, 7, 9, 11, 15, 25, 32, 41, 50};
        int[] I = {8, 5, 7, 9, 11, 15, 25, 32, 41, 50};

        System.out.println("========== Ejercicio 7 ==========");
        System.out.println("Arreglo 3 desordenado");
        imprimirArreglo(H);

        // Ordenar por mergeSort
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(H);

        System.out.println("Arreglo 3 ordenado por mergeSort");
        imprimirArreglo(H);

        System.out.println("Arreglo 4 desordenado");
        imprimirArreglo(I);

        // Ordenar por quickSort
        quickSort(I, 0, A.length - 1);

        System.out.println("Arreglo 4 ordenado por quickSort");
        imprimirArreglo(I);
    }

    public static void imprimirArreglo(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                System.out.print("(" + A[i] + ", ");
            } else if (i == A.length - 1) {
                System.out.println(A[i] + ")");
            } else {
                System.out.print(A[i] + ", ");
            }
        }
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
    public static ArrayList<Integer> conversorDecimalABinario(int X) {
        ArrayList<Integer> xNotacionBinaria = new ArrayList<>();

        convertirRecursivo(xNotacionBinaria, X);
        Collections.reverse(xNotacionBinaria);
        return xNotacionBinaria;
    }

    private static void convertirRecursivo(ArrayList<Integer> resultado, int X) {
        if (X < 2) {
            resultado.add(X % 2);
        } else {
            resultado.add(X % 2);
            X = X / 2;

            convertirRecursivo(resultado, X);
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

    /* Ejercicio 5
    Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
    determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
    cuál se encuentra, es decir, A[i] = i.

    1. Construir un algoritmo recursivo que responda a dicha verificación.
    2. Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10]) */
    public static boolean determinarAlgunValorIgualPosicion(int[] A, int pos) {
        boolean existe = false;

        if (existe || pos == A.length - 1) {
            return existe;
        } else {
            if (A[pos] == pos) {
                System.out.println("Existe el valor " + A[pos] +" en la posición " + pos);

                existe = true;
                return existe;
            }

            System.out.println("No existe el valor " + A[pos] +" en la posición " + pos);
            return determinarAlgunValorIgualPosicion(A, pos + 1); // Llamado recursivo
        }
    }

    /* Ejercicio 6
    Implemente un algoritmo de ordenamiento por selección en un arreglo.
    Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.

    • ¿Qué complejidad big-O tienen estos algoritmos? */

    /* Algoritmo de ordenamiento por selección
    Similar al burbujeo sólo que hace un intercambio por pasada.
    En cada iteración busca el elemento más grande y lo coloca sobre el final del arreglo a procesar. */

    // O(n²) ya que hay dos bucles anidados.
    public static void seleccion(int[] A) {
        int n = A.length;

        for (int i = n - 1; i > 0; i--) { // Se recorre de derecha a izquierda
            int maxIndex = 0; // Asumir que el mayor está en la posición 0

            // Buscar el máximo en la parte no ordenada
            for (int j = 1; j <= i; j++) {
                if (A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Intercambiar el máximo encontrado con el último de la parte no ordenada
            int temp = A[i];
            A[i] = A[maxIndex];
            A[maxIndex] = temp;
        }
    }

    /* Algoritmo de ordenamiento por burbujeo
    Consiste en comparar pares de elementos adyacentes en un array
    y si están desordenados intercambiarlos hasta que estén todos ordenados.

    El elemento mayor sube como una burbuja hacia la posición más alta. */

    // O(n²)
    public static void burbujeo(int[] A) {
        int i, j, aux;

        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
    }

    // Burbujeo adaptativo
    public static void bubbleSortAdapt(int[] A) {
        boolean swapped = true;
        int j = 0;
        int tmp;

        while (swapped) {
            swapped = false;
            j++;

            for (int i = 0; i < A.length - j; i++) {
                if (A[i] > A[i + 1]) {
                    tmp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    /* Ejercicio 7
    Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
    Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.

    • ¿Cuál es su complejidad en el peor caso?
    • ¿Cuál es su complejidad promedio? */

    // QuickSort -> No requiere memoria adicional! MergeSort si
    // Complejidad en el peor de los casos O(n²)
    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            // Encontrar el índice de partición
            int pivotIndex = partition(A, low, high);

            // Llamadas recursivas para las dos sublistas
            quickSort(A, low, pivotIndex - 1); // Sublista izquierda
            quickSort(A, pivotIndex + 1, high); // Sublista derecha
        }
    }

    // Método para realizar la partición del arreglo
    public static int partition(int[] A, int low, int high) {
        // Tomar el último elemento como pivote
        int pivot = A[high];
        int i = low - 1;

        // Reordenar el arreglo poniendo los menores que el pivote a la izquierda
        // y los mayores a la derecha
        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                i++;
                // Intercambiar arr[i] y arr[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // Intercambiar el pivote con el elemento en arr[i + 1]
        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        // Retornar el índice del pivote
        return i + 1;
    }

    /* Ejercicio 8
    Investigar cómo está implementado el algoritmo Collection.Sort de Java y qué características
    deben cumplir los elementos almacenados dentro de la colección a ordenar. */

    /*
    • Collections.sort() usa Timsort, que es rápido y eficiente.
    • Los elementos deben implementar Comparable o usar un Comparator.
    • Es más eficiente que QuickSort en muchos casos porque optimiza listas parcialmente ordenadas. */
}
