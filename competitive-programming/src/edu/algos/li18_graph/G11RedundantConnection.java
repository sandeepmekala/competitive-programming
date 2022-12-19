package edu.algos.li18_graph;

import java.util.Arrays;

public class G11RedundantConnection {

	public static void main(String[] args) {
		G11RedundantConnection obj = new G11RedundantConnection();
		
		int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
		int[] redundant = obj.findRedundantConnection(edges);
		System.out.println(Arrays.toString(redundant));
		
	}
	
	public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        int[] parents = new int[n];
        int[] ranks = new int[n];
        
        for(int i=1; i<n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
        
        for(int[] edge: edges){
            int src = edge[0];
            int dst = edge[1];
            int srcPrt = find(parents, src);
            int dstPrt = find(parents, dst);
            if(srcPrt == dstPrt){
                return edge;
            }else{
                union(parents, ranks, srcPrt, dstPrt);
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
