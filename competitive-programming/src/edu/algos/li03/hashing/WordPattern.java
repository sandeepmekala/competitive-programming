package edu.algos.li03.hashing;

import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		WordPattern obj = new WordPattern();
		
		System.out.println(obj.wordPattern("abba", "dog cat cat dog"));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/word-pattern/
	 * Companies: Amazon
	 * */
	public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");
        
        if(chars.length != words.length) return false;
        
        for(int i=0; i<chars.length; i++){
            if(charToWord.containsKey(chars[i]) && !charToWord.get(chars[i]).equals(words[i]))
                return false;                    
            if(wordToChar.containsKey(words[i]) && wordToChar.get(words[i]) != chars[i])
                return false;                    
            
            charToWord.put(chars[i], words[i]);
            wordToChar.put(words[i], chars[i]);
        }
        
        return true;
    }

}
