package ds.tree.binarysearchtree;

public class BinarySearchTree {
    private BinarySearchTreeNode root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(new BinarySearchTreeNode(50));
        bst.insert(new BinarySearchTreeNode(35));
        bst.insert(new BinarySearchTreeNode(75));
        bst.insert(new BinarySearchTreeNode(25));
        bst.insert(new BinarySearchTreeNode(45));
        bst.insert(new BinarySearchTreeNode(74));
        bst.insert(new BinarySearchTreeNode(72));
        bst.insert(new BinarySearchTreeNode(80));
        bst.insert(new BinarySearchTreeNode(100));
        bst.insert(new BinarySearchTreeNode(1));


        System.out.println(bst.inOrder());
        System.out.println(bst.preOrder());
        System.out.println(bst.postOrder());

        BinarySearchTreeNode searchResult = bst.search(35);
        System.out.println(searchResult == null ? "Not Found" : searchResult.getKey());
        System.out.println("Min: " + bst.min().getKey());
        System.out.println("Max: " + bst.max().getKey());
        System.out.println("Successor: " + bst.successor(bst.search(25)).getKey());
        System.out.println("Successor: " + bst.successor(bst.search(45)).getKey());
        bst.delete(bst.search(75));
        System.out.println(bst.inOrder());
    }


    public void insert(BinarySearchTreeNode node) {

        BinarySearchTreeNode candidateParent = null;
        BinarySearchTreeNode current = root;
        boolean duplicate = false;
        while (current != null) {
            candidateParent = current;
            if (node.getKey() < current.getKey()) {
                current = current.getLeft();
            } else if (node.getKey() > current.getKey()) {
                current = current.getRight();
            } else {
                duplicate = true;
            }
        }

        if (duplicate) {
            System.out.println("Key already exists " + node.getKey());
            return;
        } else if (null == candidateParent) {//root is empty
            root = node;
        } else if (node.getKey() < candidateParent.getKey()) {
            candidateParent.setLeft(node);
            node.setParent(candidateParent);
        } else {
            candidateParent.setRight(node);
            node.setParent(candidateParent);
        }
    }

    public String inOrder() {
        StringBuilder values = new StringBuilder("{");
        values = inOrder(root, values);
        values.append("}");
        return values.toString();

    }

    private StringBuilder inOrder(BinarySearchTreeNode node, StringBuilder values) {
        StringBuilder updatedValues = values;
        if (null == node) {
            return updatedValues;
        }
        updatedValues = inOrder(node.getLeft(), values);
        updatedValues.append(node.toString()).append(",");
        updatedValues = inOrder(node.getRight(), updatedValues);
        return updatedValues;
    }

    public String preOrder() {
        StringBuilder values = new StringBuilder("{");
        values = preOrder(root, values);
        values.append("}");
        return values.toString();
    }

    private StringBuilder preOrder(BinarySearchTreeNode node, StringBuilder values) {
        StringBuilder updatedValues = values;
        if (null == node) {
            return updatedValues;
        }
        updatedValues.append(node.toString()).append(",");
        preOrder(node.getLeft(), values);
        updatedValues = preOrder(node.getRight(), updatedValues);
        return updatedValues;
    }

    public String postOrder() {
        StringBuilder values = new StringBuilder("{");
        values = postOrder(root, values);
        values.append("}");
        return values.toString();

    }

    private StringBuilder postOrder(BinarySearchTreeNode node, StringBuilder values) {
        StringBuilder updatedValues = values;
        if (null == node) {
            return updatedValues;
        }

        postOrder(node.getLeft(), updatedValues);
        updatedValues = postOrder(node.getRight(), updatedValues);
        updatedValues.append(node.toString()).append(",");
        return updatedValues;
    }

    public BinarySearchTreeNode search(int key) {
        BinarySearchTreeNode node = root;
        while (node != null) {
            if (node.getKey() == key) {
                break;
            } else if (node.getKey() < key) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        return node;
    }

    public BinarySearchTreeNode min() {
        return min(root);
    }

    private BinarySearchTreeNode min(BinarySearchTreeNode root) {
        BinarySearchTreeNode min = root;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }

    public BinarySearchTreeNode max() {
        return max(root);
    }

    private BinarySearchTreeNode max(BinarySearchTreeNode root) {
        BinarySearchTreeNode max = root;
        while (max.getRight() != null) {
            max = max.getRight();
        }
        return max;
    }


    public BinarySearchTreeNode successor(BinarySearchTreeNode node) {
        BinarySearchTreeNode successor = null;

        if (node.getRight() != null) {
            successor = min(node.getRight());
        } else {
            BinarySearchTreeNode current = node;
            BinarySearchTreeNode parent = node.getParent();
            while (parent != null && parent.getRight() == current) {
                current = parent;
                parent = current.getParent();
            }
            successor = parent;
        }

        return successor;
    }

    public void delete(BinarySearchTreeNode node) {
        if (node.getLeft() == null) {
            transplant(node, node.getRight());
        } else if (node.getRight() == null) {
            transplant(node, node.getLeft());
        } else {
            BinarySearchTreeNode replacement = min(node.getRight());
            if (replacement.getParent() != node) {
                transplant(replacement, replacement.getRight());
            }
            transplant(node, replacement);
        }
    }

    private void transplant(BinarySearchTreeNode oldNode, BinarySearchTreeNode newNode) {
        BinarySearchTreeNode parent = oldNode.getParent();
        if (parent == null) {
            root = newNode;
        } else if (parent.getLeft() == oldNode) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        if (null != newNode) {
            newNode.setParent(oldNode.getParent());
        }
    }
}
