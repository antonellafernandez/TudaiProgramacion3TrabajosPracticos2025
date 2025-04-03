package TP5_Backtracking.Ejercicio07;

/* Ejercicio 7
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de las
columnas y de las filas sea igual a S. */

public class TableroMagico {
    public static int N = 4;
    public static int S = 10;

    public static int[][] mejorTablero;

    // Método de backtracking para construir el tablero
    public static int[][] Backtracking(int[][] tablero) {
        mejorTablero = new int[N][N]; // Inicializar el mejor tablero
        Backtracking(tablero, 1); // Comenzamos desde el número 1
        return mejorTablero;
    }

    // Método recursivo para intentar llenar el tablero
    private static void Backtracking(int[][] tablero, int numActual) {
        // Condición base: Si hemos colocado todos los números
        if (numActual > N * N) {
            if (verificarSumaFilas(tablero) && verificarSumaColumnas(tablero)) {
                mejorTablero = copiarTablero(tablero); // Guardamos el mejor tablero
            }
            return;
        }

        // Intentamos colocar el número actual en el tablero
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 0) { // Si la casilla está vacía
                    tablero[i][j] = numActual; // Colocamos el número

                    // Poda: Verificamos las sumas de filas y columnas hasta ahora
                    if (verificarSumaFilas(tablero) && verificarSumaColumnas(tablero)) {
                        // Continuamos con el siguiente número
                        Backtracking(tablero, numActual + 1);
                    }

                    // Back
                    tablero[i][j] = 0;
                }
            }
        }
    }

    // Verifica si las sumas de las filas son iguales a S
    private static boolean verificarSumaFilas(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            int sumaAux = 0;

            for (int j = 0; j < N; j++) {
                sumaAux += tablero[i][j];
            }

            if (sumaAux != S) {
                return false;
            }
        }
        return true;
    }

    // Verifica si las sumas de las columnas son iguales a S
    private static boolean verificarSumaColumnas(int[][] tablero) {
        for (int j = 0; j < N; j++) {
            int sumaAux = 0;

            for (int i = 0; i < N; i++) {
                sumaAux += tablero[i][j];
            }

            if (sumaAux != S) {
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
        Backtracking(tablero); // Llamamos al método de backtracking
        imprimirTablero(mejorTablero); // Imprimimos el mejor tablero encontrado
    }
}
