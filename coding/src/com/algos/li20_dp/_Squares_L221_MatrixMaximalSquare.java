package  com.algos.li20_dp;

public class _Squares_L221_MatrixMaximalSquare {

	public static void main(String[] args) {
		_Squares_L221_MatrixMaximalSquare obj = new _Squares_L221_MatrixMaximalSquare();
		
		char[][] matrix = new char[][] {
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','1','1','1'}};
		System.out.println(obj.maximalSquare(matrix));
	}
	/*
	 * Problem: https://leetcode.com/problems/maximal-square/
	 * Idea: We store the count of squares in each cell and sum them up.
     * We take the min of all the 3 sorrounding cells and add one. This boost the count if all the 3 cells are 1's. 
     * Similarly, if all the 3 cells are 2 it boosts it to 3.
	 * 
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
		int[][] count = new int[m+1][n+1];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == '1') {
					if(i == 0 || j == 0) {				// [0][0] position
						count[i][j] = 1;
					}else {
						count[i][j] = 1+Math.min(count[i-1][j-1], Math.min(count[i][j-1], count[i-1][j]));
					}					
					
					if(count[i][j] > max) {
						max = count[i][j];
					}
				}
			}
		}
		return max*max;
    }

}
