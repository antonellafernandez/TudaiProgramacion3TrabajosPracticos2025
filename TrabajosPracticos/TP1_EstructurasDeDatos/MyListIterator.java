package TP1_EstructurasDeDatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListIterator<T> implements Iterator<T> {

    private Node<T> cursor;

    public MyListIterator(Node<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
        if (cursor == null) {
            throw new NoSuchElementException();
        }

        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }

    public T get() {
        return this.cursor.getInfo();
    }
}
