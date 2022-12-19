package edu.algos.li18_graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class G22AlienDictionary {

	public static void main(String[] args) {
		G22AlienDictionary obj = new G22AlienDictionary();
		
		String[] words = new String[] {"wrt","wrf","er","ett","rftt"};
		//String[] words = new String[] {"zy","zx"};
		System.out.println(obj.alienOrder(words));
	}
	
	public String alienOrder(String[] words) {
		LinkedHashMap<Character, HashSet<Character>> adjlist = new LinkedHashMap<>();
		for(String word: words) {
			for(int i=0; i<word.length(); i++) {
				adjlist.put(word.charAt(i), new HashSet<Character>());
			}
		}
		
		for(int i=0; i<words.length-1; i++) {
			String w1 = words[i], w2 = words[i+1];
			int minlen = Math.min(w1.length(), w2.length());
			if(w1.length() > w2.length() && w1.substring(0, minlen).equals(w2.substring(0, minlen))) {
				return "";
			}
			for(int j=0; j<minlen; j++) {
				if(w1.charAt(j) != w2.charAt(j)) {
					adjlist.get(w1.charAt(j)).add(w2.charAt(j));
					break;
				}
			}
		}
		
		HashSet<Character> visited = new HashSet<>();
		HashSet<Character> path = new HashSet<>();
		ArrayList<Character> res = new ArrayList<>();
		for(char chr: adjlist.keySet()) {
			if(dfs(adjlist, chr, res, visited, path)) {
				return "";
			}
		}
		Collections.reverse(res);
		StringBuffer sb = new StringBuffer();
		for(Character chr: res) {
			sb.append(chr);
		}
		return sb.toString();
	}

	private boolean dfs(HashMap<Character, HashSet<Character>> adjlist, char chr, ArrayList<Character> res, HashSet<Character> visited,
			HashSet<Character> path) {
		if(path.contains(chr)) {
			return true;
		}
		
		if(!visited.contains(chr)) {
			visited.add(chr);
			path.add(chr);
			for(char nei: adjlist.get(chr)) {
				if(dfs(adjlist, nei, res, visited, path)) {
					return true;
				}
			}
			path.remove(chr);
			res.add(chr);
		}
		return false;
	}

}
