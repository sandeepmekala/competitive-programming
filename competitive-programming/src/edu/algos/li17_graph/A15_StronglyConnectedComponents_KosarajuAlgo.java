package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import edu.algos.li00_model.GraphAdjLst;

public class A15_StronglyConnectedComponents_KosarajuAlgo {

	public static void main(String[] args) {
		A15_StronglyConnectedComponents_KosarajuAlgo obj = new A15_StronglyConnectedComponents_KosarajuAlgo();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 3);
		g.addEdge(6, 5);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(9, 6);
		g.addEdge(9, 10);

		List<HashSet<Integer>> components = obj.getStronglyConnectedComponents(g);
		System.out.println(components);
	}

    // Idea: DO dfs and populate the topological order stack. We do another dfs in this order.
    // Then reverse the egdes in the graph so that second dfs will not go out of strong connected component.
    // Do second dfs and store the vertices which form strong connected component when dfs ends.
	public List<HashSet<Integer>> getStronglyConnectedComponents(GraphAdjLst g) {
		List<HashSet<Integer>> components = new ArrayList<HashSet<Integer>>();
		Stack<Integer> resStack = new Stack<Integer>();
		Set<Integer> visited = new HashSet<>();
		for (int current: g.adj.keySet()) {
			if(!visited.contains(current)) {
				dfs(g, current, resStack, visited);   // dfs and populate resStack in reverse topological order
			}
		}
		
		g = reverGraph(g);  //reverse the graph edges
		
		visited = new HashSet<>();
		while(!resStack.isEmpty()) {
			int current = resStack.pop();
			HashSet<Integer> set = new HashSet<Integer>();
			if(!visited.contains(current)) {
				dfs2(g, current, set, visited); // dfs and populate tge component set.
				components.add(set);
			}
			
		}
		return components;
	}

	private GraphAdjLst reverGraph(GraphAdjLst g) {
		GraphAdjLst newG = new GraphAdjLst();
		for (int src: g.adj.keySet()) {
			for(int dest: g.adj.get(src)) {
				newG.addEdge(dest, src);
			}
		}
		return newG;
	}

	private void dfs(GraphAdjLst g, int current, Stack<Integer> resStack, Set<Integer> visited) {
		visited.add(current);
		for (int neigh: g.adj.get(current)) {
			if (!visited.contains(neigh)) {
				dfs(g, neigh, resStack, visited);
			}
		}
		resStack.add(current);
	}
	
	private void dfs2(GraphAdjLst g, int current, Set<Integer> set, Set<Integer> visited) {
		visited.add(current);
		set.add(current);
		for (int neigh: g.adj.get(current)) {
			if (!visited.contains(neigh)) {
				dfs2(g, neigh, set, visited);
			}
		}
	}
}
