package edu.algos.li17_graph;

import java.util.LinkedList;
import java.util.Queue;

public class _Dfs_L200_NumberOfIslands {

    public static void main(String[] args) {
        _Dfs_L200_NumberOfIslands obj = new _Dfs_L200_NumberOfIslands();
        char[][] grid = new char[][] {
                { '0', '1' },
                { '1', '0' },
                { '1', '1' },
                { '1', '0' },
        };
        System.out.println(obj.numIslands(grid));

    }

    // Problem: https://leetcode.com/problems/number-of-islands/
    // Idea: Do dfs from each cell in matrix which explores the complete island and
    // return. Once it return count it as one island.
    // From each cell we have to dfs in 4 directions to explore the island
    // completely.
    // While exploring a cell change its value to 0 so that it won't be explored
    // again.
    // If you don't want to tamper input array, you need to use extra visited
    // matrix.
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // if not visited and is a land
                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return count;
    }

    // dfs will do with less code
    public void bfs(int i, int j, int[][] visited, char[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        visited[i][j] = 1;
        while (!q.isEmpty()) {
            Pair curr = q.remove();
            int row = curr.row, col = curr.col;

            for (int drow = -1; drow <= 1; drow++) {
                for (int dcol = -1; dcol <= 1; dcol++) {
                    int nrow = row + drow;
                    int ncol = col + dcol;
                    if (isSafe(visited, grid, n, m, nrow, ncol)) {
                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    private boolean isSafe(int[][] visited, char[][] grid, int n, int m, int nrow, int ncol) {
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                && grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0;
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.row = first;
        this.col = second;
    }
}
