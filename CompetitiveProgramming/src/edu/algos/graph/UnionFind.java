package edu.algos.graph;

import edu.algos.graph.model.Subset;

public class UnionFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Subset[] subsets;
	public void makeSet(Graph g) {
		subsets = new Subset[g.V];
		for(int vertix : g.vertices) {
			subsets[vertix] = new Subset(vertix, vertix, 0);
		}
	}
	
	// path compression: when path is long like linked list, when it find the parent of lowest leaf node, it sets the same as parent to all the above parent nodes while recursion exit
	public int find(int current) {
		if(subsets[current].parent == current) {
			return current;
		}else {
			subsets[current].parent = find(subsets[current].parent);	//path compression
			return subsets[current].parent;
		}
	}
	
	// concept: union by rank is similar to normal union except that we maintain
	// rank for each element starting 0.
	// increment the rank if you make a number as parent of another and ranks are same.
	// Make the number as parent if it rank is higher.
	public void union(int srcParent, int destParent) {
		if(subsets[srcParent].rank > subsets[destParent].rank) {
			subsets[destParent].parent = srcParent;
		}else if(subsets[destParent].rank > subsets[srcParent].rank) {
			subsets[srcParent].parent = destParent;
		}else {
			subsets[destParent].parent = srcParent;
			subsets[srcParent].rank++;
		}
	}
}
