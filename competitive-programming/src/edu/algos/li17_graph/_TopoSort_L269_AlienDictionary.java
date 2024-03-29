package edu.algos.li17_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class _TopoSort_L269_AlienDictionary {

	public static void main(String[] args) {
		_TopoSort_L269_AlienDictionary obj = new _TopoSort_L269_AlienDictionary();
		
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
		HashMap<Character, HashSet<Character>> adjlist = new HashMap<Character, HashSet<Character>>();
		for(String word: words) {
			for(char ch: word.toCharArray()) {
				adjlist.put(ch, new HashSet<Character>());
			}
		}
		
		for(int i=0; i<words.length-1; i++) {
			String w1 = words[i], w2 = words[i+1];
			int minlen = Math.min(w1.length(), w2.length());
			for(int j=0; j<minlen; j++) {
				if(w1.charAt(j) != w2.charAt(j)) {
					adjlist.get(w1.charAt(j)).add(w2.charAt(j));
					break;		// we have to break as we are sure only first chars are in lex order.
				}
			}
		}
		
		HashSet<Character> visited = new HashSet<>();
		HashSet<Character> pathVis = new HashSet<>();
		ArrayList<Character> lexOrder = new ArrayList<>();
		for(char chr: adjlist.keySet()) {
			if(dfs(adjlist, chr, lexOrder, visited, pathVis)) {
				return "";
			}
		}
		StringBuffer sb = new StringBuffer();
		for(Character ch: lexOrder) {
			sb.insert(0, ch);
		}
		return sb.toString();
	}

	private boolean dfs(HashMap<Character, HashSet<Character>> adjlist, char chr, ArrayList<Character> lexOrder, HashSet<Character> visited,
			HashSet<Character> pathVis) {
		visited.add(chr);
		pathVis.add(chr);
		for(char neigh: adjlist.get(chr)) {
			if(!visited.contains(neigh)) {
				if(dfs(adjlist, neigh, lexOrder, visited, pathVis)) {
					return true;
				}
			}else if(pathVis.contains(neigh)) {
				return true;
			}
		}
		pathVis.remove(chr);
		lexOrder.add(chr);
		return false;
	}

}
