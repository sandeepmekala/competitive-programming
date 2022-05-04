package edu.algos.dp;

public class Algo020_BinomialCoefficient {

	public static void main(String[] args) {
		int n=5, k=2;
		System.out.println(binomialCoefficientTopDown(n, k));
		System.out.println(binomialCoefficientBottomUp(n, k));
	}

	private static int binomialCoefficientTopDown(int n, int k) {
		if(k > n) {
			return 0;
		}else if( k == 0 || k == n) {
			return 1;
		}else {
			return binomialCoefficientTopDown(n-1, k-1)+binomialCoefficientTopDown(n-1, k);
		}
	}
	
	/*
	 * n\k	0	1	2
	 * 0	1	0	0
	 * 1	1	1	0
	 * 2	1	2	1
	 * 3	1	3	3
	 * 4	1	4	6
	 * 5	1	5	10
	 * 
	 * */
	private static int binomialCoefficientBottomUp(int n, int k) {
		int[][] mem = new int[n+1][k+1]; 
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=k; j++) {
				if(j > i) {
					mem[i][j] = 0;
				}else if( j == 0 || j == n) {
					mem[i][j] = 1;
				}else {
					mem[i][j] = mem[i-1][j-1]+mem[i-1][j];
				}
			}
		}
		return mem[n][k];
	}

}
