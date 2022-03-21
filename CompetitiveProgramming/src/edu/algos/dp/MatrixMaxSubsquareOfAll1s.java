package edu.algos.dp;

public class MatrixMaxSubsquareOfAll1s {

	public static void main(String[] args) {
		int[][] input = new int[][] {
			{0,0,1,1,1},
			{1,0,1,1,1},
			{0,1,1,1,1},
			{1,0,1,1,1}
		};
		System.out.println(maxLenSquare(input, input.length, input[0].length));
	}
	/*
	 *  0	0	0	0	0	0
	 * 	0	0	0	1	1	1	
	 * 	0	1	0	1	2	2
	 * 	0	0	1	1	2	3
	 * 	0	1	0	1	2	3
	 * 
	 * */
	private static int maxLenSquare(int[][] input, int m, int n) {
		int max = 0;
		int[][] mem = new int[m+1][n+1];
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(input[i-1][j-1] == 1) {
					mem[i][j] = 1+Math.min(mem[i-1][j-1], Math.min(mem[i][j-1], mem[i-1][j]));
					if(mem[i][j] > max) {
						max = mem[i][j];
					}
				}
			}
		}
		return max;
	}

}
