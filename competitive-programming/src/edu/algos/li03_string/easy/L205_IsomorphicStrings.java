package edu.algos.li03_string.easy;

import java.util.HashMap;

public class L205_IsomorphicStrings {

	public static void main(String[] args) {
		L205_IsomorphicStrings obj = new L205_IsomorphicStrings();
		
		String s = "paper";
		String t = "title";
		System.out.println(obj.isIsomorphic(s, t));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/isomorphic-strings/
	 * Idea: Create a mapping a->b if a is not in map and b is not already taken.
	 * 
	 * */
	public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(!map.containsKey(sch) && !map.containsValue(tch)) 
				map.put(sch, tch);
            
            if(!map.containsKey(sch) && map.containsValue(tch)) 
                return false;
            if(map.get(sch) != tch) 
                return false;
        }
        
        return true;
    }

}
