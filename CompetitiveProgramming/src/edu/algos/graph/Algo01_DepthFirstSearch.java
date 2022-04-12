package edu.algos.graph;

import java.util.Stack;

import edu.ds.graphs.GraphAdjLst;

public class Algo01_DepthFirstSearch {

	public static void main(String[] args) {
		Algo01_DepthFirstSearch obj = new Algo01_DepthFirstSearch();
		GraphAdjLst g = new GraphAdjLst(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		obj.dfs(g, 0);
	}

	private void dfs(GraphAdjLst g, int start) {
		Stack<Integer> s = new Stack<Integer>();

		s.add(start);
		while (!s.isEmpty()) {
			int current = s.pop();
			if (!g.visited[current]) {
				g.visited[current] = true;
				System.out.println(current);
				for (int i = 0; i < g.adjList[current].size(); i++) {
					s.add(g.adjList[current].get(i));
				}
			}
		}
	}

}
