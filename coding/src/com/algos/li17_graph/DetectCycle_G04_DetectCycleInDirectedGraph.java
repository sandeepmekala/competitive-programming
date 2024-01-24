package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import  com.algos.li30_model.GraphAdjLst;

class DetectCycle_G04_DetectCycleInDirectedGraph {
	public static void main(String args[]) {
		DetectCycle_G04_DetectCycleInDirectedGraph obj = new DetectCycle_G04_DetectCycleInDirectedGraph();

		GraphAdjLst g = new GraphAdjLst();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		//g.addEdge(2, 0);
		g.addEdge(2, 3);
		//g.addEdge(3, 3);

		System.out.println("Is cyclic: " + obj.isCyclic(g.adj));
		System.out.println("Is cyclic: " + obj.isCyclic(4, g.adj));
	}

	// DFS
	// Time: O(V+E)
	private boolean isCyclic(HashMap<Integer, ArrayList<Integer>> adj) {
		HashSet<Integer> visited = new HashSet<>();
		HashSet<Integer> pathVis = new HashSet<>();

		for(int node: adj.keySet()) {
			if(dfs(adj, node, visited, pathVis) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(HashMap<Integer, ArrayList<Integer>> adj, int node, HashSet<Integer> visited, HashSet<Integer> pathVis) {
		visited.add(node);
		pathVis.add(node);
		for(int neigh: adj.get(node)) {
			if(!visited.contains(neigh)) {
				if(dfs(adj, neigh, visited, pathVis) == true) {
					return true;
				}
			}else if(pathVis.contains(neigh)) {
				return true;
			}
		}

		pathVis.remove(node);
		return false;
	}

	// BFS: Using Kahns Algo
	// Idea: If Kahns algo doesn't find a node with indegree 0 to complete topo order means there is a cycle.
	public boolean isCyclic(int n, HashMap<Integer, ArrayList<Integer>> adj){
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

		int count=0;
		while(!q.isEmpty()){
			Integer node = q.remove();
			count++;
			for(int neigh: adj.get(node)){
				indegree[neigh]--;
				if(indegree[neigh] == 0) 
					q.add(neigh);
			}	
		}

		return count != n;
	}

}