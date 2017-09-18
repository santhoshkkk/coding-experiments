package ds.tree;

import java.util.Scanner;

public class LowestCommonAnscestorNode {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int n1Index = s.nextInt();
		int n2Index = s.nextInt();

		MyTree tree = new MyTree();
		int num1 = 0;
		int num2 = 0;

		int num;
		for (int i = 0; i < n; i++) {
			num = s.nextInt();
			if (i == n1Index) {
				num1 = num;
			}
			if (i == n2Index) {
				num2 = num;
			}
			tree.binarySearhInsert(num);
		}
		int lca = tree.lowestCommonAncestor(num1, num2);
		System.out.println(lca);
		s.close();
	}

}

class MyTreeNode {
	int val;
	MyTreeNode left;
	MyTreeNode right;

	public MyTreeNode(int val) {
		this.val = val;
	}
}

class MyTree {
	MyTreeNode root;

	public void binarySearhInsert(int val) {
		if (null == root) {
			root = new MyTreeNode(val);
		} else {
			binarySearchInsertInner(root, val);
		}
	}

	public int lowestCommonAncestor(int num1, int num2) {

		return 0;
	}

	private void binarySearchInsertInner(MyTreeNode root2, int val) {
		if (root2.val > val) {
			if (null == root2.left) {
				root2.left = new MyTreeNode(val);
			} else {
				binarySearchInsertInner(root2.left, val);
			}
		} else if (root2.val < val) {
			if (null == root2.right) {
				root2.right = new MyTreeNode(val);
			} else {
				binarySearchInsertInner(root2.right, val);
			}
		}
	}
}
