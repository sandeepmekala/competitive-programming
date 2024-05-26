package com.algos.core.li03_slidingwindow.revised;

public class L1004_MaxConsecutiveOnesIII {
    
        public static void main(String[] args) {
            L1004_MaxConsecutiveOnesIII obj = new L1004_MaxConsecutiveOnesIII();
    
            int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
            int k = 2;
            System.out.println(obj.longestOnes(nums, k));
        }
    
        // Problem: https://leetcode.com/problems/max-consecutive-ones-iii/
        // Idea: This can be reframed as find the longest subarray with at most k zeros
        // Time: O(n)
        public int longestOnes(int[] nums, int k) {
            int l=0, r=0, n = nums.length, maxLen = 0, zeros = 0;
            while(r<n) {
                if(nums[r] == 0) 
                    zeros++;
                
                if(zeros > k) {
                    if(nums[l] == 0) 
                        zeros--;
                    l++;
                }
                
                if(zeros <= k)
                    maxLen = Math.max(maxLen, r-l+1);
                r++;
            }
            
            return maxLen;
        }
}
