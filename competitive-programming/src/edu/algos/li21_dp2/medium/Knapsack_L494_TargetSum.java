package edu.algos.li21_dp2.medium;

import java.util.HashMap;

public class Knapsack_L494_TargetSum {
    public static void main(String[] args) {
        Knapsack_L494_TargetSum obj = new Knapsack_L494_TargetSum();

        System.out.println(obj.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    // Problem: https://leetcode.com/problems/target-sum/
    // Idea: Similar to knapsack. index i and the sum that is calculated so far will be the parameters.
    // Build a decision tree. start with index 0. For each element we have 2 choices + or - that number.
	// Update the sum and call two recursive functions
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> mem = new HashMap<>(); // sum could become negative and then positive. Which is valid. Hence use map instead of array.
        return rec(nums, target, 0, 0, mem);
    }
    
    private int rec(int[] nums, int target, int i, int sum, HashMap<String, Integer> mem){
        int n = nums.length;
        if(i == n){
            if(sum == target) return 1;
            else return 0;            
        }
        
        String key = (i+":"+sum);
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        
        int localSum = 0;
        localSum += rec(nums, target, i+1, sum-nums[i], mem);
        localSum += rec(nums, target, i+1, sum+nums[i], mem);
        mem.put(key, localSum);
        
        return localSum;
    }
}
