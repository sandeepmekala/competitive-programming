package li13_graph;

import java.util.LinkedList;
import java.util.Queue;

public class MultiBfs_L994_RottingOranges {

	public static void main(String[] args) {
		MultiBfs_L994_RottingOranges obj = new MultiBfs_L994_RottingOranges();
//		int[][] grid = new int[][]{
//			{2,1,1},
//			{1,1,0},
//			{0,1,1}};
		int[][] grid = new int[][]{
			{1,2}};
		System.out.println(obj.orangesRotting(grid));
	}

	// Problem: https://leetcode.com/problems/rotting-oranges/
    // 1 -> fresh, 2 -> rotten, 0 -> empty
    // Idea: We have to multi source bfs and increase time for every level.
    // We need to count the fresh nodes and load all the roatten oranges to queue
    // In every step, for every orange in queue, check in its 4 direction, if you find a rotten orange make it rotten, reduce the fresh counter and load the rotten one to queue.
    // Run this algo until there no more fresh oranges, or there no rotten orange can reach remaining fresh one's.
	// Time: O(n*m), Space: O(n*m)
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] vis = new int[m][n];
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j,0});   // x,y,mins
                    vis[i][j] = 2;              // we will use 2 for visited/rottened
                }
            }
        }

        int maxMins = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int row = curr[0], col = curr[1], mins = curr[2];
            maxMins = Math.max(maxMins, mins); // max of all minutes

            for (int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if (isSafe(grid, nrow, ncol, vis)) {
                    vis[nrow][ncol] = 2;
                    q.add(new int[] { nrow, ncol, mins + 1 });  // pushing mins to q so that we don't need to do level wise traversal
                    fresh--;
                }
            }
        }
        return (fresh == 0)? maxMins: -1;
    }

    private boolean isSafe(int[][] grid, int i, int j, int[][] vis){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 1 && vis[i][j] != 2;
    }
}
