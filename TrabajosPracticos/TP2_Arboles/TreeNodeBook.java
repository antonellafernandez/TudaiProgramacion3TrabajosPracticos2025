package TrabajosPracticos.TP2_Arboles;

public class TreeNodeBook {
    private Book book;
    private TreeNodeBook left, right;

    public TreeNodeBook(Book book) {
        this.book = book;
        this.left = null;
        this.right = null;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public TreeNodeBook getLeft() {
        return left;
    }

    public void setLeft(TreeNodeBook left) {
        this.left = left;
    }

    public TreeNodeBook getRight() {
        return right;
    }

    public void setRight(TreeNodeBook right) {
        this.right = right;
    }
}
