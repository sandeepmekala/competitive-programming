package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import edu.algos.li00_model.Edge;
import edu.algos.li00_model.GraphAdjLst;

public class _DetectCycle_G03_DetectCycleInUndirectedGraph {

	_UnionFind_G01_UnionFind uf = new _UnionFind_G01_UnionFind();

	public static void main(String[] args) {
		// cycle can be detected using union find algorithm
		// 0---1
		// |  /
		// | /
		// 2
		_DetectCycle_G03_DetectCycleInUndirectedGraph obj = new _DetectCycle_G03_DetectCycleInUndirectedGraph();
		GraphAdjLst g = new GraphAdjLst();
		g.addEdge(new Edge(0, 1));
		g.addEdge(new Edge(1, 2));
		g.addEdge(new Edge(2, 0));

		System.out.print("Is Cyclic:");
		System.out.println(obj.isCyclicBfs(g.adj));

		System.out.print("Is Cyclic by union find:");
		System.out.println(obj.isCyclicByUnionFind(g));
	}

	// BFS
	public boolean isCyclicBfs(HashMap<Integer, ArrayList<Integer>> adj) {
		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		visited.add(0);
		while (!q.isEmpty()) {
			int curr = q.remove();
			for (int neigh : adj.get(curr)) {
				if(!visited.contains(neigh)) {
					visited.add(curr);
					q.add(neigh);
				}else if (neigh != curr){	// if visited and not curr
					return true;
				} 
			}
		}
		return false;
	}

    public boolean isCycleDfs(ArrayList<ArrayList<Integer>> adj) {
		int n = adj.size();
		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				if (dfs(i, -1, visited, adj) == true)
					return true;
			}
		}
		return false;
	}

	private boolean dfs(int node, int parent, int visited[], ArrayList<ArrayList<Integer>> adj) {
		visited[node] = 1;
		for(int neigh : adj.get(node)) {
			if (visited[neigh] == 0) {
				if (dfs(neigh, node, visited, adj) == true)
					return true;
			}else if (neigh != parent)
				return true;
		}
		return false;
	}

	// time = O(V) as in worst case we execute 3v operations of union find which
	// take O(V) time.
	// space = O(V)
	public boolean isCyclicByUnionFind(GraphAdjLst g) {
		uf.makeSet(g.adj.size());
		for (int src : g.adj.keySet()) {
			int srcParent = uf.find(src);
			for(int dest: g.adj.get(src)) {
				int destParent = uf.find(dest);
				if (srcParent == destParent) 
					return true;
				
				uf.unionByRank(srcParent, destParent);
			}
		}

		return false;
	}
}