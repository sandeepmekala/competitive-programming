package  com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.List;

public class UnionFind_UnionFind {

	public static void main(String[] args) {
        UnionFind_UnionFind uf = new UnionFind_UnionFind();
        uf.makeSet(5);
        uf.unionByRank(1, 2);
        uf.unionByRank(2, 3);
        uf.unionByRank(4, 5);
        uf.unionByRank(3, 4);
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        System.out.println(uf.find(3));
        System.out.println(uf.find(4));

	}

	private int[] rank;
    private int[] parent;
    private int[] size;
    public void makeSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

	// Path Compression: If the path is long like linked list, when it find the parent of lowest leaf node, it sets the same as parent to all the above parent nodes while recursion exit
    public int find(int node) {
        if (node == parent[node]) 
            return node;
        
        return parent[node] = find(parent[node]);
    }

	// Idea: Union by rank is similar to normal union except that we maintain
	// rank for each element starting 0.
	// increment the rank if you make a number as parent of another and ranks are same.
	// Make the number as parent if its rank is higher.
    public void unionByRank(int src, int dest) {
        int srcPar = find(src);
        int destPar = find(dest);
        if (srcPar == destPar) return;

        if (rank[srcPar] < rank[destPar]) {
            parent[srcPar] = destPar;
        } else if (rank[destPar] < rank[srcPar]) {
            parent[destPar] = srcPar;
        } else {
            parent[destPar] = srcPar;
            rank[srcPar]++;
        }
    }

    public void unionBySize(int src, int dest) {
        int srcPar = find(src);
        int destPar = find(dest);
        if (srcPar == destPar) return;
        
        if (size[srcPar] < size[destPar]) {
            parent[srcPar] = destPar;
            size[destPar] += size[srcPar];
        } else {
            parent[destPar] = srcPar;
            size[srcPar] += size[destPar];
        }
    }
}
