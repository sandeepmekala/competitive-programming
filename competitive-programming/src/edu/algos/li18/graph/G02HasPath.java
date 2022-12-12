package edu.algos.li18.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import edu.algos.li00_model.GraphAdjLst;

public class G02HasPath {

	public static void main(String[] args) {
		G02HasPath obj = new G02HasPath();
		GraphAdjLst g = new GraphAdjLst();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		System.out.println(obj.hasPathWithBfs(g, 0, 3));
		
		HashMap<Integer, Boolean> visited = new HashMap<>();
		System.out.println(obj.hasPathWithDfsRec(g, visited, 0, 3));
		
	}
	
	private boolean hasPathWithBfs(GraphAdjLst g, int src, int dest) {
		if(src == dest) {
			return true;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		HashMap<Integer, Boolean> visited = new HashMap<>();
		queue.add(src);
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			if(curr == dest) {
				return true;
			}
			if(visited.get(curr) == null) {
				visited.put(curr, true);
				for(int child: g.adjList.get(curr)) {
					queue.add(child);
				}
			}
		}
		
		return false;
	}

	private boolean hasPathWithDfsRec(GraphAdjLst g, HashMap<Integer, Boolean> visited, int src, int dest) {
		if(src == dest) {
			return true;
		}
		if(visited.get(src) == null) {
			visited.put(src, true);
			for(int child: g.adjList.get(src)) {
				if(hasPathWithDfsRec(g, visited, child, dest)) {
					return true;
				}
			}
		}
		return false;
	}
}
