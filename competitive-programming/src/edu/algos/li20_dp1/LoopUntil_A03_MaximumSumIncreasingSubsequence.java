package edu.algos.li20_dp1;

public class LoopUntil_A03_MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		LoopUntil_A03_MaximumSumIncreasingSubsequence obj = new LoopUntil_A03_MaximumSumIncreasingSubsequence();
		
		int[] input = new int[] {4,6,1,3,8,4,6};
		System.out.println(obj.maxSum(input, input.length));
	}
	
	/*
		Idea: Similar like longest increasing subsequence.
	 * 	i	4	6	1	3	8	4	6
	 * 	mxs	4	10	1	4	18	8	14
	 * 
	 * */
	public int maxSum(int[] input, int n) {
		int max = 0;
		int[] mxs = new int[n];
		for(int i=0; i<n; i++) {
			mxs[i] = input[i];
		}
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(input[j] < input[i]) {
					mxs[i] = Math.max(mxs[i], mxs[j]+input[i]);
				}
			}
			
			if(mxs[i] > max) {
				max = mxs[i];
			}
		}
		
		return max;
	}

}
