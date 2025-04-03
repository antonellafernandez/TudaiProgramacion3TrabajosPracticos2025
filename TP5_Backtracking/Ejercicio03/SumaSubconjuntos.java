package TP5_Backtracking.Ejercicio03;

/* Ejercicio 3

Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
combinaciones de esos números tal que la suma sea igual a M. */

import java.util.ArrayList;
import java.util.List;

public class SumaSubconjuntos {
    public static void main(String[] args) {
        SumaSubconjuntos sumaSubconjuntos = new SumaSubconjuntos();
        int[] numeros = {2, 4, 6, 10};  // Ejemplo de conjunto de números
        int M = 12;  // Valor objetivo

        List<List<Integer>> combinaciones = sumaSubconjuntos.encontrarCombinaciones(numeros, M);

        // Imprimimos las combinaciones que suman M
        for (List<Integer> combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }

    // Método principal que inicia el proceso de backtracking
    public List<List<Integer>> encontrarCombinaciones(int[] numeros, int M) {
        List<List<Integer>> resultados = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();

        // Llamamos al método recursivo con el índice 0 y la suma inicial 0
        backtracking(numeros, M, 0, caminoActual, resultados);

        return resultados; // Retornamos todas las combinaciones encontradas
    }

    // Método recursivo de backtracking
    private void backtracking(int[] numeros, int M, int indice, List<Integer> caminoActual, List<List<Integer>> resultados) {
        if (M == 0) {  // Si la suma actual es igual a M, hemos encontrado una combinación válida
            resultados.add(new ArrayList<>(caminoActual));  // Guardamos la combinación actual
            return;
        }

        if (M < 0 || indice >= numeros.length) {  // Si la suma excede M o hemos recorrido todos los números, terminamos
            return;
        }

        // Incluir el número actual en la combinación
        caminoActual.add(numeros[indice]);
        backtracking(numeros, M - numeros[indice], indice + 1, caminoActual, resultados);  // Llamada recursiva con la suma reducida

        // Deshacer
        caminoActual.remove(caminoActual.size() - 1);  // Quitar el último número agregado
        backtracking(numeros, M, indice + 1, caminoActual, resultados);  // Llamada recursiva sin modificar la suma
    }
}
