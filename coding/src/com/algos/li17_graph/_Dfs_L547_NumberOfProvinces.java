package  com.algos.li17_graph;

import java.util.ArrayList;

public class _Dfs_L547_NumberOfProvinces {
    public static void main(String[] args) {
        _Dfs_L547_NumberOfProvinces ob = new _Dfs_L547_NumberOfProvinces();

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
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int visited[]) {
        visited[node] = 1;
        for (Integer neigh : adjLs.get(node)) {
            if (visited[neigh] == 0) {
                dfs(neigh, adjLs, visited);
            }
        }
    }
}
