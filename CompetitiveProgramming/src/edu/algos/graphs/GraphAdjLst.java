package edu.algos.graphs;

import java.util.LinkedList;

public class GraphAdjLst {
	public int V;
	public LinkedList<Integer> adjList[];
	public boolean visited[];

	public GraphAdjLst(int v) {
		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adjList[i] = new LinkedList();
		visited = new boolean[V];
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
	}

	public void print() {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.println(i + " -> " + adjList[i].get(j));
			}
		}
	}
}