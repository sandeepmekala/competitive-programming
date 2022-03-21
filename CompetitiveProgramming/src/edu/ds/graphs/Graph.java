package edu.ds.graphs;

import edu.ds.graph.model.Edge;

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
}