package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashMap;

import edu.algos.li00_model.Edge;
import edu.algos.li00_model.GraphAdjLst;
import edu.algos.li00_model.Subset;

public class A04_UnionFind {

	public static void main(String[] args) {

	}

	HashMap<Integer, Subset> subsets;
	public void makeSet(int n) {
		subsets = new HashMap<>();
		for(int i=0; i<n; i++) {
			subsets.put(i, new Subset(i, i, 0));
		}
	}

	public void makeSet(GraphAdjLst g) {
		subsets = new HashMap<>();
		for(int vertix : g.adj.keySet()) {
			subsets.put(vertix, new Subset(vertix, vertix, 0));
		}
	}
	
	public void makeSet(ArrayList<Edge> edges) {
		subsets = new HashMap<>();
		for( Edge edge : edges) {
			subsets.put(edge.src, new Subset(edge.src, edge.src, 0));
			subsets.put(edge.dest, new Subset(edge.dest, edge.dest, 0));
		}
	}

	public void makeSet(int[][] edges) {
		subsets = new HashMap<>();
		for( int[] edge : edges) {
			subsets.put(edge[0], new Subset(edge[0], edge[0], 0));
			subsets.put(edge[1], new Subset(edge[1], edge[1], 0));
		}
	}
	
	// Path Compression: If the path is long like linked list, when it find the parent of lowest leaf node, it sets the same as parent to all the above parent nodes while recursion exit
	public int find(int current) {
		if(subsets.get(current).parent == current) {
			return subsets.get(current).parent;
		}else {
			subsets.get(current).parent = find(subsets.get(current).parent);	//path compression
			return subsets.get(current).parent;
		}
	}
	
	// Idea: Union by rank is similar to normal union except that we maintain
	// rank for each element starting 0.
	// increment the rank if you make a number as parent of another and ranks are same.
	// Make the number as parent if it rank is higher.
	public void unionByRank(int src, int dest) {
		int srcParent = find(src), destParent = find(dest);
		if(subsets.get(srcParent).rank > subsets.get(destParent).rank) {
			subsets.get(destParent).parent = srcParent;
		}else if(subsets.get(destParent).rank > subsets.get(srcParent).rank) {
			subsets.get(srcParent).parent = destParent;
		}else {
			subsets.get(destParent).parent = srcParent;
			subsets.get(srcParent).rank++;
		}
	}

}
