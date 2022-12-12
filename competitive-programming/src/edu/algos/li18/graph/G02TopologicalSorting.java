package edu.algos.li18.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import edu.algos.li00_model.GraphAdjLst;

public class G02TopologicalSorting {

	public static void main(String[] args) {
		G02TopologicalSorting obj = new G02TopologicalSorting();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		Stack<Integer> stack = obj.topologicalSort(g);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	// concept: in DAG, for edge (u, v), in topological sorting u comes first then
	// v.
	// always starts from vertex whose indegree is 0
	// time O(V+E)
	// space O(V)
	public Stack<Integer> topologicalSort(GraphAdjLst g) {
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<>();
		for (int src : g.adjList.keySet()) {
			dfs(g, src, visited, stack);
		}
		return stack;
	}

	private void dfs(GraphAdjLst g, int current, HashSet<Integer> visited, Stack<Integer> stack) {
		if (!visited.contains(current)) {
			visited.add(current);
			for (int child : g.adjList.get(current)) {
				dfs(g, child, visited, stack);
			}
			stack.add(current);
		}
	}

}