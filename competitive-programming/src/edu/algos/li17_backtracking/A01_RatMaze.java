package edu.algos.li17_backtracking;

public class A01_RatMaze {

	static int N;

	public static void main(String args[]) {
		A01_RatMaze rat = new A01_RatMaze();
		int maze[][] = {
				{ 1, 0, 0, 0 },
				{ 1, 1, 0, 1 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 1 }
		};

		N = maze.length;
		rat.solveMaze(maze);
	}

	boolean solveMaze(int maze[][]) {
		int sol[][] = new int[N][N];

		if (!solveMazeUtil(maze, 0, 0, sol)) {
			System.out.print("Solution doesn't exist");
			return false;
		}

		printSolution(sol);
		return true;
	}

	boolean solveMazeUtil(int maze[][], int i, int j,
			int sol[][]) {
		if (i == N - 1 && j == N - 1
				&& maze[i][j] == 1) {
			sol[i][j] = 1;
			return true;
		}

		if (isSafe(maze, i, j, sol)) {
			sol[i][j] = 1;

			if (solveMazeUtil(maze, i + 1, j, sol))
				return true;

			if (solveMazeUtil(maze, i, j + 1, sol))
				return true;

			if (solveMazeUtil(maze, i - 1, j, sol))
				return true;

			if (solveMazeUtil(maze, i, j - 1, sol))
				return true;

			sol[i][j] = 0; 		// backtrack
			return false;
		}
		return false;
	}

	private boolean isSafe(int[][] maze, int i, int j, int[][] sol) {
		return (i >= 0 && i < N && j >= 0 && j < N && maze[i][j] == 1 && sol[i][j] == 0);
	}

	void printSolution(int sol[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(
						" " + sol[i][j] + " ");
			System.out.println();
		}
	}

}