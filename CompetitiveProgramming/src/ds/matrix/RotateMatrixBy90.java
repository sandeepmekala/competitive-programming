package ds.matrix;

public class RotateMatrixBy90 {

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

		System.out.println();
		print(matrix);

	}

	// rotate in anti clockwise
	private static void rotateBy90(int[][] matrix) {
		// i=0, j=0 -> i=n, j=0
		// i=0, j=1 -> i=n-1, j=0
		// i=0, j=2 -> i=n-2, j=0
		// i=1, j=1 -> i=2, j=1
		
		int startI = 0;
		int startJ = 0;
		int endI = matrix.length - 1;
		int endJ = matrix[0].length - 1;
		
		for (int n = matrix.length; n > 1; n=n/2) {
			System.err.println("n:"+n+" startI:"+startI +" endI:"+endI);
			
			int temp;
			// top -> left
			for (int i = endI, j=0; i > startI; i--,j++ ) {
				temp = matrix[i][startJ];
				matrix[i][startJ] = matrix[startI][startJ+j];
				matrix[startI][startJ+j] = temp;
			}

			System.out.println();
			print(matrix);
			// right -> top
			for (int j = startJ, i=0; j < endJ; j++, i++) {
				temp = matrix[startI][j];
				matrix[startI][j] = matrix[startI + i][endJ];
				matrix[startI + i][endJ] = temp;
			}

			System.out.println();
			print(matrix);
			// bottom -> right
			for (int i = startI, j=endJ; i < endI; i++, j--) {
				temp = matrix[i][endJ];
				matrix[i][endJ] = matrix[endI][j];
				matrix[endI][j] = temp;
			}
			System.out.println();
			print(matrix);

			startI++;
			startJ++;
			endI--;
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
