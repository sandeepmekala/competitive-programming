package edu.algos.li16_trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.algos.li00_model.TrieNode;

public class SearchSuggestionsSystem {

	public static void main(String[] args) {
		SearchSuggestionsSystem obj = new SearchSuggestionsSystem();
		
		String[] products = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		System.out.println(obj.suggestedProducts(products, searchWord));
	}

	/*
	 * Problem: https://leetcode.com/problems/search-suggestions-system/
	 * Companies: Amazon
	 * */
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        TrieNode root = new TrieNode();
        Arrays.sort(products);
        for(String product: products){
            TrieNode current = root;
            for(char ch: product.toCharArray()){
                if(!current.children.containsKey(ch)){
                    current.children.put(ch, new TrieNode());
                }
                current = current.children.get(ch);
                if(current.suggestions.size() < 3)
                    current.suggestions.add(product);
            }            
        }
        
        TrieNode current = root;
        for(char ch: searchWord.toCharArray()){
            if(current != null && current.children.containsKey(ch)){
                current = current.children.get(ch);
                result.add(current.suggestions);
            }else{
                current = null;
                result.add(Arrays.asList());
            }
        }
        
        return result;
    }
}
