package TP5_Backtracking.Ejercicio4;

/* Ejercicio 4

Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en
dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma. */

import java.util.ArrayList;
import java.util.List;

public class ParticionDeConjunto {
    public static void main(String[] args) {
        ParticionDeConjunto particionDeConjunto = new ParticionDeConjunto();
        int[] conjunto = {1, 5, 11, 5};  // Ejemplo de conjunto de números

        List<List<List<Integer>>> particiones = particionDeConjunto.encontrarParticiones(conjunto);

        // Imprimimos las combinaciones que suman M
        for (List<List<Integer>> particion : particiones) {
            for (List<Integer> subconjunto : particion) {
                System.out.println(subconjunto);
            }
        }
    }

    // Método principal que inicia el proceso de backtracking
    public List<List<List<Integer>>> encontrarParticiones(int[] conjunto) {
        List<List<List<Integer>>> resultados = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        int sumaTotal = 0;

        // Calculamos la suma total del conjunto
        for (int num : conjunto) {
            sumaTotal += num;
        }

        // Si la suma total es impar, no es posible dividirla en dos subconjuntos con la misma suma
        if (sumaTotal % 2 != 0) {
            return resultados; // No existe partición posible
        }

        int sumaMeta = sumaTotal / 2;

        // Llamamos al método recursivo con el índice 0 y la suma inicial 0
        backtracking(conjunto, 0, sumaMeta, caminoActual, resultados);

        return resultados; // Retornamos todas las combinaciones encontradas
    }

    // Método recursivo de backtracking
    private void backtracking(int[] conjunto, int indice, int sumaMeta, List<Integer> caminoActual, List<List<List<Integer>>> resultados) {
        // Si la suma actual es igual a la suma meta, encontramos una partición
        if (sumaMeta == 0) {
            List<List<Integer>> particion = new ArrayList<>();
            particion.add(new ArrayList<>(caminoActual));

            // Agregar el subconjunto restante
            List<Integer> restante = new ArrayList<>();
            for (int i = 0; i < conjunto.length; i++) {
                if (!caminoActual.contains(conjunto[i])) {
                    restante.add(conjunto[i]);
                }
            }
            particion.add(restante);

            resultados.add(particion); // Agregar la partición encontrada
            return;
        }

        // Si hemos recorridotodo el conjunto o si la suma actual excede la meta, terminamos
        if (indice == conjunto.length || sumaMeta < 0) {
            return;
        }

        // Incluir el elemento en el camino actual
        caminoActual.add(conjunto[indice]);
        // Llamada recursiva con el siguiente índice y la nueva suma
        backtracking(conjunto, indice + 1, sumaMeta - conjunto[indice], caminoActual, resultados);
        // Retirar el último elemento para explorar otras combinaciones
        caminoActual.remove(caminoActual.size() - 1);

        // No incluir el elemento y continuar con el siguiente índice
        backtracking(conjunto, indice + 1, sumaMeta, caminoActual, resultados);
    }
}
