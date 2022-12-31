package edu.algos.li18_graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L261_CycleDetection_GraphValidTree {

	public static void main(String[] args) {
		L261_CycleDetection_GraphValidTree obj = new L261_CycleDetection_GraphValidTree();
		int n = 5;
		//int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.println(obj.validTree(n, edges));
	}

    // Problem: https://leetcode.com/problems/graph-valid-tree/
    // https://www.lintcode.com/problem/178/
    // Idea: 
	public boolean validTree(int n, int[][] edges) {
        if(n == 0){
            return true;
        }

        HashMap<Integer, List<Integer>> adjlist = new HashMap<>();
        for(int i=0; i<n; i++){
            adjlist.put(i, new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        return dfs(adjlist, 0, -1, visited) && (visited.size() == n);
    }

    private boolean dfs(HashMap<Integer, List<Integer>> adjlist, int curr, int prev, HashSet<Integer> visited){
        if(!visited.contains(curr)){
            visited.add(curr);
            for(int neigh: adjlist.get(curr)){
                if(neigh != prev){
                    if(!dfs(adjlist, neigh, curr, visited)){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
