package Final13MAR2025;

/* Ejercicio 3

Dado un conjunto de M números naturales positivos se desea responder en cuántas secuencias distintas se pueden
ubicar dichos números sabiendo que las secuencias no deben estar vacías ni contener 2 números pares seguidos. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio3 {
    private List<List<Integer>> solucion;

    public List<List<Integer>> backtracking(List<Integer> C) {
        solucion = new ArrayList<>();
        boolean[] usado = new boolean[C.size()];
        backtracking(C, new ArrayList<>(), usado);
        return solucion;
    }

    private void backtracking(List<Integer> C, List<Integer> aux, boolean[] usado) {
        // Condición Base
        if (aux.size() == C.size()) {
            solucion.add(new ArrayList<>(aux)); // Copia
            return;
        }

        for (int i = 0; i < C.size(); i++) {
            if (!usado[i]) {
                // Poda
                if (aux.isEmpty() || !(aux.get(aux.size() - 1) % 2 == 0 && C.get(i) % 2 == 0)) {
                    // Intento de asignación
                    usado[i] = true;
                    aux.add(C.get(i));

                    // Recursión
                    backtracking(C, aux, usado);

                    // Backtrack
                    usado[i] = false;
                    aux.remove(aux.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio3 ej = new Ejercicio3();
        List<Integer> C = Arrays.asList(1, 2, 3, 4);
        System.out.println(ej.backtracking(C));
    }
}
