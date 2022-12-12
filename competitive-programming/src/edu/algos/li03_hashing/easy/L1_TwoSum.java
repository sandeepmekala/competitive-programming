package edu.algos.li03_hashing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum {

	public static void main(String[] args) {
		L1_TwoSum obj = new L1_TwoSum();
		System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15}, 9)));
	}
	
    // Problem: https://leetcode.com/problems/two-sum/
    // Idea: Use Map to put number and its index
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int rem = target-nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem), i};
            }else{
                map.put(nums[i], i);                 
            }
        }
        return new int[]{};
    }

}
