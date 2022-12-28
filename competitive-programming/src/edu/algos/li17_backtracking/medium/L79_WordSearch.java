package edu.algos.li17_backtracking.medium;

public class L79_WordSearch {

	public static void main(String[] args) {
		L79_WordSearch obj = new L79_WordSearch();
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(obj.exist(board, word));
	}

	// Problem: https://leetcode.com/problems/word-search/
	// Idea: Do dfs on the grid and check the char at index is matching the board grid char.
	// Pass the index of word in the recursion
	// If index == word len, the return true.
	// CHECK
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

	private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
		if (index == word.length()) {
			return true;
		}

		if (isSafe(board, word, i, j, index, visited)) {
			visited[i][j] = true;

			boolean result = (dfs(board, word, i + 1, j, index + 1, visited)) || 
					(dfs(board, word, i - 1, j, index + 1, visited)) || 
					(dfs(board, word, i, j + 1, index + 1, visited)) || 
					(dfs(board, word, i, j - 1, index + 1, visited));

			if (result) {
				return true;
			}
			visited[i][j] = false;		// backtrack
		}

		return false;

	}

	private boolean isSafe(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]
				|| word.charAt(index) != board[i][j]) {
			return false;
		}
		return true;
	}
}
