package  com.algos.li16_trie;

import  com.algos.li30_model.TrieNode;

public class L1804_ImplementTrieII {
    public static void main(String[] args) {
        L1804_ImplementTrieII obj = new L1804_ImplementTrieII();

        obj.insert("apple");
        obj.insert("apple");
        System.out.println(obj.countWordsEqualTo("apple"));
        System.out.println(obj.countWordsStartingWith("app"));
        obj.erase("apple");
        System.out.println(obj.countWordsEqualTo("apple"));
        System.out.println(obj.countWordsStartingWith("app"));
        obj.erase("apple");
        System.out.println(obj.countWordsEqualTo("apple"));
    }

    // Problem: https://leetcode.com/problems/implement-trie-ii-prefix-tree/
    // https://zhenchaogan.gitbook.io/leetcode-solution/leetcode-1804-implement-trie-ii-prefix-tree
    // Idea: Have to count variable at each Trie Node to track words and prefixes.
    TrieNode root;
    L1804_ImplementTrieII(){
        root = new TrieNode();
    }

    public void insert(String word) {
		TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.map.containsKey(ch)){
                TrieNode newNode = new TrieNode();
                current.map.put(ch, newNode);
            }
            current = current.map.get(ch);
            current.countPrefix += 1;
        }
        current.countEndWith += 1; 
        current.endOfWord = true;	// after new node is created current will be pointing to new node after for loop
	}

    public int countWordsEqualTo(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            current = current.map.get(ch);
            if(current == null) 
                return 0;
        }

        return current.countEndWith;
    }

    public int countWordsStartingWith(String prefix){
        TrieNode current = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            current = current.map.get(ch);
            if(current == null) 
                return 0;
        }

        return current.countPrefix;
    }

    public void erase(String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            current = current.map.get(ch);
            current.countPrefix -= 1;
        }
        current.countEndWith -= 1; 
    }
}
