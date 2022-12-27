package edu.algos.li00_model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
	public Map<Character, TrieNode> map;
	public boolean endOfWord;
	public List<String> suggestions;
	public TrieNode(){
		map = new HashMap<Character, TrieNode>();
		suggestions = new ArrayList<>();
	}
	
	public String toString() {
		
		return map.keySet()+"";
	}
}
