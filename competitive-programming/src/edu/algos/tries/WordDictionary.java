package edu.algos.tries;

import edu.algos.model.TrieNode;

public class WordDictionary {

	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		
		System.out.println(obj.search("pad"));
		System.out.println(obj.search("bad"));
		System.out.println(obj.search(".ad"));
		System.out.println(obj.search("b.."));
	}
	
	TrieNode root;
    public WordDictionary() {
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
