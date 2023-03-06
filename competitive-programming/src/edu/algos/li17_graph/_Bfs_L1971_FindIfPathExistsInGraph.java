package edu.algos.li17_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _Bfs_L1971_FindIfPathExistsInGraph {

	public static void main(String[] args) {
		_Bfs_L1971_FindIfPathExistsInGraph obj = new _Bfs_L1971_FindIfPathExistsInGraph();
		int[][] edges = new int[][]{{0,1},{1,2},{2,0}};
		int n = 3;
		
		System.out.println(obj.validPath(n, edges, 0, 2));
	}
	
	// Problem: https://leetcode.com/problems/find-if-path-exists-in-graph/
	// Idea: Use bfs
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		if(source == destination) 
			return true;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.add(source);
		visited.add(source);
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			if(curr == destination) 
				return true;
			for(int[] edge: edges) {
				if(edge[0] == curr && !visited.contains(edge[1])){
					visited.add(edge[1]);
					queue.add(edge[1]);
				}					
				if(edge[1] == curr && !visited.contains(edge[0])){
					visited.add(edge[0]);
					queue.add(edge[0]);
				}
			}		
			
		}
		
		return false;
	}

}
