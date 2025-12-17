import java.util.LinkedList;
import java.util.Queue;

public class Dfs_L200_NumberOfIslands {

    public static void main(String[] args) {
        Dfs_L200_NumberOfIslands obj = new Dfs_L200_NumberOfIslands();
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

        int[][] vis = new int[n][m];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] != 1){
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int[][] vis){
        vis[i][j] = 1;

        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
			if (isSafe(grid, ni, nj, vis)) {
				dfs(grid, ni, nj, vis);
			}
		}
    }

    private boolean isSafe(char[][] grid, int i, int j, int[][] vis){
        int m = grid.length, n = grid[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1' && vis[i][j] == 0;
    }

    // Bfs
    public int numIslandsBfs(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] vis = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if not visited and is a land
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }

    // dfs will do with less code
    public void bfs(int i, int j, int[][] vis, char[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<Pair10> q = new LinkedList<Pair10>();
        q.add(new Pair10(i, j));
        vis[i][j] = 1;
        while (!q.isEmpty()) {
            Pair10 curr = q.remove();
            int row = curr.row, col = curr.col;

            for (int drow = -1; drow <= 1; drow++) {
                for (int dcol = -1; dcol <= 1; dcol++) {
                    int nrow = row + drow;
                    int ncol = col + dcol;
                    if (isSafe(vis, grid, nrow, ncol, n, m )) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair10(nrow, ncol));
                    }
                }
            }
        }
    }

    private boolean isSafe(int[][] vis, char[][] grid, int nrow, int ncol, int n, int m) {
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0;
    }
}

class Pair10 {
    int row;
    int col;
    public Pair10(int first, int second) {
        this.row = first;
        this.col = second;
    }
}
