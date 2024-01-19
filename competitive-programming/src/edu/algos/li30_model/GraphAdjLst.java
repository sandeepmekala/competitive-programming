package edu.algos.li30_model;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphAdjLst {
	public HashMap<Integer, ArrayList<Integer>> adj;

	public GraphAdjLst() {
		adj = new HashMap<>();
	}

	public void addEdge(int v, int w) {
		if(!adj.containsKey(v)) {
			adj.put(v, new ArrayList<Integer>());
		}
		
		if(!adj.containsKey(w)) {
			adj.put(w, new ArrayList<Integer>());
		}
		
		adj.get(v).add(w);
	}


	public void addEdge(Edge edge) {
		if(!adj.containsKey(edge.src)) {
			adj.put(edge.src, new ArrayList<Integer>());
		}
		
		if(!adj.containsKey(edge.dest)) {
			adj.put(edge.dest, new ArrayList<Integer>());
		}
		
		adj.get(edge.src).add(edge.dest);
	}
	
	public void print() {
		for (Integer src: adj.keySet()) {
			for (int j = 0; j < adj.get(src).size(); j++) {
				System.out.println(src + " -> " + adj.get(src).get(j));
			}
		}
	}
}