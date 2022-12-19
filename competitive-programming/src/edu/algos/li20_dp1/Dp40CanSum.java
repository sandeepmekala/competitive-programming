package edu.algos.li20_dp1;

public class Dp40CanSum {

	public static void main(String[] args) {
		Dp40CanSum obj = new Dp40CanSum();
		
		int[] nums = new int[] {1,5,11,9};
		int sum = 13;
		System.out.println(obj.canSum(nums, sum));
	}

	private boolean canSum(int[] nums, int sum) {
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
