package ds.tree.binarysearchtree;

public class BinarySearchTreeNode {
    //It can be comparable
    private int key;
    private Object satelliteData;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;
    private BinarySearchTreeNode parent;


    public BinarySearchTreeNode(int key, Object satelliteData) {
        this.key = key;
        this.satelliteData = satelliteData;
    }

    public BinarySearchTreeNode(int key) {
        this(key, null);
    }

    public int getKey() {
        return key;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }

    public BinarySearchTreeNode getParent() {
        return parent;
    }

    public void setParent(BinarySearchTreeNode parent) {
        this.parent = parent;
    }

    public String toString(){
        return String.valueOf(key);
    }
}
