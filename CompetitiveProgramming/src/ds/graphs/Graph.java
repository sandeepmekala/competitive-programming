package ds.graphs;

import algos.graph.model.Edge;

public class Graph {
	public int V, E;
	public int[] vertices;
	public Edge[] edges;
	public Graph(int v, int e) {
		this.E = e;
		this.V = v;
		this.vertices = new int[V];
		this.edges = new Edge[E];
	}
	
	public void addEdge(int u, int v) {
		edges[u] = new Edge(u, v);
	}
	
	void addEdge(int u, int v, int w) {
		edges[u] = new Edge(u, v, w);
	}
}