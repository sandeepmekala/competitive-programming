package  com.algos.li18_string.revised;

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
    // Each anagram gets same composite key as TreeMap stores the keys in the same order.
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> aggMap = new HashMap<>();
        for(String str: strs){
            Map<Character, Integer> map = new TreeMap<>();
            for(char c: str.toCharArray())
                map.put(c, map.getOrDefault(c, 0)+1);
            
            StringBuffer sb = new StringBuffer();
            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                sb.append(entry.getKey());
                sb.append(entry.getValue());
                sb.append(":");
            }
            String compKey = sb.toString();
            if(!aggMap.containsKey(compKey))
                aggMap.put(compKey, new ArrayList<String>());
            
            aggMap.get(compKey).add(str);
        }
        
        return new ArrayList<>(aggMap.values());
    }
}
