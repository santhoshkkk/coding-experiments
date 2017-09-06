package algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class KruskalMST {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner s = new Scanner(System.in);

		int nodeCount = s.nextInt();
		UndirectedWeightedGraph graph = new UndirectedWeightedGraph(nodeCount);

		int edgeCount = s.nextInt();
		for (int i = 0; i < edgeCount; i++) {
			int src = s.nextInt() - 1;
			int dest = s.nextInt() - 1;
			int weight = s.nextInt();
			graph.addEdge(src, dest, weight);
		}

		System.out.println(graph.minSpanTreeWeight());

		s.close();
	}

}

class Edge {
	int src;
	int dest;
	int weight;

	public Edge(int s, int d, int w) {
		src = s;
		dest = d;
		weight = w;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dest;
		result = prime * result + src;
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (dest != other.dest)
			return false;
		if (src != other.src)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return src + "," + dest + "," + weight;
	}

}

class EdgeComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		int diff = o1.weight - o2.weight;
		return 0 != diff ? diff : (o1.src + o1.dest + o1.weight) - (o2.src + o2.dest + o2.weight);
	}

}

class UndirectedWeightedGraph {
	int V;
	List<Edge> edges;

	public UndirectedWeightedGraph(int v) {
		V = v;
		edges = new ArrayList<>();
	}

	public int minSpanTreeWeight() {
		int totalWeight = 0;
		Collections.sort(edges, new EdgeComparator());
		Set<Edge> minSpanTree = new HashSet<>();
		int verts = 0;
		for (Edge edge : edges) {
			minSpanTree.add(edge);
			if (isCycle(minSpanTree)) {
				minSpanTree.remove(edge);
			} else {
				verts++;
				totalWeight += edge.weight;
				if (verts == V) {
					break;
				}
			}
		}
		return totalWeight;
	}

	public int find(int[] parent, int node) {
		if (parent[node] == -1) {
			return node;
		}
		return find(parent, parent[node]);
	}

	public void union(int[] parent, int src, int dest) {
		int srcSet = find(parent, src);
		int destSet = find(parent, dest);
		parent[srcSet] = destSet;
	}

	private boolean isCycle(Set<Edge> tree) {
		boolean cycle = false;
		int[] parent = new int[V];
		Arrays.fill(parent, -1);

		for (Edge edg : tree) {
			int srcSet = find(parent, edg.src);
			int destSet = find(parent, edg.dest);
			if (srcSet == destSet) {
				cycle = true;
				break;
			}
			union(parent, srcSet, destSet);
		}
		return cycle;

	}

	public void addEdge(int s, int d, int w) {
		Edge e = new Edge(s, d, w);
		edges.add(e);
	}
}
