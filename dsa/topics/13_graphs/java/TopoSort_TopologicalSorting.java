import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopoSort_TopologicalSorting {

	public static void main(String[] args) {
		TopoSort_TopologicalSorting obj = new TopoSort_TopologicalSorting();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 6; i++)
			adj.add(new ArrayList<>());
		adj.get(5).add(2);
		adj.get(5).add(0);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(2).add(3);
		adj.get(3).add(1);

		Stack<Integer> stack = obj.topoSortByDfs(adj);
		Collections.reverse(stack);
		System.out.println(stack);

		System.out.println(obj.topoSortByKahnsAlgo(6, adj));
	}

	// Problem:
	// Idea: In DAG, for edge (u, v), in topological sorting u comes first then
	// v.
	// Always starts from vertex whose indegree is 0
	// time O(V+E)
	// space O(V)
	public Stack<Integer> topoSortByDfs(List<List<Integer>> adj) {
		int n = adj.size();

		Stack<Integer> stack = new Stack<>();
		int[] vis = new int[n];
		for (int i=0; i<n; i++) {
			if(vis[i] == 0)
				dfs(adj, i, vis, stack);
		}
		return stack;
	}

	private void dfs(List<List<Integer>> adj, int node, int[] vis, Stack<Integer> stack) {
		vis[node] = 1;
		for (int neigh : adj.get(node)) {
			if (vis[neigh] == 0)
				dfs(adj, neigh, vis, stack);
		}
		stack.add(node);
	}


	// Kahn's Algorithm:
	// 1. Insert all nodes with ingree 0 to q
	// 2. reduce the indegree of all their adj node by 1
	// 3. If indegree of adj node become 0, add it to q.
	// BFS
	public List<Integer> topoSortByKahnsAlgo(int n, List<List<Integer>> adj){
		int[] indegree = new int[n];
		for(int i=0; i<n; i++){	// find indegree
			for(int neigh: adj.get(i)){
				indegree[neigh]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();	// load all indegree=0
		for(int i=0; i<n; i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}

		List<Integer> topoSort = new ArrayList<>();
		while(!q.isEmpty()){
			Integer node = q.remove();
			topoSort.add(node);
			for(int nei: adj.get(node)){
				indegree[nei]--;
				if(indegree[nei] == 0) 	// indegree arr acts as visited array
					q.add(nei);
			}
		}
		return topoSort;
	}
}
