package edu.algos.li00.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
	public Map<Character, TrieNode> children;
	public boolean eow;
	public List<String> suggestions;
	public TrieNode(){
		children = new HashMap<Character, TrieNode>();
		suggestions = new ArrayList<>();
	}
	
	public String toString() {
		
		return children.keySet()+"";
	}
}
