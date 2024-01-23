package  com.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashSet;

public class _Dfs_L694_NumberOfDistinctIslands {
    public static void main(String[] args) {
        _Dfs_L694_NumberOfDistinctIslands ob = new _Dfs_L694_NumberOfDistinctIslands();
        int grid[][] = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 } };

        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }

    public int countDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int visited[][] = new int[m][n];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(i, j, visited, grid, shape, i, j);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    private void dfs(int row, int col, int[][] visited,
            int[][] grid, ArrayList<String> shape, int baserow, int basecol) {
        int m = grid.length, n = grid[0].length;

        visited[row][col] = 1;
        shape.add(toString(row - baserow, col - basecol));

        int drow[] = { -1, 0, +1, 0 };
        int dcol[] = { 0, -1, 0, +1 };
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            // check for valid unvisited land neighbour coordinates
            if (isSafe(visited, grid, m, n, nrow, ncol)) {
                dfs(nrow, ncol, visited, grid, shape, baserow, basecol);
            }
        }
    }

    private boolean isSafe(int[][] visited, int[][] grid, int m, int n, int nrow, int ncol) {
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1;
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
