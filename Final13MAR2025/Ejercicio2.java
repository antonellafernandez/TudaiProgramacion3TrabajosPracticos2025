package Final13MAR2025;

/* Ejercicio 2

Dado un grafo dirigido G(V,E), implementar un algoritmo en Java que determina si el mismo contiene, por lo menos, 2
ciclos donde no se compartan arcos entre ambos ciclos (si pueden compartir vértices).

public class Ejercicio2 {
    private List<Ciclo> solucion; // Ciclo guarda los vértices y arcos del mismo
    private HashMap<Integer, String> colores;

    public boolean buscarCiclos(Grafo g) {
        solucion = new ArayList<Ciclo>();
        colores = new HashMap<Integer, String>();

        Iterator<Integer> verticesIt = g.obtenerVertices();

        // Inicializar colores
        while (verticesIt.hasNext()) {
            Integer v = verticesIt.next();
            colores.put(v, "B");
        }

        verticesIt = g.obtenerVertices();

        while (verticesIt.hasNext()) {
            Integer v = verticesIt.next();
            List<Integer> recorrido = new ArrayList<Integer>();
            List<Arco> arcos = new ArrayList<Arco>();

            if (colores.get(v).equals("B")) {
                buscarCiclos(g, recorrido, arcos, v);
                if (solucion.size() >= 2) return true;
            }
        }

        return false;
    }

    private void buscarCiclos(Grafo g, List<Integer> recorrido, List<Arco> arcos, Integer v) {
        colores.put(v, "A");
        recorrido.add(v);
        Iterator<Integer> adyIt = g.obtenerAdyacentes(v);

        while (adyIt.hasNext()) {
            Integer w = adyIt.next();

            if (colores.get(w).equals("B")) {
                arcos.add(g.obtenerArco(v, w));
                buscarCiclos(g, recorrido, arcos, v);
            } else if (colores.get(w).equals("A")) { // Ciclo encontrado
                arcos.add(g.obtenerArco(v, w));

                if (esCicloValido(arcos)) {
                    solucion.add(new Ciclo(new ArrayList(recorrido), new ArrayList(arcos)));
                }

                arcos.remove(arcos.size() - 1);
            }
        }

        // Marcar como terminado
        colores.put(v, "N");
        recorrido.remove(recorrido.size() - 1);
    }

    private boolean esCicloValido(List<Arco> nuevo) {
        for (Ciclo cicloSol : solucion) {
            for (Arco a1 : nuevo) {
                for (Arco a2 : cicloSol.getArcos()) {
                    if (a1.equals(a2)) { // Redefinir el equals en Arco
                        return false;
                    }
                }
            }
        }
        return true;
    }
} */
