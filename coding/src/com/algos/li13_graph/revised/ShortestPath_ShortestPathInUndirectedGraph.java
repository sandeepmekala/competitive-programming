package  com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import  com.algos.li30_model.GraphAdjLst;

public class ShortestPath_ShortestPathInUndirectedGraph {

	public static void main(String[] args) {
		ShortestPath_ShortestPathInUndirectedGraph obj = new ShortestPath_ShortestPathInUndirectedGraph();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 0);
		g.addEdge(3, 4);
		
		System.out.println(obj.shortedPath(g, 0, 4));

		int[] dist = obj.shortedPath(g.adj, 5, 0);
		System.out.println(Arrays.toString(dist));
	}

	// Idea: Do bfs and insert lengths also in queue.
	private int shortedPath(GraphAdjLst g, int src, int dest) {
		int n = g.adj.size();

		Queue<int[]> queue = new LinkedList<>();
		int[] vis = new int[n];
		queue.add(new int[]{src, 0});
		vis[src] = 1;
		while(!queue.isEmpty()) {
			int[] curr = queue.remove();
			if(curr[0] == dest) 
				return curr[1];
			
			for(int neigh: g.adj.get(curr[0])) {
				if(vis[neigh] == 0) {
					vis[neigh] = 1;
					queue.add(new int[]{neigh, curr[1]+1});
				}
			}
		}
		return -1;
	}

	// Problem: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/
	private int[] shortedPath(HashMap<Integer, ArrayList<Integer>> adj, int n, int src) {
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[0] = 0;
		q.add(src);
		while(!q.isEmpty()) {
			int node = q.remove();
			for(int neigh: adj.get(node)) {
				if(dist[node]+1 < dist[neigh]) {
					dist[neigh] = dist[node]+1;
					q.add(neigh);
				}
			}
		}

		return dist;
	}

}
