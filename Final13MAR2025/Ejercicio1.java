package Final13MAR2025;

/* Ejercicio 1

A partir de un conjunto N de personas con diferentes valores de fuerza se desea armar una secuencia de 4
suconjuntos disjuntos de manera tal que cada conjunto tenga una fuerza acumulada mayor que su predecesor pero
intentando minimizar la diferencia total de fuerza entre cada par de conjuntos. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio1 {
    private List<List<Persona>> S; // Solución
    private int[] fuerzas;
    private static int SECUENCIAS = 4; // SECUENCIAS < N.size()

    public List<List<Persona>> greedy(List<Integer> N) {
        // Ordenar N por fuerza descendente - Longest Processing Time First
        Collections.sort(N, new ComparadorFuerzaDesc());

        S = new ArrayList<>();
        fuerzas = new int[SECUENCIAS];

        for (int i = 0; i < SECUENCIAS; i++) {
            S.add(new ArrayList<>());
            fuerzas[i] = 0;
        }


        return S;
    }
}
