package algo.search;

import java.util.Scanner;

public class IceCreamParlor {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			int m = s.nextInt();
			int n = s.nextInt();
			Tree tree = new Tree();
			for (int j = 0; j < n; j++) {
				tree.insert(s.nextInt(), j + 1);
			}
			tree.printPairs(m);
		}
		s.close();
	}

}

class Node {
	int index;
	int data;
	Node left;
	Node right;

	public String toString() {
		return new StringBuffer().append(index + ":" + data).toString();
	}
}

class Tree {
	Node root;

	boolean isEmpty() {
		return root == null;
	}

	void insert(int n, int index) {
		root = insert(root, n, index);
	}

	Node insert(Node nd, int n, int index) {
		if (null == nd) {
			nd = new Node();
			nd.data = n;
			nd.index = index;
			return nd;
		} else if (n >= nd.data) {
			nd.right = insert(nd.right, n, index);
		} else if (n < nd.data) {
			nd.left = insert(nd.left, n, index);
		}
		return nd;
	}

	void printPairs(int m) {
		inOrderAndSearch(root, m);
	}

	private boolean inOrderAndSearch(Node node, int m) {
		if (null == node) {
			return false;
		}
		int data = node.data;
		boolean pairFound = findPair(root, data, node.index, m);
		if (pairFound) {
			return true;
		} else {
			if (inOrderAndSearch(node.left, m)) {
				return true;
			} else {
				return inOrderAndSearch(node.right, m);
			}
		}
	}

	private boolean findPair(Node node, int data, int index, int m) {
		if (null == node) {
			return false;
		}
		int diff = m - data;
		if (diff == node.data && index != node.index) {
			if (index > node.index) {
				System.out.println(node.index + " " + index);
			} else {
				System.out.println(index + " " + node.index);
			}
			return true;
		} else if (diff < node.data) {
			return findPair(node.left, data, index, m);
		} else {
			return findPair(node.right, data, index, m);
		}
	}

}
