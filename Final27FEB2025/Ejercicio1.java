package Final27FEB2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Ejercicio 1

Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el camino simple
(es decir, sin ciclos) de MAYOR peso (la suma de los pesos de los arcos que forman el camino) del vértice i al
vértice j. (Nota: el grafo puede contener ciclos).

public class Ejercicio1 {
    private HashMap<Integer, String> colores;
    private List<Integer> mejorCaminoSimple;
    private Integer mejorPeso;

    public Ejercicio1() {
        this.colores = new HashMap<>();
        this.mejorCaminoSimple = new LinkedList<>();
        this.mejorPeso = null;
    }

    public List<Integer> obtenerCaminoSimple(Grafo g, Integer i, Integer j) {
        Iterator<Integer> verticesIt = g.obtenerVertices();
        while (verticesIt.hasNext()) {
            colores.put(verticesIt.next(), "B");
        }

        List<Integer> caminoActual = new LinkedList<>();
        caminoActual.add(i);
        colores.put(i, "A"); // Estado inicial

        obtenerCaminoSimple(g, i, j, caminoActual, 0);
        return mejorCaminoSimple;
    }

    private void obtenerCaminoSimple(Grafo g, Integer actual, Integer destino, List<Integer> caminoActual, Integer pesoActual) {
        // Condición Base: Llegar a destino
        if (actual == destino) {
            if (pesoActual > mejorPeso) {
                mejorCaminoSimple.clear();
                mejorCaminoSimple.addAll(caminoActual);
                mejorPeso = pesoActual;
            }
        } else {
            Iterator<Integer> adyIt = g.obtenerAdyacentes(actual);
            while (adyIt.hasNext()) {
                Integer ady = adyIt.next();

                if (colores.get(ady).equals("B")) {
                    Arco<Integer> arco = g.obtenerArco(actual, ady);

                    // Intento de asignación
                    colores.put(ady, "A");
                    caminoActual.add(ady);
                    pesoActual += arco.getEtiqueta();

                    // Recursión
                    obtenerCaminoSimple(g, ady, destino, caminoActual, pesoActual);

                    // Backtrack
                    colores.put(ady, "B");
                    caminoActual.removeLast();
                    pesoActual -= arco.getEtiqueta();
                }
            }
        }
    }
} */
