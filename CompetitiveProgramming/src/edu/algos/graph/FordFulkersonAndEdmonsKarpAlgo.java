package edu.algos.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class FordFulkersonAndEdmonsKarpAlgo {

	public static void main(String[] args) {
		FordFulkersonAndEdmonsKarpAlgo ffek = new FordFulkersonAndEdmonsKarpAlgo();
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

	// Concept: 
	//	1. do bfs
	//	2. if bfs reaches sink, find the min flow from src to sink
	//	3. substract capacity(min flow) for each edge(src -> dest) in the path and add it to reverse edge(dest -> src)
	//	4. add all the flows to get the max flow
	// Time complexity: O(E*Num Of Aug Paths) = O(E*V/2*E) = O(VE^2)
	private int maxFlow(int[][] capacity, int src, int sink) {
		int maxFlow = 0;
		int[] parent = new int[capacity.length];
		while(bsf(capacity,src,sink,parent)) {
			int flow = augmentPaths(capacity,src,sink,parent);
			maxFlow += flow;
			parent = new int[capacity.length];
		}
		return maxFlow;
	}
	private int augmentPaths(int[][] capacity, int src, int sink, int[] parent) {
		int current = sink;
		int minFlow = Integer.MAX_VALUE;
		while(current != src) {
			int curParent = parent[current];
			if(capacity[curParent][current] > 0) {
				minFlow = Math.min(minFlow, capacity[curParent][current]);
				current = curParent;
			}
		}
		current = sink;
		while(current != src) {
			int curParent = parent[current];
			if(capacity[curParent][current] > 0) {
				capacity[curParent][current] = capacity[curParent][current] - minFlow;
				capacity[current][curParent] = minFlow;
				current = curParent;
			}
		}
		return minFlow;
	}
	private boolean bsf(int[][] capacity, int src, int sink, int[] parent) {
		boolean augPathFound = false;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[capacity.length];
		
		queue.add(src);
		while(!queue.isEmpty()) {
			int current = queue.remove();
			visited[current] = true;
			for(int j=0; j<capacity[current].length; j++) {
				if(capacity[current][j] > 0 && !visited[j]) {
					queue.add(j);
					parent[j] = current;
					
					if(j == sink) {
						augPathFound = true;
					}
				}
			}
		}
		return augPathFound;
	}

}
