package li12_trie;

import java.util.ArrayDeque;
import java.util.Queue;

import com.algos.topics.models.TrieNode;

public class L208_ImplementTrie_PrefixTree {

	public static void main(String[] args) {
		L208_ImplementTrie_PrefixTree trie = new L208_ImplementTrie_PrefixTree();

		trie.insert("abc");
		trie.insert("abgl");
		trie.insert("cdf");
		trie.insert("abcd");
		trie.insert("lmn");

		trie.print();
		System.out.println(trie.startsWith("ab"));	// b's child is has EoW as false. Hence should return true.
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("lm"));

		// trie.delete("abc");
		// System.out.println(trie.search("abc"));
		// trie.delete("abgl");
		// trie.print();
		// trie.delete("abcd");
		// trie.print();

	}

	// Problem: https://leetcode.com/problems/implement-trie-prefix-tree/
	// Idea: Start with root node which contains map of first chars.
	// Deletion need to be handled in recursively as we need to delete the node in bottom up way.
	TrieNode root;
	public L208_ImplementTrie_PrefixTree(){
		root = new TrieNode();
	}

	// O(m) where m is max lenght of a word
	public void insert(String word) {
		TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            curr.map.putIfAbsent(ch, new TrieNode());
            curr = curr.map.get(ch);
        }
        curr.endOfWord = true;	// after new node is created current will be pointing to new node after for loop
	}

	public boolean startsWith(String prefix) {
		TrieNode curr = root;
        for(Character ch : prefix.toCharArray()){
            if(!curr.map.containsKey(ch))
                return false;

            curr = curr.map.get(ch);
        }
        return true;
	}

	// O(m) where m is max lenght of a word
	public boolean search(String word) {
		TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            if(!curr.map.containsKey(ch))
                return false;

            curr = curr.map.get(ch);
        }
        return curr.endOfWord;
	}

	// public void delete(String word) {
	// 	delete(root, word, 0);
	// }

	// private boolean delete(TrieNode root, String word, int index) {
	// 	if(index == word.length()) {
	// 		return root.map.isEmpty();
	// 	}

	// 	char ch = word.charAt(index);
	// 	if(root.map.containsKey(ch)) {
	// 		TrieNode current = root.map.get(ch);
	// 		boolean deleteCurrentFromRoot = delete(current, word, index+1);
	// 		if(deleteCurrentFromRoot) {
	// 			root.map.remove(ch);
	// 		}else {
	// 			current.endOfWord = false;
	// 		}
	// 	}
	// 	return root.map.isEmpty();
	// }

	private void print() {
		Queue<TrieNode> queue = new ArrayDeque<TrieNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++){
				TrieNode current = queue.remove();
				System.out.print(current.map.keySet());
				queue.addAll(current.map.values());
			}
			System.out.println();
		}
	}
}
