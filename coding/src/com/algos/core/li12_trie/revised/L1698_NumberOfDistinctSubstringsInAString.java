package  com.algos.core.li12_trie.revised;

import com.algos.core.models.TrieNode;

public class L1698_NumberOfDistinctSubstringsInAString {
    public static void main(String[] args) {
        L1698_NumberOfDistinctSubstringsInAString obj = new L1698_NumberOfDistinctSubstringsInAString();

        String s = "aabbaba";
        System.out.println(obj.countDistinct(s));
    }

    // Problem: https://leetcode.ca/2020-07-24-1698-Number-of-Distinct-Substrings-in-a-String/
    // Idea: For each character in a string, create all possible substrings and insert them in Trie.
    // "abc" -> "a", "ab", "abc", "b", "bc", "c"
    // For every new character, new substrings will be created.
    // If some prefix is already inserted by some other substring, then chars will be already present in trie.
    public int countDistinct(String s) {
        int count = 0;
        TrieNode root = new TrieNode();
        for(int i=0; i<s.length(); i++){
            TrieNode curr = root;
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);          // means substring from i to j
                if(!curr.map.containsKey(ch)){
                    curr.map.put(ch, new TrieNode());
                    count++;                    // jth character is new, so new substring
                }
                curr = curr.map.get(ch);
            }
        }

        return count;
    }
}
