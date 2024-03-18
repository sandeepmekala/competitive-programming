package  com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.List;

public class UnionFind_UnionFind {

	public static void main(String[] args) {

	}

	public List<Integer> rank = new ArrayList<>();
    public List<Integer> parent = new ArrayList<>();
    public List<Integer> size = new ArrayList<>();
    public void makeSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

	// Path Compression: If the path is long like linked list, when it find the parent of lowest leaf node, it sets the same as parent to all the above parent nodes while recursion exit
    public int find(int node) {
        if (node == parent.get(node)) 
            return node;
        
        int par = find(parent.get(node));
        parent.set(node, par);
        return par;
    }

	// Idea: Union by rank is similar to normal union except that we maintain
	// rank for each element starting 0.
	// increment the rank if you make a number as parent of another and ranks are same.
	// Make the number as parent if its rank is higher.
    public void unionByRank(int src, int dest) {
        int srcParent = find(src);
        int destParent = find(dest);
        if (srcParent == destParent) return;

        if (rank.get(srcParent) < rank.get(destParent)) {
            parent.set(srcParent, destParent);
        } else if (rank.get(destParent) < rank.get(srcParent)) {
            parent.set(destParent, srcParent);
        } else {
            parent.set(destParent, srcParent);
            rank.set(srcParent, rank.get(srcParent) + 1);
        }
    }

    public void unionBySize(int src, int dest) {
        int srcParent = find(src);
        int destParent = find(dest);
        if (srcParent == destParent) return;
        
        if (size.get(srcParent) < size.get(destParent)) {
            parent.set(srcParent, destParent);
            size.set(destParent, size.get(destParent) + size.get(srcParent));
        } else {
            parent.set(destParent, srcParent);
            size.set(srcParent, size.get(srcParent) + size.get(destParent));
        }
    }
}
