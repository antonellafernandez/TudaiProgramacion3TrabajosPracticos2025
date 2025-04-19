package TP6_Greedy.Ejercicio04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, LinkedList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap();
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("El grafo no contiene al menos uno de los vértices.");
            return false;
        } else {
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);

            for (Arco<T> arco : arcos) {
                if (arco.getVerticeDestino() == verticeId2) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            return null;
        } else if (existeArco(verticeId1, verticeId2)) {
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);

            for (Arco<T> arco : arcos) {
                if (arco.getVerticeDestino() == verticeId2) {
                    return arco;
                }
            }
        }
        return null; // Si no se encuentra el arco, devolver null
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        Iterator<Integer> iterador = vertices.keySet().iterator();
        return iterador;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            return null; // Manejar el caso donde el vértice no está en el grafo
        }

        LinkedList<Integer> vecinos = new LinkedList<>();

        for (Arco<T> arco : vertices.get(verticeId)) {
            vecinos.add(arco.getVerticeDestino());
        }

        return vecinos.iterator();
    }
}
