package edu.algos.li18_graph_grid.medium;

import java.util.HashSet;

public class L200_Dfs_NumberOfIslands {

	public static void main(String[] args) {
		L200_Dfs_NumberOfIslands obj = new L200_Dfs_NumberOfIslands();
		char[][] grid = new char[][] {
			{'0', '1'},
			{'1', '0'},
			{'1', '1'},
			{'1', '0'},
		};
		System.out.println(obj.numIslands(grid));

	}

    // Problem: https://leetcode.com/problems/number-of-islands/
    // Idea: Do dfs from each cell in matrix which explores the complete island and return. Once it return count it as one island. 
    // From each cell we have to dfs in 4 directions to explore the island completely.
    // While exploring a cell change its value to 0 so that it won't be explored again. 
    // If you don't want to tamper input array, you need to use extra visited matrix.
	public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j, int m, int n){
        if(isSafe(grid, i, j, m, n)){
            grid[i][j] = '0';
            dfs(grid, i+1, j, m, n);
            dfs(grid, i-1, j, m, n);
            dfs(grid, i, j+1, m, n);
            dfs(grid, i, j-1, m, n);
        }
    }
    
    private boolean isSafe(char[][] grid, int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1';
    }
}
