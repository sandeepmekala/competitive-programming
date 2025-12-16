package li13_graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maxflow_FordFulkersonAndEdmonsKarpAlgo {

	public static void main(String[] args) {
		Maxflow_FordFulkersonAndEdmonsKarpAlgo ffek = new Maxflow_FordFulkersonAndEdmonsKarpAlgo();
		int[][] capacity = {
				{0, 3, 0, 3, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0},
                {3, 0, 0, 1, 2, 0, 0},
                {0, 0, 0, 0, 2, 6, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0}};
		System.out.println(ffek.maxFlow(capacity, 0, 6));
	}

	// Problem: Find the maximum that we can send from src to sink.
	// Idea:
	//	1. Do bfs to find an augmented path(a path from src -> sink)
	//	2. If bfs reaches sink, find the min flow from src to sink path which you found in bfs
	//	3. Substract min flow for each edge(in src -> dest path) in the path and add it to reverse edge(dest -> src)
	//	4. Add the min flow that you got above to max flow to track total flow
	// Time complexity: O(E*Num Of Aug Paths) = O(E*V/2*E) = O(VE^2)
	// Finding an augmented path takes O(E) time and we can have at most V/2 augmented paths.
	public int maxFlow(int[][] capacity, int src, int sink) {
		int n = capacity.length, totalMaxFlow = 0;
		int[] parent = new int[n];
		while(bsf(capacity,src,sink,parent)) {
			int currFlow = augmentPaths(capacity,src,sink,parent);
			totalMaxFlow += currFlow;
			parent = new int[n];
		}
		return totalMaxFlow;
	}

	private boolean bsf(int[][] capacity, int src, int sink, int[] parent) {
		int n = capacity.length;

		Queue<Integer> q = new LinkedList<>();
		int[] vis = new int[n];
		q.add(src);
		vis[src] = 1;
		while(!q.isEmpty()) {
			int node = q.remove();
			if(node == sink)
				return true;					//break out we found a path. no need to continue bfs.

			for(int nei=0; nei<n; nei++) {
				if(capacity[node][nei] > 0 && vis[nei] != 1) {
					vis[nei] = 1;
					q.add(nei);
					parent[nei] = node;
				}
			}
		}

		return false;
	}

	private int augmentPaths(int[][] capacity, int src, int sink, int[] parent) {
		int curr = sink;
		int minFlow = Integer.MAX_VALUE;
		while(curr != src) {				// find min of all edges in the path
			int currPar = parent[curr];
			if(capacity[currPar][curr] > 0) {
				minFlow = Math.min(minFlow, capacity[currPar][curr]);
				curr = currPar;
			}
		}

		curr = sink;
		while(curr != src) {
			int currPar = parent[curr];
			if(capacity[currPar][curr] > 0) {
				capacity[currPar][curr] = capacity[currPar][curr] - minFlow;
				capacity[curr][currPar] = minFlow;
				curr = currPar;
			}
		}

		return minFlow;
	}
}
