package  com.algos.core.li18_string.revised;

import java.util.HashMap;
import java.util.Map;

public class L242_ValidAnagram {

	public static void main(String[] args) {
		L242_ValidAnagram obj = new L242_ValidAnagram();
		System.out.println(obj.isAnagram("anagram", "nagaram"));
	}

    // Problem: https://leetcode.com/problems/valid-anagram/
    // Idea: Count the char freq and compare
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        for(char ch: t.toCharArray()){
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
