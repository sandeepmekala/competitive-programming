package edu.algos.dp;

import java.util.Arrays;

public class Algo074_MinimumJumpsToReachEnd {

	public static void main(String[] args) {
		Algo074_MinimumJumpsToReachEnd obj = new Algo074_MinimumJumpsToReachEnd();
		int[] jumps = new int[] {2,3,1,1,2,4,2,0,1,1};
		int n = jumps.length;
		System.out.println(obj.minJumps(jumps, n));
	}

	/*
	 * concept: if i is reachable from j, minj[i] = min(minj[i], minj[j]+1)
	 * 
	 * 	i		2	3	1	1	2	4	2	0	1	1
	 * 	minj	0	1	1	2	2	3	3	4	4	4
	 * 	path	0	0	0	1	1	4	4	5	5	5	
	 * */
	private int minJumps(int[] jumps, int n) {
		if(jumps.length == 1){
		    return 0;
		}else if(jumps[0] == 0) {
			return -1;
		}
		
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
		if(minj[n-1] == Integer.MAX_VALUE) {
			return -1;
		}
		return minj[n-1];
	}

}