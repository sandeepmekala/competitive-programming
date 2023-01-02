package edu.algos.li18_graph_grid.medium;

import java.util.HashSet;

public class L695_Dfs_MaxAreaOfIsland {

	public static void main(String[] args) {
		L695_Dfs_MaxAreaOfIsland obj = new L695_Dfs_MaxAreaOfIsland();
		int[][] grid = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, 0 }, };
		System.out.println(obj.maxAreaOfIsland(grid));
	}

	// Problem: https://leetcode.com/problems/max-area-of-island/
	// Idea: Idea is same as number of island problem.
	// Just the we calculate and return area from recursion call
	public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isSafe(grid, m, n, i, j)){
                    int area = dfs(grid, m, n, i, j);
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int m, int n, int i, int j){
        int area = 0;
        if(isSafe(grid, m, n, i, j)){
			grid[i][j] = 0;
        	area++;
            
            area += dfs(grid, m, n, i-1, j);
            area += dfs(grid, m, n, i+1, j);
            area += dfs(grid, m, n, i, j-1);
            area += dfs(grid, m, n, i, j+1);

        }
        return area;
    }
    
    private boolean isSafe(int[][] grid, int m, int n, int i, int j){
        return i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1;
    }
}
