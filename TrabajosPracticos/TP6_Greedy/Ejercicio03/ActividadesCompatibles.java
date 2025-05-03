package TP6_Greedy.Ejercicio03;

/* Ejercicio 3

Maximizar el número de actividades compatibles. Se tienen n actividades que necesitan utilizar un
recurso, tal como una sala de conferencias, en exclusión mutua. Cada actividad i tiene asociado un
tiempo de comienzo ci y un tiempo de finalización fi de utilización del recurso, con ci < fi. Si la
actividad i es seleccionada se llevará a cabo durante el intervalo [ci, fi). Las actividades i y j son
compatibles si los intervalos [ci, fi) y [cj, fj) no se superponen (es decir, ci > fj o cj > fi). El problema
consiste en encontrar la cantidad máxima de actividades compatibles entre sí. */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActividadesCompatibles {
    private List<Actividad> S; // Solucion

    public List<Actividad> greedy(List<Actividad> C) {
        // Ordenar por tiempo de finalización
        C.sort(Comparator.comparingInt(Actividad::getTiempoFinalizacion));
        S = new ArrayList<>();

        int i = 0;

        while (i < C.size()) {
            if (S.isEmpty()) {
                // Agregar la primera actividad
                S.add(C.get(i));
            } else {
                Actividad a = C.get(i);

                if (factible(S, a)) {
                    S.add(a);
                } else {
                    i++; // Probar con la siguiente actividad
                }
            }
        }

        if (solucion(S)) {
            return S;
        }

        return null;
    }

    private boolean solucion(List<Actividad> S) {
        return !S.isEmpty();
    }

    private boolean factible(List<Actividad> S, Actividad a) {
        return a.getTiempoComienzo() > S.get(S.size() - 1).getTiempoFinalizacion();
    }
}
