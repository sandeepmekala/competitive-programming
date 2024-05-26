package  com.algos.core.li13_graph.revised;

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
        int n = grid.length, m = grid[0].length;

        int[][] vis = new int[n][m];
        int maxArea = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    int area = dfs(grid, i, j, vis);
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j, int[][] vis){
        if(!isSafe(grid, i, j, vis))
            return 0;
        
        vis[i][j] = 1;
            
        int area = 1;
        area += dfs(grid, i-1, j, vis);
        area += dfs(grid, i+1, j, vis);
        area += dfs(grid, i, j-1, vis);
        area += dfs(grid, i, j+1, vis);
        return area;
    }

    private boolean isSafe(int[][] grid, int i, int j, int[][] vis) {
        int m = grid.length, n = grid[0].length;
        return i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1 && vis[i][j] == 0;
    }
}
