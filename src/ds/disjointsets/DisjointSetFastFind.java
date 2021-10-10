package ds.disjointsets;

import java.util.Arrays;

public class DisjointSetFastFind {
    int[] roots;

    public DisjointSetFastFind(int size) {
        roots = new int[size];
        for (int i = 0; i < size; i++) {
            roots[i] = i;
        }
    }

    public static void main(String[] args) {
        DisjointSetFastFind ds = new DisjointSetFastFind(10);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(1, 2);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(2, 4);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(4, 1);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(4, 9);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(0, 7);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(7, 8);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(ds.find(4));
        System.out.println(ds.connected(9, 1));
        System.out.println(ds.connected(9, 7));
        System.out.println(ds.find(5));
        System.out.println(ds.find(8));
    }

    public void union(int vertex1, int vertex2) {
        int vertex1Root = find(vertex1);
        int vertex2Root = find(vertex2);
        if (vertex1Root != vertex2Root) {
            roots[vertex2] = vertex1Root;
        }
    }

    public int find(int vertex) {

        return roots[vertex];
    }

    public boolean connected(int vertex1, int vertex2) {
        return find(vertex1) == find(vertex2);
    }
}
