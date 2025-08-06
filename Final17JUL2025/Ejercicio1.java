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
    public String mejorCiudad(Grafo g){
        Iterator<String> ciudades = g.obtenerVertices();
        String mejorCiudad = null;
        Integer mejorCosto = null; // Menor costo

        while (ciudades.hasNext()) {
            String origen = ciudades.next();
            int[] distancias = g.dijkstra(origen);
            int costoActual = 0;

            Iterator<String> destinos = g.obtenerVertices();

            while (destinos.hasNext()) {
                String destino = destinos.next();

                if (!origen.equals(destino)) {
                    // Costo de ir y volver
                    costoActual += 2 * distancias[destino];
                }
            }

            if (costoActual < mejorCosto || mejorCosto == null) {
                mejorCiudad = origen;
                mejorCosto = costoActual;
            }
        }
        
        return mejorCiudad;
    }
}
