package TP1_EstructurasDeDatos;

/* • Ejercicio 1

Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (
void insertFront(T), T extractFront(), boolean isEmpty(), int size(),
String toString). Agregar también el método: T get(index).

• Ejercicio 2

Considerando la implementación de la lista vinculada realizada en el ejercicio anterior, comparar la
complejidad computacional contra un array en las siguientes operaciones:

1. Insertar al principio.
2. Buscar un elemento en una posición.
3. Determinar la cantidad de elementos.
4. Borrar un elemento de una posición determinada.

• Ejercicio 3

A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
elemento, o -1 si el elemento no existe en la lista.

• Ejercicio 4

A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la hora
de recorrer la lista de principio a fin si se cuenta con un iterador? */

import java.util.Iterator;
import java.util.Objects;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> first;
    private int size; // Para mantener registro del tamaño en O(1)

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, this.first);
        this.first = tmp;
        this.size++; // Incrementar tamaño
    }

    public void insertOrdered(T info) {
        Node<T> nuevo = new Node<T>(info, null);
        if (this.first == null || this.first.getInfo().compareTo(info) >= 0) {
            // Si la lista está vacía o el nuevo elemento es menor que el primero
            nuevo.setNext(this.first);
            this.first = nuevo;
        } else {
            Node<T> actual = this.first;
            Node<T> anterior = null;

            while (actual != null && actual.getInfo().compareTo(info) < 0) {
                anterior = actual;
                actual = actual.getNext();
            }

            nuevo.setNext(actual);
            anterior.setNext(nuevo);
        }

        this.size++; // Incrementar tamaño de la lista
    }

    public T extractFront() {
        if (this.first == null) {
            return null;
        }

        T info = this.first.getInfo();
        this.first = this.first.getNext();
        this.size--; // Decrementar tamaño
        return info;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<T> actual = this.first;

        for (int i = 0; i < index; i++) {
            actual = actual.getNext();
        }

        return actual.getInfo();

        /*
        if (index == 0 && this.first != null) {
            return this.first.getInfo(); // Acceder al primer elemento en O(1)
        }

        return null; // Solo se puede acceder en O(1) al primer elemento */
    }

    public int size() {
        return this.size;
    }

    // Ejercicio 3
    public int indexOf(T info) {
        int index = 0;
        Node<T> tmp = this.first;

        while (tmp != null) {
            if (Objects.equals(tmp.getInfo(), info)) { // Manejo seguro de null
                return index;
            }

            tmp = tmp.getNext(); // Avanzar al siguiente nodo
            index++;
        }

        return -1; // Si no se encontró el elemento
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> actual = this.first;
        while (actual != null) {
            sb.append(actual.getInfo());
            if (actual.getNext() != null) {
                sb.append(" -> ");
            }
            actual = actual.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    // Implementar el iterador interno
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(this.first);
    }
}
