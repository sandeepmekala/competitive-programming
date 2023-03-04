package edu.algos.li17_graph.medium;

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

        Queue<Pair> q = new LinkedList<Pair>();
        int visited[][] = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                    if(grid[i][j] == 1) {
                        q.add(new Pair(i, j)); 
                        visited[i][j] = 1; 
                    }
                }
            }
        }
        
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1}; 
        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i]; 
                if(nrow >=0 && nrow <m && ncol >=0 && ncol < n 
                        && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = 1; 
                }
            }
            
        }
        int count = 0;
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(grid[i][j] == 1 & visited[i][j] == 0) 
                    count++; 
            }
        }
        return count;         
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