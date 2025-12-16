package li01_array.java;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum_L325_MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        PrefixSum_L325_MaximumSizeSubarraySumEqualsK obj = new PrefixSum_L325_MaximumSizeSubarraySumEqualsK();
        int[] arr = { 1, -1, 5, -2, 3 };
        int k = 3;
        System.out.println(obj.maxSubArrayLen(arr, k));
        int[] arr2 = { 1, 2, 3, 1, 1, 1, 1, 0, 3, 3};
        int k2 = 6;
        System.out.println(obj.maxSubArrayLen2(arr2, k2));
    }

    // Problem: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
    // Idea: Prefix Sum
    // Time: O(n), Space: O(n)
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<>();       // sum -> index
        map.put(0L, -1);                // if first k elements sum to k, then k-1 - (-1) = k
        int maxLen = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            Long rem = sum-k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }

    // Idea: Use two pointers. Doesn't work for negative numbers.
    // Time: O(n), Space: O(1)
    public int maxSubArrayLen2(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, sum = 0, maxLen = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > k) {
                sum -= nums[l++];
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }
}
