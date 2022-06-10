package edu.algos.matrix;

public class RotateMatrixLeftBy90 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
			{ 1, 2, 3, 4 }, 
			{ 5, 6, 7, 8 }, 
			{ 9, 10, 11, 12 }, 
			{ 13, 14, 15, 16 } 
		};
//		int[][] matrix = new int[][] {
//		{1,2,3}, 
//		{4,5,6}, 
//		{7,8,9}
//		};
//		int[][] matrix = new int[][] {
//		{1,2}, 
//		{3,4}, 
//		};
		print(matrix);
		rotateBy90(matrix);

	}

	// rotate in anti clockwise
	private static void rotateBy90(int[][] matrix) {
		// i=0, j=0 -> i=n, j=0
		// i=0, j=1 -> i=n-1, j=0
		// i=0, j=2 -> i=n-2, j=0
		// i=1, j=1 -> i=2, j=1
		
		int startI = 0, startJ = 0, endI = matrix.length - 1, endJ = matrix.length - 1;
		while (startI < endI && startJ < endJ) {
			// elft-top
			for (int j = startJ, i = endI; j < endJ; j++, i--) {
				int temp = matrix[startI][j];
				matrix[startI][j] = matrix[i][startJ];
				matrix[i][startJ] = temp;
			}

			// bottom-left
			for (int i = endI, j = endJ; i > startI; i--, j--) {
				int temp = matrix[i][startJ];
				matrix[i][startJ] = matrix[endI][j];
				matrix[endI][j] = temp;
			}

			// right-bottom
			for (int j = endI, i = startI; j > startI; j--, i++) {
				int temp = matrix[endI][j];
				matrix[endI][j] = matrix[i][endJ];
				matrix[i][endJ] = temp;
			}

			startI++;
			endI--;
			startJ++;
			endJ--;
		}

	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
