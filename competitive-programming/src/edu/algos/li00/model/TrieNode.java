package edu.algos.li00.model;

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
