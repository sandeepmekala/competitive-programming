package com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArticulationPoint_I {
    public static void main (String[] args) {
        int n = 5;
        int[][] edges = {
                { 0, 1 }, { 1, 4 },
                { 2, 4 }, { 2, 3 }, { 3, 4 }
        };
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArticulationPoint_I obj = new ArticulationPoint_I();
        List<Integer> nodes = obj.articulationPoints(n, adj);

        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            int node = nodes.get(i);
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    // When neigh node can reach at max curr node, then curr node becomes articulation point
    // That is why when you see visited node take tin not low so that visited node can become ap while dfs exiting.
    // You same node might become articulation point multiple times. Hence, store them in set.
    // Time: O(V+E)
    public List<Integer> articulationPoints(int n,
            List<List<Integer>> adj) {
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        Set<Integer> artpnts = new HashSet<>();     // As same node can become articulation point multiple times
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, artpnts, adj);
            }
        }
        List<Integer> ans = new ArrayList<>(artpnts);
        if (ans.isEmpty())
            ans.add(-1);
        return ans;
    }

    private int timer = 1;
        private void dfs(int node, int parent, int[] vis,
                         int tin[], int low[], Set<Integer> artpnts,
                         List<List<Integer>> adj) {
            vis[node] = 1;
            tin[node] = low[node] = timer++;
            int child = 0;
            for (Integer neigh : adj.get(node)) {
                if (neigh == parent) continue;
                if (vis[neigh] == 0) {
                    dfs(neigh, node, vis, tin, low, artpnts, adj);
                    low[node] = Math.min(low[node], low[neigh]);
                    // node --- neigh
                    if (low[neigh] >= tin[node] && parent != -1) {
                        artpnts.add(node);
                    }
                    child++;
                } else {
                    low[node] = Math.min(low[node], tin[neigh]);
                }
            }
            if (child > 1 && parent == -1) {
                artpnts.add(node);
            }
        }

}
