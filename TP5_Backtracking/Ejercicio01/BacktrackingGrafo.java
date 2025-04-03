package TP5_Backtracking.Ejercicio01;

import java.util.*;

/* Ejercicio 1

Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en
un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
puerta es un arco dirigido hacia otra habitación. */

public class BacktrackingGrafo<T> {
    private GrafoDirigido<T> grafo;
    private List<Integer> mejorCamino;
    private int maxNodosVisitados;

    public BacktrackingGrafo(GrafoDirigido<T> grafo) {
        this.grafo = grafo;
        this.mejorCamino = new ArrayList<>();
        this.maxNodosVisitados = 0;
    }

    public List<Integer> encontrarCaminoMasLargo(int entrada, int salida) {
        List<Integer> caminoActual = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();

        // Iniciar la búsqueda desde la sala de entrada
        backtracking(entrada, salida, caminoActual, visitados);
        return mejorCamino;
    }

    private void backtracking(int actual, int salida, List<Integer> caminoActual, Set<Integer> visitados) {
        // Agregar la sala actual al camino y marcarla como visitada
        caminoActual.add(actual);
        visitados.add(actual);

        // Si llegamos a la sala de salida, verificamos si es el camino más largo
        if (actual == salida) {
            if (caminoActual.size() > maxNodosVisitados) {
                maxNodosVisitados = caminoActual.size();
                mejorCamino = new ArrayList<>(caminoActual); // Guardar la mejor solución encontrada
            }
        } else {
            // Iterar sobre los vecinos de la sala actual
            Iterator<Integer> vecinos = grafo.obtenerAdyacentes(actual);

            while (vecinos.hasNext()) {
                int vecino = vecinos.next();
                if (!visitados.contains(vecino)) { // Evitar ciclos
                    backtracking(vecino, salida, caminoActual, visitados);
                }
            }
        }

        // Retroceder: desmarcar la sala actual y eliminarla del camino actual
        visitados.remove(actual);
        caminoActual.remove(caminoActual.size() - 1);
    }
}
