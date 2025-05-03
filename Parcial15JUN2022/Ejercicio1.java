package Parcial15JUN2022;

import java.util.*;

/* Ejercicio 1

Dado un grafo dirigido, el cual contiene a lo sumo UN solo ciclo, determine si, en caso de que tenga ciclo,
la suma de los arcos del ciclo resulta ser igual a un valor X dado como parámetro.

// Blanco -> No visitado, Amarillo -> En proceso, Negro -> Terminado
public class Ejercicio1 {
    public void DFS_SumaCiclosIgualX(int X) {
        Map<Integer, String> colores = new HashMap<>();

        // Inicializar vértices como no visitados
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            colores.put(v, "B");
        }

        // Recursión
        vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();

            if (colores.get(v).equals("B")) {
                dfs(v, colores, new ArrayList<>(), X);
            }
        }
    }

    private void dfs(int v, Map<Integer, String> colores, List<Integer> camino, int X) {
        colores.put(v, "A");
        camino.add(v);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();

            if (colores.get(adyacente).equals("B")) {
                dfs(adyacente, colores, camino, X);
            } else { // Si el vértice está en Amarillo, hay un ciclo
                if (colores.get(adyacente).equals("A")) {
                    int suma = 0;

                    for (int i = camino.indexOf(adyacente); i < camino.size() - 1; i++) {
                        suma += grafo.obtenerArco(camino.get(i), camino.get(i + 1)).getEtiqueta();
                    }

                    // Sumar la arista que cierra el ciclo
                    suma += grafo.obtenerArco(camino.get(camino.size() - 1), adyacente).getEtiqueta();

                    if (suma == X) {
                        System.out.println("La suma del ciclo es igual a X: " + suma);
                    } else {
                        System.out.println("La suma del ciclo NO es igual a X: " + suma);
                    }
                }
            }
        }

        // Marcar el vértice como terminado al haber explorado los adyacentes
        colores.put(v, "N");
        camino.remove(camino.size() - 1);
    }
} */
