package edu.algos.li18_gridgraph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L417_Dfs_PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		L417_Dfs_PacificAtlanticWaterFlow obj = new L417_Dfs_PacificAtlanticWaterFlow();
		int[][] heights = new int[][]{
			{1,2,2,3,5},
			{3,2,3,4,4},
			{2,4,5,3,1},
			{6,7,1,4,5},
			{5,1,1,2,4}};
		System.out.println(obj.pacificAtlantic(heights));
	}

	// Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/
	// Idea: Do dfs from 4 border row cells.
	// We need to pass the prev cell heigh as arg to recursion to compare with current cell height.
	// Mark all the reachable cells from pasific and atlantic oceans in respective boolean matrices.
	// Take the common cells from both the matrices in result as they can reach both the oceans.
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] pVisited = new boolean[m][n];	// marks as the feasible cells from two oceans
		boolean[][] aVisited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			dfs(heights, i, 0, heights[i][0], pVisited);
			dfs(heights, i, n-1, heights[i][n-1], aVisited);
		}
		
		
		for (int j = 0; j < n; j++) {
			dfs(heights, 0, j, heights[0][j], pVisited);
			dfs(heights, m-1, j, heights[m-1][j], aVisited);
		}

		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(pVisited[i][j] && aVisited[i][j]) {
					result.add(new ArrayList<Integer>(Arrays.asList(i,j)));
				}
			}
		}
		return result;
	}

	private void dfs(int[][] heights, int i, int j, int prevHeight, boolean[][] visited) {
		if (isSafe(heights, i, j, prevHeight, visited)) {
			visited[i][j] = true;

			dfs(heights, i + 1, j, heights[i][j], visited);
			dfs(heights, i - 1, j, heights[i][j], visited);
			dfs(heights, i, j + 1, heights[i][j], visited);
			dfs(heights, i, j - 1, heights[i][j], visited);
		}
	}

	private boolean isSafe(int[][] heights, int i, int j, int prevHeight, boolean[][] visited) {
		int m = heights.length;
		int n = heights[0].length;

		return i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && heights[i][j] >= prevHeight;
	}
}
