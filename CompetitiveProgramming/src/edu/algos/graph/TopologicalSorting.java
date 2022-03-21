package edu.algos.graph;

import java.util.LinkedList;
import java.util.Stack;

import edu.ds.graphs.Graph;
import edu.ds.graphs.GraphAdjLst;

public class TopologicalSorting {

	public static void main(String[] args) {
		TopologicalSorting obj = new TopologicalSorting();
		GraphAdjLst g = new GraphAdjLst(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		// Function Call
		Stack<Integer> stack = obj.topologicalSort(g);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	// in DAG, for edge (u, v), in topological sorting u comes first then v.
	// always starts from vertex whose indegree is 0
	// time O(V+E)
	// space O(V)
	public Stack<Integer> topologicalSort(GraphAdjLst g) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[g.V];
		for (int i = 0; i < g.V; i++) {
			if (visited[i] == false) {
				topologicalSortUtil(g, i, visited, stack);
			}
		}
		return stack;
	}

	private void topologicalSortUtil(GraphAdjLst g, int current, boolean[] visited, Stack<Integer> stack) {
		visited[current] = true;
		for (int i = 0; i < g.adjList[current].size(); i++) {
			int child = g.adjList[current].get(i);
			if (visited[child] == false) {
				topologicalSortUtil(g, child, visited, stack);
			}
		}
		stack.add(current);
	}

}