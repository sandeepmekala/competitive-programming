package com.algos.li01_array.revised;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarraysWithXorK {
    
        public static void main(String[] args) {
            NumberOfSubarraysWithXorK obj = new NumberOfSubarraysWithXorK();
            
            int[] nums = new int[] {1,1,2,3,4};
            System.out.println(obj.subarrayXorK(nums, 3));
        }
    
        // Problem: https://leetcode.com/problems/subarray-sum-equals-k/
        // Idea: Use a map to store prefix sum and its frequency
        // Time: O(n), Space: O(n)
        public int subarrayXorK(int[] nums, int k) {
            int xor = 0, cnt = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for(int num: nums){
                xor ^= num;
                int x = xor^k;
                cnt += map.getOrDefault(x, 0);
                map.put(xor, map.getOrDefault(xor, 0)+1);
            }
            
            return cnt;
        }     
}
