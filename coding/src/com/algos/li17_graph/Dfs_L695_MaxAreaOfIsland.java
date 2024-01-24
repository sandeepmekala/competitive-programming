package  com.algos.li17_graph;

public class Dfs_L695_MaxAreaOfIsland {

	public static void main(String[] args) {
		Dfs_L695_MaxAreaOfIsland obj = new Dfs_L695_MaxAreaOfIsland();
		int[][] grid = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, 0 }, };
		System.out.println(obj.maxAreaOfIsland(grid));
	}

	// Problem: https://leetcode.com/problems/max-area-of-island/
	// Idea: Idea is same as number of island problem.
	// Just the we calculate and return area from recursion call
	public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
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
        if(!isSafe(grid, m, n, i, j))
            return 0;
        
        grid[i][j] = 0;
            
        int area = 1;
        area += dfs(grid, m, n, i-1, j);
        area += dfs(grid, m, n, i+1, j);
        area += dfs(grid, m, n, i, j-1);
        area += dfs(grid, m, n, i, j+1);
        return area;
    }

    private boolean isSafe(int[][] grid, int m, int n, int i, int j) {
        return i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1;
    }
}
