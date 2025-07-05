package Parcial16JUN2023;

/* Ejercicio 4

Dado un grafo no dirigido G que contiene varios ciclos, escriba un algoritmo en JAVA que devuelva (en una lista
de nodos) el ciclo de mayor tamaño (o sea, el ciclo compuesto por la mayor cantidad de nodos). */

import java.util.*;
/*
public class Ejercicio4y5 {
    private List<Integer> mayorCiclo;
    private Grafo g;

    public Ejercicio4y5(Grafo g) {
        this.g = g;
    }

    public List<Integer> dfsBuscarMayorCiclo() {
        mayorCiclo = new ArrayList<>();
        Map<Integer, String> colores = new HashMap<>();

        // Inicializar vértices como no visitados
        Iterator<Integer> vertices = g.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();
            colores.put(v, "B");
        }

        // Recursión
        vertices = g.obtenerVertices();
        while (vertices.hasNext()) {
            Integer v = vertices.next();

            if (colores.get(v).equals("B")) {
                dfsBuscarMayorCiclo(v, colores, new ArrayList<>());
            }
        }

        return mayorCiclo;
    }

    private void dfsBuscarMayorCiclo(Integer v, Map<Integer, String> colores, List<Integer> camino) {
        colores.put(v, "A");
        camino.add(v);

        Iterator<Integer> adyacentes = g.getAdyacentes(v);
        while (adyacentes.hasNext()) {
            Integer ady = adyacentes.next();

            if (colores.get(ady).equals("B")) {
                dfsBuscarMayorCiclo(ady, colores, camino);
            } else {
                if (colores.get(ady).equals("A")) { // Si el vértice está en Amarillo, hay un ciclo
                    if (mayorCiclo.isEmpty() || camino.size() > mayorCiclo.size()) {
                        mayorCiclo.clear();
                        mayorCiclo.addAll(camino);
                    }
                }
            }
        }

        colores.put(v, "N");
        camino.remove(camino.size() - 1);
    }
} */
