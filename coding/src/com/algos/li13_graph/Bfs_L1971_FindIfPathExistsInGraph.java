package  com.algos.li13_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Bfs_L1971_FindIfPathExistsInGraph {

	public static void main(String[] args) {
		Bfs_L1971_FindIfPathExistsInGraph obj = new Bfs_L1971_FindIfPathExistsInGraph();
		int[][] edges = new int[][]{{0,1},{1,2},{2,0}};
		int n = 3;
		
		System.out.println(obj.validPath(n, edges, 0, 2));
	}
	
	// Problem: https://leetcode.com/problems/find-if-path-exists-in-graph/
	// Idea: Use bfs
	public boolean validPath(int n, int[][] edges, int src, int dest) {
		if(src == dest) 
			return true;
		
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		q.add(src);
		visited.add(src);
		while(!q.isEmpty()) {
			int curr = q.remove();
			if(curr == dest) 
				return true;
			for(int[] edge: edges) {
				if(edge[0] == curr && !visited.contains(edge[1])){
					visited.add(edge[1]);
					q.add(edge[1]);
				}					
				if(edge[1] == curr && !visited.contains(edge[0])){
					visited.add(edge[0]);
					q.add(edge[0]);
				}
			}		
			
		}
		
		return false;
	}

}
