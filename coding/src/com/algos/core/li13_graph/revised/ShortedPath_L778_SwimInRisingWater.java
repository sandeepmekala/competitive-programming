package  com.algos.core.li13_graph.revised;

import java.util.PriorityQueue;

public class ShortedPath_L778_SwimInRisingWater {

	public static void main(String[] args) {
		ShortedPath_L778_SwimInRisingWater obj = new ShortedPath_L778_SwimInRisingWater();
		
		int[][] grid = new int[][]{{0,2},{1,3}};
		System.out.println(obj.swimInWater(grid));
	}
	
    // Problem: https://leetcode.com/problems/swim-in-rising-water/
    // Idea: We need to track the horizon frontier and always take min and swim in that direction in to expand frontier.
    // Once the frontier reach botton-right return the max
	public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] vis = new int[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[0] - b[0]);
        q.add(new int[]{grid[0][0], 0, 0});     // {time/max-height, r, c}
        vis[0][0] = 1;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int max = curr[0], row = curr[1], col = curr[2];
            if(row == m-1 && col == n-1)
                return max;
                
            int[][] dirs = new int[][]{{1,0}, {-1,0},  {0,1}, {0,-1}};
            for(int[] dir: dirs){
                int nrow = row+dir[0], ncol = col+dir[1];
                if(isSafe(grid, nrow, ncol, vis)){
                    vis[nrow][ncol] = 1;            // just to avoid adding same cell again
                    q.add(new int[]{
                        Math.max(max, grid[nrow][ncol]), nrow, ncol
                    });
                }
            }
        }
        
        return -1;
    }
    
    private boolean isSafe(int[][] grid, int i, int j, int[][] visited){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length && visited[i][j]==0;
    }

}
