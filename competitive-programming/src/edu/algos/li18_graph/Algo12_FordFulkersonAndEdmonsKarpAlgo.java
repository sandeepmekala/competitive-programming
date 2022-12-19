package edu.algos.li18_graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Algo12_FordFulkersonAndEdmonsKarpAlgo {

	public static void main(String[] args) {
		Algo12_FordFulkersonAndEdmonsKarpAlgo ffek = new Algo12_FordFulkersonAndEdmonsKarpAlgo();
		int[][] g = {
				{0, 3, 0, 3, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0},
                {3, 0, 0, 1, 2, 0, 0},
                {0, 0, 0, 0, 2, 6, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0}};
		System.out.println(ffek.maxFlow(g, 0, 6));
	}

	// Idea: 
	//	1. do bfs to find an augmented path(a path from src -> sink)
	//	2. if bfs reaches sink, find the min flow from src to sink path which you found in bfs
	//	3. substract min flow for each edge(in src -> dest path) in the path and add it to reverse edge(dest -> src)
	//	4. add the min flow that you got above to max flow to track total flow
	// Time complexity: O(E*Num Of Aug Paths) = O(E*V/2*E) = O(VE^2)
	private int maxFlow(int[][] graph, int src, int sink) {
		int maxFlow = 0;
		int[] parent = new int[graph.length];
		while(bsf(graph,src,sink,parent)) {
			int flow = augmentPaths(graph,src,sink,parent);
			maxFlow += flow;
			parent = new int[graph.length];
		}
		return maxFlow;
	}
	private int augmentPaths(int[][] graph, int src, int sink, int[] parent) {
		int current = sink;
		int minFlow = Integer.MAX_VALUE;
		while(current != src) {
			int curParent = parent[current];
			if(graph[curParent][current] > 0) {
				minFlow = Math.min(minFlow, graph[curParent][current]);
				current = curParent;
			}
		}
		
		current = sink;
		while(current != src) {
			int curParent = parent[current];
			if(graph[curParent][current] > 0) {
				graph[curParent][current] = graph[curParent][current] - minFlow;
				graph[current][curParent] = minFlow;
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
						break;					//break out we found a path. no need to continue bfs.
					}
				}
			}
		}
		return augPathFound;
	}

}
