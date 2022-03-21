package edu.algos.graph;

import java.util.Stack;

import edu.ds.graphs.GraphAdjLst;

public class DepthFirstSearch {

	public static void main(String[] args) {
		DepthFirstSearch obj = new DepthFirstSearch();
		GraphAdjLst g = new GraphAdjLst(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		obj.dfs(g, 0);
	}

	private void dfs(GraphAdjLst g, int startNode) {
		Stack<Integer> s = new Stack<Integer>();

		s.add(startNode);
		String path = "";
		while (!s.isEmpty()) {
			int currentNode = (int) s.pop();
			if (!g.visited[currentNode]) {
				path += " " + currentNode;

				for (int i = 0; i < g.adjList[currentNode].size(); i++) {
					s.add(g.adjList[currentNode].get(i));
				}
			}

			g.visited[currentNode] = true;
		}
		System.out.println(path);
	}

}
