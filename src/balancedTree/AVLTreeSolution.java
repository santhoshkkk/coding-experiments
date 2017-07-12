package balancedTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AVLTreeSolution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node root = null;
		for (int i = 0; i < n; i++) {
			int num = s.nextInt();
			if (null == root) {
				root = Node.createNew(num);
			} else {
				root = Node.insert(root, num);
			}
		}
		System.out.println("In Order");
		Node.inorder(root);
		System.out.println("\nLevel Order");
		Node.lot(root);
		s.close();
	}

}

class Node {
	int val;
	Node left;
	Node right;
	int ht = 0;

	static Node insert(Node root, int val) {
		if (val < root.val) {
			if (null == root.left) {
				root.left = createNew(val);
			} else {
				root.left = insert(root.left, val);
			}
			if (computeBalanceFactor(root) == -2) {
				if (root.left.val > val) {
					root = leftSideRoatation(root);
				} else if (root.left.val < val) {
					root = leftSideDoubleRoatation(root);
				}
			}
		} else if (val > root.val) {
			if (null == root.right) {
				root.right = createNew(val);
			} else {
				root.right = insert(root.right, val);
			}
			if (computeBalanceFactor(root) == 2) {
				if (root.right.val < val) {
					root = rightSideRoatation(root);
				} else if (root.right.val > val) {
					root = rightSideDoubleRoatation(root);
				}
			}
		} else {
			// discard duplicate
		}
		updateHeight(root);
		return root;
	}

	static Node leftSideRoatation(Node n) {
		// System.out.println("leftSideRoatation @" + n.data);

		Node newRoot = n.left;
		n.left = newRoot.right;
		newRoot.right = n;
		updateHeight(n);
		updateHeight(newRoot);
		return newRoot;
	}

	static Node rightSideRoatation(Node n) {
		// System.out.println("rightSideRoatation @" + n.data);
		Node newRoot = n.right;
		n.right = newRoot.left;
		newRoot.left = n;
		updateHeight(n);
		updateHeight(newRoot);
		return newRoot;
	}

	static Node rightSideDoubleRoatation(Node n) {
		// System.out.println("rightSideDoubleRoatation @" + n.data);
		n.right = leftSideRoatation(n.right);
		return rightSideRoatation(n);
	}

	static Node leftSideDoubleRoatation(Node n) {
		// System.out.println("leftSideDoubleRoatation @" + n.data);
		n.left = rightSideRoatation(n.left);
		return leftSideRoatation(n);
	}

	static int computeBalanceFactor(Node n) {
		int leftHeight = null == n.left ? -1 : n.left.ht;
		int rightHeight = null == n.right ? -1 : n.right.ht;
		return rightHeight - leftHeight;
	}

	static void updateHeight(Node n) {
		n.ht = Math.max(null == n.left ? -1 : n.left.ht, null == n.right ? -1 : n.right.ht) + 1;
	}

	static Node createNew(int num) {
		Node root;
		root = new Node();
		root.val = num;
		return root;
	}

	public static void lot(Node n) {
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		while (!q.isEmpty()) {
			Node current = q.poll();
			System.out.print("[" + current.val + "," + current.ht + "],");
			if (null != current.left)
				q.add(current.left);
			if (null != current.right)
				q.add(current.right);
		}
	}

	public static void inorder(Node n) {
		if (null == n) {
			return;
		}
		inorder(n.left);
		System.out.print("[" + n.val + "," + n.ht + "],");
		inorder(n.right);
	}
}