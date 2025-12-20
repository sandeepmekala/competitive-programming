import java.util.Arrays;

public class Lis_L300_LongestIncreasingSequence {

	public static void main(String[] args) {
		Lis_L300_LongestIncreasingSequence obj = new Lis_L300_LongestIncreasingSequence();
		int[] nums = new int[] { 2, -1, 4, 3, 5, -1, 3, 2 };
		System.out.println(obj.lengthOfLis(nums, 0, -1)); // ind, prev
		System.out.println(obj.lengthOfLIS(nums));
	}

	// Problem: https://leetcode.com/problems/longest-increasing-subsequence/
	// Idea: Pass prev element index to find the lis of current element
	// Time: O(n^2)
    // Space: O(n)
	public int lengthOfLis(int[] nums, int ind, int prev) {
		int n = nums.length;
		if(ind == n)
			return 0;

		int notPick = 0 + lengthOfLis(nums, ind+1, prev);
		int pick = 0;
		if(prev == -1 || nums[ind] > nums[prev]){
			pick = 1 + lengthOfLis(nums, ind+1, ind);
		}
		return Math.max(pick, notPick);
	}

	// Idea: Find lis of all the previous elements starting from left to right,	then find lis of current element
	// Current element lis is the max of all the previous elements lis plus 1
	// O(n^2) as it takes another loop to find the max for current element
	// Lis can be printed if we track the parent array if the cur lis gets updated.
	// The same can be written in interative way where ind = n-1 -> 0, prev = ind-1 -> -1. prev can't be greater then ind.
	// There is a better way of implementing it with same O(n^2) time as below.
	// Alternative: We can use binary search to create a new increasing temp array by inserting and overriding the elements in temp array to reduce the time complexity.
	// But that adds O(n) space. With this approach, we can't derive the the lis string.
	public int lengthOfLIS(int[] nums) {
        int max = 0, n = nums.length;
        if(n == 1) return 1;

		int[] lis = new int[n];
		Arrays.fill(lis, 1);				// lis for each element is itself
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j]) {
					if(1 + lis[j] > lis[i]){
						lis[i] = 1 + lis[j];
					}
				}
			}

			max = Math.max(max, lis[i]);	// max lis of all the elements
		}

		return max;
    }
}
