package TP2_Arboles;

public class TreeNodeInt {
    private Integer value;
    private TreeNodeInt left;
    private TreeNodeInt right;

    public TreeNodeInt(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNodeInt getLeft() {
        return left;
    }

    public void setLeft(TreeNodeInt left) {
        this.left = left;
    }

    public TreeNodeInt getRight() {
        return right;
    }

    public void setRight(TreeNodeInt right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
