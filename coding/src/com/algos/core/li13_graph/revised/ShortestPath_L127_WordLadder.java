package com.algos.core.li13_graph.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPath_L127_WordLadder {

	public static void main(String[] args) {
		ShortestPath_L127_WordLadder obj = new ShortestPath_L127_WordLadder();
		List<String> list = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		System.out.println(obj.ladderLength("hit", "cog", list));	// 5
	}

	// Problem: https://leetcode.com/problems/word-ladder/
	// Idea: Create patterns by placing * at each position of each word. Create a
	// map of pattern to words.
	// cat is reachable from bat as they belong to same patter *at. It forms a
	// graph.
	// Do short path with unit distanc to find the gest node
	public int ladderLength(String startWord, String target, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList); 	// to check if word is present in list or not

		Queue<Pair> q = new LinkedList<>();
		Set<String> vis = new HashSet<>();
		q.add(new Pair(startWord, 1));
		vis.add(startWord);
		while (!q.isEmpty()) {
			Pair curr = q.remove();
			String word = curr.word;
			int length = curr.length;

			if (word.equals(target) == true)
				return length;

			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char wordArray[] = word.toCharArray();
					wordArray[i] = ch;
					String tranfrmdWord = new String(wordArray);
					if (!set.contains(tranfrmdWord))
						continue;

					if (!vis.contains(tranfrmdWord)) {
						vis.add(tranfrmdWord);
						q.add(new Pair(tranfrmdWord, length + 1));
					}
				}

			}
		}
		// If there is no transformation sequence possible
		return 0;
	}
}

class Pair {
	String word;
	int length;

	public Pair(String word, int length) {
		this.word = word;
		this.length = length;
	}
}