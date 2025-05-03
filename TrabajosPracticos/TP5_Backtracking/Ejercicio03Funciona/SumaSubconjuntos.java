package TrabajosPracticos.TP5_Backtracking.Ejercicio03Funciona;

/* Ejercicio 3

Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
combinaciones de esos números tal que la suma sea igual a M. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumaSubconjuntos {
    private int M = 12; // Objetivo
    List<List<Integer>> soluciones;

    public List<List<Integer>> backSubconjuntos(List<Integer> conjunto) {
        soluciones = new ArrayList<>();
        ArrayList<Integer> auxiliar = new ArrayList<>();
        backSubconjuntos(conjunto, 0, 0, auxiliar);
        return soluciones;
    }

    private void backSubconjuntos(List<Integer> conjunto, Integer actual, Integer suma, ArrayList<Integer> auxiliar) {
        if (suma == M) { // Caso base
            soluciones.add(new ArrayList<>(auxiliar));
            return; // Salir de la recursión
        } else {
            for (int i = actual; i < conjunto.size(); i++) {
                auxiliar.add(conjunto.get(i));

                if ((suma + conjunto.get(i)) <= 12) { // Poda
                    backSubconjuntos(conjunto, i + 1, suma + conjunto.get(i), auxiliar); // Recursión
                }

                auxiliar.remove(auxiliar.size() - 1); // Bactrack
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> conjunto = Arrays.asList(2, 4, 6, 10);
        SumaSubconjuntos sumaSubconjuntos = new SumaSubconjuntos();
        List<List<Integer>> resultado = sumaSubconjuntos.backSubconjuntos(conjunto);

        System.out.println("Subconjuntos que suman 12: " + resultado);
    }
}
