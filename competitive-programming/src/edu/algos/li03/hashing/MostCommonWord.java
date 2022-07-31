package edu.algos.li03.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MostCommonWord {

	public static void main(String[] args) {
		MostCommonWord obj = new MostCommonWord();
		
		//String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String paragraph = "a, a, a, a, b,b,b,c, c";
		String[] banned = new String[] {"a"};
		System.out.println(obj.mostCommonWord(paragraph, banned));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/most-common-word/
	 * */
	public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        List<String> bannedWords = Arrays.asList(banned);
        
        HashMap<String, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
    	char[] chars = paragraph.toLowerCase().toCharArray();
    	for(char ch: chars) {
    		if(ch >= 'a' && ch<='z')
    			sb.append(ch);
    		else {
    			if(sb.length() > 0) {
        			String word = sb.toString();
        			if(!bannedWords.contains(word)){
        	            map.put(word, map.getOrDefault(word, 0)+1);
        	        }
        			sb = new StringBuffer();
    			}
    		}
    	}
        if(sb.length() > 0) {
            String word = sb.toString();
            if(!bannedWords.contains(word)){
                map.put(word, map.getOrDefault(word, 0)+1);
            }
            sb = new StringBuffer();
        }
    	
        String result = "";
        int max = 0;
        for(String word: map.keySet()){
            if(map.get(word) > max){
                max = map.get(word);
                result = word;
            }
        }
        
        return result;
    }
}
