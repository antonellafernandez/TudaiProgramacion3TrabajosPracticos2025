package Final13MAR2025;

/* Ejercicio 1

A partir de un conjunto N de personas con diferentes valores de fuerza se desea armar una secuencia de 4
suconjuntos disjuntos de manera tal que cada conjunto tenga una fuerza acumulada mayor que su predecesor pero
intentando minimizar la diferencia total de fuerza entre cada par de conjuntos.

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio1 {
    private List<List<Persona>> S; // Solución
    private int[] fuerzas;
    private static int SECUENCIAS = 4; // SECUENCIAS < N.size()

    public List<List<Persona>> greedy(List<Persona> N) {
        // Ordenar N por fuerza descendente - Longest Processing Time First
        Collections.sort(N, new ComparadorFuerzaDesc());

        S = new ArrayList<>();
        fuerzas = new int[SECUENCIAS];

        // Inicializar los 4 subconjuntos con las primeras 4 personas más fuertes
        for (int i = 0; i < SECUENCIAS; i++) {
            List<Persona> aux = new ArrayList<>();
            aux.add(N.get(i));
            S.add(aux);

            fuerzas[i] = N.get(i).getFuerza();;
        }

        // Para cada persona restante
        for (int i = SECUENCIAS; i < N.size(); i++) {
            Persona p = N.get(i);

            for (int j = S.size() - 1; j > 0; j--) {
                if ((fuerzas[j] + p.getFuerza()) < fuerzas[j - 1]) {
                    S.get(j).add(p);
                    fuerzas[j] += p.getFuerza();
                }
            }
        }

        return S;
    }
} */
