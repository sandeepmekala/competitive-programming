package edu.algos.li18.graph;

import java.util.Arrays;
import java.util.HashSet;

public class G14PrimsMinimumSpanningTree {

	public static void main(String[] args) {
		G14PrimsMinimumSpanningTree obj = new G14PrimsMinimumSpanningTree();

		int[][] graph = new int[][] { 
			{ 0, 2, 0, 6, 0 }, 
			{ 2, 0, 3, 8, 5 }, 
			{ 0, 3, 0, 0, 7 }, 
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 } 
			};

		int[] parent = obj.primsMst(graph, 0);
		for (int v = 1; v < parent.length; v++) {
			System.out.println(parent[v] + "->" + v);
		}

	}

	// concept: assign edge weight as value to each vertex and root vertex value is 0
	// start picking each min value vertex and adjust its adjacent vertices key values 
	// O(V^2) as it loops over vertices twice
	private int[] primsMst(int[][] graph, int src) {
		int V = graph.length;
		HashSet<Integer> visited = new HashSet<Integer>();
		int[] dist = new int[V];
		int[] parent = new int[V];

		// assign all the key to max value and set visited value to false
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//set the root key value to 0 to pick that first
		dist[src] = 0;
		//each iteration picks one vertex and adjust its neighbor key values
		while(visited.size() < V) {
			int u = getMinDistNode(visited, dist);
			visited.add(u);
			for (int v = 0; v < V; v++) {
				if (graph[u][v] > 0 && !visited.contains(v) && graph[u][v] < dist[v] ) {
					dist[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		return parent;
	}

	private int getMinDistNode(HashSet<Integer> visited, int[] dist) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int v = 0; v < dist.length; v++) {
			if (!visited.contains(v)&& dist[v] < min) {
				min = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

}
