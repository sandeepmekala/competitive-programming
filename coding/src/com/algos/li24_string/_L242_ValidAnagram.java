package edu.algos.li24_string;

import java.util.HashMap;

public class _L242_ValidAnagram {

	public static void main(String[] args) {
		_L242_ValidAnagram obj = new _L242_ValidAnagram();
		System.out.println(obj.isAnagram("anagram", "nagaram"));
	}

    // Problem: https://leetcode.com/problems/valid-anagram/
    // Idea: Count the char freq and compare
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch))
                return false;

            map.put(ch, map.get(ch)-1);  
        }
        
        for(Character ch: map.keySet()){
            if(map.get(ch) != 0){
                return false;
            }
        }
        return true;
    }
}
