package edu.algos.li18.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import edu.algos.li00.model.GraphAdjLst;

public class Algo11_StronglyConnectedComponentsKosarajuAlgo {

	public static void main(String[] args) {
		Algo11_StronglyConnectedComponentsKosarajuAlgo obj = new Algo11_StronglyConnectedComponentsKosarajuAlgo();
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

	private List<HashSet<Integer>> getStronglyConnectedComponents(GraphAdjLst g) {
		List<HashSet<Integer>> components = new ArrayList<HashSet<Integer>>();
		Stack<Integer> resStack = new Stack<Integer>();
		boolean[] visited = new boolean[g.V];
		
		// do dfs
		for (int i = 0; i < g.V; i++) {
			if(!visited[i]) {
				dfs(g, i, resStack, visited);
			}
		}
		
		//reverse
		g = reverGraph(g);
		
		visited = new boolean[g.V];
		while(!resStack.isEmpty()) {
			int current = resStack.pop();
			HashSet<Integer> set = new HashSet<Integer>();
			if(!visited[current]) {
				dfs2(g, current, set, visited);
				components.add(set);
			}
			
		}
		return components;
	}

	private GraphAdjLst reverGraph(GraphAdjLst g) {
		GraphAdjLst newG = new GraphAdjLst(g.V);
		for (int i = 0; i < g.V; i++) {
			for(int j=0; j<g.adjList[i].size(); j++) {
				newG.addEdge(g.adjList[i].get(j), i);
			}
		}
		return newG;
	}

	private void dfs(GraphAdjLst g, int current, Stack<Integer> resStack, boolean[] visited) {
		visited[current] = true;
		for (int i = 0; i < g.adjList[current].size(); i++) {
			if (!visited[g.adjList[current].get(i)]) {
				dfs(g, g.adjList[current].get(i), resStack, visited);
			}
		}
		resStack.add(current);
	}
	
	private void dfs2(GraphAdjLst g, int current, Set<Integer> set, boolean[] visited) {
		visited[current] = true;
		set.add(current);
		for (int i = 0; i < g.adjList[current].size(); i++) {
			if (!visited[g.adjList[current].get(i)]) {
				dfs2(g, g.adjList[current].get(i), set, visited);
			}
		}
	}
}
