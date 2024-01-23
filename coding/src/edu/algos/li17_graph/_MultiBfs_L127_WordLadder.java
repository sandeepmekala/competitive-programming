package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _MultiBfs_L127_WordLadder {

	public static void main(String[] args) {
		_MultiBfs_L127_WordLadder obj = new _MultiBfs_L127_WordLadder();
		List<String> list = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		System.out.println(obj.ladderLength("hit", "cog", list));
	}

	// Problem: https://leetcode.com/problems/word-ladder/
	// Idea: Create patterns by placing * at each position of each word. Create a map of pattern to words.
	// cat is reachable from bat as they belong to same patter *at. It forms a graph.
	// Do multi source bfs and for each level track length. Once target word is found, return length.
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);
		HashMap<String, ArrayList<String>> patToWord = new HashMap<>();
		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
				if (!patToWord.containsKey(pattern)) 
					patToWord.put(pattern, new ArrayList<String>());
				
				patToWord.get(pattern).add(word);
			}
		}

		Queue<String> q = new LinkedList<String>();
		HashSet<String> visited = new HashSet<>();
		q.add(beginWord);
		visited.add(beginWord);
		int length = 1;			// as begin word is already counted
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.remove();
				if(word.equals(endWord)) 
					return length;
				
				for (int j = 0; j < word.length(); j++) {
					String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
					for (String neigh : patToWord.get(pattern)) {
						if(!visited.contains(neigh)){
							visited.add(neigh);
							q.add(neigh);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}

}
