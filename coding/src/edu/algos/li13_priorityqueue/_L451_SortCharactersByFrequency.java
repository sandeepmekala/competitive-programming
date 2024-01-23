package edu.algos.li13_priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _L451_SortCharactersByFrequency {

	public static void main(String[] args) {
		_L451_SortCharactersByFrequency obj = new _L451_SortCharactersByFrequency();
		
		System.out.println(obj.frequencySort("tree"));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/sort-characters-by-frequency/
	 * Companies: Amazon
     * Idea: Hashing and Priority Queue
	 * */
	public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);
        
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
