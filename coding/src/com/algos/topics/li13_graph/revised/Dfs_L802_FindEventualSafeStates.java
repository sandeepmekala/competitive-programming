package  com.algos.topics.li13_graph.revised;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dfs_L802_FindEventualSafeStates {
    public static void main(String[] args) {
        Dfs_L802_FindEventualSafeStates obj = new Dfs_L802_FindEventualSafeStates();

        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(obj.eventualSafeNodes(graph));
        System.out.println(graph[2].length);

    }

    // Approach 1
    // Problem: https://leetcode.com/problems/find-eventual-safe-states/
    // Idea: All the node which are in cycle and which are leading to cycle are not safe nodes.
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int[] vis = new int[n]; // to aviod duplicate exploration
        int[] pathVis = new int[n]; // to detect cycles
        int[] isSafe = new int[n];  // to mark safe
        for(int src=0; src<n; src++){
            if(vis[src] == 0){
                dfs(graph, src, vis, pathVis, isSafe);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int node=0; node<n; node++)
            if(isSafe[node] == 1)
                safeNodes.add(node);
        return safeNodes;
    }

    private boolean dfs(int[][] graph, int node, int[] vis, int[] pathVis, int[] isSafe) {
        vis[node] = 1;
        pathVis[node] = 1;
        for(int neigh: graph[node]){
            if(vis[neigh] == 0){
                if(dfs(graph, neigh, vis, pathVis, isSafe))
                    return true;
            }else if(pathVis[neigh] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        isSafe[node] = 1;
        return false;
    }
    // Approach 2
    // Just apply topo sort using kahn's algo. It will have not all the nodes in result if not DAG.

    // Approach 3
    // Initially the terminal nodes are those who have outdegree 0
    // but after reversal the terminal nodes becomes those which have indegree 0
    // so we can apply Kahn's algo to find all the nodes connected to it which have linear dependency on the terminal node or is on the path which leads to terminal node
    // so if the nodes is a part of a cycle or points to a cycle , that path cannot lead to terminal node as each node in that  path will have cyclic dependency
    //
    // topo sort
    public List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjRev.add(new ArrayList<>());

        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neigh : adj.get(i)) {
                adjRev.get(neigh).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
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
