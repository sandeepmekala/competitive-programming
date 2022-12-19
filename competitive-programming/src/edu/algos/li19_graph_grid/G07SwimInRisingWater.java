package edu.algos.li19_graph_grid;

import java.util.PriorityQueue;

public class G07SwimInRisingWater {

	public static void main(String[] args) {
		G07SwimInRisingWater obj = new G07SwimInRisingWater();
		
		int[][] grid = new int[][]{{0,2},{1,3}};
		System.out.println(obj.swimInWater(grid));
		
	}
	
	public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
            return a[0] - b[0];
        });
        int[][] directions = new int[][]{{1,0}, {-1,0},  {0,1}, {0,-1}};
        q.add(new int[]{grid[0][0], 0, 0});
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int stodt = curr[0], si = curr[1], sj = curr[2];
            if(si == m-1 && sj == n-1){
                return stodt;
            }
            if(isSafe(grid, si, sj, visited)){
                visited[si][sj] = true;
                for(int[] direction: directions){
                    int di = si+direction[0], dj = sj+direction[1];
                    if(isSafe(grid, di, dj, visited)){
                        q.add(new int[]{
                            Math.max(stodt, grid[di][dj]), di, dj
                        });
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isSafe(int[][] grid, int i, int j, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(i>=0 && i<m && j>=0 && j<n && !visited[i][j]){
            return true;
        }
        return false;
    }

}
