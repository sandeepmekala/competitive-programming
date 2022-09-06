package edu.algos.li16.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
		TopKFrequentWords obj = new TopKFrequentWords();
		
		String[] words = new String[] {"i","love","leetcode","i","love","coding"};
		System.out.println(obj.topKFrequent(words, 2));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/top-k-frequent-words/
	 * Companies: Amazon
	 * 
	 * Concept: Hashing and Priority Queue
	 * */
	public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if(e1.getValue() == e2.getValue()){
                return e1.getKey().compareTo(e2.getKey());
            }else{
                return e2.getValue() - e1.getValue();
            }
        });
        
        pq.addAll(map.entrySet());
        
        List<String> result = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(!pq.isEmpty())
                result.add(pq.remove().getKey());
        }
        
        return result;
    }

}
