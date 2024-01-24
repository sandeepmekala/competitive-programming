package  com.algos.li16_trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import  com.algos.li30_model.TrieNode;

public class L212_WordSearchII {

	public static void main(String[] args) {
		L212_WordSearchII obj = new L212_WordSearchII();
		
		char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = new String[] {"oath","pea","eat","rain"};
		System.out.println(obj.findWords(board, words));

	}

	/*
	 * Problem: https://leetcode.com/problems/word-search-ii/
	 * Idea: Build a trie of all the words
	 * Do dfs of the grid and track the word that is being formed. If each char in that is going into word, track its trie node.
	 * If trie node is eow, then add word to result;
	 * 
	 * */
	TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words)
            add(word);
        
        int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];	// needed to to make sure same cell is not explored. 
		HashSet<String> res = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, root, i, j, "", visited, res);
			}
		}
		List<String> result = new ArrayList<String>();
		result.addAll(res);
		return result;
    }
    
    private void dfs(char[][] board, TrieNode node, int i, int j, String word, boolean[][] visited, HashSet<String> res) {
		if (isSafe(board, node, i, j, word, visited)) {
			visited[i][j] = true;	// mark the explore cells to that they are not reconsidered.

			node = node.map.get(board[i][j]);
			word += board[i][j]; 
			if(node.endOfWord) 
				res.add(word);
			
			dfs(board, node, i + 1, j, word, visited, res); 
			dfs(board, node, i - 1, j, word, visited, res);
			dfs(board, node, i, j + 1, word, visited, res);
			dfs(board, node, i, j - 1, word, visited, res);

			visited[i][j] = false;		// once dfs is done from this cell, make it available for dfs from other cells.
		}

	}

	private boolean isSafe(char[][] board, TrieNode node, int i, int j, String word, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]
				|| !node.map.containsKey(board[i][j]) ) {
			return false;
		}
		return true;
	}

	private void add(String word) {
		TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.map.containsKey(ch)){
                TrieNode newNode = new TrieNode();
                current.map.put(ch, newNode);
            }
            current = current.map.get(ch);
        }
        current.endOfWord = true;	// after new node is created current will be pointing to new node after for loop
	}
}
