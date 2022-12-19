package edu.algos.li19_graph_grid;

import java.util.Arrays;

public class ImageSmoother {

	public static void main(String[] args) {
		ImageSmoother obj = new ImageSmoother();
		
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
	 * */
	public int[][] imageSmoother(int[][] img) {
        int m=img.length;
        int n=img[0].length;
        
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
        int m=img.length;
        int n=img[0].length;
        
        if(i>=0 && i<m && j>=0 && j<n) return true;
        return false;
    }

}
