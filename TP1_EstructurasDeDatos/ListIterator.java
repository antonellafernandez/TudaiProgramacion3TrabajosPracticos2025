private class MyListIterator<T> implements Iterator<T> {

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
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }

    public T get() {
        return this.cursor.getInfo();
    }
}
