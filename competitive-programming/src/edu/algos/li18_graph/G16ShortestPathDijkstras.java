package edu.algos.li18_graph;

import java.util.Arrays;
import java.util.HashSet;

public class G16ShortestPathDijkstras {

	public static void main(String[] args) {
		G16ShortestPathDijkstras shortedpath = new G16ShortestPathDijkstras();
		
		int graph[][] = new int[][] { 
			{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            
            int dist[] = shortedpath.dijkstra(graph, 0);
            shortedpath.print(dist);
	}

	private void print(int[] dist) {
		for(int v=0; v<dist.length; v++) {
			System.out.println(v+":"+dist[v]);
		}
	}

	//Idea: same as prims algo except that instead of just check the edge weight we track cumulative sum from root
	// use dist array to track distance each vertices
	// visited array to track explored vertices
	// may be a parent array if you want to print path
	// drawbacks: can't work with negative edge cycles. use Bellman Ford algo.
	//O(V^2)
	private int[] dijkstra(int[][] graph, int src) {
		int V = graph.length;
		HashSet<Integer> visited = new HashSet<Integer>();
		int[] dist = new int[V];

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		while(visited.size() < V){
			int u = getMin(visited, dist);
			visited.add(u);
			for (int v = 0; v < V; v++) {
				if (graph[u][v] > 0 && !visited.contains(v) && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		return dist;
	}

	private int getMin(HashSet<Integer> visited, int[] dist) {
		int minDist = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int v = 0; v < dist.length; v++) {
			if (!visited.contains(v) && dist[v] < minDist) {
				minDist = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

}
