package  com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bridges_L1192_CriticalConnectionsInANetwork {
    public static void main (String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        

        Bridges_L1192_CriticalConnectionsInANetwork obj = new Bridges_L1192_CriticalConnectionsInANetwork();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);

        for(var bridge: bridges)
            System.out.println(bridge);
    }

    // Problem: https://leetcode.com/problems/critical-connections-in-a-network/
    // Idea: Tarjan's algo
    // Track insertion time and low time of each node.
    // Insertion time is when dfs starte, low time is the lowest time of all the neighbors except parent.
    // If low time of neighbor is greater than insertion time of node, then there is no back edge.  This is bridge
    // We don't consider back edge to parent, because hypothetically, we assume that edge is removed. And we need to check if there is another path to reach parent.
    // Time: O(V+E)
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> cons) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());
        for (var con : cons) {
            adj.get(con.get(0)).add(con.get(1));
            adj.get(con.get(1)).add(con.get(0));
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adj, tin, low, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, int[] vis,
                     List<List<Integer>> adj, int tin[], int low[],
                     List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        for (Integer nei : adj.get(node)) {
            if (nei == parent) continue;
            if (vis[nei] != 1) {
                dfs(nei, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[nei]);
                // node --> nei is a bridge?
                if (low[nei] > tin[node]) 
                    bridges.add(Arrays.asList(nei, node));
            } else {
                low[node] = Math.min(low[node], low[nei]);
            }
        }
    }
}
