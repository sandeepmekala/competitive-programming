package  com.algos.li17_graph;

import java.util.HashSet;

import  com.algos.li30_model.GraphAdjLst;

public class Dfs_L323_NumberOfConnectedComponentsInAnUndirectedGraph {

	public static void main(String[] args) {
		Dfs_L323_NumberOfConnectedComponentsInAnUndirectedGraph obj = new Dfs_L323_NumberOfConnectedComponentsInAnUndirectedGraph();
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
	
	// Problem: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
	// Companies: Amazon Facebook Google LinkedIn Microsoft Twitter,
	// Idea: Do dfs from all vertices. Once, dfs returns, count it as once CC.
	public int numberOfConnectedComponents(GraphAdjLst g) {
		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int src: g.adj.keySet()) {
			if(!visited.contains(src)) {
				dfs(g, src, visited);
				count++;
			}
		}
		return count++;
	}

	private void dfs(GraphAdjLst g, int src, HashSet<Integer> visited) {
		visited.add(src);
		for(int neigh: g.adj.get(src)) {
			if(!visited.contains(neigh)) {
				dfs(g, neigh, visited);
			}
		}
	}

}
