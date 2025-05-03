package TrabajosPracticos.TP6_Greedy.Ejercicio04;

/* Ejercicio 4

Algoritmo de Dijkstra. Dado un grafo con pesos no negativos, implemente el algoritmo de Dijkstra
para determinar el array de distancias y de predecesores en el camino más corto, desde un vértice
orígen dado como parámetro hacia el resto de los vértices. Una vez realizado, imprima el camino
más corto que se debe seguir desde el orígen hacia cada vértice. */

import java.util.*;

public class Disjkstra {
    private Map<Integer, Integer> distancias;
    private Map<Integer, Integer> padres;
    private Set<Integer> S;

    public Map<Integer, Integer> Dijkstra(Grafo G, Integer origen) {
        distancias = new HashMap<>();
        padres = new HashMap<>();

        Iterator<Integer> vertices = G.obtenerVertices();

        // Inicializar distancias y padres
        while (vertices.hasNext()) {
            Integer v = (Integer) vertices.next();

            distancias.put(v, Integer.MAX_VALUE); // La distancia inicial se establece en infinito
            padres.put(v, null); // El nodo anterior en el camino más corto desde el origen
        }

        distancias.put(origen, 0); // Distancia desde el origen hasta él mismo se establece en 0
        S = new HashSet<>(); // Conjunto de vértices para los que ya se calculó el camino min desde el origen

        vertices = G.obtenerVertices(); // Reobtener vértices

        // Loop principal -> Mientras hayan vértices sin considerar
        while (S.size() < distancias.size()) {
            // distancias.get(u) tiene el menor valor
            Integer u = obtenerVerticeMinimoNoProcesado(G);

            S.add(u);

            Iterator<Integer> adyacentes = G.obtenerAdyacentes(u);

            while (adyacentes.hasNext()) {
                Integer v = adyacentes.next();
                int nuevaDistancia = distancias.get(u) + distanciaEntre(G, u, v);

                if (nuevaDistancia < distancias.get(v)) {
                    distancias.put(v, nuevaDistancia);
                    padres.put(v, u);
                }
            }
        }

        return padres;
    }

    private int obtenerVerticeMinimoNoProcesado(Grafo G) {
        int minVertice = -1;
        int minDistancia = Integer.MAX_VALUE;

        Iterator<Integer> vertices = G.obtenerVertices();

        while (vertices.hasNext()) {
            Integer v = (Integer) vertices.next();

            if(!S.contains(v) && distancias.get(v) < minDistancia) {
                minVertice = v;
                minDistancia = distancias.get(v);
            }
        }

        return minVertice;
    }

    private int distanciaEntre(Grafo G, Integer u, Integer v) {
        return (Integer) G.obtenerArco(u, v).getEtiqueta();
    }
}
