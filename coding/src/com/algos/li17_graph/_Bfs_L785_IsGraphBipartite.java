package  com.algos.li17_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _Bfs_L785_IsGraphBipartite {
    public static void main(String[] args) {
        _Bfs_L785_IsGraphBipartite obj = new _Bfs_L785_IsGraphBipartite();

        //int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        //System.out.println(obj.isBipartite(graph));
        System.out.println(obj.isBipartiteDfs(graph));
    }

    // Problem: https://leetcode.com/problems/is-graph-bipartite
    // Idea: Apply BFS/DFS and assign opposite color to neighbor compare to the node if color is not already assigned.
    // If neigh color is already assigned, check if it same as node to return false.
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int src=0; src<n; src++){
            if(colors[src] == -1){
                if(bfs(graph, src, colors) == false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(int[][] graph, int src, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 1;
        while(!q.isEmpty()){
            Integer node = q.remove();
            for(int neigh: graph[node]){
                if(color[neigh] == -1){
                    color[neigh] = 1-color[node];  // colors 0/1
                    q.add(neigh);
                }else if(color[neigh] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDfs(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int src=0; src<n; src++){
            if(colors[src] == -1){
                if(dfs(graph, src, 0,  colors) == false)
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int col, int[] colors) {
        colors[node] = col;
        for(int neigh: graph[node]){
            if(colors[neigh] == -1){
                if(dfs(graph, neigh, 1-col,  colors) == false){
                    return false;
                }
            }else if(colors[neigh] == colors[node]){
                return false;
            }
        }
        return true;
    }

}
