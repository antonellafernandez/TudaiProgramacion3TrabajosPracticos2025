package TP5_Backtracking.Ejercicio06;

/* Ejercicio 6

Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió a
ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas todavía
había pasto (señal de que en ellas no había estado el caballo). Escriba un algoritmo que deduzca el
recorrido completo que hizo el caballo. */

import java.util.ArrayList;
import java.util.Arrays;

public class CaballoDeAtila {
    private static int N = 4;
    private static ArrayList<int[]> mejorDeduccion;
    private static int noVisitados;
    private static int[] destino;
    private static int[][] tablero = {
            {0, 0, 0, 1}, // 0 = no visitado, 1 = visitado
            {0, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
    };

    public static void main(String[] args) {
        mejorDeduccion = new ArrayList<>();
        noVisitados = contarNoVisitados();

        int[] origen = buscarOrigen();

        if (origen != null) {
            backtracking(origen);
        }

        if (mejorDeduccion.isEmpty()) {
            System.out.println("No se ha encontrado solución.");
        } else {
            imprimir(mejorDeduccion);
        }
    }

    public static int[] buscarOrigen() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 0) {
                    int[] origen = {i, j};
                    destino = origen;
                    return origen;
                }
            }
        }

        return null;
    }

    public static int contarNoVisitados() {
        int cant = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 0) {
                    cant++;
                }
            }
        }

        return cant;
    }

    public static void backtracking(int[] origen) {
        ArrayList<int[]> deduccion = new ArrayList<>();
        int pasos = 1;

        deduccion.add(origen);
        marcarVisitado(origen);

        backtracking(origen, deduccion, pasos);
    }

    private static void backtracking(int[] actual, ArrayList<int[]> deduccionActual, int pasos) {
        if ((actual[0] == destino[0]) && (actual[1] == destino[1])  && (pasos - 1 == noVisitados)) { // Condición de corte / Si llegue a destino (origen) y recorrí tdos los casilleros no visitados
            if (mejorDeduccion.isEmpty()) {
                mejorDeduccion = new ArrayList<>(deduccionActual);
            }

            return;
        }

        ArrayList<int[]> vecinos = getVecinos(actual); // Me da los casilleros a los cuales me puedo mover

        for (int[] vecino : vecinos) {
            boolean visitado = false;
            int i = 0;

            while (!visitado && (i < deduccionActual.size())) {
                int[] aux = deduccionActual.get(i);

                if (Arrays.equals(aux, vecino)) { // Comparar contenido, no referencia
                    visitado = true;
                } else {
                    i++;
                }
            }

            if (!visitado || Arrays.equals(vecino, destino)) {
                // Aplicar / Hacer cambios / Agregar solucion
                deduccionActual.add(vecino);
                marcarVisitado(vecino);
                pasos++;

                if (mejorDeduccion.isEmpty()) { // Poda
                    backtracking(vecino, deduccionActual, pasos); // Llamado recursivo
                }

                // Deshacer
                quitarUltimo(deduccionActual);
                marcarNoVisitado(vecino);
                pasos--;
            }
        }
    }

    public static void marcarVisitado(int[] casillero) {
        tablero[casillero[0]][casillero[1]] = 1;
    }

    public static void marcarNoVisitado(int[] casillero) {
        tablero[casillero[0]][casillero[1]] = 0;
    }

    public static void quitarUltimo(ArrayList<int[]> deduccion) {
        deduccion.remove(deduccion.size() - 1);
    }

    private static ArrayList<int[]> getVecinos(int[] actual) {
        ArrayList<int[]> vecinos = new ArrayList<>();

        int i = actual[0];
        int j = actual[1];

        // Arriba
        if (j - 1 >= 0) { // Verificar movimiento factible
            if (tablero[i][j - 1] == 0 || (destino[0] == i && (destino[1] == j - 1))) { // Verificar que el vecino no esté visitado en el tablero inicial
                vecinos.add(new int[]{i, j - 1});
            }
        }

        // Abajo
        if (j + 1 < N) {
            if (tablero[i][j + 1] == 0 || (destino[0] == i && (destino[1] == j + 1))) {
                vecinos.add(new int[]{i, j + 1});
            }
        }

        // Derecha
        if (i + 1 < N) {
            if (tablero[i + 1][j] == 0 || ((destino[0] == i + 1) && destino[1] == j)) {
                vecinos.add(new int[]{i + 1, j});
            }
        }

        // Izquierda
        if (i - 1 >= 0) {
            if (tablero[i - 1][j] == 0 || ((destino[0] == i - 1) && destino[1] == j)) {
                vecinos.add(new int[]{i - 1, j});
            }
        }

        return vecinos;
    }

    public static void imprimir(ArrayList<int[]> deduccion) {
        for (int [] actual : deduccion) {
            System.out.println("(" + actual[0] + ", " + actual[1] + ")");
        }
    }
}
