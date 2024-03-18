package  com.algos.li12_trie.revised;

import  com.algos.li30_model.TrieNode;

public class L1698_NumberOfDistinctSubstringsInAString {
    public static void main(String[] args) {
        L1698_NumberOfDistinctSubstringsInAString obj = new L1698_NumberOfDistinctSubstringsInAString();

        String s = "aabbaba";
        System.out.println(obj.countDistinct(s));
    }

    // Problem: https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/
    // https://leetcode.ca/2020-07-24-1698-Number-of-Distinct-Substrings-in-a-String/
    // Idea: For each character in string, create all possible substrings and insert them in Trie.
    public int countDistinct(String s) {
        TrieNode root = new TrieNode();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            TrieNode curr = root;
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                if(!curr.map.containsKey(ch)){
                    TrieNode newNode = new TrieNode();
                    curr.map.put(ch, newNode);
                    count++;
                }
                curr = curr.map.get(ch);
            }
        }

        return count;
    }
}
