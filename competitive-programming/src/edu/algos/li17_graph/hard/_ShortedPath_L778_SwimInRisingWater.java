package edu.algos.li17_graph.hard;

import java.util.PriorityQueue;

public class _ShortedPath_L778_SwimInRisingWater {

	public static void main(String[] args) {
		_ShortedPath_L778_SwimInRisingWater obj = new _ShortedPath_L778_SwimInRisingWater();
		
		int[][] grid = new int[][]{{0,2},{1,3}};
		System.out.println(obj.swimInWater(grid));
		
	}
	
    // Problem: https://leetcode.com/problems/swim-in-rising-water/
    // Idea: We need to track the horizon frontier and always take min and swim in that direction in to expand frontier.
    // Once the frontier reach botton-right return the max
	public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[0] - b[0]);
        q.add(new int[]{grid[0][0], 0, 0});     // max, i, j
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int max = curr[0], row = curr[1], col = curr[2];
            if(row == m-1 && col == n-1)
                return max;
                
            int[][] directions = new int[][]{{1,0}, {-1,0},  {0,1}, {0,-1}};
            for(int[] direction: directions){
                int nrow = row+direction[0], ncol = col+direction[1];
                if(isSafe(grid, nrow, ncol, visited)){
                    visited[nrow][ncol] = true;
                    q.add(new int[]{
                        Math.max(max, grid[nrow][ncol]), nrow, ncol
                    });
                }
            }
        }
        
        return -1;
    }
    
    private boolean isSafe(int[][] grid, int i, int j, boolean[][] visited){
        int m = grid.length, n = grid[0].length;
        return i>=0 && i<m && j>=0 && j<n && !visited[i][j];
    }

}
