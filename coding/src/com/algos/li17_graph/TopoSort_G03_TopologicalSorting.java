package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import  com.algos.li30_model.GraphAdjLst;

public class TopoSort_G03_TopologicalSorting {

	public static void main(String[] args) {
		TopoSort_G03_TopologicalSorting obj = new TopoSort_G03_TopologicalSorting();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		Stack<Integer> stack = obj.topologicalSort(g.adj);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println(obj.topoSortByKahnsAlgo(6, g.adj));
	}

	// Problem: 
	// Idea: In DAG, for edge (u, v), in topological sorting u comes first then
	// v.
	// Always starts from vertex whose indegree is 0
	// time O(V+E)
	// space O(V)
	public Stack<Integer> topologicalSort(HashMap<Integer, ArrayList<Integer>> adj) {
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<>();
		for (int src : adj.keySet()) {
			if(!visited.contains(src))
				dfs(adj, src, visited, stack);
		}
		return stack;
	}

	private void dfs(HashMap<Integer, ArrayList<Integer>> adj, int node, HashSet<Integer> visited, Stack<Integer> stack) {
		visited.add(node);
		for (int neigh : adj.get(node)) {
			if (!visited.contains(neigh)) {
				dfs(adj, neigh, visited, stack);
			}
		}
		stack.add(node);
	}


	// Kahn's Algorithm:
	// 1. Insert all nodes with ingree 0 to q
	// 2. reduce the indegree of all their adj node by 1
	// 3. If indegree of adj node become 0, add it to q.
	// BFS
	public List<Integer> topoSortByKahnsAlgo(int n, HashMap<Integer, ArrayList<Integer>> adj){
		int[] indegree = new int[n];
		for(int node=0; node<n; node++){	// find indegree
			for(int neigh: adj.get(node)){
				indegree[neigh]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();	// load all indegree=0
		for(int node=0; node<n; node++){
			if(indegree[node] == 0){
				q.add(node);
			}
		}

		List<Integer> topoOrder = new ArrayList<>();
		while(!q.isEmpty()){
			Integer node = q.remove();
			topoOrder.add(node);
			for(int neigh: adj.get(node)){
				indegree[neigh]--;
				if(indegree[neigh] == 0) 	// indegree arr acts as visited array
					q.add(neigh);
			}	
		}
		return topoOrder;
	}
}