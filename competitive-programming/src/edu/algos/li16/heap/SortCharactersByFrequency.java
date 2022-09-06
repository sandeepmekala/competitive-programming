package edu.algos.li16.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		SortCharactersByFrequency obj = new SortCharactersByFrequency();
		
		System.out.println(obj.frequencySort("tree"));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/sort-characters-by-frequency/
	 * Companies: Amazon
	 * */
	public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        
        pq.addAll(map.entrySet());
        
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.remove();
            for(int i=0; i<entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        
        return sb.toString();
    }

}
