package  com.algos.li16_trie;

import  com.algos.li30_model.TrieNode;

public class L1698_NumberOfDistinctSubstringsInAString {
    public static void main(String[] args) {
        L1698_NumberOfDistinctSubstringsInAString obj = new L1698_NumberOfDistinctSubstringsInAString();

        String s = "aabbaba";
        System.out.println(obj.countDistinct(s));
    }

    public int countDistinct(String s) {
        TrieNode root = new TrieNode();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            TrieNode current = root;
            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                if(!current.map.containsKey(ch)){
                    TrieNode newNode = new TrieNode();
                    current.map.put(ch, newNode);
                    count++;
                }
                current = current.map.get(ch);
            }
        }

        return count;
    }
}
