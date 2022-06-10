package edu.algos.model;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public Map<Character, TrieNode> map;
	public boolean endOfWord;
	public TrieNode(){
		map = new HashMap<Character, TrieNode>();
	}
	
	public String toString() {
		
		return map.keySet()+"";
	}
}
