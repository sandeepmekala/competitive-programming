package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class A11_ShortestPath_Dijkstras {

	public static void main(String[] args) {
		A11_ShortestPath_Dijkstras shortedpath = new A11_ShortestPath_Dijkstras();
		
		int[][][] edges = new int[][][]{{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
		HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
		for(int i=0; i<edges.length; i++){
			adj.put(i, new ArrayList<>());
			for(int[] edge: edges[i]){
				adj.get(i).add(edge);
			}
		}	
		
            
            int dist[] = shortedpath.dijkstra(adj, 2);
            System.out.println(Arrays.toString(dist));
	}

	// Idea: Same as prims algo except that instead of just check the edge weight we track cumulative sum from root
	// Use dist array to track distance each vertices
	// May be a parent array if you want to print path
	// Drawbacks: Won't work with negative edge cycles. Use Bellman Ford algo.
	//O(ElogV)
	public int[] dijkstra(HashMap<Integer, ArrayList<int[]>> adj, int src) {
		int n = adj.size();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((d1, d2)->d1[0]-d2[0]);
		int[] parent = new int[n];
		int[] dist = new int[n];
		for(int i=0; i<n; i++) {
			parent[i]=i; dist[i] = Integer.MAX_VALUE;
		}

		dist[src] = 0;
		pq.add(new int[]{0, src});	//{dist, node, parent}
		while(!pq.isEmpty()){
			int[] top = pq.remove();
			int dis = top[0], node = top[1];
			for (int neigh[]: adj.get(node)) {
				int neighNode = neigh[0], edgeWeight = neigh[1];
				if (dis + edgeWeight < dist[neighNode]) {	// visited is not needed as anyway this condition won't satisfy for already visited nodes
					dist[neighNode] = dis + edgeWeight;
					parent[neighNode] = node;
					pq.add(new int[]{dist[neighNode], neighNode});
				}
			}
		}

		// print parent
		// while(parent[node] != node)
		// node = parent[node];

		return dist;
	}

}
