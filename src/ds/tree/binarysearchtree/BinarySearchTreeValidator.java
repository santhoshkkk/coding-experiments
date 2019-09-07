package ds.tree.binarysearchtree;

public class BinarySearchTreeValidator {
    public static void main(String[] args) {
        BinarySearchTreeNode fifty = new BinarySearchTreeNode(50);
        BinarySearchTreeNode thirty = new BinarySearchTreeNode(30);
        BinarySearchTreeNode forty = new BinarySearchTreeNode(40);
        BinarySearchTreeNode thirtyFive = new BinarySearchTreeNode(35);
        BinarySearchTreeNode fortyFive = new BinarySearchTreeNode(45);
        BinarySearchTreeNode twenty = new BinarySearchTreeNode(20);
        BinarySearchTreeNode sixty = new BinarySearchTreeNode(60);
        BinarySearchTreeNode fiftyFive = new BinarySearchTreeNode(55);
        BinarySearchTreeNode sixtyFive = new BinarySearchTreeNode(65);
        BinarySearchTreeNode hundred = new BinarySearchTreeNode(100);

        fifty.setLeft(forty);
        fifty.setRight(sixtyFive);
        forty.setRight(fortyFive);
        forty.setLeft(thirtyFive);
        thirtyFive.setLeft(thirty);
        thirty.setLeft(twenty);
        sixtyFive.setLeft(fiftyFive);
        fiftyFive.setRight(sixty);
        sixtyFive.setRight(hundred);

        System.out.println(isBST(fifty, null, null));


    }

    private static boolean isBST(BinarySearchTreeNode root, Integer lowerLimit, Integer upperLimit) {
        if (null != lowerLimit && root.getKey() < lowerLimit) {
            return false;
        }
        if (null != upperLimit && root.getKey() > upperLimit) {
            return false;
        }

        boolean isLeftBst = true;
        if (null != root.getLeft()) {
            isLeftBst = isBST(root.getLeft(), lowerLimit, root.getKey());
        }

        boolean isRightBst = true;
        if (isLeftBst && null != root.getRight()) {
            isRightBst = isBST(root.getRight(), root.getKey(), upperLimit);
        }
        return isLeftBst && isRightBst;
    }


}
