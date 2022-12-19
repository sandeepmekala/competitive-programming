package edu.algos.li18_graph;

import java.util.ArrayList;
import java.util.Arrays;

import edu.algos.li00_model.Edge;

public class G19ShartestPathBellmanFord {

	public static void main(String[] args) {
		G19ShartestPathBellmanFord obj = new G19ShartestPathBellmanFord();

		int n = 5;
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 4));
		edges.add(new Edge(0, 2, 5));
		edges.add(new Edge(0, 3, 8));
		edges.add(new Edge(1, 2, -3));
		edges.add(new Edge(2, 4, 4));
		edges.add(new Edge(3, 4, 2));
		edges.add(new Edge(4, 3, 1));

		System.out.println(Arrays.toString(obj.shartedPath(n, edges, 0)));
	}

	// works with negative edges also
	// with one more additional iteration can detect negative weight cycle
	// time = O(V*E)
	// space = O(V)
	private int[] shartedPath(int n, ArrayList<Edge> edges, int source) {
		int[] dist = new int[n];
		int[] parent = new int[n];
			
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			parent[i] = i;
		}

		dist[source] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (Edge edge : edges) {
				int src = edge.src;
				int dest = edge.dest;
				if (dist[dest] > dist[src] + edge.weight) {
					dist[dest] = dist[src] + edge.weight;
					parent[dest] = src;
				}
			}
		}
		System.out.println(Arrays.toString(parent));
		return dist;
	}
}
