package TrabajosPracticos.TP2_Arboles;

public class TreeNodeChar {
    private Character value;
    private TreeNodeChar left;
    private TreeNodeChar right;

    public TreeNodeChar(Character value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNodeChar getLeft() {
        return left;
    }

    public void setLeft(TreeNodeChar left) {
        this.left = left;
    }

    public TreeNodeChar getRight() {
        return right;
    }

    public void setRight(TreeNodeChar right) {
        this.right = right;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }
}
