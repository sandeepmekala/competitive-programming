package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _ShortestPath_G02_ShortestPathInDirectedGraph {

	_TopoSort_G03_TopologicalSorting  topo = new _TopoSort_G03_TopologicalSorting();

	public static void main(String[] args) {
		_ShortestPath_G02_ShortestPathInDirectedGraph obj = new _ShortestPath_G02_ShortestPathInDirectedGraph();
		
		int[][] edges = new int[][]{{0,1,2},{0,4,1},{4,5,4}
		,{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
		
		int[] dist = obj.shortestPath(6, 7, edges);
		System.out.println(Arrays.toString(dist));
	}

	// Problem: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph
	// Idea: Topo sort gives sequenctial ordering of edges. If we relax edges in that order, we get short path to each edge as we relax the edges in sequential order.
	// 1. Find topo sort
	// 2. Take each node from topo sort and relax its edges.
	public int[] shortestPath(int N,int M, int[][] edges) {
		HashMap<Integer, ArrayList<int[]>> adj = new HashMap<Integer, ArrayList<int[]>>();
		for(int node=0; node<N; node++) 
			adj.put(node, new ArrayList<>());
		for(int[] edge: edges)
			adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
		
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[N];
		for(int node=0; node<N; node++){
			if(visited[node] != 1){
				dfs(adj, node, visited, stack);
			}
		}
		System.out.println(stack);

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		while(!stack.isEmpty()){
			Integer node = stack.pop();
			for(int neigh[]: adj.get(node)){
				if(dist[node]+neigh[1] < dist[neigh[0]]){
					dist[neigh[0]] = dist[node]+neigh[1];
				}
			}
		}
		return dist;
	}

	private void dfs(HashMap<Integer, ArrayList<int[]>> adj, int node, int[] visited, Stack<Integer> stack) {
		visited[node] = 1;
		for(int neigh[]: adj.get(node)){
			if(visited[neigh[0]] != 1){
				dfs(adj, neigh[0], visited, stack);
			}
		}
		stack.push(node);
	}

}
