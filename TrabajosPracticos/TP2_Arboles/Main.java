package TP2_Arboles;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 2
        BinarySearchTree bst = new BinarySearchTree();

        // Insertar algunos valores en el árbol
        bst.insert(6);
        bst.insert(2);
        bst.insert(10);
        bst.insert(1);
        bst.insert(4);
        bst.insert(8);
        bst.insert(11);
        bst.insert(7);
        bst.insert(9);

        // Imprimir la suma de los nodos internos
        System.out.println("Suma de los nodos internos: " + bst.sumInternalNodes());

        System.out.println();

        // Ejercicio 3
        int k = 8;
        List<Integer> leaves = bst.findLeavesGreaterThanK(k);
        System.out.println("Valores de las hojas mayores que " + k + ": " + leaves);

        System.out.println();

        // Ejercicio 4
        // Crear la estructura del árbol
        TreeNodeInt root4 = new TreeNodeInt(null);

        root4.setLeft(new TreeNodeInt(null));
        root4.setRight(new TreeNodeInt(null));

        root4.getLeft().setLeft(new TreeNodeInt(14));
        root4.getLeft().setRight(new TreeNodeInt(null));

        root4.getLeft().getRight().setLeft(new TreeNodeInt(7));
        root4.getLeft().getRight().setRight(new TreeNodeInt(-5));

        root4.getRight().setLeft(new TreeNodeInt(null));
        root4.getRight().setRight(new TreeNodeInt(20));

        root4.getRight().getLeft().setRight(new TreeNodeInt(9));

        // Crear nuevo árbol
        BinaryTreeInt bti = new BinaryTreeInt(root4);

        // Rellenar árbol
        bti.fillNodes();

        // Imprimir árbol
        bti.printPreOrder();

        System.out.println();

        // Ejercicio 5
        // Crear la estructura del árbol
        TreeNodeChar root5 = new TreeNodeChar('M');

        root5.setLeft(new TreeNodeChar('A'));
        root5.setRight(new TreeNodeChar('I'));

        root5.getLeft().setLeft(new TreeNodeChar('L'));
        root5.getLeft().setRight(new TreeNodeChar('N'));

        root5.getLeft().getRight().setLeft(new TreeNodeChar('A'));
        root5.getLeft().getRight().setRight(new TreeNodeChar('O'));

        root5.getRight().setLeft(new TreeNodeChar('S'));
        root5.getRight().setRight(new TreeNodeChar('O'));

        root5.getRight().getLeft().setRight(new TreeNodeChar('A'));

        // Crear nuevo árbol
        BinaryTreeChar btc = new BinaryTreeChar(root5);

        // Definir N
        int N = 2;

        // Imprimir las palabras con N vocales
        System.out.println(btc.searchWordsWithNVowels(N));

        System.out.println();

        // Ejercicio 6
        // Crear nuevos libros
        Book book1 = new Book(123456, "Jorge Luis Borges", 1996, 2);
        book1.addGenero("Terror");

        Book book2 = new Book(123457, "Julio Cortázar", 1997, 3);
        book2.addGenero("Fantástico");
        book2.addGenero("Terror");

        Book book3 = new Book(123455, "Ernesto Sábato", 1995, 4);
        book3.addGenero("Fantástico");
        book3.addGenero("Ciencia Ficción");
        book3.addGenero("Terror");

        // Crear nuevo árbol
        BinarySearchTreeBook bstb = new BinarySearchTreeBook();

        // Añadir libros
        bstb.add(book1);
        bstb.add(book2);
        bstb.add(book3);

        // Obtener la cantidad de ejemplares de un libro dado su identificador único.
        int idBuscado = 123455;
        System.out.println("La cantidad de ejemplares del Libro con id " + idBuscado + " es " + bstb.obtenerCantEjemplares(idBuscado) + ".");

        // Obtener todos los libros de un género dado.
        String generoBuscado = "Ciencia Ficción";
        System.out.println(bstb.obtenerLibrosPorGenero(generoBuscado));

        // Obtener todos los libros publicados entre dos años de publicación dados.
        int anioPublicacion1 = 1990;
        int anioPublicacion2 = 2000;
        System.out.println(bstb.obtenerLibrosEntreAniosPublicacion(anioPublicacion1, anioPublicacion2));
    }
}
