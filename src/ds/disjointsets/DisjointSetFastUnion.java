package ds.disjointsets;

import java.util.Arrays;

public class DisjointSetFastUnion {
    int[] roots;
    int[] rank;

    public DisjointSetFastUnion(int size) {
        roots = new int[size];
        for(int i=0; i<size; i++){
            roots[i]=i;
        }
        rank = new int[size];
    }

    public void union(int vertex1, int vertex2) {
        int vertex1Root = find(vertex1);
        int vertex2Root = find(vertex2);
        if (vertex1Root != vertex2Root) {
            roots[vertex2] = vertex1;
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


    public static void main(String[] args) {
        DisjointSetFastUnion ds = new DisjointSetFastUnion(10);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(1,2);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(2,4);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(4,1);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(4,9);
        System.out.println(Arrays.toString(ds.roots));
        ds.union(0,7);
        System.out.println(Arrays.toString(ds.roots));
        System.out.println(ds.find(4));
        System.out.println(ds.connected(9,1));
        System.out.println(ds.connected(9,7));
        System.out.println(ds.find(5));
    }
}
