package li13_graph;

import java.util.Arrays;

public class Dfs_L733_FloodFill {

	public static void main(String[] args) {
		Dfs_L733_FloodFill obj = new Dfs_L733_FloodFill();

		int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
		int[][] newImage = obj.floodFill(image, 1, 1, 2);
		for(int[] row: newImage) {
			System.out.println(Arrays.toString(row));
		}
	}

	/*
	 * Problem: https://leetcode.com/problems/flood-fill/
	 * Idea: Do dfs recursively in 4 directions and pass first src cell color and new color
     * If the color of current cell is same as src color, change it to new color.
	 * */
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc])
            return image;

        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int srcCol, int newColor) {
        if(!isSafe(image, i, j, srcCol))
            return;

        image[i][j] = newColor;

        dfs(image, i+1, j, srcCol, newColor);
        dfs(image, i-1, j, srcCol, newColor);
        dfs(image, i, j+1, srcCol, newColor);
        dfs(image, i, j-1, srcCol, newColor);
    }

    private boolean isSafe(int[][] image, int i, int j, int srcColor) {
        int m = image.length, n = image[0].length;
        return i>=0 && i<m && j>=0 && j<n && srcColor == image[i][j];
    }
}
