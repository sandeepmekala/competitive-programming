package edu.algos.li00_model;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphAdjLst {
	public HashMap<Integer, ArrayList<Integer>> adjList;

	public GraphAdjLst() {
		adjList = new HashMap<>();
	}

	public void addEdge(int v, int w) {
		if(!adjList.containsKey(v)) {
			adjList.put(v, new ArrayList<Integer>());
		}
		
		if(!adjList.containsKey(w)) {
			adjList.put(w, new ArrayList<Integer>());
		}
		
		adjList.get(v).add(w);
	}


	public void addEdge(Edge edge) {
		if(!adjList.containsKey(edge.src)) {
			adjList.put(edge.src, new ArrayList<Integer>());
		}
		
		if(!adjList.containsKey(edge.dest)) {
			adjList.put(edge.dest, new ArrayList<Integer>());
		}
		
		adjList.get(edge.src).add(edge.dest);
	}
	
	public void print() {
		for (Integer src: adjList.keySet()) {
			for (int j = 0; j < adjList.get(src).size(); j++) {
				System.out.println(src + " -> " + adjList.get(src).get(j));
			}
		}
	}
}