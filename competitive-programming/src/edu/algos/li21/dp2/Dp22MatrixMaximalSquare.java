package edu.algos.li21.dp2;

public class Dp22MatrixMaximalSquare {

	public static void main(String[] args) {
		Dp22MatrixMaximalSquare obj = new Dp22MatrixMaximalSquare();
		
		char[][] matrix = new char[][] {
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}};
		System.out.println(obj.maximalSquare(matrix));
	}
	/*
	 *  0	0	0	0	0	0
	 * 	0	0	0	1	1	1	
	 * 	0	1	0	1	2	2
	 * 	0	0	1	1	2	3
	 * 	0	1	0	1	2	3
	 * 
	 * 
	 * */	
	public int maximalSquare(char[][] matrix) {
        int max = 0, m = matrix.length, n = matrix[0].length;
		int[][] mem = new int[m+1][n+1];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == '1') {
					if(i == 0 || j == 0) {				// [0][0] position
						mem[i][j] = 1;
					}else {
						mem[i][j] = 1+Math.min(mem[i-1][j-1], Math.min(mem[i][j-1], mem[i-1][j]));
					}					
					
					if(mem[i][j] > max) {
						max = mem[i][j];
					}
				}
			}
		}
		return max*max;
    }

}
