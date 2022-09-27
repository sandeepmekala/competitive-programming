package edu.algos.li03.hashing;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {

	public static void main(String[] args) {
		VerifyingAnAlienDictionary obj = new VerifyingAnAlienDictionary();
		
		String[] words = new String[] {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(obj.isAlienSorted(words, order));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/verifying-an-alien-dictionary/
	 * 
	 * */
	public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            map.put(order.charAt(i), i);
        }
        
        for(int i=1; i<words.length; i++){
            String prev = words[i-1], curr = words[i];
            
            if(prev.equals(curr)) continue;
            if(curr.startsWith(prev)) continue;
            if(prev.startsWith(curr)) return false;
            
            int j=0;
            while(prev.charAt(j) == curr.charAt(j)) j++;
            
            if(map.get(prev.charAt(j)) > map.get(curr.charAt(j))) return false;
        }
        
        return true;
    }

}
