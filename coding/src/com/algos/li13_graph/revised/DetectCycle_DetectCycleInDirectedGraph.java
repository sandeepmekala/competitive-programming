package  com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import  com.algos.li30_model.GraphAdjLst;

class DetectCycle_DetectCycleInDirectedGraph {
	public static void main(String args[]) {
		DetectCycle_DetectCycleInDirectedGraph obj = new DetectCycle_DetectCycleInDirectedGraph();

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
		int n = adj.size();
		int[] vis = new int[n];
		int[] pathVis = new int[n];

		for(int node: adj.keySet()) {
			if(vis[node] == 0){
				if(dfs(adj, node, vis, pathVis) == true) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(HashMap<Integer, ArrayList<Integer>> adj, int node, int[] vis, int[] pathVis) {
		vis[node] = 1;
		pathVis[node] = 1;
		for(int neigh: adj.get(node)) {
			if(vis[neigh] != 1) {
				if(dfs(adj, neigh, vis, pathVis) == true) {
					return true;
				}
			}else if(pathVis[neigh] == 1) {
				return true;
			}
		}

		pathVis[node] = 0;
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