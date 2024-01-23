package  com.algos.li17_graph;

import java.util.LinkedList;
import java.util.Queue;

public class _MultiBfs_L1020_NumberOfEnclaves {
    public static void main(String[] args){
        _MultiBfs_L1020_NumberOfEnclaves obj = new _MultiBfs_L1020_NumberOfEnclaves();

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

        Queue<Pair3> q = new LinkedList<Pair3>();
        int visited[][] = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                    if(grid[i][j] == 1 && visited[i][j] == 0) {
                        visited[i][j] = 1; 
                        q.add(new Pair3(i, j)); 
                    }
                }
            }
        }
        
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, +0, -1}; 
        while(!q.isEmpty()) {
            Pair3 curr = q.remove(); 
            int row = curr.row; 
            int col = curr.col; 
            
            for(int i = 0;i<4;i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i]; 
                if(isSafe(grid, m, n, visited, nrow, ncol)) {
                    visited[nrow][ncol] = 1; 
                    q.add(new Pair3(nrow, ncol));
                }
            }
        }
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) 
                    count++; 
            }
        }
        return count;         
    }

    private boolean isSafe(int[][] grid, int m, int n, int[][] visited, int nrow, int ncol) {
        return nrow >=0 && nrow <m && ncol >=0 && ncol < n 
                && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1;
    }
}
class Pair3 {
    int row;
    int col; 
    public Pair3(int first, int second) {
        this.row = first; 
        this.col = second; 
    }
}