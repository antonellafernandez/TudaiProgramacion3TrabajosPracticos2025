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

public class MySimpleLinkedList<T> implements Iterable<T> {

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
        if (index == 0 && this.first != null) {
            return this.first.getInfo(); // Acceder al primer elemento en O(1)
        }

        return null; // Solo se puede acceder en O(1) al primer elemento
    }

    public int size() {
        return this.size;
    }

    // Ejercicio 3
    public int indexOf(T info) {
        int index = 0;
        Node<T> tmp = this.first;

        while (tmp != null) {
            if (tmp.getInfo().equals(info)) { // Comparar usando equals()
                return index;
            }
            tmp = tmp.getNext(); // Avanzar al siguiente nodo
            index++;
        }

        return -1; // Si no se encontró el elemento
    }

    @Override
    public String toString() {
        return "MySimpleLinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    // Implementar el iterador interno
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(this.first);
    }
}
