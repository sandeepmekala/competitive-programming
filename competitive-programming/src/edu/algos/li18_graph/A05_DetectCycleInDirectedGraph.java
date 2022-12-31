package edu.algos.li18_graph;

import java.util.HashSet;

import edu.algos.li00_model.GraphAdjLst;

class A05_DetectCycleInDirectedGraph {
	public static void main(String args[]) {
		A05_DetectCycleInDirectedGraph obj = new A05_DetectCycleInDirectedGraph();

		GraphAdjLst g = new GraphAdjLst();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Is cyclic: " + obj.isCyclic(g));
	}

	// time complexity O(V+E)
	private boolean isCyclic(GraphAdjLst g) {
		HashSet<Integer> visited = new HashSet<>();
		HashSet<Integer> exploring = new HashSet<>();

		for(int current: g.adjList.keySet()) {
			if(dfs(g, current, visited, exploring)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(GraphAdjLst g, int current, HashSet<Integer> visited, HashSet<Integer> exploring) {
		if(exploring.contains(current)) {
			return true;
		}
		if(!visited.contains(current)) {
			visited.add(current);
			exploring.add(current);
			for(int neigh: g.adjList.get(current)) {
				if(dfs(g, neigh, visited, exploring)) {
					return true;
				}
			}
			exploring.remove(current);
		}
		
		return false;
	}
}