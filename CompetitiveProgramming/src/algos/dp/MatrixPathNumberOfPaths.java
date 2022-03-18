package algos.dp;

public class MatrixPathNumberOfPaths {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		int rows = matrix.length;
		int cols = matrix[0].length;
		System.out.println(totalPaths(matrix, rows, cols));
	}

	/*
	 * i\j	0	1	2	3
	 * 0	1	1	1	1
	 * 1	1	2	3	4
	 * 2	1	3	6	10
	 * 3	1	4	10	20
	 * 
	 * */
	private static int totalPaths(int[][] matrix, int rows, int cols) {
		int[][] mem = new int[rows][cols];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(i == 0 || j == 0) {
					mem[i][j] = 1;
				}else {
					mem[i][j] = mem[i-1][j]+mem[i][j-1];
				}
			}
		}
		return mem[rows-1][cols-1];
	}

}
