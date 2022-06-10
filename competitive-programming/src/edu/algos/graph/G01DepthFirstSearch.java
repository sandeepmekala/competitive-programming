package edu.algos.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import edu.algos.model.GraphAdjLst;

public class G01DepthFirstSearch {

	public static void main(String[] args) {
		G01DepthFirstSearch obj = new G01DepthFirstSearch();
		GraphAdjLst g = new GraphAdjLst();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		obj.dfs(g, 0);
		System.out.println();
		
		HashSet<Integer> visited = new HashSet<Integer>();
		obj.dfsRec(g, visited, 0);
	}

	private void dfs(GraphAdjLst g, int start) {
		Stack<Integer> s = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();

		s.add(start);
		while (!s.isEmpty()) {
			int current = s.pop();
			if (!visited.contains(current)) {
				visited.add(current);
				System.out.println(current);

				for (int i = 0; i < g.adjList.get(current).size(); i++) {
					s.add(g.adjList.get(current).get(i));
				}
			}
		}
	}

	private void dfsRec(GraphAdjLst g, HashSet<Integer> visited, int src) {
		if(!visited.contains(src)) {
			visited.add(src);
			System.out.println(src);
			for(int child: g.adjList.get(src)) {
				dfsRec(g, visited, child);
			}
		}
	}
}
