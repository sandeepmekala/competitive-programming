package  com.algos.li01_array.revised;

import java.util.HashMap;

public class PrefixSum_L560_SubarraySumEqualsK {
    public static void main(String[] args) {
        PrefixSum_L560_SubarraySumEqualsK obj = new PrefixSum_L560_SubarraySumEqualsK();
		System.out.println(obj.subarraySum(new int[] { 1,2,3 }, 3));
    }

    // Problem: https://leetcode.com/problems/subarray-sum-equals-k/
    // Concept: Prefix Sum
    // Same concept can be used for finding the number of subarrays with sum equal to given XoR 
    // y ^ k = XR
    // y = XR ^ k
    public int subarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int prefixSum = 0, count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
