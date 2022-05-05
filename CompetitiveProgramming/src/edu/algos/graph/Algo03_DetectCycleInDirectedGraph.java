package edu.algos.graph;

import java.util.Stack;

class Algo03_DetectCycleInDirectedGraph {
	public static void main(String args[]) {
		Algo03_DetectCycleInDirectedGraph obj = new Algo03_DetectCycleInDirectedGraph();

		GraphAdjLst g = new GraphAdjLst(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Is cyclic: " + obj.isCyclic(g, 2));
	}

	// time complexity O(V+E)
	boolean isCyclic(GraphAdjLst g, int current) {
		boolean[] visited = new boolean[g.V];
		boolean[] inStack = new boolean[g.V];

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(current);
		inStack[current] = true;

		while (!stack.isEmpty()) {

			current = stack.pop();
			visited[current] = true;

			boolean noChildsToVisite = true;
			for (int i = 0; i < g.adjList[current].size(); i++) {
				Integer child = g.adjList[current].get(i);
				if (inStack[child] || current == child) {
					return true;
				}
				if (!visited[child]) {
					stack.push(child);

					inStack[child] = true;
					noChildsToVisite = false;
				}
			}
			if (noChildsToVisite) {
				inStack[current] = false;
			}
		}
		return false;
	}
}