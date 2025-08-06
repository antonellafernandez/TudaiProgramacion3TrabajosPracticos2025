package Final17JUL2025;

/* Ejercicio 1

Las ciudades de una provincia y sus rutas están modeladas mediante un grafo no dirigido conectado. El rótulo de
cada arco es el costo en $ de peaje en esa ruta entre las dos ciudades.

Una empresa quiere poner un centro de distribución en una ciudad de la provicna desde el cual se hará un envío una
vez por mes a cada una del resto de las ciudades, el camión saldrá del centro de distribución con destino a una
ciudad, y volverá al centro de distribución, hará esto una vez al mes por cada ciudad.

Se buscará que el costo total de los peajes a pagar sea el menor posible.

Escriba un algoritmo en JAVA que dado el grafo mencionado, devuelva qué ciudad es la que debe
seleccionarse para construir el centro de distribución.

El algoritmo deberá tener complejidad computacional menor o igual a O(n^3). */

import java.util.HashMap;

public class Ejercicio1 {
    private Grafo<String> grafo;
    private HashMap<String, String> colores; // <Vertice, Color>
    // Ciclo: Almacena el camino (secuencia de vértices) y el costo (suma de arcos)
    private Ciclo mejorSolucion;

    public Ciclo ejercicio1() {
        colores = new HashMap<>();
        mejorSolucion = new Ciclo();
        mejorSolucion.setCosto(0);

        // Inicialización
        Iterator<String> it = g.obtenerVertices();

        while (it.hasNext()) {
            colores.put(it.next(), "B");
        }

        Ciclo ciclo = new Ciclo();
        String origen = g.obtenerVertices().next(); // Obtener el primero de los vértices
        ciclo.addVertice(origen);
        ciclo.setCosto(0);
        obtenerCicloHamiltoneano(g, origen, origen, ciclo);

        return mejorSolucion;
    }

    public static void obtenerCicloHamiltoneano(String actual, String origen, Ciclo cicloActual) {
        // Cuando en el camino tenemos todos los vértices + el origen 2 veces (inicio y fin)
        if (ciclo.getCamino().size() == grafo.cantidadVertices() + 1) {
            if (actual.equals(origen)) {
                // Operar solución actual contra mejor solución
                if (ciclo.getCosto() < mejorSolucion.getCosto()) {
                    mejorSolucion = new Ciclo(ciclo); // Copia el camino y el costo
                }
            }
        } else {
            Iterator<Arco<Integer>> adyacentes = g.obtenerArcos(actual);

            while (adyacentes.hasNext()) {
                Arco<Integer> adyacente = adyacentes.next();

                if (colores.get(arco.getVerticeDestino().equals("B"))) {
                    // Intento de asignación
                    ciclo.addVertice(arco.getVerticeDestino());
                    ciclo.costo += (arco.getEtiqueta());
                    colores.put(arco.getVerticeDestino(), "A");

                    // Recursión
                    obtenerCicloHamiltoneano(g, arco.getVerticeDestino(), origen, ciclo);

                    // Backtrack
                    ciclo.removeVertice(arco.getVerticeDestino());
                    ciclo.costo -= (arco.getEtiqueta());
                    colores.put(arco.getVerticeDestino(), "B");
                }
            }
        }
    }










    /*
    private Grafo<String> grafo; // Cada vértice tiene el nombre de la ciudad
    private String mejorCiudad;
    private Integer mejorCosto;

    public Ejercicio1(Grafo<String> g) {
        this.grafo = g;
        this.mejorCiudad = null;
        this.mejorCosto = null;
    }

    public String encontrarMejorCiudad() {
        Iterator<String> ciudades = grafo.ObtenerVertices();

        for (String ciudad : ciudades) {
            MejorCaminoConPeso mccp = new MejorCaminoConPeso(grafo);
            List<String> mejorSolucion = mccp.encontrarMejorCamino(ciudad, ciudad);
            Integer mejorPeso = mccp.mejorPeso();

            if (mejorCiudad == null || (mejorCosto > mejorPeso) {
                mejorCiudad = mejorSolucion.gerFirst();
                mejorCosto = mejorPeso;
            }
        }

        return mejorCiudad;
    }*/
}
