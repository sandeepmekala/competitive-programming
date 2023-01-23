package edu.algos.li18_graph_grid.easy;

import java.util.Arrays;

public class Dfs_L661_ImageSmoother {

	public static void main(String[] args) {
		Dfs_L661_ImageSmoother obj = new Dfs_L661_ImageSmoother();
		
		int[][] img = new int[][]{
			{100,200,100},
			{200,50,200},
			{100,200,100}
			};
			
		int[][] result = obj.imageSmoother(img);
		for(int[] row: result) {
			System.out.println(Arrays.toString(row));
		}
		
	}
	
	/*
	 * Problem: https://leetcode.com/problems/image-smoother/
     * Idea: Run 3 loops, 2 for matrix one inner loop over 8 directions to calculate sum and count of cells to calculate avg.
	 * TODO
     * */
	public int[][] imageSmoother(int[][] img) {
        int m=img.length, n=img[0].length;
        
        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,0}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int[][] result = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum=0, count=0;
                for(int[] direction: directions){
                    int r = i+direction[0], c = j+direction[1];
                    if(isSafe(img, r, c)){
                        sum += img[r][c];
                        count ++;
                    }
                }
                
                result[i][j] = sum/count;
            }
        }
        
        return result;
    }
    
    private boolean isSafe(int[][] img, int i, int j){
        int m=img.length, n=img[0].length;
        
        return i>=0 && i<m && j>=0 && j<n;
    }

}
