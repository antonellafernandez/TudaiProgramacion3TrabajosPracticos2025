package PrimerRecuperatorio28JUN2025;

/* Ejercicio 3
Un mapa muestra un continente dividido en varias regiones. El mapa se representa como un grafo no dirigido, donde
cada nodo representa una región y cada arista indica que dos regiones son adyacentes (comparten frontera).

El objetivo es asignar colores a las regiones de to do el mapa de forma tal que ninguna región adyacente tenga el
mismo color y se utilice la mínima cantidad posible de colores.

Implementar en JAVA el método Colorear especificado a continuación, que mediante backtracking determine cuál es
el mínimo número de colores necesario y devuelva una asignación válida de colores para todas las regiones.

public HashMap<int, int> colorear(Grafo g) // El método devuelve para cada vértice, el color asignado

a) Dibuje el árbol de exploración del algoritmo indicando qué decisiones se toman en cada paso y qué
información se lleva en los estados.
b) Escriba un algoritmo en JAVA que resuelva el problema mediante la técnica de Backtracking.
c) Describa cuál sería la estrategia de poda.

public class Ejercicio3 {
    private HashMap<Integer, Integer> solucion;

    public HashMap<Integer, Integer> colorear(Grafo g) {
        Iterator<Integer> verticesIt = g.obtenerVertices();
        List<Integer> vertices = new ArrayList<>(); // Paso los vértices a una Lista para poder usar index

        while (verticesIt.hasNext()) {
            vertices.add(verticesIt.next());
        }

        // Probar con 1 color, 2 colores, ..., hasta encontrar solución
        for (int m = 1; m <= vertices.size(); m++) {
            solucion = new HashMap<>();

            for (Integer v : vertices) {
                solucion.put(v, 0); // Inicializar sin color
            }

            // Siendo m la cantidad mínima de colores
            if (colorear(g, vertices, m, 0)) {
                System.out.println("Colores mínimos necesarios: " + m);
                return solucion;
            }
        }

        return new HashMap<>();
    }

    private boolean colorear(Grafo g, List<Integer> vertices, int m, int index) {
        // Condición Base: Todos los vértices han sido coloreados
        if (index == vertices.size()) {
            return true;
        }

        Integer verticeActual = vertices.get(index);

        for (int i = 0; i < m; i++) {
            if (esColorValido(g, verticeActual, i)) {
                // Intento de asignación
                solucion.put(verticeActual, i);

                // Recursión
                if (colorear(g, vertices, m, index + 1)) {
                    return true;
                }

                // Backtrack
                solucion.put(verticeActual, 0);
            }
        }

        return false;
    }

    private boolean esColorValido(Grafo g, Integer v, int color) {
        Iterator<Integer> vecinos = g.obtenerAdyacentes(v);

        while (vecinos.hasNext()) {
            Integer vecino = vecinos.next();
            if (solucion.containsKey(vecino) && solucion.get(vecino) == color) {
                return false; // Color en conflicto con un adyacente
            }
        }

        return true; // Color válido
    }
}
*/