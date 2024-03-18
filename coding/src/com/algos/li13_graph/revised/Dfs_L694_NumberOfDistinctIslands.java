package  com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.HashSet;

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
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(i, j, vis, grid, shape, i, j);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    private void dfs(int row, int col, int[][] visited,
            int[][] grid, ArrayList<String> shape, int row0, int col0) {

        visited[row][col] = 1;
        shape.add(toString(row - row0, col - col0));

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir: dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            // check for valid unvisited land neighbour coordinates
            if (isSafe(visited, grid, nrow, ncol)) {
                dfs(nrow, ncol, visited, grid, shape, row0, col0);
            }
        }
    }

    private boolean isSafe(int[][] visited, int[][] grid, int nrow, int ncol) {
        int m = grid.length, n = grid[0].length;
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1;
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + ":" + Integer.toString(c);
    }
}
