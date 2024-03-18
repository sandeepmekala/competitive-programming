package  com.algos.li12_trie.revised;

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
     * Whild building the trie maintain the words at each node. Maintain the words in char trie node.
     * 
	 * */
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);      

        TrieNode root = new TrieNode();
        for(String product: products){
            TrieNode curr = root;
            for(char ch: product.toCharArray()){
                if(!curr.map.containsKey(ch)){
                    curr.map.put(ch, new TrieNode());
                }
                curr = curr.map.get(ch);
                if(curr.suggestions.size() < 3)
                    curr.suggestions.add(product);
            }            
        }
        
        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        for(char ch: searchWord.toCharArray()){
            if(curr != null && curr.map.containsKey(ch)){
                curr = curr.map.get(ch);
                result.add(curr.suggestions);
            }else{
                curr = null;
                result.add(Arrays.asList());
            }
        }
        
        return result;
    }
}
