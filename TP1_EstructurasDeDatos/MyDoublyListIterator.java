package TP1_EstructurasDeDatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyListIterator<T> implements Iterator<T> {
    private NodeDouble<T> cursor;

    public MyDoublyListIterator(NodeDouble<T> start) {
        this.cursor = start;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T info = cursor.getInfo();
        cursor = cursor.getNext();
        return info;
    }

    public boolean hasPrevious() {
        return cursor != null && cursor.getPrev() != null;
    }

    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }

        cursor = cursor.getPrev();
        return cursor.getInfo();
    }

    public T get() {
        if (cursor == null) {
            throw new NoSuchElementException();
        }
        return cursor.getInfo();
    }
}
