package edu.practice.leatcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		TopKFrequentElements obj = new TopKFrequentElements();
		System.out.println(Arrays.toString(obj.topKFrequent(new int[] {1,1,1,2,2,3,3,4}, 2)));
	}

	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        ArrayList<Integer> buckets[] = new ArrayList[nums.length+1];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	ArrayList<Integer> bucket = buckets[entry.getValue()];
        	if(bucket == null){
        		ArrayList<Integer> newBucket = new ArrayList<Integer>();
        		newBucket.add(entry.getKey());
        		buckets[entry.getValue()] = newBucket;
        	}else {
        		bucket.add(entry.getKey());
        	}
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
