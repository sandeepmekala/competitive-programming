package edu.algos.li04_hashing;

import java.util.HashMap;

public class L748_ShortestCompletingWord {

	public static void main(String[] args) {
		L748_ShortestCompletingWord obj = new L748_ShortestCompletingWord();
		
		String licensePlate = "1s3 PSt";
		String[] words = new String[] {"step","steps","stripe","stepple"};
		System.out.println(obj.shortestCompletingWord(licensePlate, words));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/shortest-completing-word/
	 * Companies: Google
     * Ideas: Count char freq and compare
	 * */
	public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = licensePlate.toLowerCase().toCharArray();
        for(char ch: chars){
            if(ch >= 'a' && ch <= 'z'){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }
        
        String result = "";
        int wordLen = Integer.MAX_VALUE;
        for(String word: words){
            HashMap<Character, Integer> wordMap = new HashMap<>();
            chars = word.toCharArray();
            for(char ch: chars){
                wordMap.put(ch, wordMap.getOrDefault(ch, 0)+1);
            }
            
            int matches = 0;
            for(char ch: map.keySet()){
                if(wordMap.getOrDefault(ch, 0) < map.get(ch)) break;
                matches++;
            }
            
            if(matches == map.size()){
                if(word.length() < wordLen){
                    wordLen = Math.min(wordLen, word.length());
                    result = word;
                }
            }
        }
        
        return result;
    }

}
