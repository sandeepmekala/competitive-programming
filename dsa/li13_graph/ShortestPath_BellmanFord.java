package li13_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.algos.topics.models.Edge;

public class ShortestPath_BellmanFord {

	public static void main(String[] args) {
		ShortestPath_BellmanFord obj = new ShortestPath_BellmanFord();

		int n = 5;
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(4, 3, 1));
		edges.add(new Edge(0, 1, 4));
		edges.add(new Edge(0, 2, 5));
		edges.add(new Edge(0, 3, 8));
		edges.add(new Edge(1, 2, -3));
		edges.add(new Edge(2, 4, 4));
		edges.add(new Edge(3, 4, 2));

		System.out.println(Arrays.toString(obj.shartedPath(n, edges, 0)));
	}

	// Idea: Loop n-1 times and relax all edges. In worst case the graph
	// can be linear and in each iteration we might relax only one edge. Hence, n-1
	// times relaxation needed.
	// Works with negative edges also unlike Dijkstra
	// With one more additional iteration can detect negative weight cycle. You will
	// see dist array getting updated.
	// Time = O(V*E)
	// Space = O(V)
	public int[] shartedPath(int n, List<Edge> edges, int src) {
		int[] dist = new int[n];
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			parent[i] = i;
		}

		dist[src] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (Edge edge : edges) {
				int u = edge.src;
				int v = edge.dest;
				if (dist[u] == Integer.MAX_VALUE)
					continue;

				if (dist[u] + edge.weight < dist[v]) {
					dist[v] = dist[u] + edge.weight;
					parent[v] = u;
				}
			}
		}

		return dist;
	}
}
