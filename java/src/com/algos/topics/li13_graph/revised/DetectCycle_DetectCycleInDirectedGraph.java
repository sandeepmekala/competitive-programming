package  com.algos.topics.li13_graph.revised;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DetectCycle_DetectCycleInDirectedGraph {
	public static void main(String args[]) {
		DetectCycle_DetectCycleInDirectedGraph obj = new DetectCycle_DetectCycleInDirectedGraph();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			adj.add(new ArrayList<>());
		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(2).add(3);

		System.out.println("Is cyclic: " + obj.isCyclic(adj));
		System.out.println("Is cyclic: " + obj.isCyclic(4, adj));
	}

	// DFS
	// Time: O(V+E)
	private boolean isCyclic(List<List<Integer>> adj) {
		int n = adj.size();
		int[] vis = new int[n];
		int[] pathVis = new int[n];

		for(int node=0; node<n; node++) {
			if(vis[node] == 0){
				if(dfs(adj, node, vis, pathVis) == true)
					return true;
			}
		}
		return false;
	}

	private boolean dfs(List<List<Integer>> adj, int node, int[] vis, int[] pathVis) {
		vis[node] = 1;
		pathVis[node] = 1;
		for(int nei: adj.get(node)) {
			if(vis[nei] != 1) {
				if(dfs(adj, nei, vis, pathVis) == true)
					return true;
			}else if(pathVis[nei] == 1) {
				return true;
			}
		}

		pathVis[node] = 0;
		return false;
	}

	// BFS: Using Kahns Algo
	// Idea: If Kahns algo doesn't find a node with indegree 0 to complete topo order means there is a cycle.
	public boolean isCyclic(int n, List<List<Integer>> adj){
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
