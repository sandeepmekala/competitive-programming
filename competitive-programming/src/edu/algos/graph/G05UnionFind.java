package edu.algos.graph;

import java.util.ArrayList;
import java.util.HashMap;

import edu.algos.model.Edge;
import edu.algos.model.GraphAdjLst;
import edu.algos.model.Subset;

public class G05UnionFind {

	public static void main(String[] args) {

	}

	HashMap<Integer, Subset> subsets;
	public void makeSet(GraphAdjLst g) {
		subsets = new HashMap<>();
		for(int vertix : g.adjList.keySet()) {
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
	
	// path compression: if the path is long like linked list, when it find the parent of lowest leaf node, it sets the same as parent to all the above parent nodes while recursion exit
	public int find(int current) {
		if(subsets.get(current).parent == current) {
			return current;
		}else {
			subsets.get(current).parent = find(subsets.get(current).parent);	//path compression
			return subsets.get(current).parent;
		}
	}
	
	// concept: union by rank is similar to normal union except that we maintain
	// rank for each element starting 0.
	// increment the rank if you make a number as parent of another and ranks are same.
	// Make the number as parent if it rank is higher.
	public void union(int srcParent, int destParent) {
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
