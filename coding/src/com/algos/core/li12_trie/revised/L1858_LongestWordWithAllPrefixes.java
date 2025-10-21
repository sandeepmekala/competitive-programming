package  com.algos.core.li12_trie.revised;

import com.algos.core.models.TrieNode;

public class L1858_LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        L1858_LongestWordWithAllPrefixes obj = new L1858_LongestWordWithAllPrefixes();

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
            if(checkIfPrefixesExists(root, word)){
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
		TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            if(!curr.map.containsKey(ch)){
                TrieNode newNode = new TrieNode();
                curr.map.put(ch, newNode);
            }
            curr = curr.map.get(ch);
        }
        curr.endOfWord = true;	// after new node is created current will be pointing to new node after for loop
	}

    private boolean checkIfPrefixesExists(TrieNode root, String word) {
        TrieNode curr = root;
        boolean flag = true;
        for(Character ch : word.toCharArray()){
            if(!curr.map.containsKey(ch)){
                return false;
            }
            curr = curr.map.get(ch);
            flag = flag&curr.endOfWord;
        }
        return flag;
    }
}
