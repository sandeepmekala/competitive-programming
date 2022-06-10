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
		HashSet<Pair<Integer,Integer>> path = new HashSet<Pair<Integer,Integer>>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(board, word, i, j, 0, path)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int ind, HashSet<Pair<Integer,Integer>> path) {
		if (ind == word.length()) {
			return true;
		}

		if (isSafe(board, word, i, j, ind, path)) {
			Pair<Integer,Integer> pair = new Pair<>(i,j);
			path.add(pair);

			boolean result = (dfs(board, word, i + 1, j, ind + 1, path)) || 
					(dfs(board, word, i - 1, j, ind + 1, path)) || 
					(dfs(board, word, i, j + 1, ind + 1, path)) || 
					(dfs(board, word, i, j - 1, ind + 1, path));

			if (result) {
				return true;
			}
			path.remove(pair);
		}

		return false;

	}

	private boolean isSafe(char[][] board, String word, int i, int j, int ind, HashSet<Pair<Integer, Integer>> path) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || path.contains(new Pair<Integer, Integer>(i, j))
				|| word.charAt(ind) != board[i][j]) {
			return false;
		}
		return true;
	}
}
