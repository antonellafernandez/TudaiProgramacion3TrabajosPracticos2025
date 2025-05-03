package TrabajosPracticos.TP4_Grafos;

import java.util.*;

/* Ejercicio 2
Implemente los recorridos Depth-First-Search y Breadth-First-Search. */

public class ServicioBFS<T, G extends Grafo<T>> {
    private G grafo;
    private static final int BLANCO = 0; // NO_VISITADO
    private static final int AMARILLO = 1; // VISITADO

    public ServicioBFS(G grafo) {
        this.grafo = grafo;
    }

    public List<Integer> BFS() {
        // Inicializar vértices como NO_VISITADO
        HashMap<Integer, Integer> color = new HashMap<Integer, Integer>();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();

        while (verticesIterator.hasNext()) {
            color.put(verticesIterator.next(), BLANCO);
        }

        // Crear el ArrayList para almacenar el recorrido
        ArrayList<Integer> recorridoBFS = new ArrayList<>();

        // Recorrer cada vértice en el grafo
        verticesIterator = grafo.obtenerVertices();

        while (verticesIterator.hasNext()) {
            Integer vertice = verticesIterator.next();
            // Si el vértice no ha sido visitado, llamamos al método BFS_Visit
            if (color.get(vertice) == BLANCO) {
                BFS_Visit(vertice, color, recorridoBFS);
            }
        }

        return recorridoBFS;
    }

    public void BFS_Visit(int vertice, HashMap<Integer, Integer> color, ArrayList<Integer> recorrido) {
        color.put(vertice, AMARILLO); // Cambiar a VISITADO
        Queue<Integer> cola = new LinkedList<Integer>();
        cola.add(vertice);

        while (!cola.isEmpty()) {
            // Obtener el vértice de la cola y recorrerlo
            int u = cola.poll();
            recorrido.add(u); // Agregar el vértice al recorrido

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u); // Cambio de getAdyacentes a obtenerAdyacentes
            while (adyacentes.hasNext()) {
                Integer v = adyacentes.next();
                // Si el vértice adyacente no ha sido visitado, marcarlo como VISITADO
                // y agregarlo a la cola
                if (color.get(v) == BLANCO) {
                    color.put(v, AMARILLO); // Cambiar de NO_VISITADO a VISITADO
                    cola.add(v);
                }
            }
        }
    }

    /* Ejercicio 6
    Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
    es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
    esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
    cantidad de cuadras posible. */

    public List<Integer> caminoMasCorto(int inicio, int destino) {
        HashMap<Integer, Integer> padre = new HashMap<>();
        Queue<Integer> cola = new LinkedList<>();
        HashMap<Integer, Integer> distancia = new HashMap<>();

        cola.add(inicio);
        padre.put(inicio, null);
        distancia.put(inicio, 0);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            if (actual == destino) break; // Salir del bucle si se ha llegado a destino

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (!distancia.containsKey(adyacente)) { // Si no se ha visitado antes
                    cola.add(adyacente);
                    padre.put(adyacente, actual);
                    distancia.put(adyacente, distancia.get(actual) + 1);
                }
            }
        }

        return reconstruirCamino(padre, inicio, destino);
    }

    private List<Integer> reconstruirCamino(HashMap<Integer, Integer> padre, int inicio, int destino) {
        List<Integer> camino = new ArrayList<>();
        Integer actual = destino;
        while (actual != null) {
            camino.add(0, actual);
            actual = padre.get(actual);
        }
        if (camino.get(0) == inicio) {
            return camino;
        } else {
            return new ArrayList<>(); // No hay camino desde inicio a destino
        }
    }
}
