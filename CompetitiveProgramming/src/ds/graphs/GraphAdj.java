package ds.graphs;

import java.util.LinkedList;

public class GraphAdj {
	public int V; // No. of vertices
	public LinkedList<Integer> adj[]; // Adjacency Lists
	public boolean visited[];

	public GraphAdj(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
		visited = new boolean[V];
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void print() {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				System.out.println(i + " -> " + adj[i].get(j));
			}
		}
	}
}