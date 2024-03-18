package  com.algos.li11_heap.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L347_TopKFrequentElements {

	public static void main(String[] args) {
		L347_TopKFrequentElements obj = new L347_TopKFrequentElements();
		System.out.println(Arrays.toString(obj.topKFrequent(new int[] {1,1,1,2,2,3,3,4}, 2)));
	}

	/*
	 * Problem: https://leetcode.com/problems/top-k-frequent-elements/
	 * Idea: Hashing and create buckets based on freq of nums. All the nums of same freq would fall in same bucket.
	 * Look into buckets from the end as mack freq value buck is at the end.
	 * */
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        ArrayList<Integer> buckets[] = new ArrayList[nums.length+1];	// Top freq can be nums.length if all nums are same
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	ArrayList<Integer> bucket = buckets[entry.getValue()];
        	if(bucket == null){
        		bucket = new ArrayList<Integer>();
        		buckets[entry.getValue()] = bucket;
        	}
        	bucket.add(entry.getKey());
        }
        
        int count = 0;
        int[] result = new int[k];
        for(int i=buckets.length-1; i>=0; i--) {
        	if(buckets[i] != null) {
        		for(int j=0; j<buckets[i].size(); j++) {
        			result[count++] = buckets[i].get(j);
        			if(count == k) {
        				return result;
        			}
        		}
        	}
        }
        return result;
    }
}
