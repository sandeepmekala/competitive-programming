package  com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Mst_PrimsMinimumSpanningTree {

	public static void main(String[] args) {
		Mst_PrimsMinimumSpanningTree obj = new Mst_PrimsMinimumSpanningTree();

		int n=3;
		int[][] edges = new int[][]{{0,1,5}, {1,2,3}, {0,2,1}};
		List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) 
			adj.add(new ArrayList<>());
        for(int[] edge: edges){
			adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
			adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

		int mstSum = obj.primsMst(3, adj);
		System.out.println(mstSum);

	}

	// Idea: Assign edge weight as value to each vertex and root vertex value is 0
	// start picking each min value vertex and adjust its adjacent vertices values 
	// Maintain vertices distances and its parents in respective arrays.
	// O(ElogE)
	public int primsMst(int n, List<List<int[]>> adj) {
		Queue<int[]> pq = new PriorityQueue<>((d1, d2)->d1[0]-d2[0]);
		int[] vis =  new int[n];

		int sum = 0;
		pq.add(new int[]{0, 0});
		while(!pq.isEmpty()) {
			int curr[] = pq.remove();
			int dis = curr[0], node = curr[1];
			
			if(vis[node] == 1)
				continue;

			vis[node] = 1;
			sum += dis;			// parent: track parent here for capturing mst. parent should come from q.
			for (int nei[]: adj.get(node)) {
				int neiNode = nei[0], edgeWeight = nei[1];
				if(vis[neiNode] != 1)
					pq.add(new int[]{edgeWeight, neiNode}); // ,paretnt if needed
			}
		}

		return sum;
	}

}
