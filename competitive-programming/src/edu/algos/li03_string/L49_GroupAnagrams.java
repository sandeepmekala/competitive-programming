package edu.algos.li03_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class L49_GroupAnagrams {

	public static void main(String[] args) {
		L49_GroupAnagrams obj = new L49_GroupAnagrams();
        
		System.out.println(obj.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
	}

    // Problem: https://leetcode.com/problems/group-anagrams/
    // Idea: Create Counter for each str using TreeMap. From TreeMap create a composite key for grouping the strings. 
    // Each anagram gets same key as TreeMap stores the keys in the same order.
    // TODO
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> aggMap = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
            for(int j=0; j<str.length(); j++){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
            }
            
            String compositeKey = "";
            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                compositeKey += entry.getKey().toString()+entry.getValue()+":";
            }
            
            if(!aggMap.containsKey(compositeKey)){
                aggMap.put(compositeKey, new ArrayList<String>());
            }
            aggMap.get(compositeKey).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: aggMap.entrySet()){
                result.add(entry.getValue());
        }
        
        return result;
    }
}
