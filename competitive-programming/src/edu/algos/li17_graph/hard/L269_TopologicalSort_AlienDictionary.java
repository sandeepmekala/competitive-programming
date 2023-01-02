package edu.algos.li17_graph.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class L269_TopologicalSort_AlienDictionary {

	public static void main(String[] args) {
		L269_TopologicalSort_AlienDictionary obj = new L269_TopologicalSort_AlienDictionary();
		
		//String[] words = new String[] {"wrt","wrf","er","ett","rftt"};
		String[] words = new String[] {"zy","zx"};
		System.out.println(obj.alienOrder(words));
	}
	
	// Problem: https://leetcode.com/problems/alien-dictionary/
	// https://www.lintcode.com/problem/892
	// Idea: Words are already sorted lexicographically by the rules of this new language. Hence, we can find the relationship between the chars from adjecent words.
	// Build a relationship graph from adjacent word chars.
	// From this graph reverse topological order is tha answer
	public String alienOrder(String[] words) {
		HashMap<Character, HashSet<Character>> adjlist = new HashMap<>();
		for(String word: words) {
			for(char ch: word.toCharArray()) {
				adjlist.put(ch, new HashSet<Character>());
			}
		}
		
		for(int i=0; i<words.length-1; i++) {
			String w1 = words[i], w2 = words[i+1];
			int minlen = Math.min(w1.length(), w2.length());
			if(w1.length() > w2.length() && w1.substring(0, minlen).equals(w2.substring(0, minlen))) 
				return "";
			
			for(int j=0; j<minlen; j++) {
				if(w1.charAt(j) != w2.charAt(j)) {
					adjlist.get(w1.charAt(j)).add(w2.charAt(j));
					break;		// we have to break as we are sure only first chars are in lex order.
				}
			}
		}
		
		HashSet<Character> visited = new HashSet<>();
		HashSet<Character> exploring = new HashSet<>();
		ArrayList<Character> res = new ArrayList<>();
		for(char chr: adjlist.keySet()) {
			if(dfs(adjlist, chr, res, visited, exploring)) {
				return "";
			}
		}
		StringBuffer sb = new StringBuffer();
		for(Character chr: res) {
			sb.insert(0, chr);
		}
		return sb.toString();
	}

	private boolean dfs(HashMap<Character, HashSet<Character>> adjlist, char chr, ArrayList<Character> res, HashSet<Character> visited,
			HashSet<Character> exploring) {
		if(exploring.contains(chr)) {
			return true;
		}
		
		if(!visited.contains(chr)) {
			visited.add(chr);
			exploring.add(chr);
			for(char neigh: adjlist.get(chr)) {
				if(dfs(adjlist, neigh, res, visited, exploring)) {
					return true;
				}
			}
			exploring.remove(chr);
			res.add(chr);
		}
		return false;
	}

}
