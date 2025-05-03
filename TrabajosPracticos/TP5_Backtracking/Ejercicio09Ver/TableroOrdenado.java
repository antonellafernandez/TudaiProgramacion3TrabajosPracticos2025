package TP5_Backtracking.Ejercicio09Ver;

/* Ejercicio 9

Dado un tablero de 4 x 4, en cuyas casillas se encuentran desordenados los números enteros del 1
al 15 y una casilla desocupada en una posición inicial dada, determinar una secuencia de pasos tal
intercambiando números contiguos (en horizontal y en vertical) con la casilla desocupada, los
números en el tablero queden ordenados (como muestra la figura) y la casilla desocupada quede en
la posición 4,4. */

import java.util.ArrayList;
import java.util.List;

public class TableroOrdenado {
    private static int N = 4;
    private static int[][] mejorTablero;

    public int[][] backOrdenar(int[][] tablero) {
        mejorTablero = new int[N][N];
        backOrdenar(tablero, 0, 0);

        return mejorTablero;
    }

    private void backOrdenar(int[][] tablero, int i, int j) {
        if ((i == N - 1) && (j == N - 1) && (tablero[i][j] == 0) && esTableroOrdenado(tablero)) { // Condición base
            mejorTablero = copiarTablero(tablero);
            return; // Salir de la recursión
        } else {
            // Intento asignación
            List<int[]> contiguos = obtenerContiguos(i, j);

            for (int[] pos : contiguos) {
                int x = pos[0];
                int y = pos[1];

                intercambiarContiguo(tablero, i, j, x, y);
                backOrdenar(tablero, x, y); // Recursión
                deshacerContiguo(tablero, i, j, x, y); // Back
            }
        }
    }

    private boolean esTableroOrdenado(int[][] tablero) {
        boolean ordenado = true; // Implementación
        return ordenado;
    }

    private int[][] copiarTablero(int[][] tablero) {
        int[][] salida = new int[N][N]; // Implementación
        return salida;
    }

    private List<int[]> obtenerContiguos(int i, int j) {
        List<int[]> salida = new ArrayList<>(); // Implementación
        return salida;
    }

    private void intercambiarContiguo(int[][] tablero, int i1, int j1, int i2, int j2) {
        // Implementación
    }

    private void deshacerContiguo(int[][] tablero, int i1, int j1, int i2, int j2) {
        // Implementación
    }
}
