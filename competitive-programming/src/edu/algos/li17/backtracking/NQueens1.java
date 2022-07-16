package edu.algos.li17.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens1 {
	public static void main(String args[]) {
		NQueens1 nqueen = new NQueens1();

		System.out.println(nqueen.totalNQueens(4));
	}

	// Question: Place N queens on a board so that they don't attach each other
	// Concept: For each row, recursively check if col gives solution. Else,
	// increment col. If none of the cols give solution, increment row.
	// Time complexity: O(4^n) as we start by placing 4 queens in each row and col
	// 0. Each recursion checks for different col. It will be tree with 4 children
	// and col depth.
	// Space complexity: O(n^2)
	public int totalNQueens(int n) {
		int board[][] = new int[n][n];
		
		return dfs(board, 0);

	}

	private int dfs(int board[][], int col) {
		int n = board.length;
		if (col >= n) {
			return 1;
		}

		int count = 0;
		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;

				count += dfs(board, col + 1);

				board[row][col] = 0; // Backtrack
			}
		}
		
		return count;
	}

	boolean isSafe(int board[][], int curRow, int curCol) {
		int i, j, n = board.length;;

		// left side
		for (i = 0; i < curCol; i++)
			if (board[curRow][i] == 1)
				return false;

		// upper diagonal
		for (i = curRow, j = curCol; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		// lower diagonal
		for (i = curRow, j = curCol; j >= 0 && i < n; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}
}
