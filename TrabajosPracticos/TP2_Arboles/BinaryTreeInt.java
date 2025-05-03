package TrabajosPracticos.TP2_Arboles;

public class BinaryTreeInt {
    private TreeNodeInt root;

    public BinaryTreeInt(TreeNodeInt rootNode) {
        this.root = rootNode;
    }

    public BinaryTreeInt() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null) {
            this.root = new TreeNodeInt(value);
        } else {
            this.add(this.root, value);
        }
    }

    private void add(TreeNodeInt actual, Integer value) {
        if (actual.getLeft() == null) {
            actual.setLeft(new TreeNodeInt(value));
        } else if (actual.getRight() == null) {
            actual.setRight(new TreeNodeInt(value));
        }
    }

    /* Ejercicio 4
    Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras
    que las hojas tienen valores enteros. Se debe implementar un método que recorra el árbol y
    coloque valores en los nodos vacíos (los nodos internos). El valor de cada nodo interno debe
    ser igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que el
    nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0. Por ejemplo, tomando
    como entrada el árbol de la izquierda, el árbol resultante debería quedar con los mismos
    valores que el de la derecha. */

    public void fillNodes() {
        if (this.root != null) {
            fillNodes(this.root);
        }
    }

    private void fillNodes(TreeNodeInt node) {
        if (node.getValue() == null) {
            int leftValue = 0;
            int rightValue = 0;

            if (node.getLeft() != null) {
                fillNodes(node.getLeft());
                leftValue = node.getLeft().getValue();
            }

            if (node.getRight() != null) {
                fillNodes(node.getRight());
                rightValue = node.getRight().getValue();
            }

            node.setValue(rightValue - leftValue);
        }
    }

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
}
