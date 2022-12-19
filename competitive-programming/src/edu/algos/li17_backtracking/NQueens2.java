package edu.algos.li17_backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {
	public static void main(String args[]) {
		NQueens2 nqueen = new NQueens2();

		System.out.println(nqueen.solveNQueens(4));
	}

	// Question: Place N queens on a board so that they don't attach each other
	// Idea: For each row, recursively check if col gives solution. Else,
	// increment col. If none of the cols give solution, increment row.
	// Time complexity: O(4^n) as we start by placing 4 queens in each row and col
	// 0. Each recursion checks for different col. It will be tree with 4 children
	// and col depth.
	// Space complexity: O(n^2)
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		int board[][] = new int[n][n];
		
		dfs(board, 0, result);
		return result;

	}

	private void dfs(int board[][], int col, List<List<String>> result) {
		int n = board.length;
		if (col >= n) {
			List<String> list = new ArrayList<String>();
			for(int i=0; i<board.length; i++) {
				String row = "";
				for(int j=0; j<board[i].length; j++) {
					if(board[i][j] == 1) {
						row += "Q";
					}else {
						row += ".";
					}
				}
				list.add(row);
			}
			result.add(list);
		}

		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col)) {
				board[row][col] = 1;

				dfs(board, col + 1, result);

				board[row][col] = 0; // Backtrack
			}
		}
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
