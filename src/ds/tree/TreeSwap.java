package ds.tree;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/swap-nodes-algo?h_r=next-challenge&h_v=zen
 */

public class TreeSwap {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		Node[] treeNodesArray = new Node[N];

		// init tree
		Node root = new Node();
		root.data = 1;
		treeNodesArray[0] = root;
		Node current = null;
		for (int i = 0; i < N; i++) {
			current = treeNodesArray[i];

			int left = s.nextInt();
			int right = s.nextInt();
			if (-1 != left && null != current) {
				Node n = new Node();
				n.data = left;
				current.left = n;
				treeNodesArray[left - 1] = n;
			}

			if (-1 != right && null != current) {
				Node n = new Node();
				n.data = right;
				current.right = n;
				treeNodesArray[right - 1] = n;
			}
		}

		int swapInputs = s.nextInt();

		int K = -1;
		for (int i = 0; i < swapInputs; i++) {
			K = s.nextInt();
			swap(root, K, 1);
			inorder(root);
			System.out.println();
		}

		s.close();
	}

	private static void swap(Node root, int swapHeight, int nodeHeight) {
		if (null == root) {
			return;
		}
		if (swapHeight == 1 || nodeHeight % swapHeight == 0) {
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		swap(root.left, swapHeight, nodeHeight + 1);
		swap(root.right, swapHeight, nodeHeight + 1);
	}

	static void inorder(Node root) {
		if (null == root) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	static class Node {
		int data;
		Node left;
		Node right;
	}

}
