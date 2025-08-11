package Final08AGO2024;

/* Ejercicio 1

Dado un grafo conectado no dirigido G(V,A) que tiene más de 2 vértices. Escriba en JAVA un algoritmo que devuelva una lista,
si existen, todos los puntos de articulación del grafo G(V,A). Un punto de articulación es un vértiice que si se lo borra el
grafo deja de ser un grafo conectado. */

import TrabajosPracticos.TP4_Grafos.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Ejercicio1 {
    private List<Integer> puntosDeArticulacion;
    private HashMap<Integer, String> colores;

    public List<Integer> buscarPuntosArticulacion(Grafo g) {
        puntosDeArticulacion = new ArrayList<>();

        Iterator<Integer> verticesIt = g.obtenerVertices();
        List<Integer> vertices = new ArrayList<>(); // Pasar los vértices a una lista

        while (verticesIt.hasNext()) {
            vertices.add(verticesIt.next());
        }

        // Eliminar cada vértice para luego hacer un dfs desde otro vértice
        // y ver si quedan vértices sin visitar a partir del mismo
        // lo cual implicaría que el eliminado era un punto de articulación
        for (Integer v : vertices) {
            if (esPuntoDeArticulacion(g, v, vertices)) {
                puntosDeArticulacion.add(v);
            }
        }

        return puntosDeArticulacion;
    }

    private boolean esPuntoDeArticulacion(Grafo g, Integer eliminado, List<Integer> vertices) {
        // Reiniciar colores
        colores = new HashMap<>();

        for (Integer v : vertices) {
            colores.put(v, "B");
        }

        // Marcar el eliminado como terminado para ignorarlo en el dfs
        colores.put(eliminado, "N");

        // Elegir un vértice inicial distinto al eliminado
        Integer inicio = null;
        boolean hayInicio = false;
        int i = 0;

        while (!hayInicio && i < vertices.size()) {
            if (vertices.get(i) != eliminado) {
                inicio = vertices.get(i);
                hayInicio = true;
            }

            i++;
        }

        // Hacer DFS desde el inicio
        List<Integer> visitados = new ArrayList<>();
        dfs(g, inicio, visitados);

        // Si no se visitan todos los vértices menos el eliminado, entonces este es un punto de articulación
        return visitados.size() < vertices.size() - 1; // Restar el eliminado
    }

    private List<Integer> dfs(Grafo g, Integer v, List<Integer> visitados) {
        colores.put(v, "A");
        visitados.add(v);

        Iterator<Integer> adyIt = g.obtenerAdyacentes(v);

        while (adyIt.hasNext()) {
            Integer w = adyIt.next();

            if (colores.get(w).equals("B")) {
                dfs(g, w, visitados);
            }
        }

        colores.put(v, "N");

        return visitados;
    }
}
