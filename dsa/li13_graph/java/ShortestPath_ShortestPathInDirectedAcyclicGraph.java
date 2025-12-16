
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ShortestPath_ShortestPathInDirectedAcyclicGraph {

	TopoSort_TopologicalSorting  topo = new TopoSort_TopologicalSorting();

	public static void main(String[] args) {
		ShortestPath_ShortestPathInDirectedAcyclicGraph obj = new ShortestPath_ShortestPathInDirectedAcyclicGraph();

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
		List<List<int[]>> adj = new ArrayList<>();
		for(int nod=0; nod<N; nod++)
			adj.add(new ArrayList<>());
		for(int[] edge: edges)
			adj.get(edge[0]).add(new int[]{edge[1], edge[2]});

		Stack<Integer> st = new Stack<>();
		int[] vis = new int[N];
		for(int i=0; i<N; i++){
			if(vis[i] != 1)
				topoSort(adj, i, vis, st);
		}

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		while(!st.isEmpty()){
			Integer node = st.pop();
			for(int nei[]: adj.get(node)){
				if(dist[node]+nei[1] < dist[nei[0]]){
					dist[nei[0]] = dist[node]+nei[1];
				}
			}
		}
		return dist;
	}

	private void topoSort(List<List<int[]>> adj, int nod, int[] vis, Stack<Integer> st) {
		vis[nod] = 1;
		for(int nei[]: adj.get(nod)){
			if(vis[nei[0]] != 1){
				topoSort(adj, nei[0], vis, st);
			}
		}
		st.push(nod);
	}

}
