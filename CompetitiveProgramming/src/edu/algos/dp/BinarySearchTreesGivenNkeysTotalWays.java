package edu.algos.dp;

public class BinarySearchTreesGivenNkeysTotalWays {
	public static void main(String[] orgs) {
		int n=5;
		System.out.println(totdalWays(n));
	}

	private static int totdalWays(int n) {
		int[] mem = new int[n+1];
		mem[0] = 1;
		mem[1] = 1;
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				System.out.println(i+":"+j);
				mem[i] += mem[j]*mem[i-j-1];
			}
		}
		return mem[n];
	}
}
