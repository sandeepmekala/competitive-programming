package edu.algos.li18_graph.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L1971_Bfs_FindIfPathExistsInGraph {

	public static void main(String[] args) {
		L1971_Bfs_FindIfPathExistsInGraph obj = new L1971_Bfs_FindIfPathExistsInGraph();
		int[][] edges = new int[][]{{0,1},{1,2},{2,0}};
		int n = 3;
		
		System.out.println(obj.validPath(n, edges, 0, 2));
	}
	
	// Problem: https://leetcode.com/problems/find-if-path-exists-in-graph/
	// Idea: Use bfs
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		if(source == destination) {
			return true;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.add(source);
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			if(!visited.contains(curr)) {
				if(curr == destination) 
					return true;
				visited.add(curr);
				for(int[] edge: edges) {
					if(edge[0] == curr)
						queue.add(edge[1]);
					if(edge[1] == curr)
						queue.add(edge[0]);
				}	
			}
		}
		
		return false;
	}

}
