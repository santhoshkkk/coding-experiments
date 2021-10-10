package ds.disjointsets;

import java.util.Arrays;

public class DisjointWithRank {
    int[] roots;
    int[] ranks;

    public DisjointWithRank(int size) {
        roots = new int[size];
        for (int i = 0; i < size; i++) {
            roots[i] = i;
        }
        ranks = new int[size];
    }

    public static void main(String[] args) {
        DisjointWithRank ds = new DisjointWithRank(10);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(Arrays.toString(ds.ranks));
        System.out.println();
        ds.union(1, 2);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(Arrays.toString(ds.ranks));
        System.out.println();
        ds.union(2, 4);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(Arrays.toString(ds.ranks));
        System.out.println();
        ds.union(4, 1);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(Arrays.toString(ds.ranks));
        System.out.println();
        ds.union(4, 9);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(Arrays.toString(ds.ranks));
        System.out.println();
        ds.union(0, 7);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(Arrays.toString(ds.ranks));
        ds.union(7, 6);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(Arrays.toString(ds.ranks));
        System.out.println();
        System.out.println(ds.find(4));
        System.out.println(ds.connected(9, 1));
        System.out.println(ds.connected(9, 7));
        System.out.println(ds.find(5));
    }

    public void union(int vertex1, int vertex2) {
        int vertex1Root = find(vertex1);
        int vertex2Root = find(vertex2);
        if (vertex1Root != vertex2Root) {
            if (ranks[vertex1] > ranks[vertex2]) {
                roots[vertex2] = vertex1Root;
            } else if (ranks[vertex1] < ranks[vertex2]) {
                roots[vertex1] = vertex2Root;
            } else {
                roots[vertex2] = vertex1Root;
                ranks[vertex1]++;
            }
        }
    }

    public int find(int vertex) {
        while (vertex != roots[vertex]) {
            vertex = roots[vertex];
        }
        return vertex;
    }

    public boolean connected(int vertex1, int vertex2) {
        return find(vertex1) == find(vertex2);
    }
}
