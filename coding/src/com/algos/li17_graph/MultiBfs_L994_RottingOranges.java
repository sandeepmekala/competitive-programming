package  com.algos.li17_graph;

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
    // Idea: We have to multi source bfs and increase time for every level.
    // We need to count the fresh nodes and load all the roatten oranges to queue
    // In every step, for every orange in queue, check in its 4 direction, if you find a rotten orange make it rotten, reduce the fresh counter and load the rotten one to queue.
    // Run this algo until there no more fresh oranges, or there no rotten orange can reach remaining fresh one's.
	public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    queue.add(new int[] {i,j});
            }
        }
        
        int minutes = 0;
        while(fresh > 0 &&  !queue.isEmpty()){           
            int size = queue.size();
            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int i=0; i<size; i++){
                int[] curr = queue.remove();
                for(int[] dir: directions) {
                	int nrow = curr[0]+dir[0];
                	int ncol = curr[1]+dir[1];
                	if(isSafe(grid, nrow, ncol)){
                        queue.add(new int[] {nrow, ncol});
                        grid[nrow][ncol] = 2;
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return (fresh == 0)?minutes:-1;
    }
    
    private boolean isSafe(int[][] grid, int i, int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 1;
    }
}
