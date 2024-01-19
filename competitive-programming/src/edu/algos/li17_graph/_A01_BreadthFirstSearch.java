package edu.algos.li17_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import edu.algos.li00_model.GraphAdjLst;

public class _A01_BreadthFirstSearch {

	public static void main(String[] args) {
		_A01_BreadthFirstSearch obj = new _A01_BreadthFirstSearch();
		GraphAdjLst g = new GraphAdjLst();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		obj.bfs(g, 0);
	}

	public void bfs(GraphAdjLst g, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		
		q.add(src);
		visited.add(src);
		while (!q.isEmpty()) {
			int node = q.remove();
			System.out.println(node);
			for (int neigh: g.adj.get(node)) {
				if (!visited.contains(neigh)) {
					visited.add(neigh);
					q.add(neigh);
				}
			}
		}
	}
}
