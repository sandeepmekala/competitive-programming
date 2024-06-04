package com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dfs_L694_NumberOfDistinctIslands {
    public static void main(String[] args) {
        Dfs_L694_NumberOfDistinctIslands ob = new Dfs_L694_NumberOfDistinctIslands();
        int[][] grid = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 } };

        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }

    public int countDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] vis = new int[m][n];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] != 1 && grid[i][j] == 1) {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(grid, i, j, vis, shape, i, j);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int row, int col, int[][] vis,
            List<String> shape, int row0, int col0) {

        vis[row][col] = 1;
        shape.add(toString(row - row0, col - col0));

        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            // check for valid unvisited land neighbour coordinates
            if (isSafe(grid, nrow, ncol, vis))
                dfs(grid, nrow, ncol, vis, shape, row0, col0);
        }
    }

    private boolean isSafe(int[][] grid, int nrow, int ncol, int[][] vis) {
        int m = grid.length, n = grid[0].length;
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                vis[nrow][ncol] != 1 && grid[nrow][ncol] == 1;
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + ":" + Integer.toString(c);
    }
}
