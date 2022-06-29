package edu.algos.backtrack;

import java.util.HashSet;

import edu.algos.model.Pair;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch obj = new WordSearch();
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(obj.exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, i, j, 0, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int ind, boolean[][] visited) {
		if (ind == word.length()) {
			return true;
		}

		if (isSafe(board, word, i, j, ind, visited)) {
			visited[i][j] = true;

			boolean result = (dfs(board, word, i + 1, j, ind + 1, visited)) || 
					(dfs(board, word, i - 1, j, ind + 1, visited)) || 
					(dfs(board, word, i, j + 1, ind + 1, visited)) || 
					(dfs(board, word, i, j - 1, ind + 1, visited));

			if (result) {
				return true;
			}
			visited[i][j] = false;
		}

		return false;

	}

	private boolean isSafe(char[][] board, String word, int i, int j, int ind, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]
				|| word.charAt(ind) != board[i][j]) {
			return false;
		}
		return true;
	}
}
