package Final17JUL2025;

/* Ejercicio 2
Implemente en JAVA un algoritmo que dado 2 árboles binarios de
búsqueda determine si ambos tienen la misma estructura. Por estructura
nos referimos a la misma configuración de nodos sin importar el valor de
los mismos.

public class Ejercicio2 {
    private Node root1;
    private Node root2;

    public Ejercicio2(Node root1, Node root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    public boolean mismaEstructura() {
        return mismaEstructura(root1, root2);
    }

    private boolean mismaEstructura(Node actual1, Node actual2) {
        // Ambos null, misma estructura
        if (actual1 == null && actual2 == null) {
            return true;
        }

        // Diferentes
        if (actual1 == null || actual2 == null) {
            return false;
        }

        // Recursión
        return mismaEstructura(actual1.getLeft(), actual2.getLeft()) &&
               mismaEstructura(actual1.getRight(), actual2.getRight());
    }
} */
