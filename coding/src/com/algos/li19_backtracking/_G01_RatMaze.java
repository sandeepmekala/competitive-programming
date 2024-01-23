package  com.algos.li19_backtracking;

import java.util.Arrays;

public class _G01_RatMaze {

	static int n;

	public static void main(String args[]) {
		_G01_RatMaze obj = new _G01_RatMaze();
		int maze[][] = {
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 1 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 1 }
		};

		obj.solveMaze(maze);
	}

	// Problem: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
	public void solveMaze(int maze[][]) {
		int n = maze.length;
		int vis[][] = new int[n][n];

		if (solveMaze(maze, 0, 0, vis)) 
			print(vis);
		else
			System.out.print("Solution doesn't exist");
	}

	// Time: O(4^n*n)
	// Space: O(n*n)
	boolean solveMaze(int maze[][], int i, int j, int visited[][]) {
		int n = maze.length;
		if (i == n - 1 && j == n - 1) 
			return true;

		int[][] directions = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
		for(int[] dir: directions){
			int ni = i+dir[0], nj = j+dir[1]; 
			if (isSafe(maze, ni, nj, visited)) {
				visited[ni][nj] = 1;
				if (solveMaze(maze, ni, nj, visited))
					return true;
				visited[ni][nj] = 0; 	// backtrack
			}
		}
		
		return false;
	}

	private boolean isSafe(int[][] maze, int ni, int nj, int[][] vis) {
		int n = maze.length;
		return ni >= 0 && ni < n && nj >= 0 && nj < n && maze[ni][nj] == 1 && vis[ni][nj] == 0;
	}

	void print(int sol[][]) {
		int n = sol.length;
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(sol[i]));
		}
	}

}