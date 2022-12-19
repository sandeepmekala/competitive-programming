package edu.algos.li19_graph_grid;

import java.util.Arrays;

public class FloodFill {

	public static void main(String[] args) {
		FloodFill obj = new FloodFill();
		
		int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
		int[][] newImage = obj.floodFill(image, 1, 1, 2);
		for(int[] row: newImage) {
			System.out.println(Arrays.toString(row));
		}
	}

	/*
	 * Problem: https://leetcode.com/problems/flood-fill/
	 *	 
	 * */
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int color, int newColor) {
        if(isSafe(image, i, j, color)){
            image[i][j] = newColor;
            dfs(image, i+1, j, color, newColor);
            dfs(image, i-1, j, color, newColor);
            dfs(image, i, j+1, color, newColor);
            dfs(image, i, j-1, color, newColor);
        }
    }
    
    private boolean isSafe(int[][] image, int i, int j, int color) {
        int m = image.length, n = image[0].length;
        if(i>=0 && i<m && j>=0 && j<n && color == image[i][j]) return true;
        return false;
    }
}
