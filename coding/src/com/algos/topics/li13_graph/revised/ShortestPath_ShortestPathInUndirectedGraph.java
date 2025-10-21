package  com.algos.topics.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algos.topics.models.GraphAdjLst;

public class ShortestPath_ShortestPathInUndirectedGraph {

	public static void main(String[] args) {
		ShortestPath_ShortestPathInUndirectedGraph obj = new ShortestPath_ShortestPathInUndirectedGraph();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(3);
		adj.get(3).add(0);
		adj.get(3).add(4);

		System.out.println(obj.shortedPathToDest(adj, 0, 4));

		int[] dist = obj.shortedPath(adj, 5, 0);
		System.out.println(Arrays.toString(dist));
	}

	// Idea: Do bfs and insert lengths also in queue.
	private int shortedPathToDest(List<List<Integer>> adj, int src, int dest) {
		int n = adj.size();

		Queue<int[]> queue = new LinkedList<>();
		int[] vis = new int[n];
		queue.add(new int[]{src, 0});
		vis[src] = 1;
		while(!queue.isEmpty()) {
			int[] curr = queue.remove();
			if(curr[0] == dest)
				return curr[1];

			for(int neigh: adj.get(curr[0])) {
				if(vis[neigh] == 0) {
					vis[neigh] = 1;
					queue.add(new int[]{neigh, curr[1]+1});
				}
			}
		}

		return -1;
	}

	// Problem: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/
	private int[] shortedPath(List<List<Integer>> adj, int n, int src) {
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[0] = 0;
		q.add(src);
		while(!q.isEmpty()) {
			int node = q.remove();
			for(int nei: adj.get(node)) {
				if(dist[node]+1 < dist[nei]) {
					dist[nei] = dist[node]+1;
					q.add(nei);
				}
			}
		}

		return dist;
	}

}
