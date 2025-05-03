package TP5_Backtracking.Ejercicio07Funciona;

/* Ejercicio 7
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de las
columnas y de las filas sea igual a S. */

import java.util.HashSet;
import java.util.Set;


public class TableroMagico {
    public static int N = 3;
    public static int S = 18;
    public static int K = N * N + 1;

    public static int[][] mejorTablero;

    // Método de backtracking para construir el tablero
    public static int[][] backMagico(int[][] tablero) {
        mejorTablero = new int[N][N]; // Inicializar el mejor tablero
        backMagico(tablero, 0, 0, new HashSet<>()); // Comenzamos desde el número 1
        return mejorTablero;
    }

    // Método recursivo para intentar llenar el tablero
    private static void backMagico(int[][] tablero, int fila, int columna, Set<Integer> utilizados) {
        // Condición base: Si hemos colocado todos los números
        if (fila == N) {
            if (verificarSumaFilasColumnas(tablero)) {
                mejorTablero = copiarTablero(tablero); // Guardamos el mejor tablero
            }

            return;
        }

        for (int actual = 1; actual <= K; actual++) {
            if (!utilizados.contains(actual)) {
                // Intento de asignación
                tablero[fila][columna] = actual;
                utilizados.add(actual);

                int sigFila = fila;
                int sigColumna = columna + 1;
                if (sigColumna == N) {
                    sigFila++;
                    sigColumna = 0;
                }

                // Recursión
                backMagico(tablero, sigFila, sigColumna, utilizados);

                // Backtrack
                tablero[fila][columna] = 0;
                utilizados.remove(actual);
            }
        }
    }

    // Verificar si las sumas de las filas y las columnas son iguales a S
    private static boolean verificarSumaFilasColumnas(int[][] tablero) {
        int[] sumaFilas = new int[N];
        int[] sumaColumnas = new int[N];

        // Calcular la suma de cada fila y columna
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumaFilas[i] += tablero[i][j];
                sumaColumnas[j] += tablero[i][j];
            }
        }

        // Verificar que todas las filas y columnas tengan la misma suma
        for (int i = 0; i < N; i++) {
            if (sumaFilas[i] != S || sumaColumnas[i] != S) {
                return false;
            }
        }

        return true;
    }

    // Copia el tablero para guardar el mejor resultado
    private static int[][] copiarTablero(int[][] tablero) {
        int[][] copia = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copia[i][j] = tablero[i][j];
            }
        }
        return copia;
    }

    // Método para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tablero = new int[N][N];
        backMagico(tablero); // Llamamos al método de backtracking
        imprimirTablero(mejorTablero); // Imprimimos el mejor tablero encontrado
    }
}
