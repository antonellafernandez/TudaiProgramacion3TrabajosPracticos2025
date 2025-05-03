package TrabajosPracticos.TP5_Backtracking.Ejercicio08Funciona;

/* Ejercicio 8

Colocar un entero positivo (menor que un cierto valor entero k dado) en cada casilla de una
pirámide de base B (valor entero dado) de modo que cada número sea igual a la suma de las
casillas sobre las que está apoyado. Los números de todas las casillas deben ser diferentes. */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Piramide {
    public static final int K = 15; // Límite superior de valores
    public static final int B = 3; // Base de la pirámide
    public static List<int[]> mejorPiramide;

    public static void backPiramide(List<int[]> piramide) {
        mejorPiramide = null; // Reiniciar antes de la búsqueda
        backPiramide(piramide, new HashSet<>(), 0, 0);

        if (mejorPiramide != null) {
            imprimir(mejorPiramide);
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    private static void backPiramide(List<int[]> piramide, Set<Integer> usados, int fila, int col) {
        if (fila == piramide.size()) { // Si llenamos toda la pirámide, verificamos si es solución
            mejorPiramide = new ArrayList<>();

            for (int[] nivel : piramide) {
                mejorPiramide.add(nivel.clone());
            }
            
            return;
        }

        // Intentamos colocar un número en la pirámide
        for (int num = 1; num < K; num++) {
            if (!usados.contains(num) && cumpleRestriccion(piramide, fila, col, num)) {
                piramide.get(fila)[col] = num;
                usados.add(num);

                int siguienteFila;
                int siguienteCol;

                if (col + 1 == piramide.get(fila).length) {
                    siguienteFila = fila + 1;
                    siguienteCol = 0;
                } else {
                    siguienteFila = fila;
                    siguienteCol = col + 1;
                }

                backPiramide(piramide, usados, siguienteFila, siguienteCol);

                usados.remove(num);
                piramide.get(fila)[col] = 0;
            }
        }
    }

    private static boolean cumpleRestriccion(List<int[]> piramide, int fila, int col, int num) {
        if (fila == 0) return true;

        int[] nivelActual = piramide.get(fila);
        int[] nivelSuperior = piramide.get(fila - 1);

        if (col < nivelSuperior.length) {
            int sumaEsperada = nivelSuperior[col] + nivelSuperior[col + 1];
            return sumaEsperada == 0 || sumaEsperada == num;
        }
        return true;
    }

    public static void imprimir(List<int[]> piramide) {
        for (int i = piramide.size() - 1; i >= 0; i--) {
            for (int j = 0; j < piramide.get(i).length; j++) {
                System.out.print(piramide.get(i)[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<int[]> piramide = new ArrayList<>();

        for (int i = B; i > 0; i--) {
            piramide.add(new int[i]);
        }

        backPiramide(piramide);
    }
}
