package com.algos.core.li01_array.revised;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum_CountNumberOfSubarraysWithXorK {
    
        public static void main(String[] args) {
            PrefixSum_CountNumberOfSubarraysWithXorK obj = new PrefixSum_CountNumberOfSubarraysWithXorK();
            
            int[] nums = new int[] {1,1,2,3,4};
            System.out.println(obj.subarrayXorK(nums, 3));
        }
    
        // Idea: Use a map to store prefix sum and its frequency
        // Same as count sum arrays with sum k
        // XR: xor(0 -> curr) and y: xor(0 -> j) where j < curr
        // x ^ k = XR       
        // x = XR ^ k
        // Time: O(n), Space: O(n)
        public int subarrayXorK(int[] nums, int k) {
            int XR = 0, cnt = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for(int num: nums){
                XR ^= num;
                int x = XR^k;
                if (map.containsKey(x)) {
                    cnt += map.get(x);
                }
                map.putIfAbsent(XR, 0);
                map.put(XR, map.get(XR)+1);
            }
            
            return cnt;
        }     
}
