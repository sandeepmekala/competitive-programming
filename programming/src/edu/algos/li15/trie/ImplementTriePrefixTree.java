package edu.algos.li15.trie;

import java.util.ArrayDeque;
import java.util.Queue;

import edu.algos.li00.model.TrieNode;

public class ImplementTriePrefixTree {
	
	public static void main(String[] args) {
		ImplementTriePrefixTree trie = new ImplementTriePrefixTree();
		trie.addWord("abc");
		trie.addWord("abgl");
		trie.addWord("cdf");
		trie.addWord("abcd");
		trie.addWord("lmn");
		
		trie.print();
		System.out.println(trie.prefixSearch("ab"));	// b's child is has EoW as false. Hence should return true.
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("lm"));
		
		trie.delete("abc");
		System.out.println(trie.search("abc"));
		trie.delete("abgl");
		trie.print();
		trie.delete("abcd");
		trie.print();
		
	}

	TrieNode root;
	public ImplementTriePrefixTree(){
		root = new TrieNode();
	}
	
	// O(m) where m is max lenght of a word
	private void addWord(String word) {
		
		TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.children.containsKey(ch)){
                TrieNode newNode = new TrieNode();
                current.children.put(ch, newNode);
            }
            current = current.children.get(ch);
        }
        current.eow = true;	// after new node is created current will be pointing to new node after for loop
	}
	
	private boolean prefixSearch(String prefix) {
		TrieNode current = root;
        int count = 0;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!current.children.containsKey(ch)){
                return false;
            }
            current = current.children.get(ch);
        }
        return true;
	}
	
	// O(m) where m is max lenght of a word
	private boolean search(String word) {
		TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!current.children.containsKey(ch)){
                return false;
            }
            current = current.children.get(ch);
        }
        return current.eow == true;
	}
	
	private void delete(String word) {
		delete(root, word, 0);
	}
	
	private boolean delete(TrieNode root, String word, int index) {
		if(index == word.length()) {
			return root.children.isEmpty();
		}
		char ch = word.charAt(index);
		if(root.children.containsKey(ch)) {
			TrieNode current = root.children.get(ch);
			boolean deleteCurrentFromRoot = delete(current, word, index+1);
			if(deleteCurrentFromRoot) {
				root.children.remove(ch);
			}else {
				current.eow = false;
			}
		}
		return root.children.isEmpty();
	}
	
	private void print() {
		Queue<TrieNode> queue1 = new ArrayDeque<TrieNode>();
		Queue<TrieNode> queue2 = new ArrayDeque<TrieNode>();
		queue1.add(root);
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			while(!queue1.isEmpty()) {
				TrieNode current = queue1.remove();
				System.out.print(current.children.keySet());
				queue2.addAll(current.children.values());
			}
			System.out.println();
			while(!queue2.isEmpty()) {
				TrieNode current = queue2.remove();
				System.out.print(current.children.keySet());
				queue1.addAll(current.children.values());
			}
			System.out.println();
		}
	}
}