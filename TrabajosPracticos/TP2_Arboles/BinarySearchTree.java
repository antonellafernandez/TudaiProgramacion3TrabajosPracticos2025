package TP2_Arboles;

/* Ejercicio 1
Implemente la estructura de Árbol Binario para búsquedas.

Métodos:
• Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List getElemAtLevel(int)

1. ¿Cuál es la complejidad de cada uno de estos métodos? */

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private TreeNodeInt root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Complejidad O(1), simplemente devuelve el valor de la raíz del árbol.
    public Integer getRoot() {
        if (this.root == null) {
            return null;
        }

        return this.root.getValue();
    }

    //  En el peor caso, la complejidad es O(h), donde h es la altura del árbol.
    //  En un árbol balanceado, esto sería O(log n), pero en un árbol desbalanceado podría ser O(n).
    public boolean hasElem(Integer value) {
        return hasElem(this.root, value);
    }

    private boolean hasElem(TreeNodeInt node, Integer value) {
        if (node == null) {
            return false;
        }

        if (node.getValue().equals(value)) {
            return true;
        }

        if (value < node.getValue()) {
            // Si el valor buscado es menor al valor del nodo actual, llamo recursivo al nodo izquierdo
            return hasElem(node.getLeft(), value);
        } else {
            // Si el valor buscado es mayor al valor del nodo actual, llamo recursivo al nodo derecho
            return hasElem(node.getRight(), value);
        }
    }

    // Complejidad O(1), simplemente verifica si la raíz es nula.
    public boolean isEmpty() {
        return this.root == null;
    }

    // En el peor caso, la complejidad es O(n).
    public void insert(Integer value) {
        if (this.root == null) {
            this.root = new TreeNodeInt(value);
        } else {
            insert(this.root, value);
        }
    }

    private void insert(TreeNodeInt node, Integer value) {
        if (node.getValue() > value) {
            // Si el valor a insertar es menor al valor del nodo actual,
            // se buscará insertarlo como nodo izquierdo si está vacío, si no
            // llamado recursivo a insertarlo por izquierda
            if (node.getLeft() == null) {
                TreeNodeInt temp = new TreeNodeInt(value);
                node.setLeft(temp);
            } else {
                insert(node.getLeft(), value);
            }
        } else if (node.getValue() < value) {
            // Si el valor a insertar es mayor al valor del nodo actual,
            // se buscará insertarlo como nodo derecho si está vacío, si no
            // llamado recursivo a insertarlo por derecha
            if (node.getRight() == null) {
                TreeNodeInt temp = new TreeNodeInt(value);
                node.setRight(temp);
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    // En el peor caso, la complejidad es O(n).
    public boolean delete(Integer value) {
        if (value != null) {
            this.root = delete(this.root, value);
            return true;
        }

        return false;
    }

    private TreeNodeInt delete(TreeNodeInt node, Integer value) {
        if (value < node.getValue()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            TreeNodeInt minValueNode = findMinValueNode(node.getRight());
            node.setValue(minValueNode.getValue());
            node.setRight(delete(node.getRight(), minValueNode.getValue()));
        }

        return node;
    }

    private TreeNodeInt findMinValueNode(TreeNodeInt node) {
        TreeNodeInt current = node;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(TreeNodeInt node) {
        if (node == null)
            return 0;
        else {
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public void printPosOrder() {
        printPosOrder(this.root);
        System.out.println();
    }

    private void printPosOrder(TreeNodeInt node) {
        if (node != null) {
            printPosOrder(node.getLeft());
            printPosOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public void printPreOrder() {
        printPreOrder(this.root);
        System.out.println();
    }

    private void printPreOrder(TreeNodeInt node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public void printInOrder() {
        printInOrder(this.root);
        System.out.println();
    }

    private void printInOrder(TreeNodeInt node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public List<Integer> getLongestBranch() {
        List<Integer> longestBranch = new ArrayList<>();
        List<Integer> currentBranch = new ArrayList<>();
        getLongestBranch(root, longestBranch, currentBranch, 0);
        return longestBranch;
    }

    private void getLongestBranch(TreeNodeInt node, List<Integer> longestBranch, List<Integer> currentBranch, int level) {
        if (node != null) {
            currentBranch.add(node.getValue());

            if (node.getLeft() == null && node.getRight() == null) {
                if (currentBranch.size() > longestBranch.size()) {
                    longestBranch.clear();
                    longestBranch.addAll(currentBranch);
                }
            } else {
                getLongestBranch(node.getLeft(), longestBranch, currentBranch, level + 1);
                getLongestBranch(node.getRight(), longestBranch, currentBranch, level + 1);
            }

            currentBranch.remove(currentBranch.size() - 1);
        }
    }

    // La complejidad es O(n), ya que recorre todos los nodos del árbol.
    public List<Integer> getFrontera() {
        List<Integer> frontera = new ArrayList<>();
        getFrontera(this.root, frontera);
        return frontera;
    }

    private void getFrontera(TreeNodeInt node, List<Integer> frontera) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                frontera.add(node.getValue());
            }

            getFrontera(node.getLeft(), frontera);
            getFrontera(node.getRight(), frontera);
        }
    }

    // La complejidad es O(h) en el peor caso, ya que desciende por la rama derecha del árbol hasta
    // llegar al nodo más a la derecha.
    public Integer getMaxElem() {
        if (this.root == null) {
            return null;
        }

        TreeNodeInt current = this.root;

        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current.getValue();
    }

    // En el peor de los casos, la complejidad es O(n), ya que recorre todos los nodos del árbol
    // hasta encontrar el nivel dado.
    public List<Integer> getElemAtLevel(int level) {
        List<Integer> elements = new ArrayList<>();
        getElemAtLevel(this.root, level, elements, 1);
        return elements;
    }

    private void getElemAtLevel(TreeNodeInt node, int level, List<Integer> elements, int currentLevel) {
        if (node != null) {
            if (currentLevel == level) {
                elements.add(node.getValue());
            } else {
                getElemAtLevel(node.getLeft(), level, elements, currentLevel + 1);
                getElemAtLevel(node.getRight(), level, elements, currentLevel + 1);
            }
        }
    }

    /* Ejercicio 2
    Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
    que retorne la suma de todos los nodos internos del árbol. */
    public int sumInternalNodes() {
        return sumInternalNodes(this.root);
    }

    private int sumInternalNodes(TreeNodeInt node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return 0;
        }

        return node.getValue() + sumInternalNodes(node.getLeft()) + sumInternalNodes(node.getRight());
    }

    /* Ejercicio 3
    Dado un árbol binario de búsqueda que almacena números enteros y un valor de entrada K, implementar un
    algoritmo que permita obtener un listado con los valores de todas las hojas cuyo valor supere K. Por ejemplo,
    para el árbol de la derecha, con un valor K = 8, el resultado debería ser [9, 11]. */
    public List<Integer> findLeavesGreaterThanK(int k) {
        List<Integer> result = new ArrayList<>();
        findLeavesGreaterThanK(this.root, k, result);
        return result;
    }

    private void findLeavesGreaterThanK(TreeNodeInt node, int k, List<Integer> result) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null && node.getValue() > k) {
                result.add(node.getValue());
            }

            findLeavesGreaterThanK(node.getLeft(), k, result);
            findLeavesGreaterThanK(node.getRight(), k, result);
        }
    }
}
