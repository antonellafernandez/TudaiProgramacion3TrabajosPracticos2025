package TP5_Backtracking.Ejercicio7;

/* Ejercicio 7
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de las
columnas y de las filas sea igual a S. */

public class TableroMagico {
    public static int N = 4;
    public static int S = 10;

    public static int[][] tablero;

    public static void main(String[] args) {

    }

    public static void backtracking() {

    }

    private void bactracking() {

    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
        }
    }
}
