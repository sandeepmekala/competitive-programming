package edu.algos.dp;

public class Algo071_MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = new int[] {4,6,1,3,8,4,6};
		int n = input.length;
		System.out.println(maxSum(input, input.length));
	}
	
	/*
	 * 	i	4	6	1	3	8	4	6
	 * 	mxs	4	10	1	4	18	8	14
	 * 	iss	0	0	2	2	1	3	5 
	 * 
	 * */
	private static int maxSum(int[] input, int n) {
		int max = 0;
		int[] mxs = new int[n];
		int[] iss = new int[n];
		for(int i=0; i<n; i++) {
			mxs[i] = input[i];
			iss[i] = i;
		}
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(input[j] < input[i]) {
					if(mxs[j]+input[i] > mxs[i]) {
						mxs[i] = mxs[j]+input[i];
						iss[i] = j;
					}
				}
			}
			if(mxs[i] > max) {
				max = mxs[i];
			}
		}
		
		//printing
		int i;
		for(i=0; i<n; i++) {
			if(mxs[i] == max) {
				break;
			} 
		}
		while(input[i] != mxs[i]) {
			System.out.print(input[i]+" ");
			i = iss[i];
		}
		System.out.println(input[i]);
		return max;
	}

}
