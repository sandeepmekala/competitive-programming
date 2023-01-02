package edu.algos.li20_dp1;

public class Loop_A05_CombinationSum {

	public static void main(String[] args) {
		Loop_A05_CombinationSum obj = new Loop_A05_CombinationSum();
		
		int[] nums = new int[] {1,5,11,9};
		int sum = 13;
		System.out.println(obj.combinationSum(nums, sum));
	}

	public boolean combinationSum(int[] nums, int sum) {
		int n = nums.length;
		boolean[] mem = new boolean[sum+1];
		mem[0] = true;
		for(int i=0; i<=sum; i++) {
			for(int j=0; j<n; j++) {
				if(i-nums[j] >= 0 && mem[i-nums[j]]) {
					mem[i] = true;
				}
			}
		}
		return mem[sum];
	}

}
