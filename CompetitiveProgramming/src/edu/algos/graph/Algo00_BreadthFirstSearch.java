package edu.algos.graph;

import java.util.LinkedList;
import java.util.Queue;

import edu.algos.graphs.GraphAdjLst;

public class Algo00_BreadthFirstSearch {

	public static void main(String[] args) {
		Algo00_BreadthFirstSearch obj = new Algo00_BreadthFirstSearch();
		GraphAdjLst g = new GraphAdjLst(4);

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

		q.add(start);
		while (!q.isEmpty()) {
			int current = q.remove();
			if (!g.visited[current]) {
				g.visited[current] = true;
				System.out.println(current);
				for (int i = 0; i < g.adjList[current].size(); i++) {
					q.add(g.adjList[current].get(i));
				}
			}
		}
	}
}
