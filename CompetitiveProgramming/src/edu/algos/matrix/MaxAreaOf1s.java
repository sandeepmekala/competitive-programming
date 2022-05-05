package edu.algos.matrix;

public class MaxAreaOf1s {

	public static void main(String[] args) {
		MaxAreaOf1s obj = new MaxAreaOf1s();
		int[][] grid = new int[][] {
			{1, 1, 1, 0 },
			{0, 0, 1, 0 },
			{0, 0, 0, 1 }
		};
		System.out.println(obj.findMaxArea(grid));
	}
	public int findMaxArea(int[][] grid)
    {   
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(isSafe(grid, visited, i, j, m, n)){
                    int area = dfs(grid, visited, i, j, m, n);
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n){
    	int area = 0;
        if(isSafe(grid, visited, i, j, m, n)){
            visited[i][j] = true;
            area += 1;
            
            area += dfs(grid, visited, i+1, j, m, n);
            area += dfs(grid, visited, i, j+1, m, n);
            area += dfs(grid, visited, i-1, j, m, n);
            area += dfs(grid, visited, i, j-1, m, n);
            
            area += dfs(grid, visited, i-1, j-1, m, n);
            area += dfs(grid, visited, i+1, j+1, m, n);
            area += dfs(grid, visited, i+1, j-1, m, n);
            area += dfs(grid, visited, i-1, j+1, m, n);
        }
        return area;
    }
    private boolean isSafe(int[][] grid, boolean[][] visited, int i, int j, int m, int n){
        if(i>=0 && i<m && j>=0 && j<n && !visited[i][j] && grid[i][j] == 1){
            return true;
        }
        return false;
    }
}
