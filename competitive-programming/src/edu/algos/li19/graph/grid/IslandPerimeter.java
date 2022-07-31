package edu.algos.li19.graph.grid;

public class IslandPerimeter {

	public static void main(String[] args) {
		IslandPerimeter obj = new IslandPerimeter();
		
		int[][] gird = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(obj.islandPerimeter(gird));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/island-perimeter/
	 * 
	 * */
	public int islandPerimeter(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    return islandPerimeter(grid, i, j, visited);
            }
        }
        
        return count;
    }
    
    private int islandPerimeter(int[][] grid, int i, int j, boolean[][] visited) {
        if(!isSafe(grid, i, j, visited)) return 1;
        
        if(visited[i][j]) return 0;
        
        visited[i][j] = true;
        int count = 0;
        count += islandPerimeter(grid, i+1, j, visited);
        count += islandPerimeter(grid, i-1, j, visited);
        count += islandPerimeter(grid, i, j+1, visited);
        count += islandPerimeter(grid, i, j-1, visited);
        
        return count;
        
    }
    
    private boolean isSafe(int[][] grid, int i, int j, boolean[][] visited) {
        int m=grid.length, n=grid[0].length;
        if(i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1)
            return true;
        return false;
    }

}
