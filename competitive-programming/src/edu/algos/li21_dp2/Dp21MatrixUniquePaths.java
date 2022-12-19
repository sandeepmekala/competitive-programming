package edu.algos.li21_dp2;

public class Dp21MatrixUniquePaths {

	public static void main(String[] args) {
		Dp21MatrixUniquePaths obj = new Dp21MatrixUniquePaths();

		int[][] matrix = new int[4][4] ;
		int rows = matrix.length;
		int cols = matrix[0].length;
		System.out.println(obj.totalPaths(rows, cols));
	}

	/* 
	 * Problem: Find the total ways to travel from [0, 0] to [n, n]
	 * 
	 * Idea: As there are only 2 directions to move. you can reach any position from the top or left. 
	 * So total ways to reach any position is total ways to reach top position+total ways to reach left position
	 * 
	 * i\j	0	1	2	3
	 * 0	1	1	1	1
	 * 1	1	2	3	4
	 * 2	1	3	6	10
	 * 3	1	4	10	20
	 * 
	 * */
	private int totalPaths(int rows, int cols) {
		int[][] mem = new int[rows][cols];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i == 0 || j == 0) {
					mem[i][j] = 1;							//base case
				}else {
					mem[i][j] = mem[i-1][j]+mem[i][j-1];
				}
			}
		}
		return mem[rows-1][cols-1];
	}

}
