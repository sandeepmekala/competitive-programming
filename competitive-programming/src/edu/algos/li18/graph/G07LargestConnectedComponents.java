package edu.algos.li18.graph;

import java.util.HashSet;

import edu.algos.li00_model.GraphAdjLst;

public class G07LargestConnectedComponents {

	public static void main(String[] args) {
		G07LargestConnectedComponents obj = new G07LargestConnectedComponents();
		GraphAdjLst graph = new GraphAdjLst();
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(4, 6);
		graph.addEdge(6, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 5);
		graph.addEdge(7, 6);
		graph.addEdge(6, 7);
		graph.addEdge(8, 6);
		graph.addEdge(6, 8);
		graph.addEdge(3, 3);
		
		System.out.println(obj.largestConnectedComponents(graph));
		
	}
	
	private int largestConnectedComponents(GraphAdjLst g) {
		int max = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int src: g.adjList.keySet()) {
			max = Math.max(max, dfs(g, src, visited));
		}
		return max;
	}

	private int dfs(GraphAdjLst g, int src, HashSet<Integer> visited) {
		if(visited.contains(src)) {
			return 0;
		}
		
		visited.add(src);
		int count = 1;
		for(int child: g.adjList.get(src)) {
			count += dfs(g, child, visited);
		}
		return count;
	}

}
