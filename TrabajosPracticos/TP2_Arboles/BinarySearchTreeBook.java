package TP2_Arboles;

import java.util.ArrayList;
import java.util.List;

/* Ejercicio 6
Se desea desarrollar una aplicación para mejorar la atención de una biblioteca en cuanto a la
búsqueda de libros dentro del catálogo disponible. Cada libro estará compuesto por un
identificador único y datos propios de los libros (título, autor, géneros, año de publicación,
cantidad de ejemplares, etc.)
Se sabe, además, que los libros nuevos se agregan al catálogo en horarios fuera de la atención al público.

Se desean proveer los siguientes servicios:
    • Obtener la cantidad de ejemplares de un libro dado su identificador único.
    • Obtener todos los libros de un género dado.
    • Obtener todos los libros publicados entre dos años de publicación dados.

Responda y justifique:
    1) ¿Qué estructura de datos utilizaría para almacenar todos los libros en memoria dentro
    de la aplicación?

    2) ¿Cómo resolvería cada uno de los servicios solicitados? ¿Utilizaría alguna estructura
    adicional de acceso para mejorar el costo de respuesta de cada servicio. */

public class BinarySearchTreeBook {
    private TreeNodeBook root;

    public BinarySearchTreeBook(TreeNodeBook rootNode) {
        this.root = rootNode;
    }

    public BinarySearchTreeBook() {
        this.root = null;
    }

    public void add(Book book) {
        if (this.root == null) {
            this.root = new TreeNodeBook(book);
        } else {
            this.add(this.root, book);
        }
    }

    private void add(TreeNodeBook node, Book book) {
        if (node.getBook().getId() > book.getId()) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNodeBook(book));
            } else {
                add(node.getLeft(), book);
            }
        } else if (node.getBook().getId() < book.getId()) {
            if (node.getRight() == null) {
                node.setRight(new TreeNodeBook(book));
            } else {
                add(node.getRight(), book);
            }
        }
    }

    // Obtener la cantidad de ejemplares de un libro dado su identificador único.
    public int obtenerCantEjemplares(long id) {
        if (this.root != null) {
            return obtenerCantEjemplares(this.root, id);
        }

        return 0;
    }

    private int obtenerCantEjemplares(TreeNodeBook node, long id) {
        if (node.getBook() != null) {
            if (node.getBook().getId() > id) {
                return obtenerCantEjemplares(node.getLeft(), id);
            } else if (node.getBook().getId() < id) {
                return obtenerCantEjemplares(node.getRight(), id);
            } else {
                return node.getBook().getCantEjemplares();
            }
        }

        return 0;
    }

    // Obtener todos los libros de un género dado.
    public List<Book> obtenerLibrosPorGenero(String generoBuscado) {
        List<Book> resultado = new ArrayList<>();

        if (this.root != null) {
            obtenerLibrosPorGenero(this.root, resultado, generoBuscado);
        }

        return resultado;
    }

    private void obtenerLibrosPorGenero(TreeNodeBook node, List<Book> resultado, String generoBuscado) {
        if (node != null && node.getBook() != null) {
            if (node.getBook().getGeneros().contains(generoBuscado.toUpperCase())) {
                resultado.add(node.getBook());
            }

            obtenerLibrosPorGenero(node.getLeft(), resultado, generoBuscado);
            obtenerLibrosPorGenero(node.getRight(), resultado, generoBuscado);
        }
    }

    // Obtener todos los libros publicados entre dos años de publicación dados.
    public List<Book> obtenerLibrosEntreAniosPublicacion(int anioPublicacion1, int anioPublicacion2) {
        List<Book> resultado = new ArrayList<>();

        if (this.root != null) {
            obtenerLibrosEntreAniosPublicacion(this.root, resultado, anioPublicacion1, anioPublicacion2);
        }

        return resultado;
    }

    private void obtenerLibrosEntreAniosPublicacion(TreeNodeBook node, List<Book> resultado, int anioPublicacion1, int anioPublicacion2) {
        if (node != null && node.getBook() != null) {
            if ((node.getBook().getAnioPublicacion() >= anioPublicacion1) && (node.getBook().getAnioPublicacion() <= anioPublicacion2)) {
                resultado.add(node.getBook());
            }

            obtenerLibrosEntreAniosPublicacion(node.getLeft(), resultado, anioPublicacion1, anioPublicacion2);
            obtenerLibrosEntreAniosPublicacion(node.getRight(), resultado, anioPublicacion1, anioPublicacion2);
        }
    }
}
