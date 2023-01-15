package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import edu.algos.li00_model.GraphAdjLst;

public class A10_ShortestPathInUndirectedGraph {

	public static void main(String[] args) {
		A10_ShortestPathInUndirectedGraph obj = new A10_ShortestPathInUndirectedGraph();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(2, 4);
		
		System.out.println(obj.shortedPath(g, 0, 4));

		int[] dist = obj.shortedPath(g.adj, 5, 0);
		System.out.println(Arrays.toString(dist));
	}

	// Idea: Do bfs and insert lengths also in queue.
	private int shortedPath(GraphAdjLst g, int src, int dest) {
		Queue<int[]> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		
		queue.add(new int[]{src, 0});
		visited.add(src);
		
		while(!queue.isEmpty()) {
			int[] current = queue.remove();
			if(current[0] == dest) {
				return current[1];
			}
			for(int neigh: g.adj.get(current[0])) {
				if(!visited.contains(neigh)) {
					visited.add(neigh);
					queue.add(new int[]{neigh, current[1]+1});
				}
			}
		}
		return -1;
	}

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
