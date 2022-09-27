package edu.algos.li18.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G13WordLadder {

	public static void main(String[] args) {
		G13WordLadder obj = new G13WordLadder();
		List<String> list = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		System.out.println(obj.ladderLength("hit", "cog", list));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);

		HashMap<String, ArrayList<String>> pattoword = new HashMap<>();

		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
				if (!pattoword.containsKey(pattern)) {
					pattoword.put(pattern, new ArrayList<String>());
				}
				pattoword.get(pattern).add(word);
			}
		}

		Queue<String> q = new LinkedList<String>();
		HashSet<String> visited = new HashSet<>();
		q.add(beginWord);
		int length = 1;
		while (!q.isEmpty()) {
			int qlen = q.size();
			for (int i = 0; i < qlen; i++) {
				String word = q.remove();
				if(word.equals(endWord)) {
					return length;
				}
				if (!visited.contains(word)) {
					visited.add(word);
					for (int j = 0; j < word.length(); j++) {
						String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
						for (String neigh : pattoword.get(pattern)) {
							if(!visited.contains(neigh))
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
