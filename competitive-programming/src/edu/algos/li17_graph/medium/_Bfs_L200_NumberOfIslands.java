package edu.algos.li17_graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _Bfs_L200_NumberOfIslands {

    public static void main(String[] args) {
        _Bfs_L200_NumberOfIslands obj = new _Bfs_L200_NumberOfIslands();
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
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // if not visited and is a land
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }

    public void bfs(int ro, int co, int[][] visited, char[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co));
        visited[ro][co] = 1;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                            && grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0) {
                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
