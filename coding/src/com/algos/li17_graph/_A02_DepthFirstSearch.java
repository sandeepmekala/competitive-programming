package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import  com.algos.li30_model.GraphAdjLst;

public class _A02_DepthFirstSearch {

	public static void main(String[] args) {
		_A02_DepthFirstSearch obj = new _A02_DepthFirstSearch();
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
		obj.dfs(g.adj, visited, 0);
	}

	private void dfs(GraphAdjLst g, int start) {
		Stack<Integer> s = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();

		s.add(start);
		visited.add(start);
		while (!s.isEmpty()) {
			int node = s.pop();
			System.out.println(node);
			for (int neigh : g.adj.get(node)) {
				if (!visited.contains(neigh)) {
					visited.add(neigh);
					s.add(neigh);
				}
			}
		}
	}

	private void dfs(HashMap<Integer, ArrayList<Integer>> adj, HashSet<Integer> visited, int node) {
		visited.add(node);
		System.out.println(node);
		for(int neigh: adj.get(node)) {
			if(!visited.contains(neigh)) {
				dfs(adj, visited, neigh);
			}
		}
	}
}
