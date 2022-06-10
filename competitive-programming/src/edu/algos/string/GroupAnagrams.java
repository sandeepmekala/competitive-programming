package edu.algos.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupAnagrams {

	public static void main(String[] args) {
		GroupAnagrams obj = new GroupAnagrams();
		System.out.println(obj.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> aggMap = new HashMap<String, List>();
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
            
            if(aggMap.containsKey(compositeKey)){
                List<String> list = aggMap.get(compositeKey);
                list.add(str);
                aggMap.put(compositeKey, list);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(str);
                aggMap.put(compositeKey, list);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List> entry: aggMap.entrySet()){
                result.add(entry.getValue());
        }
        
        return result;
    }
}
