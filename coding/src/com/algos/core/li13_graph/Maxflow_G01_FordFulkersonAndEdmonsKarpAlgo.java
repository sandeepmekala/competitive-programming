package  com.algos.core.li13_graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maxflow_G01_FordFulkersonAndEdmonsKarpAlgo {

	public static void main(String[] args) {
		Maxflow_G01_FordFulkersonAndEdmonsKarpAlgo ffek = new Maxflow_G01_FordFulkersonAndEdmonsKarpAlgo();
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
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[capacity.length];
		queue.add(src);
		visited[src] = true;
		while(!queue.isEmpty()) {
			int currNode = queue.remove();
			if(currNode == sink) 
				return true;					//break out we found a path. no need to continue bfs.
			
			for(int adjNode=0; adjNode<capacity[currNode].length; adjNode++) {
				if(capacity[currNode][adjNode] > 0 && !visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
					parent[adjNode] = currNode;
				}
			}
		}

		return false;
	}

	private int augmentPaths(int[][] graph, int src, int sink, int[] parent) {
		int current = sink;
		int minFlow = Integer.MAX_VALUE;
		while(current != src) {				// find min of all edges in the path
			int currParent = parent[current];
			if(graph[currParent][current] > 0) {
				minFlow = Math.min(minFlow, graph[currParent][current]);
				current = currParent;
			}
		}
		
		current = sink;
		while(current != src) {
			int currParent = parent[current];
			if(graph[currParent][current] > 0) {
				graph[currParent][current] = graph[currParent][current] - minFlow;
				graph[current][currParent] = minFlow;
				current = currParent;
			}
		}
		return minFlow;
	}
}
