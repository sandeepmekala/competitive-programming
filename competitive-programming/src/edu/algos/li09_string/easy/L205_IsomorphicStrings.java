package edu.algos.li09_string.easy;

import java.util.HashMap;

public class L205_IsomorphicStrings {

	public static void main(String[] args) {
		L205_IsomorphicStrings obj = new L205_IsomorphicStrings();
		
		String s = "egg";
		String t = "add";
		System.out.println(obj.isIsomorphic(s, t));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/isomorphic-strings/
	 * Idea: Create a mapping from a->b and b->a
	 * 
	 * */
	public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(!map.containsKey(sch) && !map.containsKey(tch)) {
				map.put(sch, tch);
				map.put(tch, sch);
			}else if(map.containsKey(sch) && !map.containsKey(tch)) {
				return false;
			}else if(!map.containsKey(sch) && map.containsKey(tch)) {
				return false;
        }
        
		return true;
    }

}
