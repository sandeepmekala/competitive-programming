package edu.algos.li19_backtracking.medium;

import java.util.Arrays;

public class A01_RatMaze {

	static int n;

	public static void main(String args[]) {
		A01_RatMaze rat = new A01_RatMaze();
		int maze[][] = {
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 1 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 1 }
		};

		rat.solveMaze(maze);
	}

	public void solveMaze(int maze[][]) {
		int n = maze.length;
		int sol[][] = new int[n][n];

		if (solveMaze(maze, 0, 0, sol)) 
			print(sol);
		else
			System.out.print("Solution doesn't exist");
	}

	boolean solveMaze(int maze[][], int i, int j, int vis[][]) {
		int n = maze.length;
		if (i == n - 1 && j == n - 1) {
			vis[i][j] = 1;
			return true;
		}

		int[][] directions = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
		for(int[] direction: directions){
			int row = i+direction[0], col = j+direction[1]; 
			if (isSafe(maze, row, col, vis)) {
				vis[row][col] = 1;
				if (solveMaze(maze, row, col, vis))
					return true;
				vis[row][col] = 0; 	// backtrack
			}
		}
		
		return false;
	}

	private boolean isSafe(int[][] maze, int i, int j, int[][] sol) {
		int n = maze.length;
		return i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && sol[i][j] == 0;
	}

	void print(int sol[][]) {
		int n = sol.length;
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(sol[i]));
		}
	}

}