package TP6_Greedy.Ejercicio08Parcial13JUL2023;

/* Ejercicio 8

Coloreo de un grafo. Dado un grafo se desea colorear cada uno de sus vértices utilizando la menor
cantidad posible de colores totales, sabiendo que dos vértices adyacentes no podrán utilizar el
mismo color. */

import java.util.*;

public class ColorearGrafo {
    private Grafo g;

    public ColorearGrafo(Grafo g) {
        this.g = g;
    }

    public int greedy() {
        Map<Integer, Integer> asignacionColores = new HashMap<>();
        Iterator<Integer> vertices = g.obtenerVertices();
        int cantidadColores = 1; // Inicializan con el color 0

        // Inicializar los vértices con el color 0
        while (vertices.hasNext()) {
            asignacionColores.put(vertices.next(), 0);
        }

        vertices = g.obtenerVertices();

        while (vertices.hasNext()) {
            Integer v = vertices.next();

            if (asignacionColores.get(v) == 0) {
                getColor(v, asignacionColores, cantidadColores);
            }
        }

        return cantidadColores;
    }

    private void getColor(int v, Map<Integer, Integer> asignacionColores, int cantidadColores) {
        // Creo una lista para guardar los colores de los adyacentes
        List<Integer> coloresAdy = new ArrayList<>();
        Iterator<Integer> adyacentes = g.obtenerAdyacentes(v);

        while (adyacentes.hasNext()) {
            coloresAdy.add(asignacionColores.get(adyacentes.next()));
        }

        // Si coloresAdy tiene {1,3,4}, suponiendo que v arranca en 1, como lo contiene suma 1 a eso,
        // ahora tiene 2 y como el array no lo contiene se queda con ese
        while (coloresAdy.contains(asignacionColores.get(v))) {
            asignacionColores.put(v, asignacionColores.get(v) + 1);
        }

        cantidadColores++;
    }
}
