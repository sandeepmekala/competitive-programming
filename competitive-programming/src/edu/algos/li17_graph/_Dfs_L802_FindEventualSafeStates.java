package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Dfs_L802_FindEventualSafeStates {
    public static void main(String[] args) {
        _Dfs_L802_FindEventualSafeStates obj = new _Dfs_L802_FindEventualSafeStates();

        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(obj.eventualSafeNodes(graph));
        System.out.println(graph[2].length);

    }

    // Problem: https://leetcode.com/problems/find-eventual-safe-states/
    // Idea: All the node which are in cycle and which are leading to cycle are not safe nodes. 
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n]; // to avoud duplicate exploration
        int[] pathVis = new int[n]; // to detect cycles
        int[] isSafe = new int[n];  // to mark safe
        List<Integer> safeNodes = new ArrayList<>();
        for(int src=0; src<n; src++){
            if(visited[src] == 0){
                dfs(graph, src, visited, pathVis, isSafe);
            }
        }
        for(int src=0; src<n; src++)
            if(isSafe[src] == 1)
                safeNodes.add(src);
        return safeNodes;
    }

    private boolean dfs(int[][] graph, int node, int[] visited, int[] pathVis, int[] isSafe) {
        visited[node] = 1;
        pathVis[node] = 1;
        for(int neigh: graph[node]){
            if(visited[neigh] == 0){
                if(dfs(graph, neigh, visited, pathVis, isSafe)){
                    return true;
                }
            }else if(pathVis[neigh] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        isSafe[node] = 1;
        return false;
    }

    //  Initially the terminal nodes are those who have outdegree 0 
    // but after reversal the terminal nodes becomes those which have indegree 0 
    // so we can apply Kahn's algo to find all the nodes connected to it  which have linear dependency on the terminal node or is on the path which leads to terminal node 
    // so if the nodes is a part of a cycle or points to a cycle , that path cannot lead to terminal node as each node in that  path will have cyclic dependency
    // 
    // topo sort 
    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.remove();
            safeNodes.add(node);
            for (int niegh : adjRev.get(node)) {
                indegree[niegh]--;
                if (indegree[niegh] == 0) 
                    q.add(niegh);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

}
