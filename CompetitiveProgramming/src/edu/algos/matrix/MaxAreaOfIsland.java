package edu.algos.matrix;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		MaxAreaOfIsland obj = new MaxAreaOfIsland();
		int[][] grid = new int[][] {
			{0, 1},
			{1, 0},
			{1, 1},
			{1, 0},
		};
		System.out.println(obj.maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isSafe(grid, visited, m, n, i, j)){
                    int area = dfs(grid,visited, m, n, i, j);
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid,boolean[][] visited, int m, int n, int i, int j){
        int area = 0;
        if(isSafe(grid, visited, m, n, i, j)){
        	visited[i][j] = true;
        	area++;
            
            area += dfs(grid, visited, m, n, i-1, j);
            area += dfs(grid, visited, m, n, i+1, j);
            area += dfs(grid, visited, m, n, i, j-1);
            area += dfs(grid, visited, m, n, i, j+1);

        }
        return area;
    }
    
    private boolean isSafe(int[][] grid, boolean[][] visited, int m, int n, int i, int j){
        if(i>=0 && i<m && j>=0 && j<n && !visited[i][j] && grid[i][j] == 1){
            return true;
        }
        return false;
    }
}
