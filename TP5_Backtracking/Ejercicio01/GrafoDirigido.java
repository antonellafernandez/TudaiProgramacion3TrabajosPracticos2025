package TP5_Backtracking.Ejercicio01;

import TP4_Grafos.Arco;
import TP4_Grafos.Grafo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, LinkedList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (vertices.containsKey(verticeId)) {
            System.out.println("El vértice " + verticeId + " ya se encuentra agregado.");
        } else {
            vertices.put(verticeId, new LinkedList<Arco<T>>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            System.out.println("El vértice " + verticeId + " no existe.");
        } else {
            // Eliminar el vértice de los conjuntos de adyacentes de los demás vértices
            for (Integer vecino : vertices.keySet()) {
                LinkedList<Arco<T>> arcos = vertices.get(vecino);
                arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId);
            }

            // Eliminar el vértice
            vertices.remove(verticeId);
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("El grafo no contiene al menos uno de los vértices.");
        } else {
            vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("El grafo no contiene al menos uno de los vértices.");
        } else {
            // Eliminar el arco de la lista de adyacencia de verticeId1
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
            arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId2);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
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
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int totalArcos = 0;

        for (LinkedList<Arco<T>> arcos : vertices.values()) {
            totalArcos += arcos.size();
        }

        return totalArcos;
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

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        LinkedList<Arco<T>> listaArcos = new LinkedList<>();

        for (LinkedList<Arco<T>> listaAdyacencia : vertices.values()) {
            listaArcos.addAll(listaAdyacencia);
        }

        return listaArcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            return null; // Manejar el caso donde el vértice no está en el grafo
        }

        return vertices.get(verticeId).iterator();
    }
}
