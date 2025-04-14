package TP6_Greedy.Ejercicio01;

/* Ejercicio 1

Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
número de ellas.

Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de
10$ y 4 de 1$. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CambioDeMonedas {
    private int M = 289; // Cantidad a pagar
    private List<Integer> S; // Solución

    public List<Integer> greedy(List<Integer> C) {
        Collections.sort(C, Collections.reverseOrder()); // Ordenar de mayor a menor
        S = new ArrayList<>();

        int i = 0;

        while (i < C.size() && !solucion(S)) {
            int x = C.get(i);

            if (factible(S, x)) {
                S.add(x);
            } else {
                i++; // Probar con el siguiente billete
            }
        }

        if (solucion(S)) {
            return S;
        }

        return null;
    }

    private boolean solucion(List<Integer> S) {
        int suma = 0;

        for (int valor : S) {
            suma += valor;
        }

        return suma == M;
    }

    private boolean factible(List<Integer> S, int x) {
        int suma = 0;

        for (int valor : S) {
            suma += valor;
        }

        return (suma + x <= M);
    }

    public static void main(String[] args) {
        List<Integer> C = new ArrayList<>(Arrays.asList(100, 25, 10, 5, 1));

        CambioDeMonedas cmd = new CambioDeMonedas();
        List<Integer> resultado = cmd.greedy(C);

        if (resultado != null) {
            System.out.println("Cantidad de billetes/monedas: " + resultado.size());
            System.out.println("Combinación: " + resultado);
        } else {
            System.out.println("No se pudo encontrar solución.");
        }
    }
}

/* Estructura general de los Algoritmos Greedy
    public List<Integer> greedy(List<Integer> C) { // Inicialmente el conjunto C contiene todos los candidatos
        Collections.sort(C, Collections.reverseOrder()); // Ordenar de mayor a menor
        S = new ArrayList<>(); // Conjunto solución, inicialmente Vacío

        while (!C.isEmpty() && !solucion(S)) { // Mientras haya candidatos y no se llegó a una solución
            int x = C.get(0); // Determina el mejor candidato del conjunto a seleccionar
            C.remove(0);

            if (factible(S, x)) {
                S.add(x);
            }
        }

        if (solucion(S)) {
            return S;
        }

        return null;
    }

    Elementos:

    • Conjunto de candidatos a seleccionar C.

    • Conjunto de candidatos seleccionados S.

    • Función Solución: determina si los candidatos seleccionados han alcanzado una solución.

    • Función Seleccionar: determina el mejor candidato del conjunto a seleccionar en ese momento (criterio greedy).

    • Función de Factible: determina si válido para nuestro problema agregar el candidato seleccionado a la solución.

    • Siempre está presente una Función Objetivo: da el valor de la solución
    alcanzada que queremos sea óptima (maximice o minimice algo). */
