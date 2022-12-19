package edu.algos.li18_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import edu.algos.li00_model.GraphAdjLst;
import edu.algos.li00_model.Pair;

public class G08ShortestPath {

	public static void main(String[] args) {
		G08ShortestPath obj = new G08ShortestPath();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(2, 4);
		
		System.out.println(obj.shortedPath(g, 0, 4));
	}

	private int shortedPath(GraphAdjLst g, int src, int dest) {
		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		
		queue.add(new Pair<Integer, Integer>(src, 0));
		while(!queue.isEmpty()) {
			Pair<Integer, Integer> current = queue.remove();
			if(!visited.contains(current.getKey())) {
				visited.add(current.getKey());
				if(current.getKey() == dest) {
					return current.getValue();
				}
				
				for(int child: g.adjList.get(current.getKey())) {
					queue.add(new Pair<Integer, Integer>(child, current.getValue()+1));
				}
			}
		}
		return -1;
	}

}
