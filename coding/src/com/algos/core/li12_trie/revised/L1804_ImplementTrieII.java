package  com.algos.core.li12_trie.revised;

import  com.algos.core.li30_model.TrieNode;

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

    // Problem: https://leetcode.ca/2020-11-07-1804-Implement-Trie-II-(Prefix-Tree)/
    // Idea: Have a countEndWith and countPrefix variables at each Trie Node to track words and prefixes.
    TrieNode root;
    L1804_ImplementTrieII(){
        root = new TrieNode();
    }

    public void insert(String word) {
		TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            curr.map.putIfAbsent(ch, new TrieNode());
            curr = curr.map.get(ch);
            curr.countPrefix += 1;
        }
        curr.countEndWith += 1; 
        curr.endOfWord = true;	// after new node is created current will be pointing to new node after for loop
	}

    public int countWordsEqualTo(String word){
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            curr = curr.map.get(ch);
            if(curr == null) 
                return 0;
        }

        return curr.countEndWith;
    }

    public int countWordsStartingWith(String prefix){
        TrieNode curr = root;
        for(Character ch : prefix.toCharArray()){
            curr = curr.map.get(ch);
            if(curr == null) 
                return 0;
        }

        return curr.countPrefix;
    }

    public void erase(String word){
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            curr = curr.map.get(ch);
            curr.countPrefix -= 1;
        }
        curr.countEndWith -= 1; 
    }
}
