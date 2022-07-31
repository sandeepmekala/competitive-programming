package edu.algos.li09.string;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings obj = new IsomorphicStrings();
		
		String s = "egg";
		String t = "add";
		System.out.println(obj.isIsomorphic(s, t));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/isomorphic-strings/
	 * 
	 * */
	public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(!map.containsKey(sch) && !map.containsValue(tch)) map.put(sch, tch);
            
            if(map.get(sch) == null) return false;
            if(map.get(sch) != tch) return false;
        }
        
        return true;
    }

}
