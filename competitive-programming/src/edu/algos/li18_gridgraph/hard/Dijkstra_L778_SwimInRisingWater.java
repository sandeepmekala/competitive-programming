package edu.algos.li18_gridgraph.hard;

import java.util.PriorityQueue;

public class Dijkstra_L778_SwimInRisingWater {

	public static void main(String[] args) {
		Dijkstra_L778_SwimInRisingWater obj = new Dijkstra_L778_SwimInRisingWater();
		
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
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int sTodMaxTime = curr[0], si = curr[1], sj = curr[2];
            if(si == m-1 && sj == n-1){
                return sTodMaxTime;
            }
            if(isSafe(grid, si, sj, visited)){
                visited[si][sj] = true;
                int[][] directions = new int[][]{{1,0}, {-1,0},  {0,1}, {0,-1}};
                for(int[] direction: directions){
                    int di = si+direction[0], dj = sj+direction[1];
                    if(isSafe(grid, di, dj, visited)){
                        q.add(new int[]{
                            Math.max(sTodMaxTime, grid[di][dj]), di, dj
                        });
                    }
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
