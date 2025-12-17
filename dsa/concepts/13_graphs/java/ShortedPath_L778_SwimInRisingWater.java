
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortedPath_L778_SwimInRisingWater {

	public static void main(String[] args) {
		ShortedPath_L778_SwimInRisingWater obj = new ShortedPath_L778_SwimInRisingWater();

		int[][] grid = {
            {0,2},
            {1,3}};
		System.out.println(obj.swimInWater(grid));
	}

    // Problem: https://leetcode.com/problems/swim-in-rising-water/
    // Idea: We need to track the horizon frontier and always take min and swim in that direction in to expand frontier.
    // Once the frontier reach botton-right return the max
	public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<int[]> q = new PriorityQueue<>((a, b)->a[0] - b[0]);
        q.add(new int[]{grid[0][0], 0, 0});     // {time or max-height, r, c}
        vis[0][0] = 1;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int max = curr[0], i = curr[1], j = curr[2];
            if(i == m-1 && j == n-1)
                return max;

            int[][] dirs = new int[][]{{1,0}, {-1,0},  {0,1}, {0,-1}};
            for(int[] dir: dirs){
                int ni = i+dir[0], nj = j+dir[1];
                if(isSafe(grid, ni, nj, vis)){
                    vis[ni][nj] = 1;            // just to avoid adding same cell again
                    q.add(new int[]{
                        Math.max(max, grid[ni][nj]), ni, nj
                    });
                }
            }
        }

        return -1;
    }

    private boolean isSafe(int[][] grid, int i, int j, int[][] visited){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length &&
            visited[i][j]==0;
    }

}
