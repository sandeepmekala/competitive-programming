package edu.algos.model;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public Map<Character, TrieNode> children;
	public boolean eow;
	public TrieNode(){
		children = new HashMap<Character, TrieNode>();
	}
	
	public String toString() {
		
		return children.keySet()+"";
	}
}
