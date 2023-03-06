package edu.algos.li17_graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Bridges_L1192_CriticalConnectionsInANetwork {
    public static void main (String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1}, {1, 2},
            {2, 0}, {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }

        _Bridges_L1192_CriticalConnectionsInANetwork obj = new _Bridges_L1192_CriticalConnectionsInANetwork();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);

        int size = bridges.size();
        for (int i = 0; i < size; i++) {
            int u = bridges.get(i).get(0);
            int v = bridges.get(i).get(1);
            System.out.print("[" + u + ", " + v + "] ");
        }
        System.out.println("");
    }

    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj =
            new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) 
            adj.add(new ArrayList<Integer>());
        
        for (List<Integer> it : connections) {
            int u = it.get(0), v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, adj, tin, low, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, int[] visited,
                     ArrayList<ArrayList<Integer>> adj, int tin[], int low[],
                     List<List<Integer>> bridges) {
        visited[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for (Integer it : adj.get(node)) {
            if (it == parent) 
                continue;
            if (visited[it] == 0) {
                dfs(it, node, visited, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] > tin[node]) 
                    bridges.add(Arrays.asList(it, node));
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}
