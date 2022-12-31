package edu.algos.li18_graph;

import java.util.Arrays;
import java.util.HashSet;

public class A08_PrimsMinimumSpanningTree {

	public static void main(String[] args) {
		A08_PrimsMinimumSpanningTree obj = new A08_PrimsMinimumSpanningTree();

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

	// Idea: Assign edge weight as value to each vertex and root vertex value is 0
	// start picking each min value vertex and adjust its adjacent vertices values 
	// Maintain vertices distances and its parents in respective arrays.
	// O(V^2) as it loops over vertices twice
	private int[] primsMst(int[][] graph, int src) {
		int V = graph.length;
		HashSet<Integer> visited = new HashSet<Integer>();
		int[] dist = new int[V];
		int[] parent = new int[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);	// assign all the key to max value
		dist[src] = 0;					//set the root key value to 0 to pick that first
		while(visited.size() < V) {		//each iteration picks one vertex and adjust its neighbor key values
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
