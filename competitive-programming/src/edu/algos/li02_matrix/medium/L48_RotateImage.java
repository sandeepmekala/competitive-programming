package edu.algos.li02_matrix.medium;

public class L48_RotateImage {

	public static void main(String[] args) {
		L48_RotateImage obj = new L48_RotateImage();
		int[][] matrix = new int[][] {
		{1,2,3}, 
		{4,5,6}, 
		{7,8,9}
		};

		print(matrix);
		obj.rotate(matrix);
		print(matrix);
	}

	// Problem: https://leetcode.com/problems/rotate-image/
	// Idea: Use two pointers for each row/column and move the pointer once that row/column processed.
	public void rotate(int[][] matrix) {
        int startI = 0, startJ = 0, endI = matrix.length-1, endJ = matrix.length-1; 
        while(startI<endI && startJ<endJ){
            //left->top
            for(int j=startJ,i=endI; j<endJ; j++,i--){
                int temp = matrix[startI][j];
                matrix[startI][j] = matrix[i][startJ];
                matrix[i][startJ] = temp;
            }
            
            //bottom->left
            for(int i=endI,j=endJ; i>startI; i--,j--){
                int temp = matrix[i][startJ];
                matrix[i][startJ] = matrix[endI][j];
                matrix[endI][j] = temp;
            }
            
            //right->bottom
            for(int j=endI,i=startI; j>startI; j--,i++){
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
