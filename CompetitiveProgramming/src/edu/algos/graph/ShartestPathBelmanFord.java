package edu.algos.graph;

import java.util.Arrays;

import edu.ds.graph.model.Edge;
import edu.ds.graphs.Graph;

public class ShartestPathBelmanFord {

	public static void main(String[] args) {
		ShartestPathBelmanFord obj = new ShartestPathBelmanFord();
		Graph  g = new Graph(5, 7);
		g.edges[0] = new Edge(0, 1, 4);
		g.edges[1] = new Edge(0, 2, 5);
		g.edges[2] = new Edge(0, 3, 8);
		g.edges[3] = new Edge(1, 2, -3);
		g.edges[4] = new Edge(2, 4, 4);
		g.edges[5] = new Edge(3, 4, 2);
		g.edges[6] = new Edge(4, 3, 1);
		
		System.out.println(Arrays.toString(obj.shartedPath(g, 0)));;
		
	}
	
	// works with negative edges also
	// with one more additional iteration can detect negative weight cycle
	// time = O(V*E)
	// space = O(V)
	private int[] shartedPath(Graph g, int srcs) {
		int[] dist = new int[g.V];
		int[] parent = new int[g.V];
		
		for(int i=0; i<g.V; i++) {
			dist[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		
		dist[srcs] = 0;		
		for(int i=0; i<g.V-1; i++) {
			for(Edge edge : g.edges) {
				int src = edge.src;
				int dest = edge.dest;
				if(dist[dest] > dist[src]+edge.weight) {
					dist[dest] = dist[src]+edge.weight;
					parent[dest] = src;
				}
			}
		}
		System.out.println(Arrays.toString(parent));
		return dist;
	}
}
