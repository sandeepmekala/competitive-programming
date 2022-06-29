package edu.algos.backtrack;

public class NQueenProblem {
	public static void main(String args[]) {
		NQueenProblem nqueen = new NQueenProblem();
		int board[][] = { 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 } };

		if (nqueen.solveNQueen(board, 0) == false) {
			System.out.print("Solution does not exist");
		}
		nqueen.print(board);
	}
	
	// Question: Place N queens on a board so that they don't attach each other
	// Concept: For each row, recursively check if col gives solution. Else, increment col. If none of the cols give solution, increment row.
	// Time complexity: O(4^n) as we start by placing 4 queens in each row and col 0. Each recursion checks for different col. It will be tree with 4 children and col depth.
	// Space complexity: O(n^2)
	final int N = 4;
	
	boolean solveNQueen(int board[][], int col) {
		if (col >= N) {
			return true;
		}
		
		for (int row = 0; row < N; row++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;

				if (solveNQueen(board, col + 1)) {
					return true;
				}

				board[row][col] = 0; // Backtrack
			}
		}
		return false;
	}

	boolean isSafe(int board[][], int curRow, int curCol) {
		int i, j;

		// left side
		for (i = 0; i < curCol; i++)
			if (board[curRow][i] == 1)
				return false;

		// upper diagonal
		for (i = curRow, j = curCol; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		// lower diagonal
		for (i = curRow, j = curCol; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}
	
	void print(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}
}
