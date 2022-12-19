package edu.algos.li19_graph_grid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.algos.li00_model.Pair;

public class G04RottingOranges {

	public static void main(String[] args) {
		G04RottingOranges obj = new G04RottingOranges();
//		int[][] grid = new int[][]{
//			{2,1,1},
//			{1,1,0},
//			{0,1,1}};
		int[][] grid = new int[][]{
			{1,2}};
		System.out.println(obj.orangesRotting(grid));
	}

	// multi source bfs
	public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                
                if(grid[i][j] == 2){
                    queue.add(new int[] {i,j});
                }
            }
        }
        
        int minutes = 0;
        while(fresh > 0 &&  !queue.isEmpty()){
            List<int[]> list = new ArrayList<>();
            while(!queue.isEmpty()){
                list.add(queue.remove());
            }
            
            int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int[] rotten: list){
                for(int[] direction: directions) {
                	int row = rotten[0]+direction[0];
                	int col = rotten[1]+direction[1];
                	if(isSafe(grid, row, col)){
                        queue.add(new int[] {row, col});
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return (fresh == 0)?minutes:-1;
    }
    
    private boolean isSafe(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1){
            return true;
        }
        return false;
    }
}
