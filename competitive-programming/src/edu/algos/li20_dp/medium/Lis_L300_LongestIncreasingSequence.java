package edu.algos.li20_dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lis_L300_LongestIncreasingSequence {

	public static void main(String[] args) {
		Lis_L300_LongestIncreasingSequence obj = new Lis_L300_LongestIncreasingSequence();
		int[] nums = new int[] { 2, -1, 4, 3, 5, -1, 3, 2 };
		System.out.println(obj.lengthOfLIS(nums));
		System.out.println(obj.lengthOfLIS(nums, 0, -1));


	}

	// Problem: https://leetcode.com/problems/longest-increasing-subsequence/
	// Idea: Find lis of all the previous elements starting from left to right,	then find lis of current element
	// Current element lis is the max of all the previous elements lis plus 1
	// O(n^2) as it takes another loop to find the max for current element
	// Lis can be printed if we track the parent array if the cur lis gets updated.
	// We can use binary search to create a new increasing temp array by inserting and overriding the elements in temp array to reduce the time complexity. 
	// But that adds O(n) space. With this approach, we can't derive the the lis string.
	public int lengthOfLIS(int[] nums) {
        int max = 0, n = nums.length;
        if(n == 1)
            return 1;
		
		int[] lis = new int[n];
		Arrays.fill(lis, 1);	//lis for each element is itself
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i]) {
					lis[i] = Math.max(lis[i], 1 + lis[j]);
				}
			}
			
			if(lis[i] > max) {	//just track max to return
				max = lis[i];
			}
		}
		return max;
    }

	private List<Integer> print(int nums[], int parent[], int lastIndex){
		ArrayList<Integer> temp=new ArrayList<>();
		temp.add(nums[lastIndex]);
		
		while(parent[lastIndex] != lastIndex){ // till not reach the initialization value
			lastIndex = parent[lastIndex];
			temp.add(nums[lastIndex]);    
		}

		return temp;
	}
	
	// The same can be written in interative way. There is a better way of implementing it with same O(n^2) time as above.
	public int lengthOfLIS(int[] nums, int i, int prev) {
		int n = nums.length;
		if(i == n)
			return 0;

		int notPick = 0 + lengthOfLIS(nums, i+1, prev);
		int pick = 0;
		if(prev == -1 || nums[i] > nums[prev]){
			pick = 1 + lengthOfLIS(nums, i+1, i);
		}
		return Math.max(pick, notPick);
	}
}
