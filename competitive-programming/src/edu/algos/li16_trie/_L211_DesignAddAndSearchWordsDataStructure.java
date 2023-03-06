package edu.algos.li16_trie;

import edu.algos.li00_model.TrieNode;

public class _L211_DesignAddAndSearchWordsDataStructure {

	public static void main(String[] args) {
		_L211_DesignAddAndSearchWordsDataStructure obj = new _L211_DesignAddAndSearchWordsDataStructure();
		
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		
		System.out.println(obj.search("pad"));
		System.out.println(obj.search("bad"));
		System.out.println(obj.search(".ad"));
		System.out.println(obj.search("b.."));
	}
	
    // Problem: https://leetcode.com/problems/design-add-and-search-words-data-structure/
    // Idea: Use Trie to store words
    // For seach if char is '.'. Then loop over all chars in current map and check if any recursion returns true. You need to skip one char from work fow '.'.
	TrieNode root;
    public _L211_DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }
	
	public void addWord(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.map.containsKey(ch)){
                TrieNode newNode = new TrieNode();
                current.map.put(ch, newNode);
            }
            current = current.map.get(ch);
        }
        current.endOfWord = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int ind, TrieNode current){
        for(int i=ind; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(TrieNode child: current.map.values()){
                    if(search(word, i+1, child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(!current.map.containsKey(ch)){
                    return false;
                }
                current = current.map.get(ch);
            }
        }
        return current.endOfWord;
    }

}
