package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _Mst_G01_PrimsMinimumSpanningTree {

	public static void main(String[] args) {
		_Mst_G01_PrimsMinimumSpanningTree obj = new _Mst_G01_PrimsMinimumSpanningTree();

		int n=3;
		int[][] edges = new int[][]{{0,1,5}, {1,2,3}, {0,2,1}};
		HashMap<Integer, ArrayList<int[]>> adj = new HashMap<Integer, ArrayList<int[]>>();
        for(int i=0; i<n; i++) 
			adj.put(i, new ArrayList<>());
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
	private int primsMst(int n, HashMap<Integer, ArrayList<int[]>> adj) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((d1, d2)->d1[0]-d2[0]);
		HashSet<Integer> visited = new HashSet<Integer>();
		//int[] parent = new int[n];
		int sum = 0;
		pq.add(new int[]{0, 0});
		while(!pq.isEmpty()) {
			int curr[] = pq.remove();
			int dis = curr[0], node = curr[1];
			if(visited.contains(node))
				continue;

			visited.add(node);
			sum += dis;			// track parent here for capturing mst. parent should come from q.
			for (int neigh[]: adj.get(node)) {
				int neighNode = neigh[0], edgeWeight = neigh[1];
				if(!visited.contains(neighNode))
					pq.add(new int[]{edgeWeight, neighNode});
			}
		}

		return sum;
	}

}
