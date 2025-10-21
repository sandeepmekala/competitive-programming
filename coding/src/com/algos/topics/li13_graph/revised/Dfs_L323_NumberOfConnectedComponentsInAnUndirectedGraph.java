package com.algos.topics.li13_graph.revised;

import java.util.ArrayList;
import java.util.List;

public class Dfs_L323_NumberOfConnectedComponentsInAnUndirectedGraph {

	public static void main(String[] args) {
		Dfs_L323_NumberOfConnectedComponentsInAnUndirectedGraph obj = new Dfs_L323_NumberOfConnectedComponentsInAnUndirectedGraph();

		int n = 5;
		int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		System.out.println(obj.countComponents(n, edges));
	}

	// Problem:
	// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
	// Idea: Do dfs from all vertices. Once, dfs returns, count it as once CC.
	public int countComponents(int n, int[][] edges) {
		int count = 0;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
		}

		int[] vis = new int[n];
		for (int i = 0; i < n; i++) {
			if (vis[i] != 1) {
				dfs(adj, i, vis);
				count++;
			}
		}
		return count++;

	}

	private void dfs(List<List<Integer>> adj, int src, int[] vis) {
		vis[src] = 1;
		for (int nei : adj.get(src)) {
			if (vis[nei] != 1) {
				dfs(adj, nei, vis);
			}
		}
	}

}
