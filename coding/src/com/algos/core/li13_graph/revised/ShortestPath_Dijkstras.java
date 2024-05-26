package  com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath_Dijkstras {

	public static void main(String[] args) {
		ShortestPath_Dijkstras shortedpath = new ShortestPath_Dijkstras();
		
		int[][][] adj = new int[][][]{{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};
            
		int dist[] = shortedpath.dijkstra(adj, 2);
		System.out.println(Arrays.toString(dist));
	}

	// Idea: Same as prims algo except that instead of just check the edge weight we track cumulative sum from root
	// Use dist array to track distance each vertices
	// May be a parent array if you want to print path
	// Drawbacks: Won't work with negative edge cycles. Use Bellman Ford algo.
	//O(ElogV)
	public int[] dijkstra(int[][][] adj, int src) {
		int n = adj.length;
		
		Queue<int[]> pq = new PriorityQueue<>((d1, d2)->d1[0]-d2[0]);
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[src] = 0;
		pq.add(new int[]{0, src});	//{dist, node}
		while(!pq.isEmpty()){
			int[] curr = pq.remove();
			int dis = curr[0], node = curr[1];
			
			for (int nei[]: adj[node]) {
				int neiNode = nei[0], edgeWeight = nei[1];
				if (dis + edgeWeight < dist[neiNode]) {	// visited is not needed as anyway this condition won't satisfy for already visited nodes
					dist[neiNode] = dis + edgeWeight;
					pq.add(new int[]{dist[neiNode], neiNode});
				}
			}
		}
		return dist;
	}

	// print parent
	// node = dest
	// while(parent[node] != node)
	// 		node = parent[node]
}
