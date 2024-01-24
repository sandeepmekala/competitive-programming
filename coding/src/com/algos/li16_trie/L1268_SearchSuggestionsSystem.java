package  com.algos.li16_trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import  com.algos.li30_model.TrieNode;

public class L1268_SearchSuggestionsSystem {

	public static void main(String[] args) {
		L1268_SearchSuggestionsSystem obj = new L1268_SearchSuggestionsSystem();
		
		String[] products = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		System.out.println(obj.suggestedProducts(products, searchWord));
	}

	/*
	 * Problem: https://leetcode.com/problems/search-suggestions-system/
	 * Companies: Amazon
     * Idea: Sort words first as we need to return in lexicographic order
     * Whild building the trie only maintain the words at each node. Maintain the words in char trie node.
     * 
	 * */
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        TrieNode root = new TrieNode();
        Arrays.sort(products);      
        for(String product: products){
            TrieNode current = root;
            for(char ch: product.toCharArray()){
                if(!current.map.containsKey(ch)){
                    current.map.put(ch, new TrieNode());
                }
                current = current.map.get(ch);
                if(current.suggestions.size() < 3)
                    current.suggestions.add(product);
            }            
        }
        
        TrieNode current = root;
        for(char ch: searchWord.toCharArray()){
            if(current != null && current.map.containsKey(ch)){
                current = current.map.get(ch);
                result.add(current.suggestions);
            }else{
                current = null;
                result.add(Arrays.asList());
            }
        }
        
        return result;
    }
}
