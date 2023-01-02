package edu.algos.li17_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import edu.algos.li00_model.GraphAdjLst;

public class A01_BreadthFirstSearch {

	public static void main(String[] args) {
		A01_BreadthFirstSearch obj = new A01_BreadthFirstSearch();
		GraphAdjLst g = new GraphAdjLst();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		obj.bfs(g, 0);
	}

	public void bfs(GraphAdjLst g, int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		
		q.add(start);
		while (!q.isEmpty()) {
			int current = q.remove();
			if (!visited.contains(current)) {
				visited.add(current);
				System.out.println(current);
				for (int child: g.adjList.get(current)) {
					q.add(child);
				}
			}
		}
	}
}
