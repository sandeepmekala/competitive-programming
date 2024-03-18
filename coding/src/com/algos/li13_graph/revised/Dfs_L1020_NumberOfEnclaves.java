package  com.algos.li13_graph.revised;

import java.util.LinkedList;
import java.util.Queue;

public class Dfs_L1020_NumberOfEnclaves {
    public static void main(String[] args){
        Dfs_L1020_NumberOfEnclaves obj = new Dfs_L1020_NumberOfEnclaves();

        int grid[][] = {
        {0, 0, 0, 0},
        {1, 0, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0}};

        int ans = obj.numEnclaves(grid);
        System.out.println(ans);
    }  
    
    // Problem: https://leetcode.com/problems/number-of-enclaves/
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length; 

        int vis[][] = new int[m][n]; 
        for(int i = 0;i<m;i++) {
            for(int j = 0 ; j<n;j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) 
                    if(vis[i][j] == 0 && grid[i][j] == 1) 
                        dfs(i, j, vis, grid); 
            }
        }
        
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) 
                    count++; 
            }
        }
        return count;         
    }

    private void dfs(int row, int col,int vis[][], int grid[][]) {
        if (!isSafe(vis, grid, row, col)) 
            return;     

        vis[row][col] = 1; 
        dfs(row+1, col, vis, grid);
        dfs(row-1, col, vis, grid);
        dfs(row, col+1, vis, grid);
        dfs(row, col-1, vis, grid);
    }

    private boolean isSafe(int[][] vis, int[][] grid, int nrow, int ncol) {
        int m = grid.length, n = grid[0].length;
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1;
    }
}