package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ShortestPath_G03_Dijkstras {

	public static void main(String[] args) {
		ShortestPath_G03_Dijkstras shortedpath = new ShortestPath_G03_Dijkstras();
		
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
		int[] dist = new int[n];
		for(int i=0; i<n; i++) 
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;
		pq.add(new int[]{0, src});	//{dist, node}
		while(!pq.isEmpty()){
			int[] curr = pq.remove();
			int dis = curr[0], node = curr[1];
			
			for (int neigh[]: adj.get(node)) {
				int neighNode = neigh[0], edgeWeight = neigh[1];
				if (dis + edgeWeight < dist[neighNode]) {	// visited is not needed as anyway this condition won't satisfy for already visited nodes
					dist[neighNode] = dis + edgeWeight;
					pq.add(new int[]{dist[neighNode], neighNode});
				}
			}
		}
		return dist;
	}

	// print parent
	// while(parent[node] != node)
	// 		node = parent[node];
}
