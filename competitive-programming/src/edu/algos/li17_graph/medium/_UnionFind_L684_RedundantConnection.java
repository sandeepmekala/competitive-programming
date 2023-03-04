package edu.algos.li17_graph.medium;

import java.util.Arrays;

public class _UnionFind_L684_RedundantConnection {

	public static void main(String[] args) {
		_UnionFind_L684_RedundantConnection obj = new _UnionFind_L684_RedundantConnection();
		
		int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
		int[] redundant = obj.findRedundantConnection(edges);
		System.out.println(Arrays.toString(redundant));
	}
	
    // Problem: https://leetcode.com/problems/redundant-connection/
    // Idea: Duplicate edge creates a cycle in the graph. Use Union Find to find the cycle. 
	public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        int[] parents = new int[n];
        int[] ranks = new int[n];
        
        for(int i=1; i<n; i++){
            parents[i] = i;
            ranks[i] = 0;
        }
        
        for(int[] edge: edges){
            int srcParent = find(parents, edge[0]);
            int dstParent = find(parents, edge[1]);
            if(srcParent == dstParent){
                return edge;
            }else{
                union(parents, ranks, srcParent, dstParent);
            }
        }
        return new int[]{};
    }
    
    private int find(int[] parents, int current){
        int parent = parents[current];
        if(parent == current){
            return parent;
        }
        parents[current] = find(parents, parent);
        return parents[current];
    }
    
    private void union(int[] parents, int[] ranks, int src, int dst){
        if(ranks[src] > ranks[dst]){
            parents[dst] = src;
        }else if(ranks[dst] > ranks[src]){
            parents[src] = dst;
        }else{
            parents[dst] = src;
            ranks[src] = ranks[src] + ranks[dst];
        }
    }

}
