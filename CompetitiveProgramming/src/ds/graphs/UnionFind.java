package ds.graphs;

import algos.graph.model.Subset;

public class UnionFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int find(Subset[] subsets, int current) {
		if(subsets[current].parent == current) {
			return current;
		}else {
			subsets[current].parent = find(subsets, subsets[current].parent);	//path compression
			return subsets[current].parent;
		}
	}
	
	// concept: union by rank is similar to normal union except that we maintain
	// rank for each element starting 0.
	// increment the rank if you make a number as parent of another.
	// Make the number as parent if it rank is higher.
	public void union(Subset[] subsets, int srcParent, int destParent) {
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
