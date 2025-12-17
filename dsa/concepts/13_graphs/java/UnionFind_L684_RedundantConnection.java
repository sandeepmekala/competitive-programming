
import java.util.Arrays;

public class UnionFind_L684_RedundantConnection {

	public static void main(String[] args) {
		UnionFind_L684_RedundantConnection obj = new UnionFind_L684_RedundantConnection();

		int[][] edges = {{1,2},{1,3},{2,3}};
		int[] redundant = obj.findRedundantConnection(edges);
		System.out.println(Arrays.toString(redundant));
	}

    // Problem: https://leetcode.com/problems/redundant-connection/
    // Idea: Duplicate edge creates a cycle in the graph. Use Union Find to find the cycle.
	public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;     // as problem said to have equal edges as nodes
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=1; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] edge: edges){
            int srcPar = find(parent, edge[0]);
            int dstPar = find(parent, edge[1]);
            if(srcPar == dstPar){
                return edge;
            }else{
                unionByRank(parent, rank, srcPar, dstPar);
            }
        }
        return new int[]{};
    }

    private int find(int[] parents, int curr){
        if(parents[curr] == curr)
            return parents[curr];
        return parents[curr] = find(parents, parents[curr]);
    }

    private void unionByRank(int[] parents, int[] ranks, int src, int dst){
        if(ranks[src] > ranks[dst]){
            parents[dst] = src;
        }else if(ranks[dst] > ranks[src]){
            parents[src] = dst;
        }else{
            parents[dst] = src;
            ranks[src] = ranks[src] + 1;
        }
    }

}
