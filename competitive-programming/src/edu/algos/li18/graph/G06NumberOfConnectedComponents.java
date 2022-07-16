package edu.algos.li18.graph;

import java.util.HashSet;

import edu.algos.li00.model.GraphAdjLst;

public class G06NumberOfConnectedComponents {

	public static void main(String[] args) {
		G06NumberOfConnectedComponents obj = new G06NumberOfConnectedComponents();
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
		
		System.out.println(obj.numberOfConnectedComponents(graph));
		
	}
	
	private int numberOfConnectedComponents(GraphAdjLst g) {
		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int src: g.adjList.keySet()) {
			if(dfs(g, src, visited)) {
				count++;
			}
		}
		return count++;
	}

	private boolean dfs(GraphAdjLst g, int src, HashSet<Integer> visited) {
		if(visited.contains(src)) {
			return false;
		}
		
		visited.add(src);
		for(int child: g.adjList.get(src)) {
			dfs(g, child, visited);
		}
		return true;
	}

}
