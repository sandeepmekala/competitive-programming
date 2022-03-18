package algos.dp;

import java.util.Arrays;

public class MinimumJumpsToReachEnd {

	public static void main(String[] args) {
		int[] jumps = new int[] {2,3,1,1,2,4,2,0,1,1};
		int n = jumps.length;
		System.out.println(minJumps(jumps, n));
	}

	/*
	 * 	i	0	1	2	3	4	5	6	7	8	9
	 * 		2	3	1	1	2	4	2	0	1	1
	 * 	minj0	1	1	2	2	3	3	4	4	4
	 * 	path0	0	0	1	1	4	4	5	5	5	
	 * */
	private static int minJumps(int[] jumps, int n) {
		int[] minj = new int[n];
		int[] path = new int[n];
		
		Arrays.fill(minj, Integer.MAX_VALUE);
		minj[0] = 0;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(j+jumps[j] >= i) {
					if(minj[j]+1 < minj[i]) {
						minj[i] = minj[j]+1;
						path[i] = j;
					}
				}
			}
		}
		System.out.println(Arrays.toString(minj));
		System.out.println(Arrays.toString(path));
		return minj[n-1];
	}

}