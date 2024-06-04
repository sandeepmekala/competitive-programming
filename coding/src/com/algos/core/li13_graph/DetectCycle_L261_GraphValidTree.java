package  com.algos.core.li13_graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycle_L261_GraphValidTree {

	public static void main(String[] args) {
		DetectCycle_L261_GraphValidTree obj = new DetectCycle_L261_GraphValidTree();
		int n = 5;
		//int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.println(obj.validTree(n, edges));
	}

    // Problem: https://leetcode.ca/2016-08-17-261-Graph-Valid-Tree/
    // Idea: Cycle detection in undirected graph. Use DFS to detect cycle.
	public boolean validTree(int n, int[][] edges) {
        if(n == 0)
            return true;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> vis = new HashSet<>();
        return dfs(adj, 0, -1, vis) && (vis.size() == n);
    }

    private boolean dfs(List<List<Integer>> adj, int curr, int prev, Set<Integer> vis){
        vis.add(curr);
        for(int nei: adj.get(curr)){
            if(!vis.contains(nei)){
                if(dfs(adj, nei, curr, vis) == false){
                    return false;
                }
            }else if(nei != prev){
                return false;
            }
        }
        return true;
    }
}
