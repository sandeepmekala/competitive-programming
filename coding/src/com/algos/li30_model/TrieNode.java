package  com.algos.li30_model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
	public Map<Object, TrieNode> map;
	public boolean endOfWord;
	public List<String> suggestions;
	public int countEndWith = 0;
	public int countPrefix = 0;
	public TrieNode(){
		map = new HashMap<Object, TrieNode>();
		suggestions = new ArrayList<>();
	}
	
	public String toString() {
		
		return map.keySet()+"";
	}
}
