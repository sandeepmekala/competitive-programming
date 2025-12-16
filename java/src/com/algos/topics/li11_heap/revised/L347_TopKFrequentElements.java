package  com.algos.topics.li11_heap.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L347_TopKFrequentElements {

	public static void main(String[] args) {
		L347_TopKFrequentElements obj = new L347_TopKFrequentElements();
		System.out.println(Arrays.toString(obj.topKFrequent(new int[] {1,1,1,2,2,3,3,4}, 2)));
	}

	// Problem: https://leetcode.com/problems/top-k-frequent-elements/
	// Idea: This can be solved using heap.
	// Alternative: Hashing and create buckets based on freq. All the nums of same freq would fall in same bucket.
	// Look into buckets from the end as max freq value bucket is at the end.
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];	// Top freq can be nums.length if all nums are same
        Arrays.fill(buckets, new ArrayList<>());
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	List<Integer> bucket = buckets[entry.getValue()];
        	bucket.add(entry.getKey());
        }

        int count = 0;
        int[] ans = new int[k];
        for(int i=buckets.length-1; i>=0; i--) {
			for(int j=0; j<buckets[i].size(); j++) {
				ans[count++] = buckets[i].get(j);
				if(count == k) {
					return ans;
				}
			}
        }
        return ans;
    }
}
