package algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ShortestPath {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < q; i++) {
			int n = s.nextInt();
			int e = s.nextInt();
			UnDirectionalGraph graph = new UnDirectionalGraph(n, 6);
			for (int j = 0; j < e; j++) {
				graph.addEdge(s.nextInt() - 1, s.nextInt() - 1);
			}
			int startNode = s.nextInt();
			int[] shortestPaths = graph.generateShortestPaths(startNode - 1);
			boolean first = true;
			for (int k = 0; k < n; k++) {
				if (0 != shortestPaths[k]) {
					if (!first) {
						sb.append(" ");
					} else {
						first = false;
					}
					sb.append(shortestPaths[k]);
				}
			}
			System.out.println(sb.toString());
			sb.setLength(0);
		}

		s.close();
	}

}

class UnDirectionalGraph {
	int size;
	Set<Integer>[] adj;
	int edgeWeight = 6;

	public UnDirectionalGraph(int n, int edgeWeight) {
		size = n;
		edgeWeight = 6;
		adj = new Set[n];
	}

	public int[] generateShortestPaths(int startNode) {
		int[] shortestPaths = new int[size];
		if (null == adj[startNode]) {
			Arrays.fill(shortestPaths, -1);
			shortestPaths[startNode] = 0;
			return shortestPaths;
		}
		Set<Integer> shortPathTree = new HashSet<>();
		Set<Integer> computedVertextNotInSpt = new HashSet<>();

		Set<Integer> remainingNodes = initializeRemaingConnectedNodesAndUpdateUnConnectedPaths(shortestPaths,
				startNode);

		shortestPaths[startNode] = 0;
		shortPathTree.add(startNode);
		for (int n : adj[startNode]) {
			shortestPaths[n] = 6;
			computedVertextNotInSpt.add(n);
		}
		remainingNodes.remove(startNode);

		while (remainingNodes.size() > 0) {
			List<Integer> minNodes = getMins(shortestPaths, computedVertextNotInSpt);
			if (minNodes.isEmpty()) {
				for (int n : remainingNodes) {
					shortestPaths[n] = -1;
				}
				remainingNodes.clear();
			} else {
				for (int minNode : minNodes) {
					shortPathTree.add(minNode);
					if (null != adj[minNode]) {
						for (int n : adj[minNode]) {
							if (!shortPathTree.contains(n) && !minNodes.contains(n)) {
								shortestPaths[n] = shortestPaths[minNode] + 6;
								computedVertextNotInSpt.add(n);
							}
						}
					}
					remainingNodes.remove(minNode);
					computedVertextNotInSpt.remove(minNode);
				}
			}
		}

		return shortestPaths;
	}

	private List<Integer> getMins(int[] shortestPaths, Set<Integer> computedVertextNotInSpt) {
		List<Integer> mins = new ArrayList<Integer>();
		int minShortestPath = Integer.MAX_VALUE;
		for (int n : computedVertextNotInSpt) {
			if (shortestPaths[n] < minShortestPath) {
				mins.clear();
				mins.add(n);
				minShortestPath = shortestPaths[n];
			} else if (shortestPaths[n] == minShortestPath) {
				mins.add(n);
			}
		}
		return mins;
	}

	private Set<Integer> initializeRemaingConnectedNodesAndUpdateUnConnectedPaths(int[] shortestPaths, int startNode) {
		Set<Integer> remN = new HashSet<>();
		for (int i = 0; i < size; i++) {
			if (i != startNode) {
				if (null != adj[i]) {
					remN.add(i);
					shortestPaths[i] = Integer.MAX_VALUE;
				} else {
					shortestPaths[i] = -1;
				}
			}
		}
		return remN;
	}

	public void addEdge(int n1, int n2) {
		addOneDedge(n1, n2);
		addOneDedge(n2, n1);
	}

	private void addOneDedge(int n1, int n2) {
		Set<Integer> n1Adjs = adj[n1];
		if (null == n1Adjs) {
			n1Adjs = new HashSet<Integer>();
			adj[n1] = n1Adjs;
		}
		n1Adjs.add(n2);
	}
}
