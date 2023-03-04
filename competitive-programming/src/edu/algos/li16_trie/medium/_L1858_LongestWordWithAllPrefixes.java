package edu.algos.li16_trie.medium;

import edu.algos.li00_model.TrieNode;

public class _L1858_LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        _L1858_LongestWordWithAllPrefixes obj = new _L1858_LongestWordWithAllPrefixes();
        
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(obj.longestWord(words));
    }

    // Problem: https://leetcode.com/problems/longest-word-with-all-prefixes/
    // https://leetcode.ca/2021-07-14-1858-Longest-Word-With-All-Prefixes/ 
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words)
            insert(root, word);

        String longest = "";
        for(String word: words){
            if(checkIfPrefixExists(root, word)){
                if(word.length() > longest.length()){
                    longest = word;
                }else if(word.length() == longest.length() && word.compareTo(longest) < 0){
                    longest = word;
                }
            }
        }
        return longest;
    }
    
    public void insert(TrieNode root, String word) {
		TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.map.containsKey(ch)){
                TrieNode newNode = new TrieNode();
                current.map.put(ch, newNode);
            }
            current = current.map.get(ch);
        }
        current.endOfWord = true;	// after new node is created current will be pointing to new node after for loop
	}
    
    private boolean checkIfPrefixExists(TrieNode root, String word) {
        TrieNode current = root;
        boolean flag = true;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.map.containsKey(ch)){
                return false;
            }
            current = current.map.get(ch);
            flag = flag&current.endOfWord;
        }
        return flag;
    }
}
