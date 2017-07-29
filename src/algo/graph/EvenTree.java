package algo.graph;

import java.util.Scanner;

public class EvenTree {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Graph g = new Graph(n);
		int v = s.nextInt();

		for (int i = 0; i < v; i++) {
			int n1 = s.nextInt();
			int n2 = s.nextInt();
			g.addEdge(n1-1, n2-1);
		}

		int count = countEvenSubTrees(g, 0)[0]-1;
		System.out.println(count);

		s.close();
	}

	private static int[] countEvenSubTrees(Graph g, int root) {
		int subTreeCounts = 0;
		int subTreeNodes = 0;
		for (int i = 0; i < g.size; i++) {
			if (1 == g.adj[root][i]) {
				int[] subTreeInfo = countEvenSubTrees(g, i);
				subTreeCounts += subTreeInfo[0];
				if (subTreeInfo[1] != 0) {
					subTreeNodes += subTreeInfo[1];
				}
			}
		}

		int[] data = new int[2];
		if (subTreeNodes % 2 == 1) {
			data[0] = subTreeCounts + 1;
			data[1] = 0;
		} else {
			data[0] = subTreeCounts;
			data[1] = subTreeNodes + 1;
		}

		return data;
	}

}

class Graph {
	int[][] adj;
	int size;

	public Graph(int n) {
		adj = new int[n][n];
		size = n;
	}

	public void addEdge(int i, int j) {
		adj[j][i] = 1;
	}
}