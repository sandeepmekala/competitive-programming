package edu.algos.dp;

public class BinaryTreesGivenPreorderTotalWays {

	public static void main(String[] args) {
		int n=5;
		System.out.println(numberOfBinaryTrees(n));
	}
	/*
	 * 	0	1	2	3	4	5
	 * 	1	1	2
	 * 
	 * 	n=2
	 * 	l=0, r=1
	 * 	l=1, r=0
	 * 
	 * 	n=3	
	 * 	l=0, r=2
	 * 	l=1, r=1
	 * 	l=2, r=0
	 * 
	 * */
	private static int numberOfBinaryTrees(int n) {
		int[] mem = new int[n+1];
		mem[0] = 1;
		mem[1] = 1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				System.out.println(j+":"+(i-j-1));
				mem[i] += mem[j]*mem[i-j-1];
			}
			System.out.println();
		}
		return mem[n];
	}

}
