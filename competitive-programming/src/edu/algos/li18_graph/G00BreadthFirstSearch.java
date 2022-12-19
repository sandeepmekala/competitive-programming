package edu.algos.li18_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import edu.algos.li00_model.GraphAdjLst;

public class G00BreadthFirstSearch {

	public static void main(String[] args) {
		G00BreadthFirstSearch obj = new G00BreadthFirstSearch();
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
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		
		q.add(start);
		while (!q.isEmpty()) {
			int current = q.remove();
			if (visited.get(current) == null) {
				visited.put(current, true);
				System.out.println(current);
				
				for (int i = 0; i < g.adjList.get(current).size(); i++) {
					q.add(g.adjList.get(current).get(i));
				}
			}
		}
	}
}
