package com.algos.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dfs_L417_PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		Dfs_L417_PacificAtlanticWaterFlow obj = new Dfs_L417_PacificAtlanticWaterFlow();
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
		int m = heights.length, n = heights[0].length;
		boolean[][] pvis = new boolean[m][n];	// marks as the feasible cells from two oceans
		boolean[][] avis = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			dfs(heights, i, 0, 0, pvis);	// we need to pass the prev cell heigh as arg to recursion to compare with current cell height
			dfs(heights, i, n-1, 0, avis);
		}
		
		for (int j = 0; j < n; j++) {
			dfs(heights, 0, j, 0, pvis);
			dfs(heights, m-1, j, 0, avis);
		}

		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(pvis[i][j] && avis[i][j]) {
					result.add(Arrays.asList(i,j));
				}
			}
		}
		return result;
	}

	private void dfs(int[][] heights, int i, int j, int pheight, boolean[][] vis) {
		if (!isSafe(heights, i, j, pheight, vis)) 
			return;
		
		vis[i][j] = true;
		dfs(heights, i + 1, j, heights[i][j], vis);
		dfs(heights, i - 1, j, heights[i][j], vis);
		dfs(heights, i, j + 1, heights[i][j], vis);
		dfs(heights, i, j - 1, heights[i][j], vis);
	}

	private boolean isSafe(int[][] heights, int i, int j, int prevHeight, boolean[][] visited) {
		int m = heights.length, n = heights[0].length;
		return i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && heights[i][j] >= prevHeight;
	}
}
