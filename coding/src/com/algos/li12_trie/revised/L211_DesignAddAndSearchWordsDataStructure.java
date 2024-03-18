package  com.algos.li12_trie.revised;

import  com.algos.li30_model.TrieNode;

public class L211_DesignAddAndSearchWordsDataStructure {

	public static void main(String[] args) {
		L211_DesignAddAndSearchWordsDataStructure obj = new L211_DesignAddAndSearchWordsDataStructure();
		
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
    public L211_DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }
	
	public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.map.containsKey(ch)){
                TrieNode newNode = new TrieNode();
                curr.map.put(ch, newNode);
            }
            curr = curr.map.get(ch);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);   // when search char is '.' then we need to skip one char from word. Hence we need to pass index as well.
    }
    
    private boolean search(String word, int ind, TrieNode curr){
        for(int i=ind; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(TrieNode child: curr.map.values()){
                    if(search(word, i+1, child)){       // i+1 as we need to skip one char from word.
                        return true;
                    }
                }
                return false;
            }else{
                if(!curr.map.containsKey(ch)){
                    return false;
                }
                curr = curr.map.get(ch);
            }
        }
        return curr.endOfWord;
    }

}
