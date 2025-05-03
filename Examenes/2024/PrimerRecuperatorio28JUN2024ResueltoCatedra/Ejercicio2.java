package PrimerRecuperatorio28JUN2024;

/* Ejercicio 2

Escriba enJAVA el código del método de la clase Tree (que representa árboles binarios) que tiene la siguiente declaración:

private Lista<T> obtenerNIvel(TreeNode<T> n, int k)

El método al ser invocado con el nodo raíz del árbol binario, debe retornar una lista con los elementos del nivel k
de dicho árbol en orden de derecha a izquierda. Si k es mayor a la altura del árbol deberá retornar una lista vacía.

Suponga que la clase Lista (simplemente vinculada) y TreeNode (nodo del árbol binario) tienen los métodos usuales. */

/*
public class Ejercicio2 {
    // Variantes: llevar otro int "nivel" inicializado en 0  que se va acumulando hasta k
    // llevar una lista por parámetro con un método void
    private static List<T> obtenerNivel(TreeNode<T> n, int k) {
        List<T> resultado = new LinkedList<T>();

        if (n != null) {
            if (k == 0) {
                resultado.add(n.getValue());
            } else {
                resultado.addAll(obtenerNivel(n.getRight()), k - 1);
                resultado.addAll(obtenerNivel(n.getLeft()), k - 1);
            }
        }

        return resultado;
    }
} */
