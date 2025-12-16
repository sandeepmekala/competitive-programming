package li13_graph;

import java.util.ArrayList;

public class Dfs_L547_NumberOfProvinces {
    public static void main(String[] args) {
        Dfs_L547_NumberOfProvinces ob = new Dfs_L547_NumberOfProvinces();

        // adjacency matrix
        int[][] isConnected = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        System.out.println(ob.findCircleNum(isConnected));
    }

    // Problem: https://leetcode.com/problems/number-of-provinces/
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // to change adjacency matrix to list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // self nodes are not considered
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] vis = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[]) {
        vis[node] = 1;
        for (Integer neigh : adj.get(node)) {
            if (vis[neigh] == 0) {
                dfs(neigh, adj, vis);
            }
        }
    }
}
