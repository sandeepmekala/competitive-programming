package  com.algos.li01_array;

public class Matrix_RotateMatrixByOneElement {

	public static void main(String[] args) {
		Matrix_RotateMatrixByOneElement obj = new Matrix_RotateMatrixByOneElement();
		int[][] matrix = new int[][] {
			{1,2,3}, 
			{4,5,6}, 
			{7,8,9}
			};
		
		print(matrix);
		obj.rotate(matrix);
		
		System.out.println();
		print(matrix);
	}
	
	private void rotate(int[][] matrix) {
		int startI = 0, startJ = 0, endI = matrix.length-1, endJ = matrix[0].length-1;
		int curr, prev;
		while(startI < endI && startJ < endJ) {
			//shift top row
			prev = matrix[startI+1][startJ];
			for(int j=startJ; j<endJ; j++ ) {
				curr = matrix[startI][j];
				matrix[startI][j] = prev;
				prev = curr;
			}
			
			//shift last column
			for(int i=startI; i<endI; i++ ) {
				curr = matrix[i][endJ];
				matrix[i][endJ] = prev;
				prev = curr;
			}
			
			//shift last row
			for(int j=endJ; j>startJ; j-- ) {
				curr = matrix[endI][j];
				matrix[endI][j] = prev;
				prev = curr;
			}
			
			//shift first column
			for(int i=endI; i>startI; i-- ) {
				curr = matrix[i][startJ];
				matrix[i][startJ] = prev;
				prev = curr;
			}
			
			startI++;
			startJ++;
			endI--;
			endJ--;
		}
		
		//incase of rectangle matrix with odd dimention, there will be one last row/colum to be processed
		//odd number of rows
		if(startI < endI) {
			prev = matrix[endI][endJ];
			for(int i=startI; i<=endI; i++) {
				curr = matrix[i][endJ];
				matrix[i][endJ] = prev;
				prev = curr;
			}
		}
		
		//odd number of cols
		if(startJ < endJ) {
			prev = matrix[endI][endJ];
			for(int j=startJ; j<=endJ; j++) {
				curr = matrix[endI][j];
				matrix[endI][j] = prev;
				prev = curr;
			}
		}
	}
	
	private static void print(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}

