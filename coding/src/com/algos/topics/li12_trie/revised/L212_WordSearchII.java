package  com.algos.topics.li12_trie.revised;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.algos.topics.models.TrieNode;

public class L212_WordSearchII {

	public static void main(String[] args) {
		L212_WordSearchII obj = new L212_WordSearchII();

		char[][] board = {
					{'o','a','a','n'},
					{'e','t','a','e'},
					{'i','h','k','r'},
					{'i','f','l','v'}
				};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(obj.findWords(board, words));

	}

	// Problem: https://leetcode.com/problems/word-search-ii/
	// Idea: Build a trie of all the words
	// Do dfs of the grid and track the word that is being formed. If each char in that is going into word, track its trie node.
	// If trie node is eow, then add word to result
	//
	public List<String> findWords(char[][] board, String[] words) {
		TrieNode root = new TrieNode();
        for(String word: words)
            insert(root, word);

        int m = board.length, n = board[0].length;
		boolean[][] vis = new boolean[m][n];	// needed to make sure same cell is not explored.
		Set<String> ans = new HashSet<>();	// might add duplicate words.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(root.map.containsKey(board[i][j]))
					dfs(board, root, i, j, "", vis, ans);
			}
		}

		return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, TrieNode node, int i, int j, String word, boolean[][] vis,
			Set<String> res) {

		node = node.map.get(board[i][j]);
		word += board[i][j];
		if (node.endOfWord)
			res.add(word);

		vis[i][j] = true; // mark the explore cells so that they are not reconsidered.

		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int[] dir : dirs) {
			int ni = i + dir[0], nj = j + dir[1];
			if (isSafe(board, node, ni, nj, vis)){
				dfs(board, node, ni, nj, word, vis, res);
			}
		}

		vis[i][j] = false; // once dfs is done from this cell, make it available for dfs from other cells.
	}

	private void insert(TrieNode root, String word) {
		TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            curr.map.putIfAbsent(ch, new TrieNode());
            curr = curr.map.get(ch);
        }
        curr.endOfWord = true;	// after new node is created current will be pointing to new node after for loop
	}

	private boolean isSafe(char[][] board, TrieNode node, int i, int j, boolean[][] vis) {
		return i >= 0 && j >= 0 && i < board.length && j < board[i].length
				&& !vis[i][j] && node.map.containsKey(board[i][j]);
	}
}
